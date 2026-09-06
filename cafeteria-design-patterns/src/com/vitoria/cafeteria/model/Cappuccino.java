package com.vitoria.cafeteria.model;

public class Cappuccino implements Bebida {

    @Override
    public String getDescricao() {
        return "Cappuccino";
    }

    @Override
    public double getPreco() {
        return 9.00;
    }
}
