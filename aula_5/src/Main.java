import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\n|1 -    Sair   | |3 - Alimento |");
                System.out.println("|2 - Eletronico| |4 - Vestuario|");
                System.out.println("Que tipo de produto deseja analisar? (Se não desejar nenhum, selecione \"sair\")");
                int op = sc.nextInt();
                sc.nextLine();

                if (op > 4 || op < 1) {
                    System.out.println("Erro!!! Digite um valor válido!");
                } else {
                    System.out.println("Digite o nome do produto:");
                    String nome = sc.nextLine();

                    System.out.println("Digite o preco do produto:");
                    double preco = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Digite o codigo do produto:");
                    String codigo = sc.nextLine();

                    if (op == 1) {
                        System.out.println("Programa finalizado com sucesso!");
                        break;
                    } else if (op == 2) {
                        System.out.println("Quantos meses de garantia o produto tem? ");
                        int garantia = sc.nextInt();
                        sc.nextLine();

                        Eletronico eletronico = new Eletronico(nome, codigo, preco, garantia);

                        eletronico.mostrar_dados(sc);
                    } else if (op == 3) {
                        Alimento alimento = new Alimento(nome, preco, codigo);

                        alimento.mostrar_dados(sc);
                    } else {
                        System.out.println("Qual o tamanho do produto?");
                        String tamanho = sc.nextLine();

                        System.out.println("Qual a cor do produto?");
                        String cor = sc.nextLine();

                        Vestuario vestuario = new Vestuario(nome, preco, codigo, tamanho, cor);

                        vestuario.mostrar_dados(sc);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um valor numérico!");
            }
        }
        sc.close();
    }
}