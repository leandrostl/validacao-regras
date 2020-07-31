package com.leandro.validacaoregras.regras;

import com.leandro.validacaoregras.entidades.PacotePaoQueijo;
import com.leandro.validacaoregras.excecoes.PacoteDefeituosoException;
import org.springframework.stereotype.Component;

@Component
public class RegraQuantidadePaesPacote implements Regra<PacotePaoQueijo, PacoteDefeituosoException> {
    public static final int QUANTIDADE_PAO_DE_QUEIJO_PACOTE = 10;

    @Override
    public void validar(PacotePaoQueijo pacote) throws PacoteDefeituosoException {
        final int quantidade = pacote.size();
        if (quantidade == QUANTIDADE_PAO_DE_QUEIJO_PACOTE)
            return;

        throw new PacoteDefeituosoException(String.format("Quantidade de pães de queijo errada. Esperava %d e " +
                "encontrou %d.", QUANTIDADE_PAO_DE_QUEIJO_PACOTE, quantidade));
    }
}
