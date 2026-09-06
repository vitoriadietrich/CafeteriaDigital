# ☕ Cafeteria Digital — Desafio de Projeto: Padrões de Projeto em Java

Projeto desenvolvido para o desafio **"Explorando Padrões de Projeto na Prática"** (Digital Innovation One).
Em vez de apenas reproduzir os exemplos originais, criei um domínio próprio — uma cafeteria digital —
para aplicar os padrões de forma mais próxima de um cenário real de portfólio, combinando os três
padrões trabalhados em aula com dois padrões adicionais.

## Padrões aplicados

| Padrão | Onde está | Por que foi usado |
|---|---|---|
| **Singleton** | `singleton/Caixa.java` | Garante que exista **um único caixa** registrando todas as vendas da cafeteria, com um ponto de acesso global e consistente. |
| **Strategy** | `strategy/*` (`FormaPagamento`, `PagamentoPix`, `PagamentoCartaoCredito`, `PagamentoDinheiro`) | Cada forma de pagamento tem sua própria regra (desconto no Pix, taxa no cartão), podendo ser trocada em tempo de execução sem alterar quem paga. |
| **Facade** | `facade/CafeteriaFacade.java` | Esconde toda a complexidade de criar o pedido, processar pagamento, registrar no caixa e disparar notificações atrás de um único método: `fazerPedido(...)`. |
| **Decorator** *(extra)* | `decorator/*` (`ComLeite`, `ComChantilly`, `ComCanela`) | Permite "montar" a bebida com adicionais combináveis (leite + chantilly, por exemplo) sem precisar de uma subclasse para cada combinação. |
| **Observer** *(extra)* | `observer/*` + `model/Pedido.java` | O cliente é notificado automaticamente sempre que o status do pedido muda (recebido → em preparo → pronto → finalizado). |

## Estrutura do projeto

```
src/com/vitoria/cafeteria/
├── Main.java                     # Demonstração de uso
├── model/
│   ├── Bebida.java                # Interface (componente do Decorator)
│   ├── Espresso.java / Cappuccino.java
│   ├── Pedido.java                 # Subject do Observer
│   └── StatusPedido.java
├── decorator/
│   ├── BebidaDecorator.java
│   └── ComLeite.java / ComChantilly.java / ComCanela.java
├── strategy/
│   ├── FormaPagamento.java
│   └── PagamentoPix.java / PagamentoCartaoCredito.java / PagamentoDinheiro.java
├── singleton/
│   └── Caixa.java
├── observer/
│   ├── ObservadorPedido.java
│   └── ClienteNotificacao.java
└── facade/
    └── CafeteriaFacade.java
```

## Como executar

Pré-requisito: JDK 11+ instalado.

```bash
# a partir da pasta raiz do projeto
javac -d bin $(find src -name "*.java")
java -cp bin com.vitoria.cafeteria.Main
```

## Saída esperada (resumo)

O `Main.java` simula 3 pedidos diferentes (um espresso simples pago no Pix, um cappuccino com
leite e chantilly pago no cartão, e um espresso com leite pago em dinheiro), mostrando no console:
- o valor calculado dinamicamente pelos decorators;
- a regra de cada forma de pagamento (Strategy);
- as notificações de mudança de status do pedido (Observer);
- e por fim, o resumo consolidado do caixa único (Singleton).

## Próximos passos (ideias de evolução)

- Persistir os pedidos em banco de dados (ex.: MySQL, já usado em outros projetos do meu portfólio).
- Expor os pedidos via API REST com Spring Boot.
- Adicionar um padrão **Factory Method** para centralizar a criação de bebidas por nome.
- Criar testes unitários (JUnit) para cada Strategy e Decorator.

## Referências

- [DIO — Padrões de Projeto com Java Puro](https://github.com/digitalinnovationone/lab-padroes-projeto-java)
- [DIO — Padrões de Projeto com Spring](https://github.com/digitalinnovationone/lab-padroes-projeto-spring)

---
Desenvolvido por **Vitória de Jesus Dietrich**.
