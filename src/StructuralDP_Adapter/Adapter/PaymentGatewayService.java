package StructuralDP.Adapter;

public interface PaymentGatewayService {
    Long payWithCC (String cardNumber, int cardCVV,  int expiryMonth, int expiryYear);
    PaymentStatus getPaymentStatus(Long transactionID);
}
