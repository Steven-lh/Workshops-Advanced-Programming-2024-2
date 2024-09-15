package eshop;
/**
 * The Accessories class represents a type of product specifically for accessories.
 * It extends the Products class and inherits its properties and methods.
 */
public class Accessories extends Products {
    /**
     * Constructs a new Accessories object with the specified name, price, and brand.
     *
     * @param product_name  the name of the accessories
     * @param product_price the price of the accessories
     * @param product_brand the brand of the accessories
     */
    public Accessories(String product_name, double product_price, String product_brand) {
        super(product_name, product_price, product_brand);
    }
    /**
     * Displays the details of the accessories.
     * This method overrides the displayProduct method in the Products class.
     */
    @Override
    public void displayProduct() {
        System.out.println("Product Name: " + getProduct_name() + " Price: " + getProduct_price() + " Brand: " + getProduct_brand());
    }
}
