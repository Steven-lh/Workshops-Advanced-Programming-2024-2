package eshop;

import java.util.Scanner;

/**
 * The Checkout class represents the checkout process where user information is collected and verified.
 */
public class Checkout {

    private String name, last_name, email, address, city;
    private long phone_number;

    static Scanner sc = new Scanner(System.in);

    /**
     * Default constructor for Checkout.
     */
    public Checkout() {
    }

    /**
     * Parameterized constructor for Checkout.
     *
     * @param name        the name of the user
     * @param last_name   the last name of the user
     * @param email       the email of the user
     * @param address     the address of the user
     * @param city        the city of the user
     * @param phone_number the phone number of the user
     */
    public Checkout(String name, String last_name, String email, String address, String city, long phone_number) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.phone_number = phone_number;
    }

    /**
     * Gets the name of the user.
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name the new name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the last name of the user.
     *
     * @return the last name of the user
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Sets the last name of the user.
     *
     * @param last_name the new last name of the user
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Gets the email of the user.
     *
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the new email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the address of the user.
     *
     * @return the address of the user
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the user.
     *
     * @param address the new address of the user
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the city of the user.
     *
     * @return the city of the user
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the user.
     *
     * @param city the new city of the user
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the phone number of the user.
     *
     * @return the phone number of the user
     */
    public long getPhone_number() {
        return phone_number;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phone_number the new phone number of the user
     */
    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    /**
     * Displays the user's shipping information.
     */
    // as a costumer i want to see my information easily
    public void displayInfo() {
        System.out.println("\nShipping Information: ");
        System.out.println("Name: " + getName());
        System.out.println("Last Name: " + getLast_name());
        System.out.println("Email: " + getEmail());
        System.out.println("Address: " + getAddress());
        System.out.println("City: " + getCity());
        System.out.println("Phone Number: " + getPhone_number());
    }

    /**
     * Verifies and allows the user to change their information.
     */

// as a costumer i want to verify that my information is correct
// as a costumer i want to change my information when i want

    public void verifyInfo() {
        while (true) {
            System.out.println("""
                \nWhich information would you like to change?
                1. Name
                2. Last Name
                3. Email
                4. Address
                5. City
                6. Phone Number
                7. All
                8. None
                """);
            System.out.print("Enter the number of the information you would like to change: ");
            int change_info = sc.nextInt();
            if (change_info == 1) {
                System.out.println("Actual name: " + getName());
                System.out.print("Enter new name: ");
                setName(sc.next());
                break;
            } else if (change_info == 2) {
                System.out.println("Actual last name: " + getLast_name());
                System.out.print("Enter new last name: ");
                setLast_name(sc.next());
                break;
            } else if (change_info == 3) {
                System.out.println("Actual email: " + getEmail());
                System.out.print("Enter new email: ");
                setEmail(sc.next());
                break;
            } else if (change_info == 4) {
                System.out.println("Actual address: " + getAddress());
                System.out.print("Enter new address: ");
                setAddress(sc.next());
                break;
            } else if (change_info == 5) {
                System.out.println("Actual city: " + getCity());
                System.out.print("Enter new city: ");
                setCity(sc.next());
                break;
            } else if (change_info == 6) {
                System.out.println("Actual phone number: " + getPhone_number());
                System.out.print("Phone number: ");
                while (!sc.hasNextLong()) {
                    System.out.println("Invalid input. Please enter a valid phone number.");
                    sc.next();
                }
                setPhone_number(sc.nextLong());
                break;
            } else if (change_info == 7) {
                System.out.print("Enter new name: ");
                setName(sc.next());
                System.out.print("Enter new last name: ");
                setLast_name(sc.next());
                System.out.print("Enter new email: ");
                setEmail(sc.next());
                System.out.print("Enter new address: ");
                setAddress(sc.next());
                System.out.print("Enter new city: ");
                setCity(sc.next());
                System.out.print("Enter new phone number: ");
                setPhone_number(sc.nextLong());
                break;
            } else if (change_info == 8) {
                break;
            } else {
                System.out.println("Invalid option. Please enter a valid number.");
            }
        }
        System.out.print("\nDo you want to change more information? ");
        System.out.print("\nyes/no: ");
        String moreChanges = sc.next();
        if (!moreChanges.equalsIgnoreCase("yes")) {
        } else {
            displayInfo();
            verifyInfo();
        }
    }

    /**
     * Prompts the user to provide their information.
     */

// as a costumer i want to provide my information for purchase
    public void provideInfo() {
        System.out.println("\nPlease provide the following information: ");

        System.out.print("Name: ");
        String name = sc.next();
        setName(name);

        System.out.print("Last name: ");
        String last_name = sc.next();
        setLast_name(last_name);

        System.out.print("Email: ");
        String email = sc.next();
        setEmail(email);

        System.out.print("Address: ");
        String address = sc.next();
        setAddress(address);

        System.out.print("City: ");
        String city = sc.next();
        setCity(city);

        System.out.print("Phone number: ");
        while (!sc.hasNextLong()) {
            System.out.println("Invalid input. Please enter a valid phone number.");
            sc.next();
        }
        setPhone_number(sc.nextLong());
        displayInfo();
    }

    /**
     * Checks if the user has already provided their information.
     */

    
// as a costumer i want to know if i have already provided my information
    public void alreadyProvided() {
        if (getName() != null && getLast_name() != null && getEmail() != null && getAddress() != null && getCity() != null && getPhone_number() != 0) {
            System.out.println("\nYou have already provided the information");
        }
    }
}