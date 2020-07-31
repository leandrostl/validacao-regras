package com.leandro.validacaoregras.regras;

import com.leandro.validacaoregras.entidades.PaoDeQueijo;
import com.leandro.validacaoregras.excecoes.PaoDeQueijoDefeituosoException;
import org.springframework.stereotype.Component;

@Component
public class RegraPesoPaoQueijo implements Regra<PaoDeQueijo, PaoDeQueijoDefeituosoException> {
    public static final double MIN_PESO_PAO_QUEIJO = 50;
    public static final double MAX_PESO_PAO_QUEIJO = 51;

    @Override
    public void validar(PaoDeQueijo paoDeQueijo) throws PaoDeQueijoDefeituosoException {
        final double peso = paoDeQueijo.getPeso();
        if (peso >= MIN_PESO_PAO_QUEIJO || peso <= MAX_PESO_PAO_QUEIJO) return;

        throw new PaoDeQueijoDefeituosoException(String.format("O pão de queijo encontra-se fora da faixa de peso permitida." +
                "Esperava entre %f g e %f g e encontrou %f g.", MIN_PESO_PAO_QUEIJO, MAX_PESO_PAO_QUEIJO, peso));
    }
}
