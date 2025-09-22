import java.util.InputMismatchException;
import java.util.Scanner;

public class Eletronico extends Produto{
    private int garantia;

    public Eletronico(String nome, String codigo, double preco, int garantia){
        super(nome, preco, codigo);
        this.garantia = garantia;
    }

    @Override
    public void mostrar_dados() {
        super.mostrar_dados();
        System.out.println(">Garantia: " + this.garantia + "meses");
    }

    public void mostrar_dados(Scanner sc) {
        while(true) {
            try {
                System.out.println("\n|1 - Meses| |2 - Anos|");
                System.out.println("Deseja ver a garantia em meses ou anos? ");
                int garantia = sc.nextInt();
                sc.nextLine();

                if (garantia != 1 && garantia != 2) {
                    System.out.println("Erro!!! Digite um valor válido!");
                } else {
                    String tempo = "";
                    double warranty = 0;

                    if (garantia == 1) {
                        tempo = " mes(es)";
                        warranty = this.garantia;
                    } else {
                        tempo = " ano(s)";
                        warranty = ((double) this.garantia)/12.0;
                    }

                    super.mostrar_dados();
                    System.out.println(">Garantia: " + warranty + tempo);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um valor numérico!");
                sc.nextLine();
            }
        }
    }
}