package com.example;

import java.time.LocalDate;

import com.example.model.Cidadao;

public class AppEleitor {
    public static void main(String[] args) {
        var cidadao = new Cidadao();
        cidadao.setDataNascimento(LocalDate.of(1955, 12, 9));
        System.out.println("Idade: " + cidadao.idade());
        System.out.println("Situação Eleitoral: " + cidadao.eleitor());
    }
}
