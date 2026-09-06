package com.vitoria.cafeteria.decorator;

import com.vitoria.cafeteria.model.Bebida;

public class ComLeite extends BebidaDecorator {

    public ComLeite(Bebida bebidaDecorada) {
        super(bebidaDecorada);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + leite";
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 1.50;
    }
}
