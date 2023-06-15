package br.com.improving.carrinho.singletons;

import java.util.ArrayList;
import java.util.List;

import br.com.improving.carrinho.domains.CarrinhoCompras;
import br.com.improving.carrinho.domains.Produto;
import br.com.improving.carrinho.factories.CarrinhoComprasFactory;

public class Supermercado {

	private static Supermercado supermercado;

	private static List<Produto> produtos;
	private static CarrinhoComprasFactory factory;
	private static CarrinhoCompras carrinhoComprasAtual;

	public static synchronized Supermercado getInstance() {
		if (supermercado == null) {
			Supermercado.supermercado = new Supermercado();
			Supermercado.produtos = new ArrayList<>();
			Supermercado.factory = new CarrinhoComprasFactory();
		}
		return Supermercado.supermercado;
	}

	public static void setProdutos(List<Produto> produtos) {
		Supermercado.produtos = produtos;
	}

	public static List<Produto> getProdutos() {
		return Supermercado.produtos;
	}

	public static CarrinhoComprasFactory getFactory() {
		return Supermercado.factory;
	}

	public static void setCarrinhoComprasAtual(CarrinhoCompras carrinhoComprasAtual) {
		Supermercado.carrinhoComprasAtual = carrinhoComprasAtual;
	}

	public static CarrinhoCompras getCarrinhoComprasAtual() {
		return Supermercado.carrinhoComprasAtual;
	}
}
