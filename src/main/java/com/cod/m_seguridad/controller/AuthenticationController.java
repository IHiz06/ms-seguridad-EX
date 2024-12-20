package com.cod.m_seguridad.controller;

import com.cod.m_seguridad.aggregates.request.SignInRequest;
import com.cod.m_seguridad.aggregates.response.SignInResponse;
import com.cod.m_seguridad.entity.Usuario;
import com.cod.m_seguridad.service.AuthenticationService;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.Base64;

@RestController
@RequestMapping("api/auth/v1")
@RequiredArgsConstructor

public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signupuser")
    public ResponseEntity<Usuario> signUpUser(
            @RequestBody com.cod.m_seguridad.aggregates.request.SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService
                .signUpUser(signUpRequest));
    }

    @PostMapping("/signupadmin")
    public ResponseEntity<Usuario> signUpAdmin(
            @RequestBody com.cod.m_seguridad.aggregates.request.SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService
                .signUpAdmin(signUpRequest));
    }
    //OBTENER UN ACCESS TOKEN PO MEDIO DE REFRESHTOKEN


    //OBTENER UN ACCESS TOKEN POR MEDIO DE LOGIN
    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> signIn(
            @RequestBody SignInRequest signInRequest) {
        return ResponseEntity.ok(authenticationService
                .signIn(signInRequest));

    }
    @GetMapping("/clave")
    public ResponseEntity<String> getClaveFirma(){
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String dato = Base64.getEncoder().encodeToString(key.getEncoded());
        return ResponseEntity.ok(dato);
    }
}