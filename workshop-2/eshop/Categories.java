package eshop;

public class Categories {
    
    private String category_name;
   
    
    
    public Categories() {
    }
    
    public Categories(String category_name) {
        this.category_name = category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void displayCategories() {
        System.out.println("Products available in the category: " + getCategory_name());
    }





}
