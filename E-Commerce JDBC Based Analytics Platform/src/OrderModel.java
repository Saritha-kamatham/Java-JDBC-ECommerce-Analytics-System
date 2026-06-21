public class OrderModel {

    private int customerId;
    private double totalAmount;

    public OrderModel(int customerId,
                      double totalAmount) {

        this.customerId = customerId;
        this.totalAmount = totalAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}