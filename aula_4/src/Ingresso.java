import java.util.Scanner;

public class Ingresso {
    private int preco, quant, idade;
    private String tipo;
    private int inteira, meia, promocional, gratuito;

    public int getPreco() {
        return preco;
    }

    public int getQuant() {
        return quant;
    }

    public void definirQuant(Scanner sc) {
        while(true){
            System.out.println("Quantos ingressos você deseja comprar?");
            int quantidade = sc.nextInt();
            sc.nextLine();

            if(quantidade >=1 && quantidade <=100) {
                System.out.println("Compra realizada com sucesso!!!");
                this.quant = quantidade;
                break;
            }else{
                System.out.println("Erro, digite uma quantidade válida!");
            }
        }
    }

    public int getIdade() {
        return idade;
    }

    public void definirIdade(Scanner sc) {
        while (true) {
            System.out.println("\nInforme sua idade:");
            int idade = sc.nextInt();
            sc.nextLine();

            if(idade>=0 && idade<=120){
                System.out.println("Idade confirmada!!!");
                this.idade = idade;
                break;
            } else {
                System.out.println("Erro! Digite uma idade válida!");

            }
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void definirTipo(Scanner sc) {
        while(true) {
            System.out.println("\n_______________________________________________________");
            System.out.println("|1 -20 Inteira  | |2 -10  Meia    | |3 -14 Promocional|");
            System.out.println("-------------------------------------------------------");
            System.out.println("Qual ingresso você deseja?");
            int tipo = sc.nextInt();
            sc.nextLine();

            if (tipo == 1 || tipo == 2 || tipo == 3) {
                if (this.idade >= 5) {
                    if (tipo == 1) {
                        this.definirPreco(20*this.quant);
                        this.tipo = "Inteira";
                        this.inteira += this.quant;
                    } else if (tipo == 2) {
                        this.definirPreco(10*this.quant);
                        this.tipo = "Meia";
                        this.meia += this.quant;
                    } else if (tipo == 3) {
                        this.definirPreco(14*this.quant);
                        this.tipo = "Promocional";
                        this.promocional += this.quant;
                    }
                    break;
                } else if (this.idade >= 0) {
                    this.definirPreco(0);
                    this.tipo = "Gratuito";
                    this.gratuito += this.quant;
                    break;
                }
            } else {
                System.out.println("Erro! Digite uma opção válida!");
            }
        }
    }

    public void definirPreco(int preco) {
        this.preco = preco;
    }

    public int getInteira() {
        return inteira;
    }

    public void setInteira(int inteira) {
        this.inteira = inteira;
    }

    public int getMeia() {
        return meia;
    }

    public void setMeia(int meia) {
        this.meia = meia;
    }

    public int getGratuito() {
        return gratuito;
    }

    public void setGratuito(int gratuito) {
        this.gratuito = gratuito;
    }

    public int getPromocional() {
        return promocional;
    }

    public void setPromocional(int promocional) {
        this.promocional = promocional;
    }
}