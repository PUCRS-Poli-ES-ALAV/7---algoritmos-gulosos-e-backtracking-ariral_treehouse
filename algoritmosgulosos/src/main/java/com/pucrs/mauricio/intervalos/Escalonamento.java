package com.pucrs.mauricio.intervalos;

import com.pucrs.mauricio.IteracoesInterface;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Escalonamento implements IteracoesInterface {
    private int iteracoes;

    private record Par(Integer idx, Integer s, Integer f) {}

    @Override
    public int getIteracoes() { return this.iteracoes; }

    private List<Par> formarPar(List<Integer> l1, List<Integer> l2) {
        ArrayList<Par> res = new ArrayList<>();
        if (l1.size() != l2.size()) {
            return res;
        }
        int lim = l1.size();
        for (int i = 0; i < lim; i++) {
            res.add(new Par(i, l1.get(i), l2.get(i)));
        }
        return res;
    }

    public List<Integer> run(List<Integer> start, List<Integer> finish) {
        iteracoes = 0;
        List<Par> pares = formarPar(start, finish);
        Collections.sort(pares, (a, b) -> a.f() - b.f());
        int i = 0;
        int n = pares.size();
        ArrayList<Integer> res = new ArrayList<>(n);
        while (i < n) {
            iteracoes++;
            res.add(pares.get(i).idx());
            int k = i + 1;
            while (k < n && pares.get(k).s() < pares.get(i).f()) {
                iteracoes++;
                k++;
            }
            i = k;
        }
        return res;
    }
}