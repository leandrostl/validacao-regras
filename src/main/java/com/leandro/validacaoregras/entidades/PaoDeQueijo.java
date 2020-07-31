package com.leandro.validacaoregras.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class PaoDeQueijo {
    private double circumferencia;
    private double peso;

    public double getVolume() {
        return 4./3 * Math.PI * Math.pow(circumferencia/(2 * Math.PI), 3);
    }
}
