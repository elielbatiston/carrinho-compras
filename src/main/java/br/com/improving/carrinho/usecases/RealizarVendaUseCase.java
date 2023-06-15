package br.com.improving.carrinho.usecases;

import br.com.improving.carrinho.domains.exceptions.SemProdutosException;
import br.com.improving.carrinho.helpers.ScreenHelper;
import br.com.improving.carrinho.usecases.carrinho.CriarCarrinhoCompraDoClienteUseCase;
import br.com.improving.carrinho.usecases.item_carrinho.VenderItemUseCase;

public class RealizarVendaUseCase {

	public static void execute() {
		try {
			CriarCarrinhoCompraDoClienteUseCase.execute();
			VenderItemUseCase.execute();
		} catch (SemProdutosException ex) {
			ScreenHelper.imprimirEPausar(ex.getMessage());
		}
	}
}
