package Atividade_avaliativa.Veiculo;

public class Carro extends Veiculo {
    final int portas;

    public Carro(String placa, String marca, double preco, int num_portas) {
        super(placa,marca,preco);
        this.portas = num_portas;
    }

    @Override
    public void printdt(){
        super.printdt();
    }

    public void printdt_carro(){
        super.printdt();
        System.out.println(">Número de portas: " + this.portas);
    }
}