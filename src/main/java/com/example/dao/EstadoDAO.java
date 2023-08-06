package com.example.dao; 
// o pacote DAO contém classes para instanciar objetos de conexão com o banco de dados

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Estado;

public class EstadoDAO extends DAO { //extends torna a classe filha de uma superclasse (DAO) - Herança
    
    public EstadoDAO(Connection connection) { //construtor
        super(connection); // chamando o construtor da superclasse DAO
    }

    public void inserir(Estado estado) {
        var sql = "insert into estado (nome, uf, regiao_id, area_km2, populacao) values (?, ?, ?, ?, ?)";
        try(var statement = connection.prepareStatement(sql)){
            statement.setString(1, estado.getNome()); // o objeto estado que é passado como parâmetro no método inserirestado é usado como parâmetro do "statement.set" para informar os valores do comando SQL
            statement.setString(2, estado.getUf());
            statement.setLong(3, estado.getRegiao().getId());
            statement.setInt(4, estado.getAreakm2());
            statement.setInt(5, estado.getPopulacao());
            statement.executeUpdate();
        } catch (SQLException e){
            System.err.println("Não foi possível executar a inserção no banco de dados: " + e.getMessage());
        }  
    }

    public void alterar(Estado estado) {
        var sql = "update estado set nome = ?, uf = ?, regiao_id = ?, area_km2 = ?, populacao = ? where id = ?";
        try(var statement = connection.prepareStatement(sql)){
            statement.setString(1, estado.getNome()); // o objeto estado que é passado como parâmetro no método inserirestado é usado como parâmetro do "statement.set" para informar os valores do comando SQL
            statement.setString(2, estado.getUf());
            statement.setLong(3, estado.getRegiao().getId());
            statement.setInt(4, estado.getAreakm2());
            statement.setInt(5, estado.getPopulacao());
            statement.setLong(6, estado.getId());
            statement.executeUpdate();
        } catch (SQLException e){
            System.err.println("Não foi possível executar a atualização no banco de dados: " + e.getMessage());
        }  
    }

    public void excluir(long id) {
        var sql = "Delete from estado where id = ?";
        try (var statement = connection.prepareStatement(sql)){
            statement.setLong(1, id); // o valor da variável id que é passado como parâmetro no método inserirestado é usado como parâmetro do "statement.set" para informar o valor do comando SQL
            if (statement.executeUpdate() == 1) //executeUpdate retorna um número que infomra se foi executado o comando (nesse caso se encontrou um registro que atende ao comando para executá-lo)
                System.out.println("estado excluído com sucesso.");
            else System.out.println("estado não localizado.");
        } catch (SQLException e){
            System.err.println("Não foi possível executar a exclusão no Banco de Dados: " + e.getMessage());
        }
    }
    
    public List<Estado> listar() throws SQLException {
        var lista = new LinkedList<Estado>();
        
        //var statement = connection.createStatement(); // método para criar uma declaração SQL através do objeto da conexão, onde cria um objeto statement
        //var result = statement.executeQuery("select * from estado");  // com o objeto statement é possível enviar comandos para o banco de dados. A variável result vai receber esses dados

        var sql = "select * from estado";
        var statement = connection.prepareStatement(sql);
        var result = statement.executeQuery();

        while(result.next()){ // preenchendo uma estrutura de dados em Lista. Quem chamá-lo decide o que fazer com os dados
            var estado = new Estado();
            estado.setId(result.getLong("id"));
            estado.setNome(result.getString("nome"));
            estado.setUf(result.getString("uf"));
            //estado.setRegiao(getInt("regiao_id"));
            //System.out.printf("Regiao %d\n", result.getInt("regiao_id"));
            estado.setAreakm2(result.getInt("area_km2"));
            estado.setPopulacao(result.getInt("populacao"));
            lista.add(estado);
        }
        /*Código se fosse imprimir no terminal (teste) 
        while(result.next()){
            System.out.printf("Id: %d Nome: %s UF: %s Regiao_Id: %d Area_km2: %d Populacao: %d\n", result.getInt("id"), result.getString("nome"), result.getString("uf"), result.getInt("regiao_id"), result.getInt("area_km2"), result.getInt("populacao")); // método printf para mostrar dados "formatados" (suporta vários argumentos)
        }
        System.out.println();
        */
        return lista;       
    }

    public void localizar(String uf) {
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
                System.out.printf("Id: %d Nome: %s UF: %s Regiao_Id: %d Area_km2: %d Populacao: %d\n", result.getInt("id"), result.getString("nome"), result.getString("uf"), result.getInt("regiao_id"), result.getInt("area_km2"), result.getInt("populacao"));
            else System.out.println("Estado não localizado: " + uf);
            System.out.println();
        } catch (SQLException e) {
            System.err.println("Não foi possível executar a consulta ao banco de dados: " + e.getMessage());
        }        
    }
}
