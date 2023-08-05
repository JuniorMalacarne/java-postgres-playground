package com.example.model;

import java.time.LocalDate;

public class Cidadao {
    private LocalDate dataNascimento;

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int idade(){ //não precisa declarar parâmetros para "pegar" a data de nascimento pois os métodos dentro de uma classe tem acesso direto a todas as variáveis da classe
        return LocalDate.now().getYear() - dataNascimento.getYear();
    }

    public String eleitor(){
        int idade = idade();
        if (idade < 16)
            return "Não é Eleitor."; // o return faz sair da função, então se há return dentro do if, não precisa de else
        if (idade > 15 && idade < 18 || idade > 70)
            return "É Eleitor Facultativo";
        return "É Eleitor";
    }
}
