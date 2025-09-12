package aula_2.conta_bancaria;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Conta_bancaria {
    private String titular;
    private int  numero;
    private double saldo, saldo_em_mao;

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo_em_mao() {
        return saldo_em_mao;
    }

    public void setSaldo_em_mao(double saldo_em_mao) {
        this.saldo_em_mao = saldo_em_mao;
    }

    public void criar_conta(Scanner sc) {
        while (true) {
            try {
                while (true) {
                    System.out.println("Digite o nome e sobrenome do titular:");
                    String[] nome = sc.nextLine().split(" ");

                    if (nome.length != 2) {
                        System.out.println("Erro!!! Digite nome e sobrenome!\n");
                    } else {
                        this.setTitular(nome[0] +  " " + nome[1]);
                        break;
                    }
                }

                while (true) {
                    System.out.println("Digite o numero da conta (contendo 7 digitos):");
                    String numero = sc.nextLine();

                    if (numero.length() != 7) {
                        System.out.println("Erro!!! O numero deve conter 7 digitos!\n");
                    } else {
                        int numero_conta = Integer.parseInt(numero);
                        this.setNumero(numero_conta);
                        break;
                    }
                }

                while (true) {
                    System.out.println("Digite o saldo inicial da conta:");
                    double saldo_inicial = sc.nextDouble();

                    if (saldo_inicial < 0) {
                        System.out.println("Erro!!! Saldo inicial deve ser maior ou igual a zero!\n");
                    } else {
                        this.setSaldo(saldo_inicial);
                        break;
                    }
                }

                this.saldo_em_mao = 0;
                System.out.println("Conta criada com sucesso!");
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um valor válido!\n");
                sc.nextLine();
            }
        }
    }

    public void sacar(Scanner sc) {
        while (true) {
            try {
                System.out.println("Digite o valor a ser retirado da conta: ");
                double valor_retirado = sc.nextDouble();
                sc.nextLine();

                if (valor_retirado <= 0) {
                    System.out.println("Erro!!! Impossível sacar uma quantia negativa ou nula!\n");
                } else if(valor_retirado > this.saldo) {
                    System.out.println("Erro!!! Saldo insuficiente!\n");
                } else {
                    this.saldo_em_mao += valor_retirado;
                    this.saldo -= valor_retirado;
                    System.out.println("Valor retirado com sucesso!");
                    System.out.println("Saldo em mão: " + this.getSaldo_em_mao());
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um valor válido!\n");
                sc.nextLine();
            }
        }
    }

    public void depositar(Scanner sc) {
        while (true) {
            try {
                System.out.println("Digite o valor a ser depositado da conta: ");
                double valor = sc.nextDouble();
                sc.nextLine();

                if (valor <= 0) {
                    System.out.println("Erro!!! Impossível depositar uma quantia negativa ou nula!\n");
                } else {
                    System.out.println("Valor depositado com sucesso!");
                    this.saldo += valor;
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um valor válido\n!");
                sc.nextLine();
            }
        }
    }

    public void operar(Scanner sc) throws IOException {
        while (true) {
            System.out.println("\nQue operação deve ser feita (saque/deposito)? ");
            String operacao = sc.nextLine().toLowerCase();

            if (operacao.contains("saque") || operacao.contains("saca") || operacao.contains("etirar")) {
                this.sacar(sc);
            } else if (operacao.contains("eposit") || operacao.contains("guardar")) {
                this.depositar(sc);
            }

            System.out.println("Deseja fazer outra operacao? ");
            String continuar = sc.nextLine();

            if (continuar.equals("s") || continuar.equals("sim") || continuar.equals("desejo") || continuar.equals("quero")) {
                continue;
            } else {
                System.out.println("Programa encerrado com sucesso!");
                break;
            }
        }
    }
}