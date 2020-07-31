package com.leandro.validacaoregras.excecoes;

public class PacoteDefeituosoException extends Exception {
    public PacoteDefeituosoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public PacoteDefeituosoException(String mensagem) {
        super(mensagem);
    }
}
