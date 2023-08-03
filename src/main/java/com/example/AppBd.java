package com.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class AppBd {
    public static void main(String[] args){
        try {
            Class.forName("org.postgresql.Driver"); // chamando a classe que representa a conexão com o Banco de Dados
            var conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "gitpod", ""); // com o drivermanager é possível obter a conexão com o Banco de Dados
            System.out.println("Conexão com Banco de Dados realizada com sucesso.");

            var statement = conn.createStatement(); // método para criar uma declaração SQL através do objeto da conexão, onde cria um objeto statement
            var result = statement.executeQuery("select * from estado");  // com o objeto statement é possível enviar comandos para o banco de dados. A variável result vai receber esses dados

            while(result.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }

        } catch (ClassNotFoundException e) { //exceção, caso não consiga carregar a classe
            System.err.println("Não foi possível carregar a biblioteca para acesso ao Banco de Dados: " + e.getMessage());
        } catch (SQLException e) { // exceção, caso não consiga conectar ao Banco de Dados
            System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());
        } 
    }
}
