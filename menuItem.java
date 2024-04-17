public class menuItem {
    private int Id;
    private String name;
    private double price;
    private String category;
    private String ingredients = "";

    public menuItem(int id,String name, double price, String category){
        setId(id);
        setName(name);
        setPrice(price);
        setCategory(category);
    }
    public menuItem(int id,String name, double price, String category, String ingredients){
        setId(id);
        setName(name);
        setPrice(price);
        setCategory(category);
        setIngredients(ingredients);
    }

    // Get Functions
    public int getId() {
        return Id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public String getIngredients() {
        return ingredients;
    }

    //Set Functions
    public void setId(int id) {
        Id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void printItem(){
        System.out.printf(" "+getId()+" -> "+getName()+ " - $"+getPrice()+"\n");
    }
}
