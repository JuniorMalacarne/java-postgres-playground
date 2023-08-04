package com.example;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBd {
    public static void main(String[] args){
        try {
            Class.forName("org.postgresql.Driver"); // chamando a classe que representa a conexão com o Banco de Dados
        } catch (ClassNotFoundException e) { //exceção, caso não consiga carregar a classe
            System.err.println("Não foi possível carregar a biblioteca para acesso ao Banco de Dados: " + e.getMessage());
        } 
        
        Statement statement = null;
        try(var connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "gitpod", "")){ 
            // com o drivermanager é possível obter a conexão com o Banco de Dados
            // o objeto Connection é autocloseable (fecha sozinho ao finalizar o try com parênteses, sem precisar fazer isso manualmente)
            // pois é preciso fechar a conexão do banco de dados quando finalizar a execução do que está dentro do try
            System.out.println("Conexão com Banco de Dados realizada com sucesso.");

            statement = connection.createStatement(); // método para criar uma declaração SQL através do objeto da conexão, onde cria um objeto statement
            var result = statement.executeQuery("select * from estado");  // com o objeto statement é possível enviar comandos para o banco de dados. A variável result vai receber esses dados

            while(result.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf")); // método printf para mostrar dados "formatados" (suporta vários argumentos)
            }
        }catch (SQLException e) { // exceção, caso não consiga conectar ao Banco de Dados ou haja alguma falha na consulta sql
            if (statement == null)
                System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());
            else System.err.println("Não foi possível executar a consulta ao banco de dados: " + e.getMessage());
        } 
    }
}
