package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres"; //localhost pois o servidor é local. Do contrário seria o IP do servidor
    // sintaxe da URL: jdbc:Banco de Dados://servidor/nome do banco

    public static Connection getConnection() throws SQLException{ // o throws passa o tratamento da exceção (erro de conexão com o banco) para quem chamar o método
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        // com o drivermanager é possível obter a conexão com o Banco de Dados
    }
}
