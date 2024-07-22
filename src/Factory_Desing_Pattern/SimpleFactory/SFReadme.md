```Steps In which I created the Tax Calculator app:-
TaxCalculator_First:-
1.  we create TaxRegime class.
2.  we create SalaryDetails class.
3. we create TaxCalculator class.
    3.1  create static method called calculateTax().
   3.2  implement the calculateTax().


TaxCalculator_Second:-
1.  we create TaxAlgor ithm interface in new package.
      1.1  create method called calculateTax(). 
                parameter of this method is ?
                    we can't take Regime as a param in the calculateTax(), becoz each Regime has a diff implementation, so instead of Regim calculatingTax method takes SalaryDetails as a parameter. 
                calculateTax(SalaryDetails details);
2.  we create the two sub class which implements TaxCalculator interface, that is OldTaxCalculator, NewTaxCalculator.
3.  we create the Factory class called TaxCalculatorFactory.
4.  implements the TaxCalculator class. 


```