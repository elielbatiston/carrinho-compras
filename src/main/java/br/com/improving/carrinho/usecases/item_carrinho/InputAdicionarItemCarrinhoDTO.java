package br.com.improving.carrinho.usecases.item_carrinho;

import java.math.BigDecimal;

import br.com.improving.carrinho.domains.Produto;

public class InputAdicionarItemCarrinhoDTO {
	private Produto produto;
	private BigDecimal valorUn;
	private int quantidade;

	public InputAdicionarItemCarrinhoDTO(Produto produto, BigDecimal valorUn, int quantidade) {
		this.produto = produto;
		this.valorUn = valorUn;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public BigDecimal getValorUn() {
		return valorUn;
	}

	public int getQuantidade() {
		return quantidade;
	}
}
