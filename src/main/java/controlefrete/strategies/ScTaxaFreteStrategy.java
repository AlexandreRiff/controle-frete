package controlefrete.strategies;

public class ScTaxaFreteStrategy implements TaxaFrete {

    @Override
    public double calcularTaxa(double peso) {
        double TAXA = 35.00;
        return peso * TAXA;
    }

}
