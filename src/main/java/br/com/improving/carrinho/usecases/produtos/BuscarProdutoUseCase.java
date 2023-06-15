package br.com.improving.carrinho.usecases.produtos;

import java.util.List;

import br.com.improving.carrinho.domains.Produto;
import br.com.improving.carrinho.singletons.Supermercado;
import br.com.improving.carrinho.helpers.ScreenHelper;

public class BuscarProdutoUseCase {

	public static Produto execute() {
		final List<Produto> produtos = Supermercado.getInstance().getProdutos();
		Produto produto;

		do {
			ScreenHelper.clearConsole();
			ScreenHelper.imprimir(String.format("CLIENTE %s **************", Supermercado.getInstance().getFactory().getClienteAtual()));
			final Long idProduto = ScreenHelper.readLong("Informe o codigo do produto: ");

			produto = produtos.stream()
					.filter(it -> it.getCodigo() == idProduto)
					.findFirst()
					.orElse(null);

			if (produto == null) {
				ScreenHelper.imprimirEPausar("Produto não encontrado!");
			}
		} while(produto == null);

		return produto;
	}
}
