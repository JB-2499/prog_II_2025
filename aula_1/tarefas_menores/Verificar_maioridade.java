import java.util.Scanner;

public class verificar_maioridade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String maioridade;

        while (true) {
            System.out.println("Digite a idade da pessoa: ");
            int idade = sc.nextInt();
            sc.nextLine();

            if (idade < 0) {
                System.out.println("Erro!!! Impossível ter uma idade negativa!");
            }  else if (idade >= 130) {
                System.out.println(idade + " anos!?!? É um vampiro.");
            } else if (idade >= 18 && idade < 130) {
                maioridade = "maior";
                break;
            } else if (idade < 18 && idade >= 0) {
                maioridade = "menor";
                break;
            }
        }
        sc.close();

        System.out.println("Esta pessoa é " +  maioridade + " de idade!");
    }
}