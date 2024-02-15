package Lesson8.Assignment1.Question8;

class PayPal implements PaymentGateway {
    private boolean paymentSuccessful;

    @Override
    public void processPayment(double amount) {

        System.out.println("Processing payment of RM " + amount + " through PayPal...");

        paymentSuccessful = true;
    }

    @Override
    public boolean isPaymentSuccessful() {

        return paymentSuccessful;
    }
}