package com.mydrink.model;

import java.util.ArrayList;

import com.mydrink.dao.ProdutoDao;

public class Produto {

	private int produto_id;
	private String descricao;
	private int quantidade;
	private double preco;

	public Produto() {

	}

	public Produto(String descricao, int quantidade, double preco) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Produto(int produto_id, String descricao, int quantidade, double preco) {
		this.produto_id = produto_id;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public int getProduto_id() {
		return this.produto_id;
	}

	public void setProduto_id(int produto_id) {
		this.produto_id = produto_id;
	}
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void salvar() {
		new ProdutoDao().cadastrarProduto(this);
	}
	
	public void excluir(int Produto_id) {
		new ProdutoDao().ExcluirProduto(Produto_id);
	}
	
	public Produto buscarProdutoPorId(int Produto_id) {
		return new ProdutoDao().BuscarProdutoPorId(Produto_id);
	}
	
	public ArrayList<Produto> buscarProdutosPorDescricao(String descricao) {
	    return new ProdutoDao().BuscarProdutosPorDescricao(descricao);
	}
	
}
