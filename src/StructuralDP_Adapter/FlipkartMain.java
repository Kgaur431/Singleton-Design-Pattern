package StructuralDP;

import StructuralDP.Adapter.Flipkart;
import StructuralDP.Adapter.RazorPayGatewayAdapter;

public class FlipkartMain {
    public static void main(String[] args) {
        Flipkart flipkart = new Flipkart( new RazorPayGatewayAdapter());        // doing dependency injection
    }
}
