package Factory_Desing_Pattern.SimpleFactory.TaxCalculator_Second;

import Factory_Desing_Pattern.SimpleFactory.TaxCalculator_Second.algorithm.TaxCalculatorFactory;
// step 4
public class TaxCalculator {
    public static Double calculateTax(TaxRegim taxRegim, SalaryDetails salaryDetails) {
        return TaxCalculatorFactory
                .getTaxAlgorithm(taxRegim)
                .calculateTax(salaryDetails);
    }
}

/**
 *  How method chaning works ?
 *      we call the method of TaxCalculatorFactory which is getTaxAlgorithm(taxRegim), this method returns the TaxAlgorithm object or we can say TaxAlgorithmImpl class object. means we have an TaxAlgorithm obj.
 *      Now we can call the calculateTax method using TaxAlgorithm object, this will return the double.
 *
 *
 *
 */
