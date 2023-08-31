package com.RecipeBook.recipes;

public class Recipe {

    private boolean inUse;
    private String name;
    private int price;
    private int coffee;
    private int milk;
    private int sugar;
    private int cocoa;

    public Recipe(String name, int price, int coffee, int milk, int sugar, int cocoa) {
        this.inUse = true;  // Assuming you want 'inUse' to be true initially
        this.name = name;
        this.price = price;
        this.coffee = coffee;
        this.milk = milk;
        this.sugar = sugar;
        this.cocoa = cocoa;
    }

    // Getters and setters for properties (if needed)
    
    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice(){
        return price;
    
    }

    public Integer getMilk(){
        return milk;
    
    }

    public Integer getSugar(){
        return sugar;
    
    }

    public Integer getCocoa(){
        return cocoa;
    
    }

    public Integer getCoffee(){
        return coffee;
    
    }

    public static String getRecipe(Recipe recipe) {
        String details = "Name: " + recipe.getName() + "\n" +
                         "Price: " + recipe.getPrice() + "\n" +
                         "Coffee: " + recipe.getCoffee() + "\n" +
                         "Milk: " + recipe.getMilk() + "\n" +
                         "Sugar: " + recipe.getSugar() + "\n" +
                         "Cocoa: " + recipe.getCocoa();
        
        return details;
    }


}
