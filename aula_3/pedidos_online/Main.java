package aula_3.pedidos_online;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        Pedido pedido = new Pedido();

        pedido.menu(sc);
        sc.close();
    }
}