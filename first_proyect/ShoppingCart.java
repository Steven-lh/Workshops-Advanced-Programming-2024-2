package eshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The ShoppingCart class represents a shopping cart that can hold products.
 */
public class ShoppingCart {

    private Scanner sc = new Scanner(System.in);
    private List<Products> devices;

    /**
     * Constructs an empty ShoppingCart.
     */
    public ShoppingCart() {
        devices = new ArrayList<>();
    }

    /**
     * Adds a product to the shopping cart.
     *
     * @param device the product to be added
     */

//as a costumer i want to add an item to my cart
    public void addDevice(Products device) {
        devices.add(device);
    }

    /**
     * Removes a product from the shopping cart based on its index.
     *
     * @param device the index of the product to be removed (1-based index)
     */

//as a costumer i want to remove an item from my cart without having to remove all the items
    public void removeDevice(int device) {
        while (true) {
            if (devices.isEmpty()) {
                System.out.println("The cart is empty, nothing to remove");
                break;
            } else if (device > 0 && device <= devices.size()) {
                devices.remove(device - 1);
                System.out.println("Item removed from the cart.");
                if (devices.isEmpty()) {
                    System.out.println("The cart is now empty.");
                    break;
                }
            } else {
                System.out.println("Invalid index. Please enter a valid item number.");
                break;
            }
        }
    }

    /**
     * Displays the items currently in the shopping cart.
     */

//as a costumer i want to see the items in my cart and the total price
    public void displayCart() {
        int i = 1;
        if (devices.isEmpty()) {
            System.out.println("The cart is empty");
        } else {
            System.out.println("Items in the cart: ");
            for (Products device : devices) {
                System.out.println(i + ". " + device.toString());
                i++;
            }
        }
    }

    /**
     * Calculates and displays the total price of the items in the shopping cart.
     */

//as a costumer i want to see the total price of the items in my cart
    public void calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Products device : devices) {
            totalPrice += device.getProduct_price();
        }
        System.out.println("Total price of items in the cart: $" + totalPrice);
    }

    /**
     * Displays a message indicating that an item has been added to the cart.
     */
    public void addMessage() {
        System.out.println("Item added to the cart");
    }

    /**
     * Clears all items from the shopping cart.
     */
    public void clearCart() {
        devices.clear();
    }

    /**
     * Checks if the shopping cart is empty.
     *
     * @return true if the cart is empty, false otherwise
     */
    public boolean cartEmpty() {
        return devices.isEmpty();
    }
}