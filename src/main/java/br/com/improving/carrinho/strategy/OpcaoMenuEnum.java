package br.com.improving.carrinho.strategy;

import br.com.improving.carrinho.helpers.ScreenHelper;
import br.com.improving.carrinho.usecases.RealizarVendaUseCase;
import br.com.improving.carrinho.usecases.carrinho.CalcularTicketMedioUseCase;
import br.com.improving.carrinho.usecases.carrinho.InvalidarCarrinhoUseCase;
import br.com.improving.carrinho.usecases.produtos.CriarProdutosUseCase;

public enum OpcaoMenuEnum implements OpcaoMenu {

	PRODUTO(1) {
		@Override
		public void acao() {
			CriarProdutosUseCase.execute();
		}
	},
	VENDER(2) {
		@Override
		public void acao() {
			RealizarVendaUseCase.execute();
		}
	},
	TICKET_MEDIO(3) {
		@Override
		public void acao() {
			CalcularTicketMedioUseCase.execute();
		}
	},
	INVALIDAR_CARRINHO(4) {
		@Override
		public void acao() {
			InvalidarCarrinhoUseCase.execute();
		}
	},
	SAIR(9) {
		@Override
		public void acao() {
			System.out.println("Saindo ....");
		}
	},
	OPCAO_INVALIDA(-1) {
		@Override
		public void acao() {
			ScreenHelper.imprimirEPausar("Opção inválida!!");
		}
	};

	private final int opcao;

	OpcaoMenuEnum(int opcao) {
		this.opcao = opcao;
	}

	public int getOpcao() {
		return opcao;
	}

	public static OpcaoMenuEnum getInstance(final int opcao) {
		OpcaoMenuEnum found = OpcaoMenuEnum.OPCAO_INVALIDA;

		for (OpcaoMenuEnum op : OpcaoMenuEnum.values()) {
			if (op.getOpcao() == opcao) {
				found = op;
				break;
			}
		}

		return found;
	}
}
