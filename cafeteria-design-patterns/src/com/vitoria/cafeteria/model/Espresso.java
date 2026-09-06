package com.vitoria.cafeteria.model;

public class Espresso implements Bebida {

    @Override
    public String getDescricao() {
        return "Espresso";
    }

    @Override
    public double getPreco() {
        return 6.50;
    }
}
