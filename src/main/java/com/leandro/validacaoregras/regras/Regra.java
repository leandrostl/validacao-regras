package com.leandro.validacaoregras.regras;

import org.springframework.stereotype.Component;

@Component
public interface Regra<T, E extends Exception> {
    void validar(T produto) throws E;
}
