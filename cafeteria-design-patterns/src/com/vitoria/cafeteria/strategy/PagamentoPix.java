package com.vitoria.cafeteria.strategy;

public class PagamentoPix implements FormaPagamento {

    private static final double DESCONTO = 0.05; // 5% de desconto no Pix

    @Override
    public void pagar(double valor) {
        double valorComDesconto = valor * (1 - DESCONTO);
        System.out.printf("Pagamento via Pix: R$ %.2f (5%% de desconto aplicado)%n", valorComDesconto);
    }

    @Override
    public String getNome() {
        return "Pix";
    }
}
