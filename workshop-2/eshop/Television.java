package eshop;
/**
 * The Television class represents a type of product specifically for television's.
 * It extends the Products class and inherits its properties and methods.
 */
public class Television extends Products{

    /**
     * Constructs a new Television object with the specified name, price, and brand.
     *
     * @param product_name  the name of the television
     * @param product_price the price of the television
     * @param product_brand the brand of the television
     */
    public Television() {
    }
    
    public Television(String product_name, double product_price, String product_brand) {
        super(product_name, product_price, product_brand);
    }
/**
     * Displays the details of the television.
     * This method overrides the displayProduct method in the Products class.
     */
    @Override
    public void displayProduct() {
    System.out.println(" Product Name: " + getProduct_name() + " Price: " + getProduct_price() + " Brand: " + getProduct_brand());
    }
    
}
