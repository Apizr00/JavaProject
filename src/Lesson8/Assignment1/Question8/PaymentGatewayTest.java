package Lesson8.Assignment1.Question8;

public class PaymentGatewayTest {
    public static void main(String[] args) {

        PaymentGateway paypal = new PayPal();
        paypal.processPayment(100.00);

        if (paypal.isPaymentSuccessful()) {

            System.out.println("Payment through PayPal was successful!");

        } else {

            System.out.println("Payment through PayPal failed!");
        }

        PaymentGateway stripe = new Stripe();
        stripe.processPayment(75.00);

        if (stripe.isPaymentSuccessful()) {

            System.out.println("Payment through Stripe was successful!");

        } else {

            System.out.println("Payment through Stripe failed!");
        }
    }
}