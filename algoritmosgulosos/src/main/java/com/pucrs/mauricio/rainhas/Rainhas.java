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
                if (!posicaoValida(pos)) {
                    continue;
                }
                this.posicoes.add(pos);
                if (run(out, n - 1)) {
                    return true;
                }
                this.posicoes.remove(this.posicoes.size() - 1);
            }
        }
        return false;
    }

    private boolean posicaoValida(Par pos1) {
        return pos1.x >= 0 && pos1.x < N &&
            pos1.y >= 0 && pos1.y < N &&
            this.posicoes.stream().allMatch(pos2 -> 
                pos1.x != pos2.x && 
                pos1.y != pos2.y &&
                Math.abs(pos2.x - pos1.x) != Math.abs(pos2.y - pos1.y)
            );
    }
}
