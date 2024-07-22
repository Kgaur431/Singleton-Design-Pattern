package Factory_Desing_Pattern.SimpleFactory.TaxCalculator_Second.algorithm;

import Factory_Desing_Pattern.SimpleFactory.TaxCalculator_Second.SalaryDetails;

// step 2
public class OldTaxAlogirthm implements TaxAlgorithm{
    @Override
    public Double calculateTax(SalaryDetails salaryDetails) {
            return 0.4 * salaryDetails.getBasePay() + 0.3 * salaryDetails.getHra();
    }
}