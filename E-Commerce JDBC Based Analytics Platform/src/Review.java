public class Review {

    private int customerId;
    private int productId;
    private int rating;
    private String reviewText;

    public Review(int customerId,
                  int productId,
                  int rating,
                  String reviewText) {

        this.customerId = customerId;
        this.productId = productId;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getProductId() {
        return productId;
    }

    public int getRating() {
        return rating;
    }

    public String getReviewText() {
        return reviewText;
    }
}