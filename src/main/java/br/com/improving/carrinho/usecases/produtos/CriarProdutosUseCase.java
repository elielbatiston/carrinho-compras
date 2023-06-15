package br.com.improving.carrinho.usecases.produtos;

import java.util.ArrayList;
import java.util.List;

import br.com.improving.carrinho.domains.Produto;
import br.com.improving.carrinho.singletons.Supermercado;
import br.com.improving.carrinho.helpers.ScreenHelper;

public class CriarProdutosUseCase {

	public static void execute() {
		int opcao;
		final List<Produto> produtos = Supermercado.getInstance().getProdutos();
		int cont = produtos.size() + 1;

		do {
			ScreenHelper.clearConsole();
			ScreenHelper.imprimirEPularLinha("Informe os dados do produto " + cont + " ===========");
			final Long codigo = ScreenHelper.readLong("Forneça o código: ");
			final String nome = ScreenHelper.readString("Forneça o nome: ");
			Produto produto = new Produto(
				codigo,
				nome
			);
			produtos.add(produto);

			opcao = ScreenHelper.menuSimOuNao("Deseja cadastrar mais produtos?");
			cont++;
		} while(opcao == 1);

		Supermercado.getInstance().setProdutos(produtos);
	}
}
