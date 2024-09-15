package eshop;

/*
 * This class is the main class of the program, it contains the main method and the logic of the program.
 * The program is a simple electronic shop that allows the user to add items to a shopping cart, view the cart, remove items from the cart, and proceed with the purchase.
 * The program also allows the user to set and display their payment information.
 * 
 * @author Steven Londoño
 */
import java.util.Scanner;

public class Store {
    /*
     * The main method of the program, it contains the logic of the program.
     */
    public static void main(String[] args) {
        
        // Create instances of Smartphone products
        Smartphone smartphone1 = new Smartphone("Galaxy S24", 999.99, "Samsung");
        Smartphone smartphone2 = new Smartphone("iPhone 15", 1099.99, "Apple");
        Smartphone smartphone3 = new Smartphone("Pixel 7", 899.99, "Google");
        Smartphone smartphone4 = new Smartphone("OnePlus 10", 899.99, "OnePlus");

        // Create instances of Television products
        Television tv1 = new Television("QLED 4K", 1299.99, "Samsung");
        Television tv2 = new Television("OLED 4K", 1399.99, "LG");
        Television tv3 = new Television("LED 4K", 999.99, "Sony");
        Television tv4 = new Television("QLED 4K", 1199.99, "TCL");

        // Create instances of Laptop products
        Laptops laptop1 = new Laptops("MacBook Pro", 1999.99, "Apple");
        Laptops laptop2 = new Laptops("Surface Laptop", 1299.99, "Microsoft");
        Laptops laptop3 = new Laptops("ZenBook", 999.99, "Asus");
        Laptops laptop4 = new Laptops("ThinkPad", 899.99, "Lenovo");

        // Create instances of Game Console products
        GameConsoles console1 = new GameConsoles("PlayStation 5", 499.99, "Sony");
        GameConsoles console2 = new GameConsoles("Xbox Series X", 499.99, "Microsoft");
        GameConsoles console3 = new GameConsoles("Switch", 299.99, "Nintendo");
        GameConsoles console4 = new GameConsoles("Steam Deck", 399.99, "Valve");

        // Create instances of Accessories products
        Accessories accessory1 = new Accessories("AirPods", 199.99, "Apple");
        Accessories accessory2 = new Accessories("Galaxy Buds", 149.99, "Samsung");
        Accessories accessory3 = new Accessories("Magic Mouse", 79.99, "Apple");
        Accessories accessory4 = new Accessories("Smart Band", 99.99, "Xiaomi"); 

        // Initialize Scanner for user input
        Scanner sc = new Scanner(System.in);
        // Create a ShoppingCart instance
        ShoppingCart Cart = new ShoppingCart();
        // Create a Checkout instance
        Checkout checkout = new Checkout();

        // Welcome message
        System.out.println("""
            Welcome to the Electronic Shop!
            We have a variety of electronic items available for you to purchase.
            """);

        try {
            while (true) {
                // Display main menu options
                // as a costumer i want to back to the main menu when i need it
                System.out.println("""
                    \nPlease select one of the following options:
                    1. Categories
                    2. Shopping Cart
                    3. Checkout
                    4. Payment information
                    5. Exit
                    """);

                System.out.print("Enter the number of the option: ");
                int welcome_opcion = sc.nextInt();

                if (welcome_opcion == 1) {
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
                
                    System.out.print("Enter the number of the category: ");
                    int category_opcion = sc.nextInt();
                
                    if (category_opcion == 1) {
                        // Display smartphone products
                        System.out.print("\n1. "); smartphone1.displayProduct();
                        System.out.print("2. "); smartphone2.displayProduct();
                        System.out.print("3. "); smartphone3.displayProduct();
                        System.out.print("4. "); smartphone4.displayProduct();
                        System.out.print("\nWould you like to add any of these items to your cart? (yes/no): ");
                        String yes_no = sc.next();
                
                        OUTER:
                        while (true) {
                            if (yes_no.equalsIgnoreCase("yes")) {
                                System.out.print("\nWhat product would you like to add to your cart? (insert '0' to return to the main menu): ");
                                int smartphone_opcion = sc.nextInt();
                                switch (smartphone_opcion) {
                                    case 1:
                                        Cart.addDevice(smartphone1);
                                        Cart.addMessage();
                                        break;
                                    case 2:
                                        Cart.addDevice(smartphone2);
                                        Cart.addMessage();
                                        break;
                                    case 3:
                                        Cart.addDevice(smartphone3);
                                        Cart.addMessage();
                                        break;
                                    case 4:
                                        Cart.addDevice(smartphone4);
                                        Cart.addMessage();
                                        break;
                                    case 0:
                                        System.out.println("\nReturning to the main menu.");
                                        break OUTER;
                                    default:
                                        System.out.println("\nInvalid option, try again.");
                                        break;
                                }
                            } else if (yes_no.equalsIgnoreCase("no")) {
                                System.out.println("\nReturning to the main menu.");
                                break;
                            } else {
                                System.out.println("\nInvalid option.");
                                break;
                            }
                        }
                    } else if (category_opcion == 2) {
                        // Display TV products
                        System.out.print("\n1. "); tv1.displayProduct();
                        System.out.print("2. "); tv2.displayProduct();
                        System.out.print("3. "); tv3.displayProduct();
                        System.out.print("4. "); tv4.displayProduct();
                        System.out.print("\nWould you like to add any of these items to your cart? (yes/no): ");
                        String yes_no = sc.next();
                
                        OUTER_2:
                        while (true) {
                            if (yes_no.equalsIgnoreCase("yes")) {
                                System.out.print("\nWhat product would you like to add to your cart? (insert '0' to return to the main menu): ");
                                int tv_opcion = sc.nextInt();
                                switch (tv_opcion) {
                                    case 1:
                                        Cart.addDevice(tv1);
                                        Cart.addMessage();
                                        break;
                                    case 2:
                                        Cart.addDevice(tv2);
                                        Cart.addMessage();
                                        break;
                                    case 3:
                                        Cart.addDevice(tv3);
                                        Cart.addMessage();
                                        break;
                                    case 4:
                                        Cart.addDevice(tv4);
                                        Cart.addMessage();
                                        break;
                                    case 0:
                                        System.out.println("\nReturning to the main menu.");
                                        break OUTER_2;
                                    default:
                                        System.out.println("\nInvalid option, try again.");
                                        break;
                                }
                            } else if (yes_no.equalsIgnoreCase("no")) {
                                System.out.println("\nReturning to the main menu.");
                                break;
                            } else {
                                System.out.println("\nInvalid option.");
                                break;
                            }
                        }
                    } else if (category_opcion == 3) {
                        // Display laptop products
                        System.out.print("\n1. "); laptop1.displayProduct();
                        System.out.print("2. "); laptop2.displayProduct();
                        System.out.print("3. "); laptop3.displayProduct();
                        System.out.print("4. "); laptop4.displayProduct();
                        System.out.print("\nWould you like to add any of these items to your cart? (yes/no): ");
                        String yes_no = sc.next();
                    
                        OUTER_3:
                        while (true) {
                            if (yes_no.equalsIgnoreCase("yes")) {
                                System.out.print("\nWhat product would you like to add to your cart? (insert '0' to return to the main menu): ");
                                int laptop_opcion = sc.nextInt();
                                switch (laptop_opcion) {
                                    case 1:
                                        Cart.addDevice(laptop1);
                                        Cart.addMessage();
                                        break;
                                    case 2:
                                        Cart.addDevice(laptop2);
                                        Cart.addMessage();
                                        break;
                                    case 3:
                                        Cart.addDevice(laptop3);
                                        Cart.addMessage();
                                        break;
                                    case 4:
                                        Cart.addDevice(laptop4);
                                        Cart.addMessage();
                                        break;
                                    case 0:
                                        System.out.println("\nReturning to the main menu.");
                                        break OUTER_3;
                                    default:
                                        System.out.println("\nInvalid option, try again.");
                                        break;
                                }
                            } else if (yes_no.equalsIgnoreCase("no")) {
                                System.out.println("\nReturning to the main menu.");
                                break;
                            } else {
                                System.out.println("\nInvalid option.");
                                break;
                            }
                        }
                    } else if (category_opcion == 4) {
                        // Display accessory products
                        System.out.print("\n1. "); accessory1.displayProduct();
                        System.out.print("2. "); accessory2.displayProduct();
                        System.out.print("3. "); accessory3.displayProduct();
                        System.out.print("4. "); accessory4.displayProduct();
                        System.out.print("\nWould you like to add any of these items to your cart? (yes/no): ");
                        String yes_no = sc.next();
                    
                        OUTER_4:
                        while (true) {
                            if (yes_no.equalsIgnoreCase("yes")) {
                                System.out.print("\nWhat product would you like to add to your cart? (insert '0' to return to the main menu): ");
                                int accessory_opcion = sc.nextInt();
                                switch (accessory_opcion) {
                                    case 1:
                                        Cart.addDevice(accessory1);
                                        Cart.addMessage();
                                        break;
                                    case 2:
                                        Cart.addDevice(accessory2);
                                        Cart.addMessage();
                                        break;
                                    case 3:
                                        Cart.addDevice(accessory3);
                                        Cart.addMessage();
                                        break;
                                    case 4:
                                        Cart.addDevice(accessory4);
                                        Cart.addMessage();
                                        break;
                                    case 0:
                                        System.out.println("\nReturning to the main menu.");
                                        break OUTER_4;
                                    default:
                                        System.out.println("\nInvalid option, try again.");
                                        break;
                                }
                            } else if (yes_no.equalsIgnoreCase("no")) {
                                System.out.println("\nReturning to the main menu.");
                                break;
                            } else {
                                System.out.println("\nInvalid option.");
                                break;
                            }
                        }
                    } else if (category_opcion == 5) {
                        // Display game console products
                        System.out.print("\n1. "); console1.displayProduct();
                        System.out.print("2. "); console2.displayProduct();
                        System.out.print("3. "); console3.displayProduct();
                        System.out.print("4. "); console4.displayProduct();
                        System.out.print("\nWould you like to add any of these items to your cart? (yes/no): ");
                        String yes_no = sc.next();
                    
                        OUTER_5:
                        while (true) {
                            if (yes_no.equalsIgnoreCase("yes")) {
                                System.out.print("\nWhat product would you like to add to your cart? (insert '0' to return to the main menu): ");
                                int console_opcion = sc.nextInt();
                                switch (console_opcion) {
                                    case 1:
                                        Cart.addDevice(console1);
                                        Cart.addMessage();
                                        break;
                                    case 2:
                                        Cart.addDevice(console2);
                                        Cart.addMessage();
                                        break;
                                    case 3:
                                        Cart.addDevice(console3);
                                        Cart.addMessage();
                                        break;
                                    case 4:
                                        Cart.addDevice(console4);
                                        Cart.addMessage();
                                        break;
                                    case 0:
                                        System.out.println("\nReturning to the main menu.");
                                        break OUTER_5;
                                    default:
                                        System.out.println("\nInvalid option, try again.");
                                        break;
                                }
                            } else if (yes_no.equalsIgnoreCase("no")) {
                                System.out.println("\nReturning to the main menu.");
                                break;
                            } else {
                                System.out.println("\nInvalid option.");
                                break;
                            }
                        }
                    } else if (category_opcion == 6) {
                        // Return to the main menu
                        System.out.println("\nReturning to the main menu.");
                        break;
                    } else {
                        System.out.println("\nInvalid option.");
                    }
                } else if (welcome_opcion == 2) {
                    // Display shopping cart options
                    System.out.println("""
                        \n1. View Cart
                        2. Remove Item
                        3. Return to Main Menu
                        """);
                    System.out.print("Enter the number of the option: ");
                    int cart_opcion = sc.nextInt();
                
                    while (true) {
                        if (cart_opcion == 1) {
                            // View the cart and calculate the total price
                            Cart.displayCart();
                            Cart.calculateTotalPrice();
                            break;
                        } else if (cart_opcion == 2) {
                            // Remove an item from the cart
                            Cart.displayCart();
                            Cart.calculateTotalPrice();
                            System.out.println("If you want to remove all items from the cart, please enter '-1'.");
                            System.out.print("\nWhat item would you like to remove from the cart? (insert '0' to return to the main menu): ");
                            int remove_opcion = sc.nextInt();
                            if (remove_opcion == 0) {
                                System.out.println("\nReturning to the main menu.");
                                break;
                            } else if (remove_opcion == -1) {
                                Cart.clearCart();
                                System.out.println("\nAll items removed from the cart.");
                                break;
                            }
                            Cart.removeDevice(remove_opcion);
                        } else if (cart_opcion == 3) {
                            // Return to the main menu
                            System.out.println("\nReturning to the main menu.");
                            break;
                        } else if (cart_opcion <= 0 || cart_opcion > 2) {
                            System.out.println("\nInvalid option.");
                            break;
                        }
                    }
                } else if (welcome_opcion == 3) {
                    // Proceed to checkout
                    Cart.displayCart();
                    Cart.calculateTotalPrice();
                    if (Cart.cartEmpty()) {
                        System.out.println("\nYour cart is empty, returning to the main menu.");
                        continue;
                    }
                    System.out.print("\nDo you want to proceed with the purchase? (yes/no): ");
                    String purchase_opcion = sc.next();
                    while (true) {
                        if (purchase_opcion.equalsIgnoreCase("yes")) {
                            if (checkout.getName() == null) {
                                // Provide user information if not already provided
                                checkout.provideInfo();
                                continue;
                            } else {
                                // Display user information
                                checkout.displayInfo();
                                checkout.alreadyProvided();
                            }
                            System.out.print("\nIs the information correct? (yes/no): ");
                            String info_correct = sc.next();
                            if (info_correct.equalsIgnoreCase("yes")) {
                                // Proceed with the purchase
                                System.out.println("Proceeding with the purchase...");
                                System.out.println("The items will be shipped to the next address: " + checkout.getAddress() + ", " + checkout.getCity());
                                System.out.println("Thank you for your purchase!");
                                Cart.clearCart();
                                break;
                            } else if (info_correct.equalsIgnoreCase("no")) {
                                // Verify and update user information
                                checkout.verifyInfo();
                                checkout.displayInfo();
                            } else {
                                System.out.println("Invalid option.");
                            }
                            break;
                        // as a costumer i want to cancel the purchase
                        } else if (purchase_opcion.equalsIgnoreCase("no")) {
                            // Cancel the order and return to the main menu
                            System.out.println("\nYour order has been cancelled, returning to the main menu.");
                            break;
                        } else {
                            System.out.println("Invalid option.");
                            break;
                        }
                    }
                } else if (welcome_opcion == 4) {
                    // Display options for setting or displaying payment information
                    System.out.println("""
                            \n1. Set information
                            2. Display information
                            """);
                    while (true) {
                        System.out.print("Enter the number of the option: ");
                        int info_opcion = sc.nextInt();
                        if (info_opcion == 1) {
                            if (checkout.getName() != null) {
                                // If information is already provided, notify the user
                                checkout.alreadyProvided();
                                break;
                            } else {
                                // Prompt the user to provide their information
                                checkout.provideInfo();
                                System.out.print("\nIs the information correct? (yes/no): ");
                                String info_correct = sc.next();
                                if (info_correct.equalsIgnoreCase("yes")) {
                                    System.out.println("Saving information...");
                                    break;
                                } else if (info_correct.equalsIgnoreCase("no")) {
                                    // Verify and update user information
                                    checkout.verifyInfo();
                                    checkout.displayInfo();
                                    break;
                                } else {
                                    System.out.println("Invalid option.");
                                }
                            }
                        } else if (info_opcion == 2) {
                            // Display the provided information
                            checkout.displayInfo();
                            break;
                        } else {
                            System.out.println("Invalid option.");
                        }
                    }
                } else if (welcome_opcion == 5) {
                    // Exit the program
                    System.out.println("Thank you for visiting, good bye!");
                    System.exit(0);
                } else {
                    System.out.println("Invalid option.");
                }

            }
        } catch (Exception e) {
                        System.out.println("\nInvalid option");
        }
    }
}