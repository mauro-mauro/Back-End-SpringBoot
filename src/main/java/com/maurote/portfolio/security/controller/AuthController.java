package com.maurote.portfolio.security.controller;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import com.maurote.portfolio.entity.Mensaje;
import com.maurote.portfolio.security.dto.JwtDto;
import com.maurote.portfolio.security.dto.LoginUsuario;
import com.maurote.portfolio.security.dto.NuevoUsuario;
import com.maurote.portfolio.security.entity.Rol;
import com.maurote.portfolio.security.entity.Usuario;
import com.maurote.portfolio.security.enums.RolNombre;
import com.maurote.portfolio.security.jwt.JwtProvider;
import com.maurote.portfolio.security.service.RolService;
import com.maurote.portfolio.security.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwt;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"${crossorigin.origin}"})
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
 public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
    if(bindingResult.hasErrors())
        return new ResponseEntity(new Mensaje("campos mal puestos o email invalido"),HttpStatus.BAD_REQUEST);
    if(usuarioService.existsByNombreusuario(nuevoUsuario.getNombreUsuario()))
        return new ResponseEntity(new Mensaje("ese nombre ya existe"),HttpStatus.BAD_REQUEST);
    if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
        return new ResponseEntity(new Mensaje("ese email ya existe"),HttpStatus.BAD_REQUEST);
    Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombre(), nuevoUsuario.getEmail(),passwordEncoder.encode(nuevoUsuario.getPassword()));
    Set<Rol> roles = new HashSet<>();
    roles.add(rolService.getByRolNombre(RolNombre.ROL_USER).get());
    if(nuevoUsuario.getRoles().contains("admin"))
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
    usuario.setRoles(roles);
    usuarioService.save(usuario);
    return new ResponseEntity(new Mensaje("usuario guardado"),HttpStatus.CREATED);
 }

 @PostMapping("/login")
 public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
     if(bindingResult.hasErrors())
        return new ResponseEntity(new Mensaje("campos mal puestos"),HttpStatus.BAD_REQUEST);
    Authentication authentication = 
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtProvider.generateToken(authentication);
    JwtDto jwtDto = new JwtDto(jwt);
    return new ResponseEntity<>(jwtDto,HttpStatus.OK);
 }

//  @PostMapping("/refresh")
//  public ResponseEntity<JwtDto> refresh(@RequestBody JwtDto jwtDto) throws ParseException{
//      String token=jwtProvider.refreshToken(jwtDto);
//      JwtDto jwt = new JwtDto(token);
//      return new ResponseEntity(jwt, HttpStatus.OK);
//  }
}
