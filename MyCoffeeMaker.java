import com.RecipeBook.recipes.Recipe;

public class MyCoffeeMaker implements MainUI {

    private boolean inUse;
    private RecipeBook recipeBook;  // Adding the recipeBook field
    
    // Other methods and constructor
    
    @Override
    public boolean inUse() {
        return inUse;
    }

    @Override
    public void setInUse(boolean value) {
        inUse = value;
    }

    // Method to set the recipe book
    public void setRecipeBook(RecipeBook recipeBook) {
        this.recipeBook = recipeBook;
    }

    
}
