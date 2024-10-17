package com.pucrs.mauricio;

import java.util.List;

import com.pucrs.mauricio.troco.TrocoGuloso;
import com.pucrs.mauricio.troco.TrocoSemReordenar;
import com.pucrs.mauricio.intervalos.Escalonamento;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Integer[] arrTest = {1, 10, 25, 5, 100};
        double valTest = 5.42; 

        TrocoGuloso sol = new TrocoGuloso();
        List<Integer> solution = sol.run(valTest, arrTest);
        System.out.printf("moedas: %s\nno moedas: %d\niteracoes: %d\n", solution, solution.size(), sol.getIteracoes());
        System.out.println();

        // TrocoSemReordenar sol2 = new TrocoSemReordenar();
        // solution = sol2.run(valTest, arrTest);
        // System.out.printf("moedas: %s\nno moedas: %d\niteracoes: %d\n", solution, solution.size(), sol2.getIteracoes());
        // System.out.println();

        Escalonamento esc = new Escalonamento();
        List<Integer> s = List.of(4, 6, 13, 4, 2, 6, 7, 9, 1, 3, 9);
        List<Integer> f = List.of(8, 7, 14, 5, 4, 9, 10, 11, 6, 13, 12);
        solution = esc.run(s, f);
        System.out.printf("começo: %s\nfim: %-8s\nres: %-8s\niteracoes: %d\n", s, f, solution, esc.getIteracoes());

        for (int idx : solution) {
            System.out.printf("%d ", s.get(idx));
        }
        System.out.println();
        for (int idx : solution) {
            System.out.printf("%d ", f.get(idx));
        }
        System.out.println();
    }
}