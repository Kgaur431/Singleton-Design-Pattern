package Factory_Desing_Pattern.SimpleFactory.TaxCalculator_First;

public class TaxCalculator {
    public static Double calculateTax(TaxRegim taxRegim, SalaryDetails salaryDetails){
        switch (taxRegim){
            case OLD:
                return 0.4 * salaryDetails.getBasePay() + 0.3 * salaryDetails.getHra();
            case NEW:
                return 0.4 * salaryDetails.getBasePay() + 0.3 * salaryDetails.getHra() + + 0.2 * salaryDetails.getLta();
        }
        throw new RuntimeException("Invalid Tax Regim");
    }
}

/**
 *    To calculate tax, first thing we have to do is figure out what is the tax regim.
 *
 *
 *
 */
