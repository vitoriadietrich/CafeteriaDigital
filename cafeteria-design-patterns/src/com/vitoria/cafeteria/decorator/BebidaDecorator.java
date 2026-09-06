package com.vitoria.cafeteria.decorator;

import com.vitoria.cafeteria.model.Bebida;

/**
 * Padrão Decorator: permite "envolver" uma bebida com adicionais (leite, chantilly, canela...)
 * sem precisar criar uma subclasse para cada combinação possível.
 */
public abstract class BebidaDecorator implements Bebida {

    protected final Bebida bebidaDecorada;

    protected BebidaDecorator(Bebida bebidaDecorada) {
        this.bebidaDecorada = bebidaDecorada;
    }

    @Override
    public String getDescricao() {
        return bebidaDecorada.getDescricao();
    }

    @Override
    public double getPreco() {
        return bebidaDecorada.getPreco();
    }
}
