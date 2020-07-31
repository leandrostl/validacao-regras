/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.leandro.validacaoregras;

import com.leandro.validacaoregras.entidades.PacotePaoQueijo;
import com.leandro.validacaoregras.entidades.PaoDeQueijo;
import com.leandro.validacaoregras.excecoes.PacoteDefeituosoException;
import com.leandro.validacaoregras.excecoes.PaoDeQueijoDefeituosoException;
import com.leandro.validacaoregras.regras.Regra;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
@Log4j2
public class EsteiraAvaliacaoPaesDeQueijo {

    private final List<Regra<PaoDeQueijo, PaoDeQueijoDefeituosoException>> regrasPaoDeQueijo;
    private final List<Regra<PacotePaoQueijo, PacoteDefeituosoException>> regrasPacotePaoQueijo;

    public void validarPacote(PacotePaoQueijo pacote) {
        for (var regra : regrasPacotePaoQueijo) {
            try {
                regra.validar(pacote);
            } catch (PacoteDefeituosoException e) {
                log.error("Defeito no pacote.", e);
            }
        }

        for (PaoDeQueijo paoDeQueijo : pacote) {
            for (var regra : regrasPaoDeQueijo) {
                try {
                    regra.validar(paoDeQueijo);
                } catch (PaoDeQueijoDefeituosoException e) {
                    log.error("Defeito no pão de queijo.", e);
                }
            }
        }
    }
}
