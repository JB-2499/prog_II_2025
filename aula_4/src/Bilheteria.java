import java.util.Scanner;

public class Bilheteria {
    private int vendas_totais, renda;
    private int inteira, meia, promocional, gratuito;

    public void passarVendas(Ingresso ingresso){
        this.inteira+=ingresso.getInteira();
        this.meia+=ingresso.getMeia();
        this.promocional+=ingresso.getPromocional();
        this.gratuito+=ingresso.getGratuito();

        this.vendas_totais+=(ingresso.getInteira() + ingresso.getMeia() + ingresso.getPromocional() + ingresso.getGratuito());
        this.renda+=(ingresso.getPreco());
    }

    public void venderIngressos(Scanner sc) {
        Ingresso ingresso = new Ingresso();

        ingresso.definirIdade(sc);

        ingresso.definirQuant(sc);

        ingresso.definirTipo(sc);

        this.passarVendas(ingresso);

        this.passar_cartao(sc, ingresso);
    }

    public void mostrarVendas(){
        System.out.println("Vendas totais: "+this.vendas_totais);
        System.out.println("Vendas inteiras:"+this.inteira);
        System.out.println("Vendas meias:"+this.meia);
        System.out.println("Vendas promocionais:"+this.promocional);
        System.out.println("Vendas gratuitas:"+this.gratuito);
    }

    public void passar_cartao(Scanner sc, Ingresso ingresso){
        while(true){
            System.out.println("\n___________________________");
            System.out.println("|1 - dinheiro| |2 - cartão|");
            System.out.println("---------------------------");

            System.out.println("Valor a pagar = " + ingresso.getPreco());
            System.out.println("Qual deseja utilizar para pagar?");
            int cartao = sc.nextInt();
            sc.nextLine();

            if (cartao==1){
                while (true) {
                    System.out.println("Pague o ingresso!");
                    int pagar = sc.nextInt();
                    sc.nextLine();

                    if (pagar < ingresso.getPreco()) {
                        System.out.println("Dinheiro insuficiente!!!");
                    } else if (pagar > ingresso.getPreco()) {
                        System.out.println("Ingresso pago com sucesso!");
                        System.out.println("Troco: " + (pagar - ingresso.getPreco()));
                        break;
                    } else if(pagar == ingresso.getPreco()){
                        System.out.println("Ingresso pago com sucesso!");
                        break;
                    }
                }
            } else if (cartao==2){
                System.out.println("Ingresso pago com sucesso!");
                break;
            } else {
                System.out.println("Erro!!! Digite um valor válido!");
            }
        }
    }

    public void menu(Scanner sc){
        while(true){
            System.out.println("\n______________________");
            System.out.println("|1 - Vender ingressos|");
            System.out.println("|2 -  Mostrar vendas |");
            System.out.println("|3 -       Sair      |");
            System.out.println("----------------------");

            System.out.println("Bem vindo ao cinema da UPE!!!\nO que deseja fazer?");

            int op = sc.nextInt();
            sc.nextLine();

            if(op==1){
                this.venderIngressos(sc);
            }
            else if(op==2){
                this.mostrarVendas();
            }
            else if(op==3){
                break;
            }
            else{
                System.out.println("Erro, digite uma opção válida!\n");
                continue;
            }

            int numero = 0;
            while (true) {
                System.out.println("Atender próximo cliente (s/n)?");
                String opcao = sc.nextLine();
                if (opcao.equalsIgnoreCase("n")) {
                    System.out.println("Programa fechado com sucesso");
                    numero = 1;
                    break;
                } else if (opcao.equalsIgnoreCase("s")) {
                    numero = 0;
                    break;
                } else {
                    System.out.println("Erro!!! Digite uma opção válida!!!!!👍");
                }
            }

            if (numero == 1) {
                System.out.println("Obrigado pela preferência!!!\nprograma finalizado com sucesso.");
                break;
            }
        }
    }
}