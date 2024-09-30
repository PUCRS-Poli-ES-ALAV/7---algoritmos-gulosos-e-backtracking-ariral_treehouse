package com.pucrs.mauricio;

import java.util.List;

import com.pucrs.mauricio.troco.TrocoGuloso;
import com.pucrs.mauricio.troco.TrocoSemReordenar;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Integer[] arrTest = {10, 25, 5, 100};
        double valTest = 0.25; 

        TrocoGuloso sol = new TrocoGuloso();
        List<Integer> solution = sol.run(valTest, arrTest);
        System.out.printf("moedas: %s\nno moedas: %d\niteracoes: %d\n", solution, solution.size(), sol.getIteracoes());
        System.out.println();

        TrocoSemReordenar sol2 = new TrocoSemReordenar();
        solution = sol2.run(valTest, arrTest);
        System.out.printf("moedas: %s\nno moedas: %d\niteracoes: %d\n", solution, solution.size(), sol2.getIteracoes());
    }
}