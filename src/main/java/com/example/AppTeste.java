package com.example;

public class AppTeste {
    
    public static void main(String[] args){
        System.out.println();
        System.out.println("Minha Aplicação Java");
        System.out.println();
        
        int idadeint = 35;
        //cast: conversão de tipo
        byte idade = (byte)idadeint; 

        double peso = 58;
        //var peso = 58.9;
        /*nas versões novas do Java, as variáveis podem ser declaradas apenas com "var" que o compilador automaticamente define o tipo
        mas é preciso sempre iniciá-las com um valor*/

        System.out.println("Minha idade é: " + idade + " e meu peso é: " + peso);

        char sexo = 'M';
        System.out.println("sexo: " + sexo);

        boolean pcd = false;
        System.out.println("PCD: " + pcd);
    }
}
