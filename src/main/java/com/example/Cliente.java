package com.example;

public class Cliente{
    //variáveis criada no nível da classe, chamada de atributo. Qualquer função da classe consegue acessar essa variável
    private double renda; 
    private char sexo;
    private int anoNascimento;

    public double getRenda(){
        return renda;
    }

    public void setRenda(double renda){
        if(renda >= 0)    
            this.renda = renda; //usar o this. ou diferenciar o nome do parâmetro
        else System.out.println("A renda deve ser maior ou igual a zero");
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }




}