package com.vitoria.cafeteria.decorator;

import com.vitoria.cafeteria.model.Bebida;

public class ComChantilly extends BebidaDecorator {

    public ComChantilly(Bebida bebidaDecorada) {
        super(bebidaDecorada);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + chantilly";
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 2.00;
    }
}
