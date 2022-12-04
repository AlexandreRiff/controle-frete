package controlefrete.strategies;

import controlefrete.enums.FreteEstadosEnum;

public class TaxaFreteContext {

    public TaxaFrete getStrategy(int tipo) {
        if(FreteEstadosEnum.SC.getValor() == tipo) {
            return new ScTaxaFreteStrategy();
        }

        if(FreteEstadosEnum.SP.getValor() == tipo) {
            return new SpTaxaFreteStrategy();
        }

        throw new IllegalArgumentException("error");
    }

}
