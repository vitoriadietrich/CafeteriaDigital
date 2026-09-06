package com.vitoria.cafeteria.model;

/**
 * Componente base do padrão Decorator.
 * Toda bebida (pura ou "decorada" com adicionais) sabe se descrever e informar seu preço.
 */
public interface Bebida {

    String getDescricao();

    double getPreco();
}
