package br.com.improving.carrinho.usecases.item_carrinho;

import java.math.BigDecimal;
import br.com.improving.carrinho.domains.Produto;
import br.com.improving.carrinho.helpers.ScreenHelper;
import br.com.improving.carrinho.singletons.Supermercado;
import br.com.improving.carrinho.usecases.produtos.BuscarProdutoUseCase;

public class VenderItemUseCase {

	public static void execute() {
		int opcao;

		do {
			final Produto produto = BuscarProdutoUseCase.execute();
			ScreenHelper.imprimir(String.format("Vendendo (%s-%s)", produto.getCodigo(), produto.getDescricao()));
			final BigDecimal valorUn = ScreenHelper.readBigDecimal("Informe o valor unitário: ");
			final int quantidade = ScreenHelper.readInt("Informe a quantidade: ");
			final InputAdicionarItemCarrinhoDTO dto =
				new InputAdicionarItemCarrinhoDTO(produto, valorUn, quantidade);

			AdicionarItemCarrinhoUseCase.execute(dto);

			opcao = ScreenHelper.menuSimOuNao("Deseja vender mais itens?");
		} while(opcao == 1);
	}
}
