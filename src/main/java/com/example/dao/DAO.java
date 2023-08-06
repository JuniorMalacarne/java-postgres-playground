package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DAO {
    protected Connection connection;

    public DAO(Connection connection) {
        this.connection = connection;
    }

    public void listar(String tabela) {
        try {
            var sql = "select * from " + tabela;
            var statement = connection.prepareStatement(sql);
            var result = statement.executeQuery();
            
            var metadada = result.getMetaData();
            int cols = metadada.getColumnCount(); // obtendo metadados da tabela e a quantidade de colunas
            for (int i = 1; i <= cols; i++) { // em SQL os parâmetros começam a contar do 1 (as colunas da tabela)
                System.out.printf("%-25s | ", metadada.getColumnName(i)); // obtendo em formato String o conteúdo do nome de cada coluna da tabela
            }
            System.out.println();
            while(result.next()){// o método next verifica se há alguma linha após
                for (int i = 1; i <= cols; i++) { // em SQL os parâmetros começam a contar do 1 (as colunas da tabela)
                    System.out.printf("%-25s | ", result.getString(i)); // obtendo em formato String o conteúdo de cada coluna da tabela
                }
                System.out.println();
            }
            System.out.println();
        } catch (SQLException e) {
            System.err.println("Não foi possível executar a consulta ao banco de dados: " + e.getMessage());
        }
    }
}
