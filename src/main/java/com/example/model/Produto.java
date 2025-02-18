package com.example.model;

public class Produto {
    private Long id; // ao usar a classe Long ao invés do tipo primitivo long, posso iniciá-lo como null
    private String nome;
    private Marca marca;
    private double valor;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Marca getMarca() {
        return marca;
    }
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString(){
        return "Produto: " + nome + " Id: " + id + " Valor: " + valor;
    }
}
