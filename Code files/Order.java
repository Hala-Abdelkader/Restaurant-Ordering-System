import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<menuItem> itemsOrdered;
    private double totalPrice;
    private List<String> instructions;
    private double discount=0;
    private double taxrate = 0.14;
    private String paymentMethod = "";
    private String orderType;

    // Constructor
    public Order() {
        this.itemsOrdered = new ArrayList<>();
        this.instructions = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    // Add item to Order ArrayList
    public void addItem(menuItem mItem, int quantity) {
        for (int i = 0; i < quantity; i++) {
            itemsOrdered.add(mItem);
            totalPrice += mItem.getPrice();
            instructions.add("");
        }

    }
    public void addItem(menuItem mItem, int quantity, String inst) {
        for (int i = 0; i < quantity; i++) {
            itemsOrdered.add(mItem);
            instructions.add(inst);
            totalPrice += mItem.getPrice();
        }

    }

    // Remove Item from Order Array List
    public void removeItem(menuItem mItem, int quantity) {
        for (int i = 0; i < quantity; i++) {
            for (int j = 0; j < itemsOrdered.size() ; j++) {

                if (itemsOrdered.get(j) == mItem) {
                    totalPrice -= mItem.getPrice();
                    itemsOrdered.remove(j);
                    instructions.remove(j);
                    break;
                }
            }
        }
    }
    public void removeItem(menuItem mItem) {
        for (int i = 0; i < getItemsOrdered().size(); i++) {
            totalPrice -= mItem.getPrice();
            itemsOrdered.remove(mItem);
            instructions.remove(itemsOrdered.get(i));
        }
    }

    // Get Functions
    public String getTotalPrice() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedPrice = decimalFormat.format(totalPrice);
        return formattedPrice;
    }
    public String getDiscount() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedPrice = decimalFormat.format(discount);
        return formattedPrice;
    }
    public String getBill(){
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        String formattedPrice = decimalFormat.format(totalPrice + (totalPrice*taxrate)-discount);
        return formattedPrice;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public String getOrderType() {
        return orderType;
    }
    public List<menuItem> getItemsOrdered() {
        return itemsOrdered;
    }

    // Set Payment Method Function
    public void setPaymentMethod(String payment) {
        paymentMethod = payment;
    }
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // Apply Discount
    public void applyDiscount(double discountPercentage) {
        discount = totalPrice * (discountPercentage / 100);
    }

    // Display Order
    public void displayOrder() {
        System.out.println("Order Details:");
        for (int i = 0; i < itemsOrdered.size() ; i++) {
            itemsOrdered.get(i).printItem();
            if(!instructions.get(i).isEmpty()){
                System.out.println("                                     "+instructions.get(i)+"\n");
        }
        }
        if(!getPaymentMethod().isEmpty()){
            System.out.println("Payment chosen :  "+ paymentMethod);
        }
        System.out.println("    Total Price    : $" + getTotalPrice());
    }
    public void checkoutOrder(){
        displayOrder();
        System.out.println("    Discount       : $" + getDiscount());
        System.out.println("    Bill After Tax : $" + getBill());
    }
    public void payment(String payment){
        setPaymentMethod(payment);
        System.out.println("Processing payment of $" + getBill() +"   "+ payment);
    }

}
