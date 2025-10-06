package Atividade_avaliativa.Banco;

public class Conta {
    final String numero, titular;
    final double saldo;

    public Conta(String numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void mostrar_dados(){
        System.out.println("\nInformações da conta:");
        System.out.println(">Número da conta: " + this.numero);
        System.out.println(">Nome do titular: " + this.titular);
        System.out.println(">Saldo: " + this.saldo);
    }

    public void mostrar_dados(double projecao_mensal){
        mostrar_dados();
        System.out.println(">Saldo previsto na projeção: " + (this.saldo + projecao_mensal*this.saldo));
    }

    public double getSaldo() {
        return saldo;
    }
}