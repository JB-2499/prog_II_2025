package aula_3.gestao_de_loja;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Produto {
    private String nome;
    private double preco;
    private int estoque;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void criarProduto(Scanner sc, Map<String, Produto> produtos) {
        int quantidade;

        while (true) {
            try {
                System.out.println("Quantos produtos serão adicionados ao catálogo? ");
                quantidade = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite uma quantidade válida!");
                sc.nextLine();
            }
        }
        for (int i = 0; i < quantidade; i++) {
            Produto produto = new Produto();

            System.out.println("Digite o nome do produto: ");
            produto.setNome(sc.nextLine());

            while (true) {
                System.out.println("Digite o preço do produto:");
                double preco = sc.nextDouble();
                sc.nextLine();

                if (preco > 0) {
                    produto.setPreco(preco);
                    break;
                } else {
                    System.out.println("Erro!!! O preço deve ser maior que zero!");
                }
            }

            while (true) {
                System.out.println("Quantas unidades devem ser adicionadas ao estoque? ");
                int quantidadeEstoque = sc.nextInt();

                if  (quantidadeEstoque > 0) {
                    produto.setEstoque(quantidadeEstoque);
                    break;
                } else {
                    System.out.println("Erro!!! O estoque inicial deve ser maior que zero!");
                }
            }

            produtos.put(produto.getNome(), produto);
        }
    }

    public void exibirProduto(Scanner sc, Map<String, Produto> produtos) {
        while (true) {
            System.out.println("Digite o nome do produto: ");
            String nome = sc.nextLine();

            if (produtos.containsKey(nome)) {
                System.out.println(">Preço: R$" + produtos.get(nome).getPreco() + "\n>Quantidade em estoque: " + produtos.get(nome).getEstoque());
                break;
            } else {
                System.out.println("Erro!!! Nome errado ou produto não existente!");
            }
        }
    }

    public void listarProdutos(Map<String, Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("A lista está vazia.");
        } else {
            for (Map.Entry<String, Produto> entry : produtos.entrySet()) {
                System.out.println("Nome: " + entry.getValue().getNome() + ", Preço: " + entry.getValue().getPreco() + ", Estoque: " + entry.getValue().getEstoque());
            }
        }
    }

    public void menu(Scanner sc, Map<String, Produto> produtos) {

        while (true) {
            System.out.println("_______________________________");
            System.out.println("|1 -    Adicionar produto     |");
            System.out.println("|2 -    Analisar produto      |");
            System.out.println("|3 - Listar todos os produtos |");
            System.out.println("|4 -           Sair           |");
            System.out.println("-------------------------------\n");
            System.out.println("Bem-vindo às lojas Barreto!\nComo você gostaria de utilizar o sistema? ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                this.criarProduto(sc, produtos);
            } else if (opcao == 2) {
                this.exibirProduto(sc, produtos);
            } else if (opcao == 3) {
                this.listarProdutos(produtos);
            } else if (opcao == 4) {
                System.out.println("Sistema fechado com sucesso.\nObrigado por utilizar nosso sistema!");
                break;
            } else {
                System.out.println("Erro!!! Digite uma opção válida!");
            }
        }
    }
}