package com.example;

public class AppOperadores {
    /*
    // criando métodos que retornam valores lógicos e imprimem o nome do método para testar se estão sendo chamados no shoet circuit
    // short circuit é quando, pela tabela verdade, já se sabe o resultado da expressão lógica pelo(s) primeiro(s) valor, não é preciso calcular os valores seguintes
    boolean a(boolean valor){
        System.out.println("a");
        return valor;
    }
    
    boolean b(boolean valor){
        System.out.println("b");
        return valor;
    }

    boolean c(boolean valor){
        System.out.println("c");
        return valor;
    }

    AppOperadores(){
        System.out.println(a(false) && b(true) || c(false));
    }
    */
    public static void main(String[] args) {
        //Operadores Relacionais
        /*
        var cliente1 = new Cliente();
        cliente1.setAnoNascimento(1980);

        var cliente2 = new Cliente();
        cliente2.setAnoNascimento(1987);
        
        boolean cliente1MaisJovem = cliente1.getAnoNascimento() > cliente2.getAnoNascimento();
        boolean cliente1MaisVelho = cliente1.getAnoNascimento() < cliente2.getAnoNascimento();

        if (cliente1MaisJovem) {
            System.out.println("O cliente 1 é mais jovem que o cliente 2.");
        }
        else if (cliente1MaisVelho) {
            System.out.println("O cliente 1 é mais velho que o cliente 2.");
        }
        else System.out.println("Os dois clientes tem a mesma idade");
        */

        //Operadores Lógicos
        boolean a = true, b = false, c = false;
        System.out.println(a && b || c);
        //new AppOperadores();
    }
}
