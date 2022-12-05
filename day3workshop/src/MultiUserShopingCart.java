
/**
 * App
 */

public class MultiUserShopingCart {

    public static void main(String[] args) {
        
        ShoppingCartDB cart = new ShoppingCartDB("cartdb"); // default folder: "db"
        // cart.setup();
        cart.startShell();
        
    }
    
}