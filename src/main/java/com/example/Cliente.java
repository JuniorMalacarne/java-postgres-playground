package com.example;

public class Cliente{
    //variáveis criadas no nível da classe, chamadas de atributos. Qualquer função da classe consegue acessar essas variáveis
    private String nome;
    private double renda; 
    private char sexo;
    private int anoNascimento;
    private boolean especial;
    
    public Cliente(){ //método construtor. Não pode colocar o tipo do retorno (void, etc). Se o método não for incluso, fica implícito sem nada adicional
        //construtuores podem ser usados para inicialização de variáveis com valores padrão de acordo com alguma lógica ou para imprimir mensagens, por exemplo
        System.out.println("Criando um objeto Cliente.");
    }

    public Cliente(double renda, char sexo){
        this(); //chamando um outro método construtor (para evitar duplicação de código e poder generalizar alterações)
        //this.renda = renda; // jeito padrão para atribuir valor para o parâmetro
        setRenda(renda); // chamando o método Set para aplicar a lógica do método ao atribuir valor ao parâmetro
        setSexo(sexo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getRenda(){
        return renda;
    }

    public void setRenda(double renda){
        if (renda >= 0)    
            this.renda = renda; //usar o this. ou diferenciar o nome do parâmetro
        else System.out.println("A renda deve ser maior ou igual a zero.");
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if (sexo == 'M' || sexo == 'm' || sexo == 'F' || sexo == 'f')
            this.sexo = sexo;
        else System.out.println("O sexo deve ser 'M' ou 'F'.");
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }


}