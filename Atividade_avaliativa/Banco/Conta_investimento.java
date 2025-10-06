package Atividade_avaliativa.Banco;

public class Conta_investimento extends Conta {
    final double taxa_admin;
    final double projecao_men;

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
}