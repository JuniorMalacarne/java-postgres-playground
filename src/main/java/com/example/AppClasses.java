package com.example;

public class AppClasses {
    public static void main(String[] args) { // "void" seria o "tipo" do retorno do método ("main" é o método principal). Void significa que esse retorno é vazio, ou que ele não tem um "tipo" para retornar
        Cliente cliente1 = new Cliente(); //método construtor para instanciar/criar um objeto de uma classe
        cliente1.setNome("João");
        cliente1.setRenda(3000);
        cliente1.setSexo('M');
        cliente1.setAnoNascimento(1987);;
        System.out.println("Cliente 1");
        System.out.println("Nome: " + cliente1.getNome());
        System.out.println("Renda: " + cliente1.getRenda());
        System.out.println("Sexo: " + cliente1.getSexo());
        System.out.println("Ano de Nascimento: " + cliente1.getAnoNascimento());
        System.out.println();

        Cliente cliente2 = new Cliente(1500, 'F');
        cliente2.setNome("Maria");
        cliente2.setAnoNascimento(1991);
        System.out.println("Cliente 2");
        System.out.println("Nome: " + cliente2.getNome());
        System.out.println("Renda: " + cliente2.getRenda());
        System.out.println("Sexo: " + cliente2.getSexo());
        System.out.println("Ano de Nascimento: " + cliente2.getAnoNascimento());
        System.out.println();
    }
}
