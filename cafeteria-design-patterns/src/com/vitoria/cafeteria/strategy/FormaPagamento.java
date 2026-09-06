package com.vitoria.cafeteria.strategy;

/**
 * Padrão Strategy: cada forma de pagamento implementa sua própria regra de cobrança
 * (desconto, taxa, etc.), e o cliente pode trocar a estratégia em tempo de execução.
 */
public interface FormaPagamento {

    void pagar(double valor);

    String getNome();
}
