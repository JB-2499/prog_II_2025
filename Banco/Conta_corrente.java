package Conta;

public class Conta_corrente extends Conta{
    double limite_cred;

    public Conta_corrente(String numero, String titular, double saldo, double limite_cred) {
        super(numero, titular, saldo);
        this.limite_cred = limite_cred;
    }

    @Override
    public void mostrar_dados(){
        super.mostrar_dados();

        System.out.println(">Valor limite de cheques: " + this.limite_cred);
    }

    public void mostrar_dados_corrente(){
        super.mostrar_dados();

        System.out.println(">Valor limite de crédito: " + this.limite_cred);
        System.out.println(">Saldo e crédito: " + this.limite_cred + this.getSaldo());
    }

    public double getLimite_cred() {
        return limite_cred;
    }

    public void setLimite_cred(double limite_cred) {
        this.limite_cred = limite_cred;
    }
}