package Atividade_avaliativa.Banco;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List <Conta> banco = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("\n|=-=-=-=-=-=-=-=-=|Banco|-=-=-=-=-=-=-=-=-|");
        while (true) {
            try{
                System.out.println("\n___________________________________________");
                System.out.println("|1 - Conta corrente | |2 - Conta poupança |");
                System.out.println("|3 - Conta de investimentos | |4 -  Sair  |");
                System.out.println("-------------------------------------------");
                System.out.println("\nO que você deseja fazer?");
                int opcao = sc.nextInt();
                sc.nextLine();

                if (opcao == 4) {
                    break;

                } else {
                    System.out.println("Digite o número da conta: ");
                    String numero = sc.nextLine();

                    System.out.println("Digite o nome do titular: ");
                    String titular = sc.nextLine();

                    System.out.println("Digite o saldo da conta: ");
                    double saldo = sc.nextDouble();
                    sc.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.println("Digite o limite de crédito do titular: ");
                            double limite_cred = sc.nextDouble();
                            sc.nextLine();
                            Conta_corrente conta_corrente = new Conta_corrente(numero, titular, saldo, limite_cred);
                            banco.add(conta_corrente);
                            System.out.println("Conta registrada com sucesso.");
                            break;
                        case 2:
                            System.out.println("Digite o rendimento da poupança (em percentual): ");
                            double rendimento = sc.nextDouble();
                            sc.nextLine();
                            Conta_poupanca conta_poupanca = new Conta_poupanca(numero, titular, saldo, rendimento);
                            banco.add(conta_poupanca);
                            System.out.println("Conta registrada com sucesso.");
                            break;
                        case 3:
                            System.out.println("Digite a taxa gasta com administração (em percentual): ");
                            double taxa_admin = sc.nextDouble();
                            sc.nextLine();

                            System.out.println("Digite a projeção prevista para o crescimento do valor: ");
                            double projecao = sc.nextDouble();
                            sc.nextLine();

                            Conta_investimento conta_investimento = new Conta_investimento(numero, titular, saldo, taxa_admin, projecao);
                            banco.add(conta_investimento);
                            System.out.println("Conta registrada com sucesso.");
                            break;
                        default:
                            System.out.println("Digite uma opção válida!");
                            break;
                    }

                }
            } catch (InputMismatchException e){
                System.out.println("Erro!!! Digite um número!");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("\n_____________________");
                System.out.println("|1 - Sim | |2 - Não |");
                System.out.println("---------------------");
                System.out.println("Deseja que as contas sejam listadas? ");
                int opcao = sc.nextInt();
                sc.nextLine();

                if (opcao == 1) {
                    System.out.println("\n_____________________");
                    System.out.println("|1 - Sim | |2 - Não |");
                    System.out.println("---------------------");
                    System.out.println("Deseja que sejam exibidas as informações complexas? ");
                    int detalhe = sc.nextInt();
                    sc.nextLine();

                    System.out.println();
                    if (detalhe == 1) {
                        for (Conta conta : banco) {
                            if (conta instanceof Conta_corrente) {
                                ((Conta_corrente) conta).mostrar_dados_corrente();
                            } else if (conta instanceof Conta_poupanca) {
                                ((Conta_poupanca) conta).mostrar_dados_poupanca(true);
                            } else if  (conta instanceof Conta_investimento) {
                                ((Conta_investimento) conta).mostrar_dados_investimento();
                            }
                        }
                    } else {
                        for (Conta conta : banco) {
                            if (conta instanceof Conta_corrente) {
                                conta.mostrar_dados();
                            } else if (conta instanceof Conta_poupanca) {
                                conta.mostrar_dados();
                            } else if  (conta instanceof Conta_investimento) {
                                conta.mostrar_dados();
                            }
                        }
                    }

                } else if (opcao == 2) {
                    System.out.println("|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
                    System.out.println("\nPrograma finalizado com sucesso!");
                    break;
                } else {
                    System.out.println("Erro!!! Digite uma opção válida!");
                }

            } catch (InputMismatchException e){
                System.out.println("Erro!!! Digite um valor numérico!");
                sc.nextLine();
            }
        }
        sc.close();
    }
}