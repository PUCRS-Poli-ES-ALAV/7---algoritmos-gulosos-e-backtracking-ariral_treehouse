package com.pucrs.mauricio.troco;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.pucrs.mauricio.IteracoesInterface;

public class TrocoSemReordenar implements IteracoesInterface {
    private int iteracoes;

    @Override
    public int getIteracoes() { return this.iteracoes; }

    public List<Integer> run(double valor, Integer[] moedas) {
        int valorInt = (int) (valor * 100);
        List<Integer> res = new ArrayList<>();

        for (int moeda : moedas) {
            iteracoes++;
            while (moeda <= valorInt) {
                iteracoes++;
                valorInt -= moeda;
                res.add(moeda);
            }
        }

        if (valorInt > 0) {
            return Collections.<Integer>emptyList();
        }
        return res;
    }
}
