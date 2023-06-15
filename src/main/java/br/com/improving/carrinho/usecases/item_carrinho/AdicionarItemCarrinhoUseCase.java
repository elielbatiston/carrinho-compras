package br.com.improving.carrinho.usecases.item_carrinho;

import br.com.improving.carrinho.singletons.Supermercado;
import br.com.improving.carrinho.usecases.carrinho.RenovarCarrinhoComprasUseCase;

public class AdicionarItemCarrinhoUseCase {

	public static void execute(InputAdicionarItemCarrinhoDTO dto) {
		Supermercado.getInstance()
				.getCarrinhoComprasAtual()
				.adicionarItem(dto.getProduto(), dto.getValorUn(), dto.getQuantidade());
		RenovarCarrinhoComprasUseCase.execute();
	}
}
