package aula_2.simular_carro;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Carro {
    private String marca, modelo;
    private int ano, velocidade;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public void criarCarro(Scanner sc) {
        System.out.println("Digite a marca do carro: ");
        this.setMarca(sc.nextLine());

        System.out.println("Digite o modelo do carro: ");
        this.setModelo(sc.nextLine());

        while (true) {
            try {
                System.out.println("Digite a ano de fabricação: ");
                this.setAno(sc.nextInt());
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um valor válido!\n");
            }
        }

        this.setVelocidade(0);
        System.out.println("Carro registrado com sucesso!\n");
    }

    public void acelerar(Scanner sc) {
        while (true) {
            try {
                if (this.getVelocidade() == 200) {
                    System.out.println("O carro já está em velocidade máxima!");
                    break;
                } else {
                    System.out.println("Digite quantos km/h o carro deve acelerar: ");
                    int velocidade = sc.nextInt();
                    sc.nextLine();

                    if (velocidade < 0) {
                        System.out.println("Erro!!! Impossível frear com o acelerador!\n");
                    } else {
                        if (this.getVelocidade() < 200) {
                            this.setVelocidade(this.getVelocidade() + velocidade);

                            if (this.getVelocidade() >= 200) {
                                this.setVelocidade(200);
                            }
                        }

                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um valor válido!\n");;
            }
        }
    }

    public void frear(Scanner sc) {
        while (true) {
            try {
                if (this.getVelocidade() == 0) {
                    System.out.println("O carro já está parado!");
                    break;
                } else {
                    System.out.println("Digite quantos km/h o carro deve frear: ");
                    int freio = sc.nextInt();
                    sc.nextLine();

                    if (freio < 0) {
                        System.out.println("Erro!!! Não é possível acelerar freando!\n");
                    } else {
                        this.setVelocidade(this.getVelocidade() - freio);
                        if (this.getVelocidade() < 0) {
                            this.setVelocidade(0);
                        }

                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um valor válido!");
                sc.nextLine();
            }
        }
    }

    public void dirigir(Scanner sc) {
        while (true) {
            System.out.println("\nVelocidade atual: " + this.getVelocidade());
            System.out.println("Deseja frear ou acelerar?");
            String acao = sc.nextLine().toLowerCase();

            if (acao.contains("frear") || acao.contains("diminuir") || acao.contains("parar")) {
                this.frear(sc);
            } else if (acao.contains("acelerar") || acao.contains("aumentar") || acao.contains("partida")) {
                this.acelerar(sc);
            }

            System.out.println("Velocidade atual: " + this.getVelocidade());

            System.out.println("\nDeseja sair do programa? ");
            String sair = sc.nextLine().toLowerCase();

            if (sair.equals("sim") || sair.equals("s") || sair.equals("quero") || sair.equals("desejo")) {
                break;
            }
        }
    }
}