package br.com.improving.carrinho.domains.exceptions;

public class SemProdutosException extends RuntimeException {

	public SemProdutosException(String message) {
		super(message);
	}
}
