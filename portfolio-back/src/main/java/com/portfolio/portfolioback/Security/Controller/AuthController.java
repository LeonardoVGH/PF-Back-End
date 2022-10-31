/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioback.Security.Controller;

import com.portfolio.portfolioback.Security.Dto.JwtDto;
import com.portfolio.portfolioback.Security.Dto.LoginUsuario;
import com.portfolio.portfolioback.Security.Dto.NuevoUsuario;
import com.portfolio.portfolioback.Security.Entity.Rol;
import com.portfolio.portfolioback.Security.Entity.Usuario;
import com.portfolio.portfolioback.Security.Enums.RolNombre;
import com.portfolio.portfolioback.Security.Service.RolService;
import com.portfolio.portfolioback.Security.Service.UsuarioService;
import com.portfolio.portfolioback.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leo
 */

@RestController
@RequestMapping("/auth")
@CrossOrigin (origins = {"http://localhost:4200", "https://portolioargprofront.web.app"})
public class AuthController {
    
    @Autowired 
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors())
          return new ResponseEntity (new Mensaje("Error de carga de datos de usuario"),HttpStatus.BAD_REQUEST);
        
        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
          return new ResponseEntity (new Mensaje("el nombre de usuario ya existe"),HttpStatus.BAD_REQUEST); 
        
        if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
          return new ResponseEntity (new Mensaje("el nombre de mail ya existe"),HttpStatus.BAD_REQUEST);            
        
        Usuario usuario = new Usuario (nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
        nuevoUsuario.getEmail(),passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol> roles = new HashSet<> ();
        roles.add (rolService.getByRolNombre (RolNombre.ROLE_USER).get());
        
        if (nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        return new ResponseEntity(new Mensaje ("Se guardo el usuario correctamente"),HttpStatus.CREATED);
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login (@RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Datos mal cargados"),HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),loginUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken (authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto (jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity (jwtDto, HttpStatus.OK);
    }
    
}
