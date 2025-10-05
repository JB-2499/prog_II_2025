package Conta;

public class Conta_investimento extends Conta {
    private double taxa_admin;
    private double projecao_men;

    public Conta_investimento(String numero, String titular, double saldo, double taxa_admin, double projecao_men) {
        super(numero, titular, saldo);
        this.taxa_admin = taxa_admin;
        this.projecao_men = projecao_men;
    }

    @Override
    public void mostrar_dados() {
        super.mostrar_dados();
        System.out.println(">Taxa gasta com administração: " + this.taxa_admin);
    }

    public void mostrar_dados_investimento() {
        super.mostrar_dados();

        double projecao = (this.projecao_men - this.taxa_admin);
        super.mostrar_dados(projecao);
    }

    public double getTaxa_admin() {
        return taxa_admin;
    }

    public void setTaxa_admin(double taxa_admin) {
        this.taxa_admin = taxa_admin;
    }
}