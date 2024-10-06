package eshop;

/**
 * The Products class represents a generic product with a name, price, and brand.
 * This class is abstract and should be extended by specific product types.
 */
public abstract class Products {

    protected String product_name;
    protected double product_price;
    protected String product_brand;

    /**
     * Default constructor for Products.
     */
    public Products() {
    }

    /**
     * Constructs a new Products object with the specified name, price, and brand.
     *
     * @param product_name  the name of the product
     * @param product_price the price of the product
     * @param product_brand the brand of the product
     */
    public Products(String product_name, double product_price, String product_brand) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_brand = product_brand;
    }

    /**
     * Gets the name of the product.
     *
     * @return the name of the product
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * Sets the name of the product.
     *
     * @param product_name the new name of the product
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * Gets the price of the product.
     *
     * @return the price of the product
     */
    public double getProduct_price() {
        return product_price;
    }

    /**
     * Sets the price of the product.
     *
     * @param product_price the new price of the product
     */
    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    /**
     * Gets the brand of the product.
     *
     * @return the brand of the product
     */
    public String getProduct_brand() {
        return product_brand;
    }

    /**
     * Sets the brand of the product.
     *
     * @param product_brand the new brand of the product
     */
    public void setProduct_brand(String product_brand) {
        this.product_brand = product_brand;
    }

    /**
     * Displays the details of the product.
     * This method must be implemented by subclasses.
     */
    public abstract void displayProduct();

    /**
     * Returns a string representation of the product.
     *
     * @return a string representation of the product in the format "name (brand) - $price"
     */
    
    @Override
    public String toString() {
        return product_name + " (" + product_brand + ") - $" + product_price;
    }
}
