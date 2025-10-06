package Atividade_avaliativa.Veiculo;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Veiculo> concessionaria = new ArrayList<>();
        while (true) {
            try {
                System.out.println("Bem-vindo ao site da concessionária!");
                System.out.println("\n|-------------------------| |-------------------------|");
                System.out.println("| 1 -  Comprar um carro   | | 2 -  Comprar uma moto   |");
                System.out.println("|-------------------------| |-------------------------|");
                System.out.println("| 3 - Comprar um Caminhão | | 4 -        Sair         |");
                System.out.println("|-------------------------| |-------------------------|");
                System.out.println("\nO que você deseja fazer?");

                int opcao = sc.nextInt();
                sc.nextLine();

                if (opcao == 4) {
                    break;
                } else {
                    String placa, marca;
                    double preco;

                    while (true) {
                        try {
                            System.out.println("Digite o número da placa:");
                            placa = sc.nextLine();

                            System.out.println("Digite a marca do veículo:");
                            marca = sc.nextLine();

                            System.out.println("Digite o preço do veículo:");
                            preco = sc.nextDouble();
                            sc.nextLine();

                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Erro!!! Digite um número!");
                            sc.nextLine();
                        }
                    }

                    Veiculo veiculo = new Veiculo(placa, marca, preco);

                    switch (opcao) {
                        case 1:
                            int portas = veiculo.ler_dados_carro(sc);
                            Carro carro = new Carro(placa, marca, preco, portas);
                            concessionaria.add(carro);
                            System.out.println("Veiculo registrado com sucesso.");
                            break;
                        case 2:
                            int cilindradas = veiculo.ler_dados_moto(sc);
                            Moto moto = new Moto(placa, marca, preco, cilindradas);
                            concessionaria.add(moto);
                            System.out.println("Veiculo registrado com sucesso.");
                            break;
                        case 3:
                            double capacidade = veiculo.ler_dados_caminhao(sc);
                            Caminhao caminhao = new Caminhao(placa, marca, preco, capacidade);
                            concessionaria.add(caminhao);
                            System.out.println("Veiculo registrado com sucesso.");
                            break;
                        default:
                            System.out.println("Erro!!! Digite uma opção válida!");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um número!");
                sc.nextLine();
            }
        }

        while (true) {
            System.out.println("Deseja exibir todos os veículos vendidos hoje?");
            System.out.println("Digite \"s\" para \"sim\" e qualquer outra coisa para \"não\"");

            String s = sc.nextLine();

            if (s.equalsIgnoreCase("s")) {
                System.out.println("Deseja ver todos os detalhes, ou uma versão simplificada?");
                System.out.println("Digite \"s\" para \"sim\" e qualquer outra coisa para \"não\"");

                String n = sc.nextLine();

                if (n.equalsIgnoreCase("s")) {
                    System.out.println("Veículos vendidos:\n");
                    for (Veiculo veiculo : concessionaria) {
                        if (veiculo instanceof Carro) {
                            ((Carro) veiculo).printdt_carro();
                        } else if (veiculo instanceof Moto) {
                            ((Moto) veiculo).printdt_moto();
                        } else if (veiculo instanceof Caminhao) {
                            ((Caminhao) veiculo).printdt_caminhao();
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Veículos vendidos:\n");
                    for (Veiculo veiculo : concessionaria) {
                        veiculo.printdt();
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Programa finalizado com sucesso.\nObrigado pela preferência!");
                break;
            }
        }
        sc.close();
    }
}