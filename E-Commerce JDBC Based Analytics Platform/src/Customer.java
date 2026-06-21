public class Customer {

    private String customerName;
    private String email;
    private String phone;
    private String city;

    public Customer(String customerName,
                    String email,
                    String phone,
                    String city) {

        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.city = city;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }
}