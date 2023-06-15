package br.com.improving.carrinho.domains;

import java.util.Objects;

public class Produto {

    private Long codigo;
    private String descricao;

    public Produto(Long codigo, String descricao) {
    	this.codigo = codigo;
    	this.descricao = descricao;
    }

    public Long getCodigo() {
    	return codigo;
    }

	public String getDescricao() {
		return descricao;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Produto)) {
			return false;
		}
		final Produto produto = (Produto) o;
		return Objects.equals(codigo, produto.codigo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
}