package StructuralDP.RazorPay;


// this is Razorpay codebase so the code signature would not be same as Flipkart PaymentGatewayService interface.
public class RazorPayGateway {
    public String payByCreditCard(String creditCard, String cvv, String expiryDate) {
        System.out.println("Payment done by RazorPay");
        return "123";
    }

    public boolean checkPaymentStatus(String transactionID) {
        return false;
    }
}
