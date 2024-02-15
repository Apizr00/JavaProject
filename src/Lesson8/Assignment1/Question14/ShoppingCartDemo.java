package Lesson8.Assignment1.Question14;

public class ShoppingCartDemo {
    public static void main(String[] args) {

        Item item1 = new Item("Laptop", 1200.0);
        Item item2 = new Item("Headphones", 50.0);

        ShoppingCart onlineCart = new OnlineShoppingCart();
        onlineCart.addItem(item1);
        onlineCart.addItem(item2);
        onlineCart.calculateTotal();

        ShoppingCart inStoreCart = new InStoreShoppingCart();
        inStoreCart.addItem(item1);
        inStoreCart.removeItem(item2);
        inStoreCart.calculateTotal();
    }
}
