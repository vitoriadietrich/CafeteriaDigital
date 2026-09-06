package com.vitoria.cafeteria.model;

import com.vitoria.cafeteria.observer.ObservadorPedido;

import java.util.ArrayList;
import java.util.List;

/**
 * Além de representar o pedido do cliente, esta classe atua como "Subject"
 * do padrão Observer: sempre que o status muda, todos os observadores são avisados.
 */
public class Pedido {

    private final int numero;
    private final Bebida bebida;
    private StatusPedido status;
    private final List<ObservadorPedido> observadores = new ArrayList<>();

    public Pedido(int numero, Bebida bebida) {
        this.numero = numero;
        this.bebida = bebida;
        this.status = StatusPedido.RECEBIDO;
    }

    public void adicionarObservador(ObservadorPedido observador) {
        observadores.add(observador);
    }

    public void setStatus(StatusPedido novoStatus) {
        this.status = novoStatus;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (ObservadorPedido observador : observadores) {
            observador.atualizar(this);
        }
    }

    public int getNumero() {
        return numero;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public StatusPedido getStatus() {
        return status;
    }
}
