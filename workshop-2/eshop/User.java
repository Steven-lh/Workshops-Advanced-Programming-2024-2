package eshop;

/**
* The User class represents a generic user with a name, email, and password.
* This class is abstract and should be extended by specific user types.
*/

public abstract class User {
    protected String password;
    protected String email;

    /**
     * Default constructor for User.
     */
    public User() {
    }

    public User(String password, String email) {
        
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract void userType();
}
