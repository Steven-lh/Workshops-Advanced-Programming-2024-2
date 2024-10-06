package eshop;

import java.util.Scanner;
/*
 * This class is the main class of the program, it contains the main method and the logic of the program.
 * The program is a simple electronic shop that allows the user to add items to a shopping cart, view the cart, remove items from the cart, and proceed with the purchase.
 * The program also allows the user to set and display their payment information.
 * 
 * @author Steven Londoño
 */

public class Store {
    /*
     * The main method of the program, it contains the logic of the program.
     */
    public static void main(String[] args) {

        // Initialize Scanner for user input
        Scanner sc = new Scanner(System.in);
        // Create a Shoppingcart instance
        ShoppingCart cart = new ShoppingCart();
        // Create a Client instance
        Client client = new Client();
        // Create a Manager instance
        Manager manager = new Manager();


        // Welcome message
        System.out.println("""
            Welcome to the Electronic Shop!
            We have a variety of electronic items available for you to purchase.
            """);

        
        while (true) {
            System.out.print("""
                \nWhat kind of user are you?:
                1. Client
                2. Manager
                3. Exit
                """);

            System.out.print("Enter the number of the option: ");
            int user_option = sc.nextInt();

            if (user_option == 1) {
                client.userType();
                while (true) {
                    // Display main menu options
                    // as a costumer i want to back to the main menu when i need it
                    System.out.println("""
                        \nPlease select one of the following options:
                        1. Categories
                        2. Shopping cart
                        3. Checkout
                        4. Payment information
                        5. Exit
                        """);

                    System.out.print("Enter the number of the option: ");
                    int welcome_option = sc.nextInt();

                    if (welcome_option == 1) {
                        // Display category options
                        // as a costumer i want to see the products in the different categories
                        System.out.println("""
                            \nPlease select one of the following categories:
                            1. Smartphones
                            2. TVs
                            3. Laptops
                            4. Accessories
                            5. Gaming Consoles
                            6. Return to Main Menu
                            """);
                    
                        System.out.print("Enter the category number: ");
                        int categoryProduct = sc.nextInt();

                        String category = ""; 
                        switch (categoryProduct) {
                            case 1:
                                category = "Smartphone";
                                break;
                            case 2:
                                category = "Television";
                                break;
                            case 3:
                                category = "Laptop";
                                break;
                            case 4:
                                category = "Accessory";
                                break;
                            case 5:
                                category = "Game Console";
                                break;
                            case 6:
                                System.out.println("\nReturning to the main menu.");
                                continue;
                            default:
                                System.out.println("\nInvalid option, please enter a valid number.");
                                continue; 
                        }

                        Products selectedProduct = manager.viewAndSelectCategory(category);
                        if (selectedProduct != null) {
                            cart.addToCart(selectedProduct, manager, category);
                        }

                    } else if (welcome_option == 2) {
                        // Display shopping cart options
                        System.out.println("""
                            \n1. View cart
                            2. Remove Item
                            3. Return to Main Menu
                            """);
                        System.out.print("Enter the number of the option: ");
                        int cart_option = sc.nextInt();
                    
                        while (true) {
                            if (cart_option == 1) {
                                // View the cart and calculate the total price
                                cart.viewCart();
                                cart.calculateTotalPrice();
                                break;
                            } else if (cart_option == 2) {
                                // Remove an item from the cart
                                cart.viewCart();
                                cart.calculateTotalPrice();
                                System.out.println("If you want to remove all items from the cart, please enter '-1'.");
                                System.out.print("\nWhat item would you like to remove from the cart? (insert '0' to return to the main menu): ");
                                int remove_option = sc.nextInt();
                                if (remove_option == 0) {
                                    System.out.println("\nReturning to the main menu.");
                                    break;
                                } else if (remove_option == -1) {
                                    cart.clearCart();
                                    System.out.println("\nAll items removed from the cart.");
                                    break;
                                }
                                cart.removeDevice(remove_option);
                            } else if (cart_option == 3) {
                                // Return to the main menu
                                System.out.println("\nReturning to the main menu.");
                                break;
                            } else if (cart_option <= 0 || cart_option > 2) {
                                System.out.println("\nInvalid option.");
                                break;
                            }
                        }
                    } else if (welcome_option == 3) {
                        // Proceed to checkout
                        cart.viewCart();
                        cart.calculateTotalPrice();
                        if (cart.cartEmpty()) {
                            System.out.println("\nYour cart is empty, returning to the main menu.");
                            continue;
                        }
                        System.out.print("""
                            \nDo you want to proceed with the purchase?
                            1. Yes
                            2. No
                            3. Return to Main Menu
                            """);
                        
                        try{
                            while (true) {
                                int purchase_option = sc.nextInt();
                                if (purchase_option == 1) {
                                    if (client.getName() == null) {
                                        // Provide user information if not already provided
                                        client.provideCInfo();
                                        continue;
                                    } else {
                                        // Display user information
                                        client.displayCInfo();
                                        client.alreadyProvided();
                                    }
                                    System.out.print("""
                                        \nIs the information correct?
                                        1. Yes
                                        2. No
                                        """);
                                    int info_correct = sc.nextInt();
                                    if (info_correct == 1) {
                                        // Proceed with the purchase
                                        System.out.println("Proceeding with the purchase...");
                                        System.out.println("The items will be shipped to the next address: " + client.getAddress() + ", " + client.getCity());
                                        System.out.println("Thank you for your purchase!");
                                        cart.clearCart();
                                        break;
                                    } else if (info_correct == 2) {
                                        // Verify and update user information
                                        client.changeUserInfo();
                                        client.displayCInfo();
                                    } else {
                                        System.out.println("Invalid option.");
                                        break;
                                    }
                                    break;
                                // as a costumer i want to cancel the purchase
                                } else if (purchase_option == 2) {
                                    // Cancel the order and return to the main menu
                                    System.out.println("\nYour order has been cancelled, returning to the main menu.");
                                    break;
                                } else if (purchase_option == 3) {
                                    System.out.println("Returning to the main menu.");
                                    break;
                                } else if (purchase_option <= 0 || purchase_option > 3) {
                                    System.out.println("Invalid option.");
                                    break;
                                }
                            }
                        } catch (Exception e) {
                        System.out.println("Invalid input, please enter a valid number.");
                        sc.next();
                        }
                    } else if (welcome_option == 4) {
                        // Display options for setting or displaying payment information
                        System.out.println("""
                                \n1. Set information
                                2. Display information
                                """);
                        while (true) {
                            System.out.print("Enter the number of the option: ");
                            int info_option = sc.nextInt();
                            if (info_option == 1) {
                                if (client.getName() != null) {
                                    // If information is already provided, notify the user
                                    client.alreadyProvided();
                                    break;
                                } else {
                                    // Prompt the user to provide their information
                                    client.provideCInfo();
                                    System.out.print("\nIs the information correct? (yes/no): ");
                                    String info_correct = sc.next();
                                    if (info_correct.equalsIgnoreCase("yes")) {
                                        System.out.println("Saving information...");
                                        break;
                                    } else if (info_correct.equalsIgnoreCase("no")) {
                                        // Verify and update user information
                                        client.changeUserInfo();
                                        client.displayCInfo();
                                        break;
                                    } else {
                                        System.out.println("Invalid option.");
                                    }
                                }
                            } else if (info_option == 2) {
                                // Display the provided information
                                client.displayCInfo();
                                break;
                            } else {
                                System.out.println("Invalid option.");
                            }
                        }
                    } else if (welcome_option == 5) {
                        // Exit the program
                        System.out.println("Thank you for visiting, good bye!");
                        break;
                    } else {
                        System.out.println("Invalid option.");
                    }
                }
            } else if (user_option == 2) {
                manager.userType();
                // Display manager options
                while (true) {
                    System.out.println("""
                        \nPlease select one of the following options:
                        1. View products
                        2. Add new product
                        3. Return to Main Menu
                        """);

                
                    System.out.print("Enter the number of the option: ");
                    int manager_option = sc.nextInt();
                
                    if (manager_option == 1) {
                        manager.viewAllProducts();

                    } else if (manager_option == 2) {
                        System.out.println("""
                            \nPlease select the category of the product:
                            1. Smartphone
                            2. TV
                            3. Laptop
                            4. Accessory
                            5. Game Console
                            6. Return
                            """);

                        System.out.print("Enter the category number: ");
                        int productCategory = sc.nextInt();
                        switch (productCategory) {
                            case 1:
                                manager.createProduct("smartphone");
                                break;
                            case 2:
                                manager.createProduct("television");
                                break;
                            case 3:
                                manager.createProduct("laptop");
                                break;
                            case 4:
                                manager.createProduct("accessory");
                                break;
                            case 5:
                                manager.createProduct("game console");
                                break;
                            case 6:
                                System.out.println("\nReturning to the main menu.");
                                break;
                            default:
                                System.out.println("\nInvalid option, please a valid number.");
                                break;
                        }
                        
                    } else if (manager_option == 3) {
                        System.out.println("\nReturning to the main menu.");
                        break;
                    } else {
                        System.out.println("\nInvalid option, please a valid number.");
                    }
                }
                
            } else if (user_option == 3) {
                // Exit the program
                System.out.println("Thank you for visiting, good bye!");
                
            } else {
                System.out.println("Invalid option, please try again.");
            }
        }
    }
}