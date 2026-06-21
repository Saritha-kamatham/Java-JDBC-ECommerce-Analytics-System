public class Product {

    private String productName;
    private double price;
    private int stock;
    private int categoryId;

    public Product(String productName,
                   double price,
                   int stock,
                   int categoryId) {

        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getCategoryId() {
        return categoryId;
    }
}