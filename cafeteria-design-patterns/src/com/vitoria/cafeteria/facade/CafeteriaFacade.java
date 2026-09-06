package com.vitoria.cafeteria.facade;

import com.vitoria.cafeteria.model.Bebida;
import com.vitoria.cafeteria.model.Pedido;
import com.vitoria.cafeteria.model.StatusPedido;
import com.vitoria.cafeteria.observer.ClienteNotificacao;
import com.vitoria.cafeteria.singleton.Caixa;
import com.vitoria.cafeteria.strategy.FormaPagamento;

/**
 * Padrão Facade: esconde do cliente toda a complexidade de criar o pedido,
 * registrar as notificações (Observer), processar o pagamento (Strategy)
 * e lançar a venda no caixa (Singleton). Para quem usa, é só uma chamada simples.
 */
public class CafeteriaFacade {

    private int proximoNumeroPedido = 1;

    public Pedido fazerPedido(String nomeCliente, Bebida bebida, FormaPagamento formaPagamento) {
        System.out.println("=== Novo pedido de " + nomeCliente + " ===");

        Pedido pedido = new Pedido(proximoNumeroPedido++, bebida);
        pedido.adicionarObservador(new ClienteNotificacao(nomeCliente));

        System.out.printf("Item: %s | Valor: R$ %.2f%n", bebida.getDescricao(), bebida.getPreco());

        formaPagamento.pagar(bebida.getPreco());
        Caixa.getInstancia().registrarVenda(bebida.getPreco());

        pedido.setStatus(StatusPedido.EM_PREPARO);
        pedido.setStatus(StatusPedido.PRONTO);
        pedido.setStatus(StatusPedido.FINALIZADO);

        System.out.println();
        return pedido;
    }
}
