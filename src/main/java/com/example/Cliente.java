package com.example;

public class Cliente{
    //variáveis criadas no nível da classe, chamadas de atributos. Qualquer função da classe consegue acessar essas variáveis
    private String nome;
    private String cpf;
    private String cidade;
    private double renda; 
    private char sexo;
    private int anoNascimento;
    private boolean especial;
    
    public Cliente(){ //método construtor. Não pode colocar o tipo do retorno (void, etc). Se o método não for incluso, fica implícito sem nada adicional
        //construtuores podem ser usados para inicialização de variáveis com valores padrão de acordo com alguma lógica ou para imprimir mensagens, por exemplo
        System.out.println("Criando um objeto Cliente.");
    }

    public Cliente(String nome, String cpf, String cidade, double renda, char sexo, int anoNascimento, boolean especial){
        this(); //chamando um outro método construtor (para evitar duplicação de código e poder generalizar alterações)
        //this.renda = renda; // jeito padrão para atribuir valor para o parâmetro
        setNome(nome); // chamando o método Set para aplicar a lógica do método ao atribuir valor ao parâmetro
        setCpf(cpf);
        setCidade(cidade);
        setRenda(renda);
        setSexo(sexo);
        setAnoNascimento(anoNascimento);
        setEspecial(especial);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isBlank())
            System.out.println("O nome não pode ser vazio.");
        else this.nome = nome.toUpperCase().trim(); // colocando tudo me maiúsculo e retirando espaços periféricos
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf.length() == 11)
            this.cpf = cpf;
        else System.out.println("O CPF deve conter 11 dígitos.");
    } 

    public String getCidade() {
        return cidade;
       }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
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