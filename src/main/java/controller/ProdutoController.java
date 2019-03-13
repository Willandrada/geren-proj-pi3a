/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.Date;
import model.Produto;

/**
 *
 * @author Johnathan
 */
public class ProdutoController {

    //salvar no banco de dados
    public static boolean Salvar(String nome, String descricao, float valorCompra, float valorVenda, int quantidade, boolean status) {
        model.Produto produto = new model.Produto(nome, descricao, valorCompra, valorVenda, quantidade, status);
        return ProdutoDAO.SalvarProduto(produto);

    }

    public static boolean Excluir(int indice) {
        return ProdutoDAO.ExcluirProduto(indice);
    }

    public static boolean Atualizar(String nome, String descricao, float valorCompra, float valorVenda, int quantidade, boolean status) {
        model.Produto produto = new model.Produto(nome, descricao, valorCompra, valorVenda, quantidade, status);
        return ProdutoDAO.AtualizarProduto(produto);
    }

    public static ArrayList<String[]> getProdutos() {
        ArrayList<model.Produto> produtos = ProdutoDAO.getProdutos();
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            listaProdutos.add(new String[]{String.valueOf(produtos.get(i).getIdProduto()),
                produtos.get(i).getNome(),
                String.valueOf(produtos.get(i).getdescricao()),
                String.valueOf(produtos.get(i).getPrecoCompra()),
                String.valueOf(produtos.get(i).getPrecoVenda()),
                String.valueOf(produtos.get(i).getQuantidade()),
                String.valueOf(produtos.get(i).isStatus()),});

        }
        return listaProdutos;
    }

    public static ArrayList<String[]> ConsultarProdutoNome(String nome) {
        ArrayList<model.Produto> produto = ProdutoDAO.ConsultarProdutoNome(nome);
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produto.size(); i++) {
            listaProdutos.add(new String[]{String.valueOf(produto.get(i).getIdProduto()),
                produto.get(i).getNome(),
                String.valueOf(produto.get(i).getdescricao()),
                String.valueOf(produto.get(i).getPrecoCompra()),
                String.valueOf(produto.get(i).getPrecoVenda()),
                String.valueOf(produto.get(i).getQuantidade()),
                String.valueOf(produto.get(i).isStatus()),});

        }
        return listaProdutos;
    }

}
