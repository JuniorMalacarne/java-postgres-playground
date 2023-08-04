package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBd {
    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";

    public static void main(String[] args){
        new AppBd();
    }

    public AppBd(){
        //carregarDriverJDBC(); // os frameworks atuais como o Spring realizam o carregamento do driver do banco de dados automaticamente sem precisar que criemos um método para isso

        try(var connection = getConnection()){
            // o objeto Connection é autocloseable (fecha sozinho ao finalizar o try com parênteses, sem precisar fazer isso manualmente)
            // pois é preciso fechar a conexão do banco de dados quando finalizar a execução do que está dentro do try
            
            System.out.println("Conexão com Banco de Dados realizada com sucesso.");

            listarEstados(connection);
            localizarEstados(connection, "ES");
            listaDadosTabela(connection, "produto");
        }catch (SQLException e) { // exceção, caso não consiga conectar ao Banco de Dados ou haja alguma falha na consulta sql
                System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());
        } 
    }

    private void listaDadosTabela(Connection connection, String tabela) {
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

    private void localizarEstados(Connection connection, String uf) {
        try {
            /*
            var statement = connection.createStatement(); // createStatement não recebe uma SQL
            var result = statement.executeQuery("select * from estado where uf = '" + uf + "'"); 
            *Passar e concatenar strings como comandos SQL pode resultar na falha grave de segurança chamada SQL Injection, 
            isso quando o usuário pode inserir dados de consulta na aplicação. 
            Uma opção para reforçar a segurança é sanitizar/validar os dados do usuário
            */

            var sql = "select * from estado where uf = ?";
            var statement = connection.prepareStatement(sql); // o prepareStatement cria uma consulta preparada (ele verifica se a consulta está correta) e ela não vai ser alterada. Apenas pode-se alterar o valor dos parâmetros            
            statement.setString(1, uf); //os métodos set colocam a string no parâmetro (da sql) da ordem do número declarado
            var result = statement.executeQuery();
            
            if (result.next())
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            System.out.println();
        } catch (SQLException e) {
            System.err.println("Não foi possível executar a consulta ao banco de dados: " + e.getMessage());
        }        
    }

    private void listarEstados(Connection connection) {
        try{ 
            //var statement = connection.createStatement(); // método para criar uma declaração SQL através do objeto da conexão, onde cria um objeto statement
            //var result = statement.executeQuery("select * from estado");  // com o objeto statement é possível enviar comandos para o banco de dados. A variável result vai receber esses dados

            var sql = "select * from estado";
            var statement = connection.prepareStatement(sql);
            var result = statement.executeQuery();

            while(result.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf")); // método printf para mostrar dados "formatados" (suporta vários argumentos)
            }
            System.out.println();
        }catch (SQLException e) { // exceção, caso haja alguma falha na consulta sql
            System.err.println("Não foi possível executar a consulta ao banco de dados: " + e.getMessage());
        }        
    }

    private Connection getConnection() throws SQLException{ // o throws passa o tratamento da exceção (erro de conexão com o banco) para quem chamar o método
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        // com o drivermanager é possível obter a conexão com o Banco de Dados
    }
    
    /*
    private void carregarDriverJDBC() {
        try {
            Class.forName("org.postgresql.Driver"); // chamando a classe que representa a conexão com o Banco de Dados - carregamento do Driver JDBC (API de conexão com banco de dados)
        } catch (ClassNotFoundException e) { //exceção, caso não consiga carregar a classe
            System.err.println("Não foi possível carregar a biblioteca para acesso ao Banco de Dados: " + e.getMessage());
        }
    }
    */
}
