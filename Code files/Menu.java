import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<menuItem> menuItems;
    private List<String> categories;

    public Menu() {
        this.menuItems = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public void addMenuItem(menuItem mItem) {
        menuItems.add(mItem);
        if(checkNewCategory(mItem.getCategory())){
            categories.add(mItem.getCategory());
        }

    }

    public List<menuItem> getMenuItems() {
        return menuItems;
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println("\n"+categories.get(i) + ":");

            for (menuItem mItem : menuItems) {
                if (mItem.getCategory().equals(categories.get(i))) {
                    mItem.printItem();
                }
            }
        }
        System.out.println(" ");
    }
    public menuItem findItem(int id) {
        for (int i = 0; i < getMenuItems().size(); i++) {
            if (getMenuItems().get(i).getId() == id) {
                return getMenuItems().get(i);
            }
        }
        return null;
    }
    public boolean searchItem( String name){
        boolean found = false;
        for (menuItem mItem:menuItems ) {
            if (mItem.getName().toLowerCase().contains(name)) {
                System.out.println("Item is in the menu: ");
                mItem.printItem();
                System.out.println("        Please use Item Id to Order!");
                found = true ;
            }
        }
        return found;
    }
    public boolean checkNewCategory(String category){
        for (String cat:categories){
            if(cat.equals(category)){
                return false;
            }
        }
        return true;
    }
}
