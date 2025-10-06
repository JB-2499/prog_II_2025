package Atividade_avaliativa.Veiculo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Veiculo {
    final String placa, marca;
    final double preco;

    public Veiculo(String placa, String marca, double preco) {
        this.placa = placa;
        this.marca = marca;
        this.preco = preco;

    }

    public void printdt() {
        System.out.println("Informações do veículo:");
        System.out.println(">Número da placa: " + this.placa);
        System.out.println(">Marca: " + this.marca);
        System.out.println(">Preço: "  + this.preco);
    }

    public void printdt(double desconto_percentual) {
        System.out.println(">Preço do veículo com desconto: "  + (this.preco*(desconto_percentual/100)));
    }

    public int ler_dados_carro(Scanner sc) {
        while (true) {
            try {
                System.out.println("Quantas portas tem o carro?");
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um número!");
                sc.nextLine();
            }
        }
    }

    public int ler_dados_moto(Scanner sc) {
        while (true) {
            try {
                System.out.println("Quantas cilindradas tem o motor?");
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um número!");
                sc.nextLine();
            }
        }
    }

    public double ler_dados_caminhao(Scanner sc) {
        while (true) {
            try {
                System.out.println("Qual a capacidade de carga do caminhão (toneladas)?");
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um número!");
                sc.nextLine();
            }
        }
    }
}