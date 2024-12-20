package com.cod.m_seguridad.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRefreshToken {
    private String refreshToken;
}
