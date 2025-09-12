import java.util.Scanner;

public class Par_impar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número a ser verificado: ");
        int num = sc.nextInt();
        sc.close();

        String par_impar;
        if (num%2 == 0) {
            par_impar = "Par";
        } else {
            par_impar = "Impar";
        }

        System.out.println("O número informado é " + par_impar + "!");
    }
}