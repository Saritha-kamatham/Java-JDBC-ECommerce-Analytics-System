public class Payment {

    private int orderId;
    private String paymentMethod;
    private double amount;

    public Payment(int orderId,
                   String paymentMethod,
                   double amount) {

        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }
}