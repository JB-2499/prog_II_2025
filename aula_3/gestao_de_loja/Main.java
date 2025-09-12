package aula_3.gestao_de_loja;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Map<String, Produto> produtos = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        Produto produto = new Produto();

        produto.menu(sc, produtos);
        sc.close();
    }
}