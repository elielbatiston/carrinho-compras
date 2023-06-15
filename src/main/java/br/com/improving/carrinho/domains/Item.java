package br.com.improving.carrinho.domains;

import java.math.BigDecimal;

public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;

    public Item(Produto produto) {
    	this.produto = produto;
    	this.quantidade = 0;
    }

    public Produto getProduto() {
    	return produto;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
    	this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
    	BigDecimal quantidadeBigDecimal = new BigDecimal(quantidade);
    	return quantidadeBigDecimal.multiply(valorUnitario);
    }
    
    public void somaQuantidade(int quantidade) {
    	this.quantidade += quantidade;
    }
}
