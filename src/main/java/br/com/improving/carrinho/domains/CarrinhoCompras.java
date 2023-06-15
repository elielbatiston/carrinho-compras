package br.com.improving.carrinho.domains;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import br.com.improving.carrinho.domains.Item;
import br.com.improving.carrinho.domains.Produto;

public class CarrinhoCompras {
	
	private String identificacaoCliente;
	
	private List<Item> itens;
	
	public CarrinhoCompras(String identificacaoCliente) {
		this.identificacaoCliente = identificacaoCliente;
	}

	public String getIdentificacaoCliente() {
		return this.identificacaoCliente;
	}

    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
    	valida(produto, valorUnitario, quantidade);
        
        final Item item = getItens().stream()
        		.filter(it ->  it.getProduto().equals(produto))
        		.findFirst()
        		.orElse(new Item(produto));

		item.somaQuantidade(quantidade);
		item.setValorUnitario(valorUnitario);
		removerItem(produto);
        
        getItens().add(item);
    }

    public boolean removerItem(Produto produto) {
        final Item item = getItens().stream()
			.filter(it ->  it.getProduto().equals(produto))
			.findFirst()
			.orElse(null);
        
        if (item == null) {
        	return false;
        }
        
        getItens().remove(item);
        return true;
    }

    public boolean removerItem(int posicaoItem) {
    	if (posicaoItem < 0 || posicaoItem >= getItens().size()) {
            return false;
        }
    	getItens().remove(posicaoItem);
    	return true;
    }

    public BigDecimal getValorTotal() {
    	final BigDecimal soma = getItens().stream()
			.map(Item::getValorTotal)
			.reduce(BigDecimal.ZERO, BigDecimal::add);
    	
    	return soma;
    }

    public Collection<Item> getItens() {
    	if(this.itens == null) {
    		this.itens = new ArrayList<>();
    	}
    	return this.itens;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof CarrinhoCompras)) {
			return false;
		}
		final CarrinhoCompras that = (CarrinhoCompras) o;
		return Objects.equals(identificacaoCliente, that.identificacaoCliente);
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificacaoCliente);
	}

	private void valida(Produto produto, BigDecimal valorUnitario, int quantidade) {
    	if (produto == null) {
    		throw new RuntimeException("Produto não encontrado!");
    	}
    	int resultado = valorUnitario.compareTo(BigDecimal.ZERO);
        if (resultado <= 0) {
        	throw new RuntimeException("O valor deve ser maior que zero.");
        } 
        if (quantidade <= 0) {
        	throw new RuntimeException("A quantidade deve ser maior que zero.");
        } 
    }
}
