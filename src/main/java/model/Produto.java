/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Johnathan
 */
public class Produto {

    private int idProduto;
    private String nome;
    private String descricao;
    private float precoCompra;
    private float precoVenda;
    private int quantidade;
    private boolean status;

    public Produto()
    {
        
    }
    
    public Produto(String nome, String descricao, float precoCompra, float precoVenda, int quantidade, boolean status)
    {
     this.nome = nome;
     this.descricao = descricao;
     this.precoCompra = precoCompra;
     this.precoVenda = precoVenda;
     this.quantidade = quantidade;
     this.status = status;
    }
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
