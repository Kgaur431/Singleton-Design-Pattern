package StructuralDP.Adapter;

import StructuralDP.RazorPay.RazorPayGateway;

public class RazorPayGatewayAdapter implements PaymentGatewayService{

  private RazorPayGateway razorPayGateway = new RazorPayGateway();  // we create an instance of RazorPayGateway becoz this class will do the actual work of payment.
    @Override
    public Long payWithCC(String cardNumber, int cardCVV, int expiryMonth, int expiryYear) {
        String cardCVVString = String.valueOf(cardCVV);
        String expiryYearString = String.valueOf(expiryYear);
        String expiryMonthString = String.valueOf(expiryMonth);
        String result = razorPayGateway.payByCreditCard(cardNumber, cardCVVString, expiryMonthString + "/" + expiryYearString);
        return Long.parseLong(result);
    }

    @Override
    public PaymentStatus getPaymentStatus(Long transactionID) {
        boolean status = razorPayGateway.checkPaymentStatus(String.valueOf(transactionID));
        if (status == true) {
            return PaymentStatus.SUCCESS;
        } else {
            return PaymentStatus.PENDING;
        }
    }
}
