package com.vitoria.cafeteria.singleton;

/**
 * Padrão Singleton: existe apenas um caixa registrando todas as vendas da cafeteria,
 * garantindo um único ponto de acesso e consistência do total arrecadado.
 */
public class Caixa {

    private static Caixa instancia;

    private double totalVendas;
    private int quantidadePedidos;

    private Caixa() {
        this.totalVendas = 0.0;
        this.quantidadePedidos = 0;
    }

    public static synchronized Caixa getInstancia() {
        if (instancia == null) {
            instancia = new Caixa();
        }
        return instancia;
    }

    public void registrarVenda(double valor) {
        this.totalVendas += valor;
        this.quantidadePedidos++;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public int getQuantidadePedidos() {
        return quantidadePedidos;
    }

    public void exibirResumo() {
        System.out.println("----- Resumo do Caixa -----");
        System.out.println("Pedidos processados: " + quantidadePedidos);
        System.out.printf("Total arrecadado: R$ %.2f%n", totalVendas);
        System.out.println("----------------------------");
    }
}
