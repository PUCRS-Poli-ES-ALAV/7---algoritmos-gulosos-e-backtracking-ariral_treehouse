package com.pucrs.mauricio.rainhas;

import java.util.List;
import java.util.ArrayList;

public class Rainhas {
    private List<Par> posicoes;
    private int N;
    private boolean hasSolution;

    public Rainhas(int n) {
        this.N = n;
        this.posicoes = new ArrayList<>();
        this.hasSolution = true;
    }

    public int getN() {
        return this.N;
    }

    public void setN(int n) {
        this.N = n;
    }

    public List<Par> posicoes() {
        if (this.hasSolution && this.posicoes.isEmpty()) {
            if (!this.run(this.posicoes, this.N)) {
                this.posicoes.clear();
                this.hasSolution = false;
            }
        }
        return this.posicoes;
    }

    // O(n^3)
    private boolean run(List<Par> out, int n) {
        if (n == 0) {
            return true;
        }
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                Par pos = new Par(x, y);
                // linear em relacao ao numero de rainhas (O(n))
                if (!posicaoValida(pos, out)) {
                    continue;
                }
                out.add(pos);
                if (run(out, n - 1)) {
                    return true;
                }
                out.remove(out.size() - 1);
            }
        }
        return false;
    }

    private boolean posicaoValida(Par pos1, List<Par> lista) {
        return pos1.x >= 0 && pos1.x < N &&
            pos1.y >= 0 && pos1.y < N &&
            lista.stream().allMatch(pos2 -> 
                pos1.x != pos2.x && 
                pos1.y != pos2.y &&
                Math.abs(pos2.x - pos1.x) != Math.abs(pos2.y - pos1.y) // um quadrado :O
            );
    }

    public List<List<Par>> todasPosicoes() {
        List<List<Par>> todasSolucoes = new ArrayList<>();
        for (int y = 0; y < this.N; y++) {
            for (int x = 0; x < this.N; x++) {
                List<Par> res = new ArrayList<>();
                Par p = new Par(x, y);
                res.add(p);
                if (run(res, this.N - 1)) {
                    // provavelmente ineficiente....
                    if (todasSolucoes.stream().anyMatch(e -> e.containsAll(res))) {
                        res.clear();
                    } else {
                        todasSolucoes.add(res);
                    }
                } else {
                    res.clear();
                }
            }
        }
        return todasSolucoes;
    }
}
