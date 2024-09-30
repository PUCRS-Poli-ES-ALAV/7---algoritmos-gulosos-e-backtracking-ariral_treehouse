package com.pucrs.mauricio.troco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.pucrs.mauricio.IteracoesInterface;

import java.util.Collections;

public class TrocoGuloso implements IteracoesInterface {
    private int iteracoes = 0;

    public int getIteracoes() { return this.iteracoes; }

    public List<Integer> run(double valor, Integer[] moedas) {
        int valorInt = (int) (valor * 100);
        List<Integer> solucao = new ArrayList<>();
        Integer[] moedasOrdenado = Arrays.copyOf(moedas, moedas.length);
        Arrays.sort(moedasOrdenado, Comparator.reverseOrder());

        for (int moeda : moedasOrdenado) {
            iteracoes++;
            while (moeda <= valorInt) {
                iteracoes++;
                valorInt -= moeda;
                solucao.add(moeda);
            }
        }
        
        if (valorInt > 0) {
            solucao.clear();
            return Collections.<Integer>emptyList();
        }
        return solucao;
    }
}