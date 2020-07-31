package com.leandro.validacaoregras;

import com.leandro.validacaoregras.entidades.PacotePaoQueijo;
import com.leandro.validacaoregras.entidades.PaoDeQueijo;
import com.leandro.validacaoregras.excecoes.PacoteDefeituosoException;
import com.leandro.validacaoregras.excecoes.PaoDeQueijoDefeituosoException;

public class EsteiraValidacaoPaesDeQueijoOld {

    public static final int QUANTIDADE_PAO_DE_QUEIJO_PACOTE = 10;
    public static final float PESO_PACOTE = 500f;
    public static final double MIN_VOLUME_PAO_DE_QUEIJO = 1.;
    public static final double MAX_PAO_DE_QUEIJO_VOLUME = 1.1;
    public static final double MIN_PESO_PAO_QUEIJO = 50;
    public static final double MAX_PESO_PAO_QUEIJO = 51;

    public boolean isPaoDeQueijoValido(PacotePaoQueijo pacote) throws PacoteDefeituosoException {
        final int quantidade = pacote.size();
        if (quantidade != QUANTIDADE_PAO_DE_QUEIJO_PACOTE)
            throw new PacoteDefeituosoException(String.format("Quantidade de pães de queijo errada. Esperava %d e " +
                    "encontrou %d.", QUANTIDADE_PAO_DE_QUEIJO_PACOTE, quantidade));

        final double pesoPacote = pacote.stream().map(PaoDeQueijo::getPeso).reduce(0., Double::sum);
        if (pesoPacote != PESO_PACOTE)
            throw new PacoteDefeituosoException(String.format("O peso do pacote de pães de queijo não está correto. " +
                            "Esperava %f g e encontrou %f g.",
                    PESO_PACOTE, pesoPacote));

        for (PaoDeQueijo paoDeQueijo : pacote) {
            try {
                validarPaoDeQueijo(paoDeQueijo);
            } catch (PaoDeQueijoDefeituosoException e) {
                throw new PacoteDefeituosoException("Esse pacote possui pães de queijo defeituosos.", e);
            }
        }

        return true;
    }

    public void validarPaoDeQueijo(final PaoDeQueijo paoDeQueijo) throws PaoDeQueijoDefeituosoException {
        final double peso = paoDeQueijo.getPeso();
        if (peso < MIN_PESO_PAO_QUEIJO || peso > MAX_PESO_PAO_QUEIJO)
            throw new PaoDeQueijoDefeituosoException(String.format("O pão de queijo encontra-se fora da faixa de peso permitida." +
                    "Esperava entre %f g e %f g e encontrou %f g.", MIN_PESO_PAO_QUEIJO, MAX_PESO_PAO_QUEIJO, peso));


        final double volume = paoDeQueijo.getVolume();
        if (volume < MIN_VOLUME_PAO_DE_QUEIJO || volume > MAX_PAO_DE_QUEIJO_VOLUME)
            throw new PaoDeQueijoDefeituosoException(String.format("Pão de queijo com volume errado. Esperava valores entre " +
                    "%f e %f e encontrou %f", MIN_VOLUME_PAO_DE_QUEIJO, MAX_PAO_DE_QUEIJO_VOLUME, volume));
    }
}
