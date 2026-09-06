package com.vitoria.cafeteria.strategy;

public class PagamentoCartaoCredito implements FormaPagamento {

    private static final double TAXA = 0.03; // 3% de taxa da maquininha

    @Override
    public void pagar(double valor) {
        double valorComTaxa = valor * (1 + TAXA);
        System.out.printf("Pagamento via Cartão de Crédito: R$ %.2f (taxa de 3%% inclusa)%n", valorComTaxa);
    }

    @Override
    public String getNome() {
        return "Cartão de Crédito";
    }
}
