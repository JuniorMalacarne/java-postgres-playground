package com.example;

public class AppClasses {
    public static void main(String[] args) { // "void" seria o "tipo" do retorno do método ("main" é o método principal). Void significa que esse retorno é vazio, ou que ele não tem um "tipo" para retornar
        Cliente cliente1 = new Cliente(); //usando o método construtor para instanciar/criar um objeto de uma classe
        cliente1.setNome("João");
        cliente1.setCpf("99999999999");
        cliente1.setCidade("Curitiba");
        cliente1.setRenda(3000);
        cliente1.setSexo('M');
        cliente1.setAnoNascimento(1987);;
        System.out.println("Cliente 1");
        System.out.println("Nome: " + cliente1.getNome());
        System.out.println("CPF: " + cliente1.getCpf());
        System.out.println("Cidade: " + cliente1.getCidade());
        System.out.println("Renda: " + cliente1.getRenda());
        System.out.println("Sexo: " + cliente1.getSexo());
        System.out.println("Ano de Nascimento: " + cliente1.getAnoNascimento());
        if (cliente1.isEspecial()==true)
            System.out.println("Cliente Especial: Sim.");
        else System.out.println("Cliente Especial: Não.");
        System.out.println();

        Cliente cliente2 = new Cliente("Maria das Dores", "88888888888", "CURITIBA", 1500, 'F', 1991, true); // usando o outros método construtor para instanciar um objeto da classe Cliente, mas com parâmetros
        System.out.println("Cliente 2");
        System.out.println("Nome: " + cliente2.getNome());
        System.out.println("CPF: " + cliente2.getCpf());
        System.out.println("Cidade: " + cliente2.getCidade());
        System.out.println("Renda: " + cliente2.getRenda());
        System.out.println("Sexo: " + cliente2.getSexo());
        System.out.println("Ano de Nascimento: " + cliente2.getAnoNascimento());
        if (cliente2.isEspecial()==true)
            System.out.println("Cliente Especial: Sim.");
        else System.out.println("Cliente Especial: Não.");    
        System.out.println();

        if (cliente1.getCpf().equals(cliente2.getCpf())) // usar ométodo equals para comparar Strings, pois assim independe de endereços de memória
            System.out.println("Atenção: o Cliente 1 e o Cliente 2 tem os CPFs iguais.");
        else System.out.println("O Cliente 1 e o Cliente 2 tem os CPFs diferentes.");

        if (cliente1.getCidade().equalsIgnoreCase(cliente2.getCidade())) // o método equalsIgnoreCase compara Strings ignorando diferença entre maiúsculas e minúsculas
            System.out.println("Os dois clientes moram na mesma cidade.");
        else System.out.println("Os dois clientes moram em cidades diferentes.");

        /*    
        var vetorString = cliente2.getNome().split(" "); // o método split divide a String de acordo com um delimitador
        for (int i = 0; i < vetorString.length; i++){
            System.out.println(vetorString[i]);
        }
        */
        //System.out.println("O 1º caractere do nome do clente 2 é: " + cliente2.getNome().charAt(0)); // o método charAt informa um caractere de determinada posição da String
    }
}
