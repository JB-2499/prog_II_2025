package Atividade_avaliativa.Veiculo;

public class Caminhao extends Veiculo {
    final double capacidade;

    public Caminhao(String placa, String marca, double preco, double capacidade){
        super(placa, marca, preco);
        this.capacidade = capacidade;

    }

    @Override
    public void printdt(){
        super.printdt();
    }

    public void printdt_caminhao(){
        super.printdt();
        System.out.println(">Capacidade de carga (toneladas): " + this.capacidade);
    }
}