package com.leandro.validacaoregras.regras;

import com.leandro.validacaoregras.entidades.PaoDeQueijo;
import com.leandro.validacaoregras.excecoes.PaoDeQueijoDefeituosoException;
import org.springframework.stereotype.Component;

@Component
public class RegraVolumePaoQueijo implements Regra<PaoDeQueijo, PaoDeQueijoDefeituosoException> {
    public static final double MIN_VOLUME_PAO_DE_QUEIJO = 1.;
    public static final double MAX_VOLUME_PAO_DE_QUEIJO = 1.1;

    @Override
    public void validar(PaoDeQueijo paoDeQueijo) throws PaoDeQueijoDefeituosoException {
        final double volume = paoDeQueijo.getVolume();
        if (volume >= MIN_VOLUME_PAO_DE_QUEIJO && volume <= MAX_VOLUME_PAO_DE_QUEIJO)
            return;

        throw new PaoDeQueijoDefeituosoException(String.format("Pão de queijo com volume errado. Esperava valores entre " +
                "%f e %f e encontrou %f", MIN_VOLUME_PAO_DE_QUEIJO, MAX_VOLUME_PAO_DE_QUEIJO, volume));
    }
}
