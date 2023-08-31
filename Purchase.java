import com.RecipeBook.recipes.Recipe;

public class Purchase {
    private String recipeName;
    private int recipePrice;
    private int payment;
    private boolean process;
    private int amountOwed;
    private RecipeBook recipeBook;
    private Inventory inventory;

    public Purchase(String recipeName, int recipePrice, int payment, RecipeBook recipeBook, Inventory inventory) {
        this.recipeName = recipeName;
        this.recipePrice = recipePrice;
        this.payment = payment;
        this.recipeBook = recipeBook;
        this.inventory = inventory;
        calculateProcessAndAmountOwed();
    }
    private boolean inventoryHasEnoughItems(Recipe recipe) {
        return inventory.getMilk() >= recipe.getMilk() &&
               inventory.getCoffee() >= recipe.getCoffee() &&
               inventory.getSugar() >= recipe.getSugar() &&
               inventory.getCocoa() >= recipe.getCocoa();
    }

    private void calculateProcessAndAmountOwed() {
        if (recipeBook.canPurchaseRecipe(recipeName, payment, inventory)) {
            Recipe recipe = recipeBook.getRecipeByName(recipeName);
            if (payment >= recipe.getPrice() && inventoryHasEnoughItems(recipe) == true ) {
                
                            // Deduct ingredients from inventory
            inventory.setMilk(inventory.getMilk() - recipe.getMilk());
            inventory.setCoffee(inventory.getCoffee() - recipe.getCoffee());
            inventory.setSugar(inventory.getSugar() - recipe.getSugar());
            inventory.setCocoa(inventory.getCocoa() - recipe.getCocoa());


                process = true;
                amountOwed = 0;

            } else {
                if (inventoryHasEnoughItems(recipe) == false){
                    process = false;
                }
                else{
                process = false;
                amountOwed = recipe.getPrice() - payment;
                }}
        } else {
            process = false;
            amountOwed = -1;  // Indicate that purchase is not possible
        }
    }

    public String getRecipeName() {
        return recipeName;
    }

    public int getRecipePrice() {
        return recipePrice;
    }

    public int getPayment() {
        return payment;
    }

    public boolean isProcess() {
        return process;
    }

    public int getAmountOwed() {
        return amountOwed;
    }
}

