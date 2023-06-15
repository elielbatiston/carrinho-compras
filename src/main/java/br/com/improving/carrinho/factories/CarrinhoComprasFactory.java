package br.com.improving.carrinho.factories;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import br.com.improving.carrinho.domains.CarrinhoCompras;

public class CarrinhoComprasFactory {

	private static List<CarrinhoCompras> carrinhos;
	private static String clienteAtual;

	public CarrinhoComprasFactory() {
	}

    public CarrinhoCompras criar(final String identificacaoCliente) {
		CarrinhoComprasFactory.setClienteAtual(identificacaoCliente);
    	CarrinhoCompras carrinho = CarrinhoComprasFactory.getCarrinhoCompras(identificacaoCliente);
    	if (carrinho == null) {
    		carrinho = new CarrinhoCompras(identificacaoCliente);
    	}
    	return carrinho;
    }

    public BigDecimal getValorTicketMedio() {
    	if (CarrinhoComprasFactory.getCarrinhoCompras().size() == 0) {
    		return BigDecimal.ZERO;
    	}
    	
    	final BigDecimal valorTotal = CarrinhoComprasFactory.getCarrinhoCompras().stream()
                .map(CarrinhoCompras::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
		return valorTotal.divide(new BigDecimal(carrinhos.size()), RoundingMode.HALF_UP);
    }

    public boolean invalidar(final String identificacaoCliente) {
    	final CarrinhoCompras carrinho = CarrinhoComprasFactory.getCarrinhoCompras(identificacaoCliente);
    	if (carrinho == null) {
    		return false;
    	}
		CarrinhoComprasFactory.getCarrinhoCompras().remove(carrinho);
    	return true;
    }
    
    private static List<CarrinhoCompras> getCarrinhoCompras() {
    	if (CarrinhoComprasFactory.carrinhos == null) {
			CarrinhoComprasFactory.carrinhos = new ArrayList<>();
    	}
    	
    	return CarrinhoComprasFactory.carrinhos;
    }
    
    private static CarrinhoCompras getCarrinhoCompras(final String identificacaoCliente) {
    	return CarrinhoComprasFactory.getCarrinhoCompras().stream()
    			.filter(carrinho -> carrinho.getIdentificacaoCliente().equals(identificacaoCliente))
    			.findFirst()
    			.orElse(null);
    } 
    
    public static CarrinhoCompras findCarrinhoCompras(final CarrinhoCompras carrinhoCompras) {
		return CarrinhoComprasFactory.getCarrinhoCompras().stream()
				.filter(it -> it.equals(carrinhoCompras))
				.findFirst()
				.orElse(null);
	}

	public static void renovarCarrinho(final CarrinhoCompras carrinhoCompras) {
		final CarrinhoCompras carrinho = CarrinhoComprasFactory.findCarrinhoCompras(carrinhoCompras);
		if (carrinho != null) {
			getCarrinhoCompras().remove(carrinho);
		}
		getCarrinhoCompras().add(carrinhoCompras);
	}

	public static String getClienteAtual() {
		return CarrinhoComprasFactory.clienteAtual;
	}

	public static void setClienteAtual(String clienteAtual) {
		CarrinhoComprasFactory.clienteAtual = clienteAtual;
	}
}
