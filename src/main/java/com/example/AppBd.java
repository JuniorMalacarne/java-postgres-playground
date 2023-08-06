package com.example;

import java.sql.SQLException;

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
            
            /* CRUD com a tabela estado
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
            //estadoDAO.alterar(estado);
            //estadoDAO.excluir(estado);
            //estadoDAO.inserir(estado);
            estadoDAO.localizar(estado);
            
            var listaEstados = estadoDAO.listar();
            for (var registroEstado : listaEstados) {
                System.out.println(registroEstado); //para imprimir o objeto diretamente dessa forma é preciso ter um método toString na classe Estado (a String fica padronizada nesse caso)
                //System.out.println("Nome: " + registroEstado.getNome()); // dessa forma pode-se montar a String como quiser na hora de imprimir os dados, sem precisar ter criado o método toString na classe Estado
            }
            */

            /*  CRUD com a tabela produto
            var marca = new Marca(); // instanciando uma classe marca no objeto marca
            marca.setId(3L); // setando/indicando o id da tabela marca (que já existe) para o objeto criado marca

            var produto = new Produto(); // instanciando uma classe produto no objeto produto
            produto.setId(210L); // setando/indicando o id do produto que será usando como condição para ATUALIZÁ-LO
            produto.setMarca(marca); // setando/indicando o objeto marca como a marca do objeto produto (pois no BD é uma chave estrangeira)
            produto.setNome("Produto Atualizado 5"); // setando/indicando um nome que está sendo criado para o novo objeto produto
            produto.setValor(200.00); // setando/indicando um valor que está sendo criado para o novo objeto produto

            var produtoDAO = new ProdutoDAO(connection);
            //produtoDAO.inserir(produto);
            //produtoDAO.excluir(produto);
            //produtoDAO.alterar(produto);
            //produtoDAO.localizar(produto);

            var listaProdutos = produtoDAO.listar();
            for (var registroProduto : listaProdutos) {
                System.out.println(registroProduto);
            }
            */

            /* 
            var dao = new DAO(connection);
            dao.listar("cliente");
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
