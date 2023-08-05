package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.model.Produto;

public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Produto produto) {
        var sql = "insert into produto (nome, marca_id, valor) values (?, ?, ?)";
        try(var statement = connection.prepareStatement(sql)){
            statement.setString(1, produto.getNome()); // o objeto produto que é passado como parâmetro no método inserirProduto é usado como parâmetro do "statement.set" para informar os valores do comando SQL
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.executeUpdate();
        } catch (SQLException e){
            System.err.println("Não foi possível executar a inserção no banco de dados: " + e.getMessage());
        }  
    }

    public void alterar(Produto produto) {
        var sql = "update produto set nome = ?, marca_id = ?, valor = ? where id = ?";
        try(var statement = connection.prepareStatement(sql)){
            statement.setString(1, produto.getNome()); // o objeto produto que é passado como parâmetro no método inserirProduto é usado como parâmetro do "statement.set" para informar os valores do comando SQL
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.setLong(4, produto.getId());
            statement.executeUpdate();
        } catch (SQLException e){
            System.err.println("Não foi possível executar a atualização no banco de dados: " + e.getMessage());
        }  
    }

    public void excluir(long id) {
        var sql = "Delete from produto where id = ?";
        try (var statement = connection.prepareStatement(sql)){
            statement.setLong(1, id); // o valor da variável id que é passado como parâmetro no método inserirProduto é usado como parâmetro do "statement.set" para informar o valor do comando SQL
            if (statement.executeUpdate() == 1) //executeUpdate retorna um número que infomra se foi executado o comando (nesse caso se encontrou um registro que atende ao comando para executá-lo)
                System.out.println("Produto excluído com sucesso.");
            else System.out.println("Produto não localizado.");
        } catch (SQLException e){
            System.err.println("Não foi possível executar a exclusão no Banco de Dados: " + e.getMessage());
        }
    }

    public void listar() {
        var sql = "select * from produto";
        try(var statement = connection.prepareStatement(sql)){ 
            //var statement = connection.createStatement(); // método para criar uma declaração SQL através do objeto da conexão, onde cria um objeto statement
            //var result = statement.executeQuery("select * from estado");  // com o objeto statement é possível enviar comandos para o banco de dados. A variável result vai receber esses dados
            
            var result = statement.executeQuery();
            while(result.next()){
                System.out.printf("Id: %d Nome: %s Marca_ID: %d Valor: %d\n", result.getInt("id"), result.getString("nome"), result.getInt("marca_id"), result.getInt("Valor")); // método printf para mostrar dados "formatados" (suporta vários argumentos)
            }
            System.out.println();
        }catch (SQLException e) { // exceção, caso haja alguma falha na consulta sql
            System.err.println("Não foi possível executar a consulta ao banco de dados: " + e.getMessage());
        }        
    }

    public void localizar(long id) {
        var sql = "select * from produto where id = ?";
        try (var statement = connection.prepareStatement(sql)){ 
            /*
            var statement = connection.createStatement(); // createStatement não recebe uma SQL
            var result = statement.executeQuery("select * from estado where uf = '" + uf + "'"); 
            *Passar e concatenar strings como comandos SQL pode resultar na falha grave de segurança chamada SQL Injection, 
            isso quando o usuário pode inserir dados de consulta na aplicação. 
            Uma opção para reforçar a segurança é sanitizar/validar os dados do usuário
            o prepareStatement cria uma consulta preparada (ele verifica se a consulta está correta) e ela não vai ser alterada. Apenas pode-se alterar o valor dos parâmetros            
            */

            statement.setLong(1, id); //os métodos set colocam a string no parâmetro (da sql) da ordem do número declarado
            var result = statement.executeQuery();
            
            if (result.next())
                System.out.printf("Id: %d Nome: %s Marca_ID: %d Valor %d\n", result.getInt("id"), result.getString("nome"), result.getInt("marca_id"), result.getInt("Valor"));
            else System.out.println("Produto não localizado.");
            System.out.println();
        } catch (SQLException e) {
            System.err.println("Não foi possível executar a consulta ao banco de dados: " + e.getMessage());
        }        
    }
}
