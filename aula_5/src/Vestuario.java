import java.util.InputMismatchException;
import java.util.Scanner;

public class Vestuario extends Produto {
    private String tamanho, cor;

    public Vestuario(String nome, double preco, String codigo, String tamanho, String cor) {
        super(nome, preco, codigo);
    }

    @Override
    public void mostrar_dados() {
        super.mostrar_dados();
        System.out.println(">Tamanho do produto: " +this.tamanho);
        System.out.println(">Cor do produto: " +this.cor);
    }

    public void mostrar_dados(Scanner sc) {
        while(true){
            try{
                System.out.println("\n|1 - Sim| |2 - Não|");
                System.out.println("Deseja ver a cor do produto junto com outros atributos? ");
                int opcao = sc.nextInt();
                sc.nextLine();

                if (opcao != 1 && opcao != 2) {
                    System.out.println("Erro!!! Digite um valor válido!");
                } else {
                    if (opcao == 1) {
                        super.mostrar_dados();
                        System.out.println(">Tamanho do produto: " +this.tamanho);
                        System.out.println(">Cor do produto: " +this.cor);
                    } else {
                        super.mostrar_dados(sc);
                        System.out.println(">Tamanho do produto: " +this.tamanho);
                    }
                    break;
                }
            }catch(InputMismatchException e) {
                System.out.println("Error!!! Digite um valor numérico!");
                sc.nextLine();
            }

        }
    }
}