package com.example;

import java.util.Scanner; // como Scanner já é uma classe própria do Java que está em um pacote especifico (java.util) fora do pacote atual, foi preciso importá-la aqui nesse aqrquivo
// a System também é um classe pronta do Java, que está no pacote java.lang também fora do pacote atual, mas não é preciso importar nada que está nesse pacote

public class AppScanner {
    public static void main(String[] args) { 
        Cliente cliente1 = new Cliente();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o Nome: ");
        cliente1.setNome(scanner.nextLine());

        System.out.println("Digite o CPF: ");
        cliente1.setCpf(scanner.nextLine());

        System.out.println("Digite a Cidade: ");
        cliente1.setCidade(scanner.nextLine());

        System.out.println("Digite a Renda: ");
        cliente1.setRenda(scanner.nextDouble());

        scanner.nextLine(); // toda vez que tiver uma entrada de dado que não seja string, é preciso pular uma linha separadamente com esse comando

        System.out.println("Digite o Sexo: ");
        String sexo = scanner.nextLine();
        cliente1.setSexo(sexo.charAt(0));

        System.out.println("Digite o Ano de Nascimento: ");
        cliente1.setAnoNascimento(scanner.nextInt());

        scanner.nextLine();

        System.out.println("Cliente Especial?: ");
        String especial  = scanner.nextLine().trim();
        if (especial.equalsIgnoreCase("SIM"))
            cliente1.setEspecial(true);
        else cliente1.setEspecial(false);

        System.out.println("Cliente 1");
        System.out.println("Nome: " + cliente1.getNome());
        System.out.println("CPF: " + cliente1.getCpf());
        System.out.println("Cidade: " + cliente1.getCidade());
        System.out.println("Renda: " + cliente1.getRenda());
        System.out.println("Sexo: " + cliente1.getSexo());
        System.out.println("Ano de Nascimento: " + cliente1.getAnoNascimento());
        System.out.println(cliente1.isEspecial());
        if (cliente1.isEspecial() == true)
            System.out.println("Cliente Especial: Sim.");
        else System.out.println("Cliente Especial: Não.");
        System.out.println();

        
    }
}
