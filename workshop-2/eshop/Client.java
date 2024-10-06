package eshop;
import java.util.Scanner;

/**
* The Client class represents the process where user client information is collected and verified.
*/
public class Client extends User {

    private String username, name, last_name, address, city;
    private long phone_number;

    Scanner sc = new Scanner(System.in);

    public Client() {
    }

    public Client(String username, String password, String email, String name, String last_name, String address, String city, long phone_number) {
        super(password, email);
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.phone_number = phone_number;
    }

    public String setUsername(String username) {
        return this.username = username;
    }

    public String getUsername() {
        return username;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    /**
    * Prompts the user to provide their information.
    */

    // as a costumer i want to provide my information for purchase
    public void provideCInfo() {
        System.out.println("\nPlease provide the following information: ");

        System.out.print("Name: ");
        String name = sc.nextLine();
        setName(name);

        System.out.print("Last name: ");
        String last_name = sc.nextLine();
        setLast_name(last_name);

        System.out.print("Email: ");
        String email = sc.nextLine();
        setEmail(email);

        System.out.print("Address: ");
        String address = sc.nextLine();
        setAddress(address);

        System.out.print("City: ");
        String city = sc.nextLine();
        setCity(city);

        System.out.print("Phone number: ");
        while (!sc.hasNextLong()) {
            System.out.println("Invalid input. Please enter a valid phone number.");
            sc.next();
        }
        setPhone_number(sc.nextLong()); 
    }

    /**
    * Verifies and allows the user to change their information.
    */

    // as a costumer i want to verify that my information is correct
    // as a costumer i want to change my information when i want
    public void changeUserInfo() {
        System.out.println("""
            \nWhat would you like to change?
            1. Name
            2. Last Name
            3. Email
            4. Address
            5. City
            6. Phone Number
            7. All
            8. Exit
            """);

        int changeinfo_option = sc.nextInt();

        if (changeinfo_option == 1) {
            System.out.println("Actual name: " + getName());
            System.out.print("Enter new name: ");
            setName(sc.next());
        } else if (changeinfo_option == 2) {
            System.out.println("Actual last name: " + getLast_name());
            System.out.print("Enter new last name: ");
            setLast_name(sc.next());
        } else if (changeinfo_option == 3) {
            System.out.println("Actual email: " + getEmail());
            System.out.print("Enter new email: ");
            setEmail(sc.next());
        } else if (changeinfo_option == 4) {
            System.out.println("Actual address: " + getAddress());
            System.out.print("Enter new address: ");
            setAddress(sc.next());
        } else if (changeinfo_option == 5) {
            System.out.println("Actual city: " + getCity());
            System.out.print("Enter new city: ");
            setCity(sc.next());
        } else if (changeinfo_option == 6) {
            System.out.println("Actual phone number: " + getPhone_number());
            System.out.print("Phone number: "); 
            while (!sc.hasNextLong()) { 
                System.out.println("Invalid input. Please enter a valid phone number."); 
                sc.next(); 
            } 
            setPhone_number(sc.nextLong());

        } else if (changeinfo_option == 7) {
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
        } else if (changeinfo_option == 8) {
            System.out.println("Exiting...");
            
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    /**
    * Displays the user's shipping information.
    */

    // as a costumer i want to see my information easily
    public void displayCInfo() {
        System.out.println("\nYour Information: ");
        System.out.println("Name: " + getName());
        System.out.println("Last Name: " + getLast_name());
        System.out.println("Email: " + getEmail());
        System.out.println("Address: " + getAddress());
        System.out.println("City: " + getCity());
        System.out.println("Phone Number: " + getPhone_number());
    }

    /**
    * Checks if the client has already provided their information.
    */

    // as a costumer i want to know if i have already provided my information
    public void alreadyProvided() {
        if (getName() != null && getLast_name() != null && getEmail() != null && getAddress() != null && getCity() != null && getPhone_number() != 0) {
            System.out.println("\nYou have already provided the information");
        }
    }

    @Override
    public void userType() {
        System.out.println("\nUser type: Client");
    }
}
