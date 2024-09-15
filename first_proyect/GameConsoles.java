package eshop;

/**
 * The GameConsoles class represents a type of product specifically for game consoles.
 * It extends the Products class and inherits its properties and methods.
 */
public class GameConsoles extends Products {

    /**
     * Constructs a new GameConsoles object with the specified name, price, and brand.
     *
     * @param product_name  the name of the game console
     * @param product_price the price of the game console
     * @param product_brand the brand of the game console
     */
    public GameConsoles(String product_name, double product_price, String product_brand) {
        super(product_name, product_price, product_brand);
    }

    /**
     * Displays the details of the game console.
     * This method overrides the displayProduct method in the Products class.
     */
    @Override
    public void displayProduct() {
        System.out.println("Product Name: " + getProduct_name() + " Price: " + getProduct_price() + " Brand: " + getProduct_brand());
    }
}