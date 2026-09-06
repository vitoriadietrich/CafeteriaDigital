package com.vitoria.cafeteria.observer;

import com.vitoria.cafeteria.model.Pedido;

public class ClienteNotificacao implements ObservadorPedido {

    private final String nomeCliente;

    public ClienteNotificacao(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Override
    public void atualizar(Pedido pedido) {
        System.out.printf("[Notificação para %s] Seu pedido #%d agora está: %s%n",
                nomeCliente, pedido.getNumero(), pedido.getStatus());
    }
}
