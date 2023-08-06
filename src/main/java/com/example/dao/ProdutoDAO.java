package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Produto;

public class ProdutoDAO extends DAO { //extends torna a classe filha de uma superclasse (DAO) - Herança

    public ProdutoDAO(Connection connection) {
        super(connection); // chamando o atributo do construtor da superclasse DAO
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
            if (statement.executeUpdate() == 1) //executeUpdate retorna um número que infomra se foi executado o comando (nesse caso se encontrou um registro que atende ao comando para executá-lo)
                System.out.println("Produto inserido com sucesso.");
            else System.out.println("Produto não inserido.");
        } catch (SQLException e){
            System.err.println("Não foi possível executar a atualização no banco de dados: " + e.getMessage());
        }  
    }

    public void excluir(Produto produto) {
        var sql = "Delete from produto where id = ?";
        try (var statement = connection.prepareStatement(sql)){
            statement.setLong(1, produto.getId()); 
            if (statement.executeUpdate() == 1) //executeUpdate retorna um número que infomra se foi executado o comando (nesse caso se encontrou um registro que atende ao comando para executá-lo)
                System.out.println("Produto excluído com sucesso.");
            else System.out.println("Produto não localizado.");
        } catch (SQLException e){
            System.err.println("Não foi possível executar a exclusão no Banco de Dados: " + e.getMessage());
        }
    }

    public List<Produto> listar() throws SQLException {
        var lista = new LinkedList<Produto>();
        var sql = "select * from produto"; 
        var statement = connection.prepareStatement(sql); // método para criar uma declaração SQL através do objeto da conexão, onde cria um objeto statement
        var result = statement.executeQuery();
        
        while(result.next()){
            var produto = new Produto();
            produto.setId(result.getLong("id"));
            produto.setNome(result.getString("nome"));
            //produto.setInt(result.getInt("marca_id"));
            produto.setValor(result.getLong("Valor"));
            lista.add(produto);
        }
        return lista;
    }

    public void localizar(Produto produto) {
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

            statement.setLong(1, produto.getId()); //os métodos set colocam a string no parâmetro (da sql) da ordem do número declarado
            var result = statement.executeQuery();
            
            if (result.next())
                System.out.printf("Id: %d Nome: %s Marca_ID: %d Valor %d\n", result.getInt("id"), result.getString("nome"), result.getInt("marca_id"), result.getInt("valor"));
            else System.out.println("Produto não localizado.");
            System.out.println();
        } catch (SQLException e) {
            System.err.println("Não foi possível executar a consulta ao banco de dados: " + e.getMessage());
        }        
    }
}
