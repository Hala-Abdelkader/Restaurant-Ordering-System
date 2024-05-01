import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //region Variable Initialization
    static menuItem item;
    static Menu menu;
    static List<Order> totalOrders;
    static List<Customer> allCustomers;
    static int input1;
    static int input2;
    static String input3;
    static String input4;
    static Order orderInput;
    static Customer customerInput;
    static Scanner sc;
    static boolean validInput =  false;
    //endregion

    public static void MenuInit() {
        // Create a menu
        menu = new Menu();
        
        // Create menu items
        item = new menuItem(1,"Caesar Salad", 8.49, "Appetizer","Lettuce, Grilled Chicken, Olive oil, and Dressing");
        menu.addMenuItem(item);
        item = new menuItem(2,"Mushroom Soup", 6.49, "Appetizer", "Water, Cream, Mushroom Extract");
        menu.addMenuItem(item);
        item = new menuItem(3,"French Fries", 5.49, "Appetizer", "Potatoes fried in Corn Oil");
        menu.addMenuItem(item);
        item = new menuItem(4,"Sambosek", 9.99, "Appetizer", "Cheese, Sambosek dough, Corn oil");
        menu.addMenuItem(item);
        item = new menuItem(5,"Lentil Soup", 6.49, "Appetizer", "Lentil, Water ,Carrots, and Potatoes");
        menu.addMenuItem(item);
        item = new menuItem(6,"Spaghetti Bolognese", 12.99, "Main Course", "Spaghetti, Tomato Sauce, Mushroom, and Olives");
        menu.addMenuItem(item);
        item = new menuItem(7,"Burger", 10.99, "Main Course", "Buns, 200g Patty, Onion, Tomato, Pickle, and Special Sauce");
        menu.addMenuItem(item);
        item = new menuItem(8,"Lasagna", 15.99, "Main Course", "Lasagna , Tomato Sauce, Cheese, and Ground Beef");
        menu.addMenuItem(item);
        item = new menuItem(9,"Pizza Margarita", 14.99, "Main Course", "Pizza Dough, Tomato sauce, Cheese, and Basil");
        menu.addMenuItem(item);
        item = new menuItem(10,"Pizza Peperoni", 16.99, "Main Course","Pizza Dough, Tomato sauce, Cheese, and Pepperoni");
        menu.addMenuItem(item);
        item = new menuItem(11,"Chocolate Brownie", 6.99, "Dessert", "Chocolate, Flour, Sugar, Eggs, and Milk" );
        menu.addMenuItem(item);
        item = new menuItem(12,"Tiramisu", 8.99, "Dessert", "Cacao, Sugar, Cream, and Milk");
        menu.addMenuItem(item);
        item = new menuItem(13,"Cheese Cake", 8.99, "Dessert", "Sugar , Cheese, Flour, Eggs, Milk");
        menu.addMenuItem(item);
        item = new menuItem(14,"Cookies", 6.99, "Dessert", "Chocolate, Flour, Sugar, Eggs, and Milk");
        menu.addMenuItem(item);
        item = new menuItem(15,"Molten Cake", 11.99, "Dessert", "Chocolate, Flour, Sugar, Eggs, and Milk");
        menu.addMenuItem(item);
        item = new menuItem(16,"V Cola", 3.99, "Drink");
        menu.addMenuItem(item);
        item = new menuItem(17,"Double Dare", 3.49, "Drink");
        menu.addMenuItem(item);
        item = new menuItem(18,"SpiroSpathes", 3.99, "Drink");
        menu.addMenuItem(item);

    }
    public static void OrderInit(){
        totalOrders = new ArrayList<>();
    }
    public static void CustomerInit(){
        allCustomers = new ArrayList<>();
        customerInput = new Customer("Hodhod","01500066702");
        allCustomers.add(customerInput);
    }

    public static void helloCustomer(){
        boolean newCustomer = true;
        System.out.printf("Please Enter your Phone Number -->   ");
        while(!validInput) {
            input3 = sc.nextLine();
            if( input3.length()==11 && input3.startsWith("01")){
                validInput = true;
            }else{
                System.out.println("Invalid Input, Please enter a valid phone number");
            }

        } validInput = false;
        int i=0 ;
        for (Customer customer:allCustomers) {
           if (customer.getPhone().equals(input3)){
               newCustomer = false;
           }
           i++;
        }
        if (newCustomer){
            newCustomer(input3);
        }else {
            oldCustomer(i-1);
        }
    }
    public static void newCustomer(String phone){
        System.out.println("         WELCOME TO OUR RESTAURANT  NEWCOMER!!!!\n\n WHAT SHOULD WE CALL YOU\n");
        while(!validInput) {
            input4 = sc.nextLine();
            if( input4.length()>2){
                validInput = true;
            }else{
                System.out.println("Invalid Input, Name should be at least 3 characters");
            }
        } validInput = false;

        customerInput = new Customer(input4,input3);
        allCustomers.add(customerInput);
        System.out.println("Would you like to do?\n    1: View Menu      2: Search Item");
        while(!validInput) {
            input1 = sc.nextInt();
            switch (input1){
                case 1:
                    System.out.println("         LET'S GET YOUR ORDER "+ allCustomers.getLast().getName()+"\n\n");
                    menu.displayMenu();
                    startOrdering(true, false,allCustomers.size()-1);
                    validInput=true;
                    break;
                case 2:
                    System.out.println("What item name would you like to Search for? ");
                    sc.nextLine();
                    input3= sc.nextLine();
                    if(menu.searchItem(input3)){
                        startOrdering(true,false,allCustomers.size()-1);
                    }else{
                        System.out.println("We're Sorry but there is no "+ input3+" in our Menu!");
                        System.out.println("Do you want to check our Menu? Y/N");
                        while(!validInput) {
                            input3 = sc.nextLine();
                            if( input3.equalsIgnoreCase("y")){
                                menu.displayMenu();
                                startOrdering(true,false, allCustomers.size()-1);
                                validInput = true;
                            } else if (input3.equalsIgnoreCase("n")) {
                                validInput = true;
                            }else{
                                System.out.println("Invalid Input, Try again -> Y/N");
                            }

                        } validInput = false;

                    }
                    validInput= true;
                    break;
                default:
                    System.out.println("Invalid Input, Try Again");
            }
        } validInput = false;

    }
    public static void oldCustomer(int customerIndex){
        System.out.println("         WELCOME BACK TO OUR RESTAURANT "+ allCustomers.get(customerIndex).getName() + "\nIT'S GOOD TO HAVE U BACK\n\n\n\n");
        System.out.println("What would you like to do?\n    1: View Menu      2: See Previous Orders    3: Search Item");

        while(!validInput) {
            input1 = sc.nextInt();
            switch (input1){
                case 1:
                    menu.displayMenu();
                    startOrdering(true,false, customerIndex);
                    validInput=true;
                    break;
                case 2:
                    previousOrder(customerIndex);
                    validInput= true;
                    break;
                case 3:
                    System.out.println("What item name would you like to Search for? ");
                    sc.nextLine();
                    input3= sc.nextLine();
                    if(menu.searchItem(input3)){
                        startOrdering(true,false,customerIndex);
                    }else{
                        System.out.println("Please take a look at our Menu");
                        menu.displayMenu();
                        startOrdering(true,false, customerIndex);
                    }
                    validInput= true;
                    break;
                default:
                    System.out.println("Invalid Input, Try Again");
            }
        } validInput = false;

    }
    public static void startOrdering( boolean isFirstIteration,boolean isAdding,int customerIndex){
        // Start Ordering Sequence
        do {
            if (isFirstIteration) {
                orderInput = new Order();
                System.out.println("What would you like to Order   -->                  Enter 99 to Display Menu Again");
                while(!validInput) {
                    input1 = sc.nextInt();
                    if( (input1>=0 && input1<= menu.getMenuItems().getLast().getId()) || input1==99){
                        validInput = true;
                    }else{
                        System.out.println("Invalid Input, No item with entered ID");
                    }

                } validInput = false;
                isFirstIteration = false;
            }else if (isAdding){
                System.out.printf("What would you like to Order   -->  ");
                while(!validInput) {
                    input1 = sc.nextInt();
                    if( (input1>=0 && input1<= menu.getMenuItems().getLast().getId()) || input1==99){
                        validInput = true;
                    }else{
                        System.out.println("Invalid Input, No item with entered ID");
                    }

                } validInput = false;
                isAdding =false;
            }else {
                while(!validInput) {
                    input1 = sc.nextInt();
                    if( (input1>=0 && input1<= menu.getMenuItems().getLast().getId()) || input1==99){
                        validInput = true;
                    }else{
                        System.out.println("Invalid Input, No item with entered ID");
                    }

                } validInput = false;
            }
            if(input1==99){
                menu.displayMenu();
                System.out.printf("What would you like to Order   -->");
                continue;
            } else if (input1==0) {
                continue;
            }
            System.out.println(menu.findItem(input1).getName()+"  -  "+menu.findItem(input1).getIngredients());
            System.out.printf("      How many of that dish would you like?    ");
            //input2 = sc.nextInt();
            while(!validInput) {
                input2 = sc.nextInt();
                if( input2>0){
                    validInput = true;
                }else{
                    System.out.println("Invalid Input, Try Again");
                }

            }validInput = false;
            System.out.println("      Do you have any preferences in the order?  Press Enter to skip");
            sc.nextLine();
            input3 = sc.nextLine();
            if(input3.isEmpty()){
                orderInput.addItem(menu.findItem(input1), input2);
            }else {
                orderInput.addItem(menu.findItem(input1), input2, input3);
            }
            System.out.println("Anything Else?   Enter - 0 - if done");


        }while (input1 != 0);

        orderInput.displayOrder();
        System.out.println("Please Press    1: Checkout     2: Adjust Order ");
        while(!validInput) {
            input1 = sc.nextInt();
            switch (input1){
                case 1:
                    checkout(orderInput,customerIndex);
                    validInput=true;
                    break;
                case 2:
                    adjustOrder(orderInput,customerIndex);
                    validInput= true;
                    break;
                default:
                    System.out.println("Invalid Input, Try Again");
            }
        } validInput = false;

    }
    public static void previousOrder(int customerIndex){
        if (allCustomers.get(customerIndex).getPastOrders().isEmpty()){
            System.out.println("You don't have any previous orders, redirected to Menu");
            menu.displayMenu();
            startOrdering(true,false, customerIndex);
        }else {
            allCustomers.get(customerIndex).displayOrders();
            System.out.println("Which Order Id would you like to Reorder?");
            //input1 = sc.nextInt();
            while (!validInput) {
                input2 = sc.nextInt();
                if (input2 > 0 && input2 <= allCustomers.get(customerIndex).getPastOrders().size()) {
                    validInput = true;
                } else {
                    System.out.println("Invalid Order ID");
                }
            }
            validInput = false;
            checkout(allCustomers.get(customerIndex).reorder(input2), customerIndex);
        }
    }
    public static void checkout(Order order,int customerIndex){
        System.out.println("Total Price After Tax is : $"+ order.getBill()+"\n Do you have any coupons? Y/N");
        sc.nextLine();
        while(!validInput) {
            input3 = sc.nextLine();
            if( input3.equalsIgnoreCase("y")){
                System.out.print("Enter Coupon Code : ");
                input3 = sc.nextLine();
                if (input3.equals("50%Off")){
                    System.out.println(" 50% Discount Registered!");
                    order.applyDiscount(50);
                    order.checkoutOrder();
                }else{
                    System.out.println("Invalid Coupon");
                    order.checkoutOrder();
                }
                validInput = true;
            } else if (input3.equalsIgnoreCase("n")) {
                validInput = true;
            }else{
                System.out.println("Invalid Input, Try again -> Y/N");
            }

        } validInput = false;

        System.out.println("Choose Order type:\n       1: Delivery    2: Dine In    3: Takeout");

        while(!validInput) {
            input1 = sc.nextInt();
            switch (input1){
                case 1:
                    order.setOrderType("Delivery");
                    if(allCustomers.get(customerIndex).getAddress().isEmpty()){
                        System.out.println("Please Enter Address for Delivery");
                        sc.nextLine();
                        input3 = sc.nextLine();
                        allCustomers.get(customerIndex).setAddress(input3);
                        System.out.println("Order will be Delivered to :"+ allCustomers.get(customerIndex).getAddress());
                    }else{
                        System.out.println(" Saved address : "+ allCustomers.get(customerIndex).getAddress());
                        System.out.println("Use this Address? Y/N");
                        while(!validInput) {
                            input3 = sc.nextLine();
                            if( input3.equalsIgnoreCase("y")){
                                System.out.println("Order will be Delivered to :"+ allCustomers.get(customerIndex).getAddress());
                                validInput = true;
                            } else if (input3.equalsIgnoreCase("n")) {
                                System.out.println("Please Enter Address for Delivery");
                                input3 = sc.nextLine();
                                allCustomers.get(customerIndex).setAddress(input3);
                                System.out.println("Order will be Delivered to :"+ allCustomers.get(customerIndex).getAddress());
                                validInput = true;
                            }else{
                                System.out.println("Invalid Input, Try again -> Y/N");
                            }
                        } validInput = false;

                    }
                    validInput=true;
                    break;
                case 2:
                    order.setOrderType("Dine In");
                    System.out.println(" Please be seated! ");
                    validInput= true;
                    break;
                case 3:
                    order.setOrderType("Takeout");
                    System.out.println(" Sure thing!  We will prepare your order immediately ");
                    validInput= true;
                    break;
                default:
                    System.out.println("Invalid Input, Try Again");
            }
        } validInput = false;

        System.out.println("What is your payment Method? \n       1: Cash    2: Visa");
        while(!validInput) {
            input1 = sc.nextInt();
            switch (input1){
                case 1:
                    order.payment("Cash");
                    validInput=true;
                    break;
                case 2:
                    order.payment("VISA");
                    validInput= true;
                    break;
                default:
                    System.out.println("Invalid Input, Try Again");
            }
        } validInput = false;
        totalOrders.add(order);
        allCustomers.get(customerIndex).addOrder(order);
    }
    public static void adjustOrder(Order order, int customerIndex){
        System.out.println("Do you want to add or remove items?");
        System.out.println("   1: Add     2: Remove");
        //input1 = sc.nextInt();
        while(!validInput) {
            input1 = sc.nextInt();
            switch (input1){
                case 1:
                    startOrdering(false,true,customerIndex);
                    validInput=true;
                    break;
                case 2:
                    removeItems(order,customerIndex);
                    validInput= true;
                    break;
                default:
                    System.out.println("Invalid Input, Try Again");
            }
        } validInput = false;
    }
    public static void removeItems(Order order, int customerIndex){
        System.out.printf("What should we remove? ( Enter Id & Quantity )    -->  ");
        input1 = sc.nextInt();

        do {
            input2 = sc.nextInt();
            order.removeItem(menu.findItem(input1), input2);
            order.displayOrder();
            System.out.println("Anything Else?  Enter - 0 - if done");
            input1 = sc.nextInt();
        }while (input1 != 0);
        order.displayOrder();
        checkout(order,customerIndex);
    }


    public static void main(String[] args) {
        MenuInit();
        OrderInit();
        CustomerInit();
        sc = new Scanner(System.in);

        do {
            helloCustomer();
            System.out.println("New Customer? Y/N");
            sc.nextLine();
            while(!validInput) {
                input3 = sc.nextLine();
                if( input3.equalsIgnoreCase("y")){
                    validInput = true;
                } else if (input3.equalsIgnoreCase("n")) {
                    validInput = true;
                }else{
                    System.out.println("Invalid Input, Try again -> Y/N");
                }

            } validInput = false;
        }while(input3.equalsIgnoreCase("Y"));
    }

}

