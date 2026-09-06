package com.vitoria.cafeteria.strategy;

public class PagamentoDinheiro implements FormaPagamento {

    @Override
    public void pagar(double valor) {
        System.out.printf("Pagamento em Dinheiro: R$ %.2f%n", valor);
    }

    @Override
    public String getNome() {
        return "Dinheiro";
    }
}
