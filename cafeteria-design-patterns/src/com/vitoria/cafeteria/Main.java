package com.vitoria.cafeteria;

import com.vitoria.cafeteria.decorator.ComChantilly;
import com.vitoria.cafeteria.decorator.ComLeite;
import com.vitoria.cafeteria.facade.CafeteriaFacade;
import com.vitoria.cafeteria.model.Bebida;
import com.vitoria.cafeteria.model.Cappuccino;
import com.vitoria.cafeteria.model.Espresso;
import com.vitoria.cafeteria.singleton.Caixa;
import com.vitoria.cafeteria.strategy.FormaPagamento;
import com.vitoria.cafeteria.strategy.PagamentoCartaoCredito;
import com.vitoria.cafeteria.strategy.PagamentoDinheiro;
import com.vitoria.cafeteria.strategy.PagamentoPix;

public class Main {

    public static void main(String[] args) {
        CafeteriaFacade cafeteria = new CafeteriaFacade();

        // Pedido 1: Espresso simples, pago no Pix (Decorator não aplicado + Strategy Pix)
        Bebida espresso = new Espresso();
        FormaPagamento pix = new PagamentoPix();
        cafeteria.fazerPedido("Ana", espresso, pix);

        // Pedido 2: Cappuccino com leite e chantilly, pago no cartão (Decorator + Strategy Cartão)
        Bebida cappuccinoEspecial = new ComChantilly(new ComLeite(new Cappuccino()));
        FormaPagamento cartao = new PagamentoCartaoCredito();
        cafeteria.fazerPedido("Bruno", cappuccinoEspecial, cartao);

        // Pedido 3: Espresso com leite, pago em dinheiro
        Bebida espressoComLeite = new ComLeite(new Espresso());
        FormaPagamento dinheiro = new PagamentoDinheiro();
        cafeteria.fazerPedido("Carla", espressoComLeite, dinheiro);

        // Singleton: o mesmo Caixa acumulou todas as vendas acima
        Caixa.getInstancia().exibirResumo();
    }
}
