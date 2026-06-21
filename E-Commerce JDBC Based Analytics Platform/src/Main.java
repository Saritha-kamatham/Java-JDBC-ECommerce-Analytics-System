import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EcommerceDAO dao = new EcommerceDAO();

        while (true) {

            System.out.println("\n===== ECOMMERCE ANALYTICS SYSTEM =====");

            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");

            System.out.println("3. Add Category");
            System.out.println("4. View Categories");

            System.out.println("5. Add Product");
            System.out.println("6. View Products");

            System.out.println("7. Place Order");
            System.out.println("8. View Orders");

            System.out.println("9. Add Payment");
            System.out.println("10. View Payments");

            System.out.println("11. Add Review");
            System.out.println("12. View Reviews");

            System.out.println("13. Top Customers");
            System.out.println("14. Best Selling Products");
            System.out.println("15. Monthly Sales Report");
            System.out.println("16. Generate Invoice");
            System.out.println("17. Sales Dashboard");

            System.out.println("18. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Name : ");
                    String cname = sc.nextLine();

                    System.out.print("Email : ");
                    String email = sc.nextLine();

                    System.out.print("Phone : ");
                    String phone = sc.nextLine();

                    System.out.print("City : ");
                    String city = sc.nextLine();

                    Customer customer =
                            new Customer(cname, email, phone, city);

                    dao.addCustomer(customer);

                    break;

                case 2:

                    dao.viewCustomers();

                    break;

                case 3:

                    sc.nextLine();

                    System.out.print("Category Name : ");
                    String categoryName = sc.nextLine();

                    Category category =
                            new Category(categoryName);

                    dao.addCategory(category);

                    break;

                case 4:

                    dao.viewCategories();

                    break;

                case 5:

                    sc.nextLine();

                    System.out.print("Product Name : ");
                    String pname = sc.nextLine();

                    System.out.print("Price : ");
                    double price = sc.nextDouble();

                    System.out.print("Stock : ");
                    int stock = sc.nextInt();

                    System.out.print("Category ID : ");
                    int cid = sc.nextInt();

                    Product product =
                            new Product(
                                    pname,
                                    price,
                                    stock,
                                    cid);

                    dao.addProduct(product);

                    break;

                case 6:

                    dao.viewProducts();

                    break;

                case 7:

                    System.out.print("Customer ID : ");
                    int custId = sc.nextInt();

                    System.out.print("Total Amount : ");
                    double amount = sc.nextDouble();

                    OrderModel order =
                            new OrderModel(
                                    custId,
                                    amount);

                    dao.placeOrder(order);

                    break;

                case 8:

                    dao.viewOrders();

                    break;

                case 9:

                    System.out.print("Order ID : ");
                    int orderId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Payment Method : ");
                    String method = sc.nextLine();

                    System.out.print("Amount : ");
                    double payAmount = sc.nextDouble();

                    Payment payment =
                            new Payment(
                                    orderId,
                                    method,
                                    payAmount);

                    dao.addPayment(payment);

                    break;

                case 10:

                    dao.viewPayments();

                    break;

                case 11:

                    System.out.print("Customer ID : ");
                    int customerId = sc.nextInt();

                    System.out.print("Product ID : ");
                    int productId = sc.nextInt();

                    System.out.print("Rating : ");
                    int rating = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Review : ");
                    String reviewText = sc.nextLine();

                    Review review =
                            new Review(
                                    customerId,
                                    productId,
                                    rating,
                                    reviewText);

                    dao.addReview(review);

                    break;

                case 12:

                    dao.viewReviews();

                    break;

                case 13:

                    dao.topCustomers();

                    break;

                case 14:

                    dao.bestSellingProducts();

                    break;

                case 15:

                    dao.monthlyReport();

                    break;

                case 16:

                    System.out.print("Enter Order ID : ");
                    int invoiceId = sc.nextInt();

                    dao.generateInvoice(invoiceId);

                    break;

                case 17:

                    dao.salesDashboard();

                    break;

                case 18:

                    System.out.println("Thank You");
                    System.exit(0);

                    break;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}