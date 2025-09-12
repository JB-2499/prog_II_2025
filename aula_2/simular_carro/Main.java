package aula_2.simular_carro;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carro carro = new Carro();

        carro.criarCarro(sc);

        carro.dirigir(sc);
        sc.close();
    }
}