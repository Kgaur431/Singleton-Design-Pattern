package Factory_Desing_Pattern.SimpleFactory.TaxCalculator_Second.algorithm;

import Factory_Desing_Pattern.SimpleFactory.TaxCalculator_Second.SalaryDetails;
// Step 1
public interface TaxAlgorithm {
   Double calculateTax(SalaryDetails salaryDetails);
}
