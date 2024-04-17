import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private String phone;
    private String address ="";
    private List<Order> pastOrders;

    public Customer(String name, String phone){
        setName(name);
        setPhone(phone);
        pastOrders = new ArrayList<>();

    }



    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public List<Order> getPastOrders() {
        return pastOrders;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void addOrder(Order order){
        pastOrders.add(order);
    }
    public Order reorder(int i){
        pastOrders.get(i-1).setDiscount(0);
        return pastOrders.get(i-1);
    }
    public void displayOrders() {
        System.out.println("Customer: " + name);
        System.out.println("Order History:");
        int i=0;
        for (Order order : pastOrders) {
            i++;
            System.out.println("  "+i+"-  ");
            order.checkoutOrder();
            System.out.println("Order Type:  "+order.getOrderType());

        }
    }

}
