package com.leandro.validacaoregras.regras;

import com.leandro.validacaoregras.entidades.PacotePaoQueijo;
import com.leandro.validacaoregras.entidades.PaoDeQueijo;
import com.leandro.validacaoregras.excecoes.PacoteDefeituosoException;
import org.springframework.stereotype.Component;

@Component
public class RegraPesoPacote implements Regra<PacotePaoQueijo, PacoteDefeituosoException> {
    public static final float PESO_PACOTE = 500f;

    @Override
    public void validar(PacotePaoQueijo pacote) throws PacoteDefeituosoException {
        final double pesoPacote = pacote.stream().map(PaoDeQueijo::getPeso).reduce(0., Double::sum);
        if (pesoPacote == PESO_PACOTE)
            return;

        throw new PacoteDefeituosoException(String.format("O peso do pacote de pães de queijo não está correto. " +
                "Esperava %f g e encontrou %f g.", PESO_PACOTE, pesoPacote));
    }
}
