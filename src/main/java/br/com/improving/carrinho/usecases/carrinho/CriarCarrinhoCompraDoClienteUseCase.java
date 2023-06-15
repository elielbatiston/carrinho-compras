package br.com.improving.carrinho.usecases.carrinho;

import br.com.improving.carrinho.domains.CarrinhoCompras;
import br.com.improving.carrinho.domains.exceptions.SemProdutosException;
import br.com.improving.carrinho.singletons.Supermercado;
import br.com.improving.carrinho.helpers.ScreenHelper;

public class CriarCarrinhoCompraDoClienteUseCase {

	public static void execute() {
		ScreenHelper.clearConsole();
		if (Supermercado.getInstance().getProdutos().size() == 0) {
			throw new SemProdutosException("Nenhum produto cadastrado. Por favor, cadastre um produto antes de entrar na venda!");
		}

		final String identificacaoCliente = ScreenHelper.readString("Informe a identificação do cliente: ");
		final CarrinhoCompras carrinhoCompras = Supermercado.getInstance().getFactory().criar(identificacaoCliente);
		Supermercado.getInstance().setCarrinhoComprasAtual(carrinhoCompras);
		RenovarCarrinhoComprasUseCase.execute();
	}
}
