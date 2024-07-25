package StructuralDP.Adapter;

public class Flipkart {
    private PaymentGatewayService paymentGatewayService;

    public Flipkart(PaymentGatewayService paymentGatewayService) {
        this.paymentGatewayService = paymentGatewayService;
    }

    public void makePaymentViaCC(String cardNumber, int cardCVV, int expiryMonth, int expiryYear) {
           Long transactionID = paymentGatewayService.payWithCC(cardNumber, cardCVV, expiryMonth, expiryYear);

            while (!paymentGatewayService.getPaymentStatus(transactionID).equals(PaymentStatus.SUCCESS)) {
                System.out.println("Payment is pending");
            }
    }
}
