package br.com.improving.carrinho.usecases.carrinho;

import br.com.improving.carrinho.domains.CarrinhoCompras;
import br.com.improving.carrinho.singletons.Supermercado;

public class RenovarCarrinhoComprasUseCase {

	public static void execute() {
		final CarrinhoCompras carrinhoCompras = Supermercado.getInstance().getCarrinhoComprasAtual();
		Supermercado.getInstance()
				.getFactory()
				.renovarCarrinho(carrinhoCompras);
	}
}
