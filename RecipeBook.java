import java.util.ArrayList;
import java.util.List;

import com.RecipeBook.recipes.Recipe;

public class RecipeBook {
    private static final int MAX_RECIPES = 3;  // Maximum number of recipes allowed
    private List<Recipe> recipes;
    private boolean recipeBookMsg = false;  // Initialize to false by default
    private MyCoffeeMaker coffeeMaker;

    public RecipeBook(MyCoffeeMaker coffeeMaker) {
        this.coffeeMaker = coffeeMaker;
        this.coffeeMaker.setInUse(true);  // Set inUse to true when RecipeBook is accessed
        recipes = new ArrayList<>();
    }

    public boolean isRecipeBookMsg() {
        return recipeBookMsg;
    }

    public int getRecipeCount() {
        return recipes.size();
    }

    public int MAX_RECIPES() {
        return MAX_RECIPES;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public boolean containsRecipe(String recipeName) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equals(recipeName)) {
                return true;
            }
        }
        return false;
    }

    public Recipe getRecipeByName(String recipeName) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equals(recipeName)) {
                return recipe;
            }
        }
        return null;  // Recipe not found
    }

    public void addRecipe(Recipe recipe) {
        if (containsRecipe(recipe.getName())) {
            recipeBookMsg = false;  // Set the flag to false if the recipe name already exists
            throw new IllegalStateException("Recipe with the same name already exists.");
        }
        if (recipes.size() < MAX_RECIPES) {
            recipes.add(recipe);
            recipeBookMsg = true;  // Set the flag to true if the operation is successful
        } else {
            recipeBookMsg = false;  // Set the flag to false if the operation fails
            throw new IllegalStateException("Maximum number of recipes reached.");
        }
    }

    public void deleteRecipe(String recipeName) {
        Recipe recipeToRemove = null;
        for (Recipe recipe : recipes) {
            if (recipe.getName().equals(recipeName)) {
                recipeToRemove = recipe;
                break;
            }
        }
        if (recipeToRemove != null) {
            recipes.remove(recipeToRemove);
            recipeBookMsg = true;  // Set the flag to true if the operation is successful
        } else {
            recipeBookMsg = false;  // Set the flag to false if the recipe name is not found
            throw new IllegalArgumentException("Recipe with the specified name not found.");
        }
    }

    public void editRecipe(String recipeName, Recipe newRecipe) {
        Recipe recipeToEdit = null;
        for (Recipe recipe : recipes) {
            if (recipe.getName().equals(recipeName)) {
                recipeToEdit = recipe;
                break;
            }
        }
        if (recipeToEdit != null) {
            recipes.remove(recipeToEdit);
            recipes.add(newRecipe);
            recipeBookMsg = true;  // Set the flag to true if the operation is successful
        } else {
            recipeBookMsg = false;  // Set the flag to false if the recipe name is not found
            throw new IllegalArgumentException("Recipe with the specified name not found.");
        }
    }

    public void exit() {
        this.coffeeMaker.setInUse(false);  // Set inUse to false when exiting RecipeBook
    }

    public boolean canPurchaseRecipe(String recipeName, int payment, Inventory inventory) {
        if (containsRecipe(recipeName)) {
            Recipe recipe = getRecipeByName(recipeName);
            if (inventoryHasEnoughItems(recipe, inventory)) {
                return payment >= recipe.getPrice();
            }
        }
        return false;
    }

    private boolean inventoryHasEnoughItems(Recipe recipe, Inventory inventory) {
        return inventory.getMilk() >= recipe.getMilk() &&
               inventory.getCoffee() >= recipe.getCoffee() &&
               inventory.getSugar() >= recipe.getSugar() &&
               inventory.getCocoa() >= recipe.getCocoa();
    }
}
