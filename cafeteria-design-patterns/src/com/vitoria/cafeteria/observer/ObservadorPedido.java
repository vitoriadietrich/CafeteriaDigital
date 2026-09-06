package com.vitoria.cafeteria.observer;

import com.vitoria.cafeteria.model.Pedido;

/**
 * Padrão Observer: define quem quer ser avisado sempre que o status de um pedido mudar.
 */
public interface ObservadorPedido {

    void atualizar(Pedido pedido);
}
