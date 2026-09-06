package com.vitoria.cafeteria.decorator;

import com.vitoria.cafeteria.model.Bebida;

public class ComCanela extends BebidaDecorator {

    public ComCanela(Bebida bebidaDecorada) {
        super(bebidaDecorada);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + canela";
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 0.75;
    }
}
