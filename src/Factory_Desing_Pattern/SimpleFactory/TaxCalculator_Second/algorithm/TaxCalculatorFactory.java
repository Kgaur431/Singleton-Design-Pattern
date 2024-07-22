package Factory_Desing_Pattern.SimpleFactory.TaxCalculator_Second.algorithm;

import Factory_Desing_Pattern.SimpleFactory.TaxCalculator_Second.TaxRegim;
// step 3
public class TaxCalculatorFactory {
    public static TaxAlgorithm getTaxAlgorithm(TaxRegim taxRegim) {
        switch (taxRegim) {
            case OLD -> {
                return new OldTaxAlogirthm();
            }
            case NEW -> {
                return new NewTaxAlogirthm();
            }
        }
        throw new RuntimeException("Invalid Regime"+ taxRegim);
    }
}

