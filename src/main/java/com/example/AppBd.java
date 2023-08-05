package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.dao.ConnectionManager;
import com.example.dao.DAO;
import com.example.dao.EstadoDAO;
import com.example.dao.ProdutoDAO;
import com.example.model.Estado;
import com.example.model.Marca;
import com.example.model.Produto;
import com.example.model.RegiaoGeografica;

public class AppBd {
    public static void main(String[] args){
        new AppBd();
    }

    public AppBd(){
        //carregarDriverJDBC(); // os frameworks atuais como o Spring realizam o carregamento do driver do banco de dados automaticamente sem precisar que criemos um método para isso

        try(var connection = ConnectionManager.getConnection()){
            // o objeto Connection é autocloseable (fecha sozinho ao finalizar o try com parênteses, sem precisar fazer isso manualmente)
            // pois é preciso fechar a conexão do banco de dados quando finalizar a execução do que está dentro do try
            
            //System.out.println("Conexão com Banco de Dados realizada com sucesso.");
            
            /* CRUD co ma tabela estado
            var regiao = new RegiaoGeografica();
            regiao.setId(1L);

            var estado = new Estado();
            estado.setId(27L);
            estado.setNome("Tocantins");
            estado.setUf("TO");
            estado.setRegiao(regiao);
            estado.setAreakm2(2777466);
            estado.setPopulacao(1584306);

            var estadoDAO = new EstadoDAO(connection);
            estadoDAO.listar();
            
            estadoDAO.alterar(estado);
            //estadoDAO.excluir(27L);
            //estadoDAO.inserir(estado);

            estadoDAO.localizar("TO");
            */

            // CRUD com a tabela produto
            var marca = new Marca(); // instanciando uma classe marca no objeto marca
            marca.setId(3L); // setando/indicando o id da tabela marca (que já existe) para o objeto criado marca

            var produto = new Produto(); // instanciando uma classe produto no objeto produto
            produto.setId(204L); // setando/indicando o id do produto que será usando como condição para ATUALIZÁ-LO
            produto.setMarca(marca); // setando/indicando o objeto marca como a marca do objeto produto (pois no BD é uma chave estrangeira)
            produto.setNome("Produto Atualizado"); // setando/indicando um nome que está sendo criado para o novo objeto produto
            produto.setValor(200.00); // setando/indicando um valor que está sendo criado para o novo objeto produto

            var produtoDAO = new ProdutoDAO(connection);
            //produtoDAO.inserir(produto);
            //produtoDAO.excluir(202L);
            //produtoDAO.alterar(produto);
            produtoDAO.listar();
            produtoDAO.localizar(200);

            /*
            var dao = new DAO(connection);
            dao.listar("produto");
            */
        }catch (SQLException e) { // exceção, caso não consiga conectar ao Banco de Dados
                System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());
        } 
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
