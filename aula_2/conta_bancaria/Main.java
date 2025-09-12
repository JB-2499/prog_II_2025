package aula_2.conta_bancaria;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Conta_bancaria conta = new Conta_bancaria();

        conta.criar_conta(sc);

        conta.operar(sc);
        sc.close();
    }
}