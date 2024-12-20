package com.cod.m_seguridad.service;

import com.cod.m_seguridad.aggregates.request.SignInRefreshToken;
import com.cod.m_seguridad.aggregates.request.SignInRequest;
import com.cod.m_seguridad.aggregates.request.SignUpRequest;
import com.cod.m_seguridad.aggregates.response.SignInResponse;
import com.cod.m_seguridad.entity.Usuario;

public interface AuthenticationService {
    //REGISTRAR USUARIOS
    Usuario signUpUser(com.cod.m_seguridad.aggregates.request.SignUpRequest signUpRequest);
    Usuario signUpAdmin(SignUpRequest signUpRequest);

    SignInResponse signIn(SignInRequest signInRequest);
    SignInResponse getTokenRefresh(SignInRefreshToken signInRefreshToken);

    boolean validateToken(String token);
}
