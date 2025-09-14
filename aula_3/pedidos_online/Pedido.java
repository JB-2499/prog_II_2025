package aula_3.pedidos_online;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Pedido {
    private int id_pedido;
    private String cliente, status;
    private double valor_total;

    public void setId_pedido(Scanner sc) {
        while (true){
            System.out.println("Digite o ID do pedido (7 digitos): ");
            String id_pedido = sc.nextLine();

            if (!id_pedido.matches("\\d{7}")) {
                System.out.println("Erro!!! O ID deve conter 7 digitos!\n");
            } else {
                System.out.println("ID atualizado com sucesso!");
                this.id_pedido = Integer.parseInt(id_pedido);
                break;
            }
        }
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setCliente(Scanner sc) {
        while (true){
            System.out.println("Digite o nome do cliente: ");
            String cliente = sc.nextLine();

            if (cliente.isEmpty()) {
                System.out.println("Erro!!! O nome deve ser preenchido!");
            } else {
                System.out.println("Nome atualizado com sucesso!");
                this.cliente = cliente;
                break;
            }
        }
    }

    public String getCliente() {
        return cliente;
    }

    public void setStatus(Scanner sc) {
        while (true) {
            try {
                System.out.println("|1 - Pendente | |2 - Processando|");
                System.out.println("|3 - Enviado  | |4  - Entregue  |");
                System.out.println("|5 - Cancelado|");
                System.out.println("Digite o status atual do pedido: ");
                int status = sc.nextInt();
                sc.nextLine();

                if (status == 1) {
                    System.out.println("Status atualizado com sucesso!");
                    this.status = "Pendente";
                    break;
                } else if (status == 2) {
                    System.out.println("Status atualizado com sucesso!");
                    this.status = "Processando";
                    break;
                } else if (status == 3) {
                    System.out.println("Status atualizado com sucesso!");
                    this.status = "Enviado";
                    break;
                } else if (status == 4) {
                    System.out.println("Status atualizado com sucesso!");
                    this.status = "Entregue";
                    break;
                } else if (status == 5) {
                    System.out.println("Status atualizado com sucesso!");
                    this.status = "Cancelado";
                    break;
                } else {
                    System.out.println("Erro!!! Digite uma opção válida!\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um valor válido!\n");
                sc.nextLine();
            }
        }
    }

    public String getStatus() {
        return status;
    }

    public void setValor_total(Scanner sc) {
        while (true) {
            try {
                System.out.println("Digite o valor total do pedido: ");
                String valor = sc.nextLine().replace(",", ".");
                double valor_total = Double.parseDouble(valor);

                if (valor_total <= 0) {
                    System.out.println("Erro!!! O valor não pode ser negativo ou nulo!\n");
                } else {
                    System.out.println("Valor atualizado com sucesso!");
                    this.valor_total = valor_total;
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro!!! Digite um valor numérico!");
            }
        }
    }

    public double getValor_total() {
        return valor_total;
    }

    public void fazerPedido(Scanner sc) {
        this.setId_pedido(sc);
        this.setValor_total(sc);
        this.setCliente(sc);

        this.status = "Pendente";

        System.out.println("O pedido foi registrado com sucesso!");
    }

    public void exibirPedido() {
        if (cliente == null || cliente.isEmpty()) {
            System.out.println("Erro!!! O pedido ainda não foi feito!");
        } else {
            System.out.println("\nInformações:");
            System.out.println(">Nome do cliente: " + this.getCliente());
            System.out.println(">Id do  Pedido: " + this.getId_pedido());
            System.out.println(">Status do pedido: " + this.getStatus());
            System.out.printf(">Valor total do pedido: %.2f", this.getValor_total());
        }
    }

    public void menu(Scanner sc) {
        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("|1 -   Fazer Pedido   | |2 - Exibir Pedido|");
                System.out.println("|3 - Atualizar status | |4 -     Sair     |");
                System.out.println("\nBem-vindo à lanchonete Pernambuco! O que deseja fazer? ");
                int opcao = sc.nextInt();
                sc.nextLine();

                if  (opcao == 1) {
                    this.fazerPedido(sc);
                } else if (opcao == 2) {
                    this.exibirPedido();
                } else if (opcao == 3) {
                    this.setStatus(sc);
                } else if (opcao == 4) {
                    System.out.println("Programa finalizado com sucesso!\nObrigado pela preferência!");
                    break;
                } else {
                    System.out.println("Erro!!! Digite uma opção válida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um valor válido!\n");
                sc.nextLine();
            }
        }
    }
}