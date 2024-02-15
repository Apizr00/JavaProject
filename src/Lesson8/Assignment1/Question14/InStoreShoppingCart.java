package Lesson8.Assignment1.Question14;

import java.util.ArrayList;
import java.util.List;

class InStoreShoppingCart implements ShoppingCart {

    private List<Item> items;

    public InStoreShoppingCart() {

        this.items = new ArrayList<>();
    }

    @Override
    public void addItem(Item item) {

        items.add(item);
        System.out.println(item.getName() + " added to the in-store shopping cart.");
    }

    @Override
    public void removeItem(Item item) {

        items.remove(item);
        System.out.println(item.getName() + " removed from the in-store shopping cart.");
    }

    @Override
    public double calculateTotal() {

        double total = items.stream().mapToDouble(Item::getPrice).sum();
        System.out.println("In-store shopping cart total: $" + total);
        return total;
    }
}