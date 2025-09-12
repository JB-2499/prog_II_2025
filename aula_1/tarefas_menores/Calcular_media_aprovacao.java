import java.util.Scanner;

public class Calcular_media_aprovacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("(Este programa recebe as notas de um aluno e calcula sua média e aprovação)");
        System.out.println("\nDigite a primeira nota: ");
        double nota_1 = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite a segunda nota: ");
        double nota_2 = sc.nextDouble();
        sc.close();

        String aprovacao;
        double media = (nota_1 + nota_2) / 2;
        if (media >= 7) {
            aprovacao = "aprovado";
        } else {
            aprovacao = "reprovado";
        }

        System.out.printf("O aluno foi %s! sua média final foi: %.2f", aprovacao, media);
    }
}