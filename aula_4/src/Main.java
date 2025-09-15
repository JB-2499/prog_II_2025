import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bilheteria bilheteria = new Bilheteria();

        bilheteria.menu(sc);
        sc.close();
    }
}