package Lesson8.Assignment1.Question14;

import java.util.ArrayList;
import java.util.List;

class OnlineShoppingCart implements ShoppingCart {

    private List<Item> items;

    public OnlineShoppingCart() {
        this.items = new ArrayList<>();
    }

    @Override
    public void addItem(Item item) {

        items.add(item);
        System.out.println(item.getName() + " added to the online shopping cart.");
    }

    @Override
    public void removeItem(Item item) {

        items.remove(item);
        System.out.println(item.getName() + " removed from the online shopping cart.");
    }

    @Override
    public double calculateTotal() {

        double total = items.stream().mapToDouble(Item::getPrice).sum();
        System.out.println("Online shopping cart total: $" + total);
        return total;
    }
}