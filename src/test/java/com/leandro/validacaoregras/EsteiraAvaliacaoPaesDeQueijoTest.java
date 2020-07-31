package com.leandro.validacaoregras;

import com.leandro.validacaoregras.entidades.PacotePaoQueijo;
import com.leandro.validacaoregras.entidades.PaoDeQueijo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootTest
class EsteiraAvaliacaoPaesDeQueijoTest {

    @Autowired
    EsteiraAvaliacaoPaesDeQueijo esteira;


    @Test
    public void testEsteira() {
        esteira.validarPacote(criarPacote());
    }

    private PacotePaoQueijo criarPacote() {
        final PacotePaoQueijo pacote = new PacotePaoQueijo();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(9, 11); i++) {
            double circumferencia = ThreadLocalRandom.current().nextDouble(3.8, 4.1);
            double peso = ThreadLocalRandom.current().nextDouble(49.5, 51.5);
            pacote.add(new PaoDeQueijo(circumferencia, peso));
        }
        return pacote;
    }
}