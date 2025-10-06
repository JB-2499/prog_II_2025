package Atividade_avaliativa.Veiculo;

public class Moto extends Veiculo {
    final int cilindradas;

    public Moto(String placa, String marca, double preco, int cilindradas){
        super(placa,marca,preco);
        this.cilindradas = cilindradas;
    }

    @Override
    public void printdt(){
        super.printdt();
    }

    public void printdt_moto(){
        super.printdt();
        System.out.println(">Cilindradas do motor: " + this.cilindradas);
    }
}