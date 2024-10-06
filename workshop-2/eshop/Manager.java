package eshop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Manager extends User {

    private List<Products> products;
    private Map<String, List<Products>> categoryMap;
    Scanner sc = new Scanner(System.in);

    public Manager() {
        products = new ArrayList<>();
        categoryMap = new HashMap<>(); 
        categoryMap.put("Smartphone", new ArrayList<>());
        categoryMap.put("Television", new ArrayList<>());
        categoryMap.put("Laptop", new ArrayList<>());
        categoryMap.put("Game Console", new ArrayList<>());
        categoryMap.put("Accessory", new ArrayList<>());
    }

    public Manager(String password, String email) {
        super(password, email);
        products = new ArrayList<>();
        categoryMap = new HashMap<>();
        categoryMap.put("Smartphone", new ArrayList<>());
        categoryMap.put("Television", new ArrayList<>());
        categoryMap.put("Laptop", new ArrayList<>());
        categoryMap.put("Game Console", new ArrayList<>());
        categoryMap.put("Accessory", new ArrayList<>());
    }

    public void viewAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("All available products:");
            for (Products product : products) {
                System.out.println(product);
            }
        }
    }


    public void createProduct(String productType) {
        System.out.print("\nEnter the brand of the " + productType + ": ");
        String product_brand = sc.nextLine();

        System.out.print("Enter the name of the " + productType + ": ");
        String product_name = sc.nextLine();

        System.out.print("Enter the price of the " + productType + ": ");
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid " + productType + " price.");
            sc.next();
        }
        double product_price = sc.nextDouble();
        sc.nextLine();

        Products product;

        switch (productType.toLowerCase()) {
            case "smartphone":
                product = new Smartphone(product_name, product_price, product_brand);
                break;
            case "television":
                product = new Television(product_name, product_price, product_brand);
                break;
            case "laptop":
                product = new Laptops(product_name, product_price, product_brand);
                break;
            case "game console":
                product = new GameConsoles(product_name, product_price, product_brand);
                break;
            case "accessory":
                product = new Accessories(product_name, product_price, product_brand);
                break;
            default:
                System.out.println("Invalid product type.");
                return;
        }

        products.add(product);

        
        List<Products> categoryList = categoryMap.get(productType.substring(0, 1).toUpperCase() + productType.substring(1).toLowerCase());
        if (categoryList != null) {
            categoryList.add(product);
        } else {
            System.out.println("Category not found for " + productType);
        }

        System.out.println(productType + " has been added to the product list.");
    }


    public Products viewAndSelectCategory(String category) {
        List<Products> categoryList = categoryMap.get(category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase());
        if (categoryList == null || categoryList.isEmpty()) {
            System.out.println("No products available in this category.");
            return null;
        } else {
            System.out.println("Products in category: " + category);
            for (int i = 0; i < categoryList.size(); i++) {
                System.out.println((i + 1) + ". " + categoryList.get(i));
            }

            
            System.out.print("\nEnter the number of the product you wish to add to your cart: ");
            int productChoice = sc.nextInt();
            sc.nextLine();

            if (productChoice > 0 && productChoice <= categoryList.size()) {
                return categoryList.get(productChoice - 1);
            } else {
                System.out.println("Invalid choice.");
                return null;
            }
        }
    }

    public void removeProduct(Products product, String category) {
        List<Products> productsInCategory = categoryMap.get(category);
        if (productsInCategory != null && productsInCategory.contains(product)) {
            products.remove(product);
            System.out.println(product.getProduct_name() + " has been removed from the " + category + " category.");
        } else {
            System.out.println("Product not found in the specified category.");
        }
    }

    @Override
    public void userType() {
        System.out.println("\nUser type: Manager");
    }
}
