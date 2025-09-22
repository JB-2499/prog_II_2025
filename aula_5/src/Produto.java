import java.util.InputMismatchException;
import java.util.Scanner;

public class Produto {
    private String codigo, nome;
    private double preco;

    public Produto(String nome, double preco, String codigo) {
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
    }

    public void mostrar_dados() {
        System.out.println("\nInformações do produto: ");
        System.out.println(">Nome do produto: " + this.nome);
        System.out.println(">Preço do produto: " + this.preco);
        System.out.println(">Codigo do produto: " + this.codigo);
    }

    public void mostrar_dados(Scanner sc) {
        while(true){
            try {
                System.out.println("\n|1 -  Sem desconto  | |2 - Desconto de 10%|");
                System.out.println("|3 - Desconto de 25%| |4 - Desconto de 40%|");
                System.out.println("Como deseja ver as informações do produto? ");
                int desconto = sc.nextInt();
                sc.nextLine();

                if (desconto > 4 || desconto < 1) {
                    System.out.println("Erro!!! Digite um valor válido!");
                } else {
                    double preco = 0;

                    if (desconto == 1) {
                        preco = this.preco;
                    } else if (desconto == 2) {
                        preco = this.preco * 0.9;
                    } else if (desconto == 3) {
                        preco = this.preco * 0.75;
                    } else if (desconto == 4) {
                        preco = this.preco * 0.6;
                    }

                    System.out.println("\nInformações do produto: ");
                    System.out.println(">Nome do produto: " + this.nome);
                    System.out.println(">Preço do produto: " + preco);
                    System.out.println(">Codigo do produto: " + this.codigo);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um valor numérico!👍");
                sc.nextLine();
            }
        }

    }
}
