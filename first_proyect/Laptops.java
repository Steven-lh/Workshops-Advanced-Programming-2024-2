package eshop;
/**
 * The Laptops class represents a type of product specifically for laptops.
 * It extends the Products class and inherits its properties and methods.
 */
public class Laptops extends Products {
    
    /**
     * Constructs a new Laptops object with the specified name, price, and brand.
     *
     * @param product_name  the name of the laptop
     * @param product_price the price of the laptop
     * @param product_brand the brand of the laptop
     */
    public Laptops(String product_name, double product_price, String product_brand) {
        super(product_name, product_price, product_brand);
    }
    /**
     * Displays the details of the laptop.
     * This method overrides the displayProduct method in the Products class.
     */
    @Override
    public void displayProduct() {
        System.out.println("Product Name: " + getProduct_name() + " Price: " + getProduct_price() + " Brand: " + getProduct_brand());
    }
}
