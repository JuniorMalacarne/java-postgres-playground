package com.example;

import java.util.Arrays;

public class AppArrays {
    public static void main(String[] args) {
        /* 
        int x = 10;
        System.out.println("Valor de x: "+ x);
        
        x = 20;
        System.out.println("Valor de x alterado: "+ x);

        double vetor[] = {10, 20, 30}; // para declarar um vetor usa-se colchetes, mas para atribuir valor usa-se chaves
        // os vetores são estáticos na quantidade de elementos
        // não é possível atribuir um vetor dentro de outro vetor se eles têm tipos diferentes. Somente é possível com tipos iguais
        
        System.out.print("Vetor 1: ");
        System.out.println(Arrays.toString(vetor));
        System.out.println("Posição 1: " + vetor[0]);
        
        vetor[0] = 1;
        System.out.println("Posição 1 alterada: " + vetor[0]);
        */

        //iniciando vetor sem atribuir diretamente os valores, mas informando a quantidade de elementos
        int vetor2[] = new int[5];
        for (int i = 0; i < vetor2.length; i++) {
            vetor2[i] = 100 * (i+1);
        }
        System.out.print("Vetor 2: ");
        System.out.println(Arrays.toString(vetor2));
        System.out.println();

        /*
        double matriz[][] = {{1, 2, 3}, {4, 5, 6}}; //iniciando a matriz já atribuindo elementos
        // as linhas da matriz não precisam necessariamente ter a mesma quantidade de elementos

        System.out.println("Matriz: ");
        System.out.println(Arrays.toString(matriz[0]));
        System.out.println(Arrays.toString(matriz[1]));
        */

        double matriz[][] = new double[3][4];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = i * matriz[i].length + j+1; // atribuindo valores em sequência
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%5.1f", matriz[i][j]);
            }
            System.out.println();
        }

        /*
        matriz[0][1] = -2;
        System.out.println("Valor da linha 0 e coluna 1 alterado: " + matriz[0][1]);
        System.out.println(Arrays.toString(matriz[0]));
        System.out.println(Arrays.toString(matriz[1]));

        //matriz[0] = {7, 8, 9}; // não é possível alterar "vetores" de matrizes diretamente. É preciso fazer o seguinte:
        matriz[0] = new double[]{7, 8, 9, 10}; // não deve-se informar a quantidade de elementos dentro das chaves
        
        //matriz[0] = new double[4]; se iniciar informando a quantidade de valores nas chaves, não informo os valores, mas assim os valores serão 0 por padrão, e poderão ser atribuídos depois
        
        System.out.println("Novos valores da Matriz: ");
        System.out.println(Arrays.toString(matriz[0]));
        System.out.println(Arrays.toString(matriz[1]));
        */
    }
}
