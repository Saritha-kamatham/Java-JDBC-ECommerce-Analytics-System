import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EcommerceDAO {

	public void addCustomer(Customer c) {

	    String sql =
	    "INSERT INTO Customers(customer_name,email,phone,city) VALUES(?,?,?,?)";

	    try(
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	    ) {

	        ps.setString(1,c.getCustomerName());
	        ps.setString(2,c.getEmail());
	        ps.setString(3,c.getPhone());
	        ps.setString(4,c.getCity());

	        int rows = ps.executeUpdate();

	        System.out.println(rows + " Customer Added");

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}

	public void viewCustomers() {

	    String sql = "SELECT * FROM Customers";

	    try(
	        Connection con = DBConnection.getConnection();
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	    ) {

	        System.out.println("\nCUSTOMERS");

	        while(rs.next()) {

	            System.out.println(
	                    rs.getInt("customer_id")+" "
	                    +rs.getString("customer_name")+" "
	                    +rs.getString("email")+" "
	                    +rs.getString("phone")+" "
	                    +rs.getString("city"));
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public void addCategory(Category c) {

	    String sql =
	    "INSERT INTO Categories(category_name) VALUES(?)";

	    try(
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	    ) {

	        ps.setString(1,c.getCategoryName());

	        int rows = ps.executeUpdate();

	        System.out.println(rows + " Category Added");

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public void viewCategories() {

	    String sql = "SELECT * FROM Categories";

	    try(
	        Connection con = DBConnection.getConnection();
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	    ) {

	        System.out.println("\nCATEGORIES");

	        while(rs.next()) {

	            System.out.println(
	                    rs.getInt("category_id")+" "
	                    +rs.getString("category_name"));
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public void addProduct(Product p) {

	    String sql =
	    "INSERT INTO Products(product_name,price,stock,category_id) VALUES(?,?,?,?)";

	    try(
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	    ) {

	        ps.setString(1,p.getProductName());
	        ps.setDouble(2,p.getPrice());
	        ps.setInt(3,p.getStock());
	        ps.setInt(4,p.getCategoryId());

	        int rows = ps.executeUpdate();

	        System.out.println(rows + " Product Added");

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public void viewProducts() {

	    String sql = "SELECT * FROM Products";

	    try(
	        Connection con = DBConnection.getConnection();
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	    ) {

	        System.out.println("\nPRODUCTS");

	        while(rs.next()) {

	            System.out.println(
	                    rs.getInt("product_id")+" "
	                    +rs.getString("product_name")+" "
	                    +rs.getDouble("price")+" "
	                    +rs.getInt("stock")+" "
	                    +rs.getInt("category_id"));
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public void placeOrder(OrderModel order) {

	    String sql =
	            "INSERT INTO Orders(customer_id,order_date,total_amount) VALUES(?,CURDATE(),?)";

	    try (
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(sql);
	    ) {

	        ps.setInt(1, order.getCustomerId());
	        ps.setDouble(2, order.getTotalAmount());

	        int rows = ps.executeUpdate();

	        System.out.println(rows + " Order Placed");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void viewOrders() {

		String sql =
				"SELECT o.order_id," +
				" c.customer_name," +
				" o.order_date," +
				" o.total_amount " +
				"FROM Orders o " +
				"JOIN Customers c " +
				"ON o.customer_id=c.customer_id";

	    try (
	            Connection con = DBConnection.getConnection();
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	    ) {

	        System.out.println("\nORDERS");

	        while(rs.next())
	        {
	            System.out.println(
	                "Order ID : "
	                + rs.getInt("order_id"));

	            System.out.println(
	                "Customer : "
	                + rs.getString("customer_name"));

	            System.out.println(
	                "Date : "
	                + rs.getDate("order_date"));

	            System.out.println(
	                "Amount : "
	                + rs.getDouble("total_amount"));

	            System.out.println("----------------");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void addPayment(Payment payment) {

	    String sql =
	            "INSERT INTO Payments(order_id,payment_date,payment_method,amount) VALUES(?,CURDATE(),?,?)";

	    try (
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(sql);
	    ) {

	        ps.setInt(1, payment.getOrderId());
	        ps.setString(2, payment.getPaymentMethod());
	        ps.setDouble(3, payment.getAmount());

	        int rows = ps.executeUpdate();

	        System.out.println(rows + " Payment Added");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void viewPayments() {

	    String sql = "SELECT * FROM Payments";

	    try (
	            Connection con = DBConnection.getConnection();
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	    ) {

	        System.out.println("\nPAYMENTS");

	        while (rs.next()) {

	            System.out.println(
	                    rs.getInt("payment_id") + " " +
	                    rs.getInt("order_id") + " " +
	                    rs.getDate("payment_date") + " " +
	                    rs.getString("payment_method") + " " +
	                    rs.getDouble("amount"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void addReview(Review review) {

	    String sql =
	            "INSERT INTO Reviews(customer_id,product_id,rating,review_text) VALUES(?,?,?,?)";

	    try (
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(sql);
	    ) {

	        ps.setInt(1, review.getCustomerId());
	        ps.setInt(2, review.getProductId());
	        ps.setInt(3, review.getRating());
	        ps.setString(4, review.getReviewText());

	        int rows = ps.executeUpdate();

	        System.out.println(rows + " Review Added");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void viewReviews() {

		String sql =
				"SELECT r.review_id," +
				" c.customer_name," +
				" p.product_name," +
				" r.rating," +
				" r.review_text " +
				"FROM Reviews r " +
				"JOIN Customers c " +
				"ON r.customer_id=c.customer_id " +
				"JOIN Products p " +
				"ON r.product_id=p.product_id";

	    try (
	            Connection con = DBConnection.getConnection();
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	    ) {

	        System.out.println("\nREVIEWS");

	        while(rs.next())
	        {
	            System.out.println(
	                "Review ID : "
	                + rs.getInt("review_id"));

	            System.out.println(
	                "Customer : "
	                + rs.getString("customer_name"));

	            System.out.println(
	                "Product : "
	                + rs.getString("product_name"));

	            System.out.println(
	                "Rating : "
	                + rs.getInt("rating"));

	            System.out.println(
	                "Review : "
	                + rs.getString("review_text"));

	            System.out.println("----------------");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void topCustomers() {

	    String sql =
	            "SELECT c.customer_name, " +
	            "SUM(o.total_amount) AS purchase " +
	            "FROM Customers c " +
	            "JOIN Orders o " +
	            "ON c.customer_id=o.customer_id " +
	            "GROUP BY c.customer_name " +
	            "ORDER BY purchase DESC LIMIT 5";

	    try(
	            Connection con = DBConnection.getConnection();
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	    ) {

	        System.out.println("\nTOP CUSTOMERS");

	        while(rs.next()) {

	            System.out.println(
	                    rs.getString("customer_name")
	                            + " "
	                            + rs.getDouble("purchase"));
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public void bestSellingProducts() {

	    String sql =
	            "SELECT p.product_name, " +
	            "SUM(oi.quantity) AS totalSold " +
	            "FROM Products p " +
	            "JOIN Order_Items oi " +
	            "ON p.product_id=oi.product_id " +
	            "GROUP BY p.product_name " +
	            "ORDER BY totalSold DESC LIMIT 5";

	    try(
	            Connection con = DBConnection.getConnection();
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	    ) {

	        System.out.println("\nBEST SELLING PRODUCTS");

	        while(rs.next()) {

	            System.out.println(
	                    rs.getString("product_name")
	                            + " "
	                            + rs.getInt("totalSold"));
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public void monthlyReport() {

	    String sql =
	            "SELECT MONTH(order_date) AS month," +
	            "YEAR(order_date) AS year," +
	            "SUM(total_amount) AS sales " +
	            "FROM Orders " +
	            "GROUP BY YEAR(order_date),MONTH(order_date)";

	    try(
	            Connection con = DBConnection.getConnection();
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	    ) {

	        System.out.println("\nMONTHLY SALES REPORT");

	        while(rs.next()) {

	            System.out.println(
	                    "Month : "
	                            + rs.getInt("month")
	                            + " Year : "
	                            + rs.getInt("year")
	                            + " Sales : "
	                            + rs.getDouble("sales"));
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public void generateInvoice(int orderId) {

	    String sql =
	            "SELECT o.order_id," +
	            "c.customer_name," +
	            "o.order_date," +
	            "o.total_amount " +
	            "FROM Orders o " +
	            "JOIN Customers c " +
	            "ON o.customer_id=c.customer_id " +
	            "WHERE o.order_id=?";

	    try(
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps =
	                    con.prepareStatement(sql);
	    ) {

	        ps.setInt(1,orderId);

	        ResultSet rs =
	                ps.executeQuery();

	        while(rs.next()) {

	        	System.out.println();

	        	System.out.println("=================================");

	        	System.out.println("          INVOICE");

	        	System.out.println("=================================");

	        	System.out.println(
	        	        "Order ID      : "
	        	        + rs.getInt("order_id"));

	        	System.out.println(
	        	        "Customer Name : "
	        	        + rs.getString("customer_name"));

	        	System.out.println(
	        	        "Order Date    : "
	        	        + rs.getDate("order_date"));

	        	System.out.println();

	        	System.out.println(
	        	        "Total Amount  : "
	        	        + rs.getDouble("total_amount"));

	        	System.out.println();

	        	System.out.println(
	        	        "Thank You For Shopping");

	        	System.out.println("=================================");
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public void salesDashboard() {

		String sql =
				"SELECT " +
				"(SELECT COUNT(*) FROM Customers) AS customers," +
				"(SELECT COUNT(*) FROM Products) AS products," +
				"(SELECT COUNT(*) FROM Orders) AS orders";

	    try(
	            Connection con = DBConnection.getConnection();
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	    ) {

	        while(rs.next()) {

	            System.out.println("\n===== DASHBOARD =====");

	            System.out.println(
	                    "Total Customers : "
	                            + rs.getInt("customers"));

	            System.out.println(
	                    "Total Products : "
	                            + rs.getInt("products"));

	            System.out.println(
	                    "Total Orders : "
	                            + rs.getInt("orders"));
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
}