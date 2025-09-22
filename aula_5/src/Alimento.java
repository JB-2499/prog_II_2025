import java.util.InputMismatchException;
import java.util.Scanner;

public class Alimento extends Produto{
    private String validade;

    public Alimento(String nome, double preco, String codigo) {
        super(nome, preco, codigo);
    }

    @Override
    public void mostrar_dados() {
        super.mostrar_dados();
        System.out.println(">Data de validade: " +this.validade);
    }

    public void mostrar_dados(Scanner sc) {
        while(true){
            try{
                System.out.println("\nA quantos dias o produto está da validade? ");
                int dias = sc.nextInt();
                sc.nextLine();

                if (dias == 0) {
                    System.out.println("A validade acaba hoje!");
                } else if (dias > 0) {
                    System.out.println("O produto está dentro da validade!");
                } else {
                    System.out.println("Já tá podre já!!!");
                }

                break;
            }catch (InputMismatchException e) {
                System.out.println("Error!!! Digite um valor numérico!");
                sc.nextLine();
            }
        }
    }
}