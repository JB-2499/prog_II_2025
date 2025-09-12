import java.util.Scanner;
import java.util.InputMismatchException;

public class Desempenho_escolar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Digite a frequência do aluno (de 0 a 100): ");
                int frequencia = sc.nextInt();
                sc.nextLine();

                System.out.println("Digite o nome do aluno: ");
                String nome = sc.nextLine();

                if (frequencia < 75) {
                    System.out.println("O aluno " + nome + " foi reprovado por falta!!!");
                    break;
                } else {
                    System.out.println("Digite a primeira nota: ");
                    float nota_1 = sc.nextFloat();
                    sc.nextLine();

                    System.out.println("Digite a segunda nota: ");
                    float nota_2 = sc.nextFloat();
                    sc.nextLine();

                    float media = (nota_1 + nota_2) / 2;

                    String aprovacao;
                    if (media >= 7) {
                        aprovacao = "foi aprovado";
                    } else if (media >= 5 && media < 7) {
                        aprovacao = "está de recuperação";
                    } else {
                        aprovacao = "foi reprovado";
                    }

                    System.out.println("O aluno " + nome + " " + aprovacao +
                            "! Sua frequencia total foi de " + frequencia + "% e sua média final foi " + media);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite uma entrada válida!");
                sc.nextLine();
            }
        }
        sc.close();
    }
}