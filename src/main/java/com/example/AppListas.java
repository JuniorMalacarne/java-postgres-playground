package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AppListas {
    public static void main(String[] args) {
        //Cliente[] vetorClientes = new Cliente[5]; //sintaxe para criar/instanciar um vetor (que tem quantidade de elementos limitada ao que é declarado na instanciação)
        
        //List<Cliente> listaClientes = new ArrayList<>(); //sintaxe para criar/instanciar uma lista (que tem quantidade de elementos dinâmica; mas também pode ser definida entre os últimos parênteses)
        // usar a List sem informar a quantidade de elementos pode comprometer a perfomance por causa dos processos de delimitação de quantidade de elementos 
        // (ele inicia com 10 posições vai criando "vetores" cada vez que é acrescentado um elemento que extrapola a primeira quantidade. assim aloca quantidade maior de memória)

        List<Cliente> listaClientes = new LinkedList<>(); // sintaxe para criar/instanciar uma lista verdadeiramente dinâmica (pois ela aloca memória somente a cada elemento que é incluído)
        // a alocação de memória pode ser mais rápida mas a leitura pode ser mais lenta, pois os elementos dificilmente estarão alocados próximos um do outro na memória
        Cliente cliente1 = new Cliente();
        cliente1.setNome("João");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria");

        // listas aceitam elementos duplicados (Sets não...)
        listaClientes.add(cliente1);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente2);

        listaClientes.remove(0); // removendo um elemento de um índice determinado
        
        listaClientes.remove(cliente1); // removendo o primeiro elemento contendo o objeto declarado
        
        int tamanho = listaClientes.size()-1; // pegando a posição do último elemento (size retorna a quantidade total de elementos da lista)
        listaClientes.remove(tamanho); // removendo o elemento da posição armazenada na variável tamanho, nesse caso o último
        
        System.out.println(listaClientes); // imprime a lista diretamente de uma só vez, um elemento atrás do outro
        
        for (Cliente cliente : listaClientes) { // atalho "foreach" para percorrer listas (e vetores?). Assim podemos imprimir cada elemento invidualmente
            System.out.println(cliente);
        }
    }
}
