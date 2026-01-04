package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompra {

    private List<Item> listCompras;

    public CarrinhoDeCompra() {
        this.listCompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        listCompras.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itemParaRemover = new ArrayList<>();

        for (Item i : listCompras) {
            if (i.getNome().equalsIgnoreCase(nome)) {
                itemParaRemover.add(i);
            }
        }
        listCompras.removeAll(itemParaRemover);
    }

    public double calcularValorTotal() {
        double total = 0;
        double subtotal = 0;
        for (Item i : listCompras) {
            subtotal = i.getPreco() * i.getQuantidade();
            total += subtotal;
        }

        return total;
    }

    public void exibirItens() {
        System.out.println(listCompras);
    }

    public static void main(String[] args) {
        CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompra();

        carrinhoDeCompra.adicionarItem("Arroz", 13, 2);
        carrinhoDeCompra.adicionarItem("Feijao", 5, 1);
        carrinhoDeCompra.adicionarItem("Costela", 25, 1);

        System.out.println("Valor total do seu carrinho: R$" + carrinhoDeCompra.calcularValorTotal());

        carrinhoDeCompra.exibirItens();

        carrinhoDeCompra.removerItem("Arroz");

        System.out.println("======= LISTA APÓS REMOÇÃO =======");
        carrinhoDeCompra.exibirItens();
    }
}
