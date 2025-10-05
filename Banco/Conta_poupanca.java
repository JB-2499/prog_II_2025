package Conta;

public class Conta_poupanca extends Conta {
    private double rendimento;

    public Conta_poupanca(String numero, String titular, double saldo, double rendimento) {
        super(numero, titular, saldo);
        this.rendimento = rendimento;
    }

    @Override
    public void mostrar_dados(){
        super.mostrar_dados();
        System.out.println("A taxa mensal de rendimento da conta é: " + this.rendimento);
    }

    public void mostrar_dados_poupanca(boolean taxa_anual){
        super.mostrar_dados();

        if(taxa_anual){
            System.out.println(">Taxa anual de rendimento: " + this.rendimento*12);
        } else {
            System.out.println(">Taxa mensal de rendimento: " + this.rendimento);
        }
    }

    public double get_rendimento() {
        return rendimento;
    }

    public void set_rendimento(double rendimento) {
        this.rendimento = rendimento;
    }
}