package controlefrete.strategies;

public class SpTaxaFreteStrategy implements TaxaFrete {

    @Override
    public double calcularTaxa(double peso) {
        double TAXA = 50.00;
        return peso * TAXA;
    }

}
