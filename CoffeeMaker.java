import com.RecipeBook.recipes.Recipe;

public class CoffeeMaker {
    public static void main(String[] args) {
        // Create a coffee maker instance
        MyCoffeeMaker MyCoffeeMaker = new MyCoffeeMaker();
        
        // Set the coffee maker in use
        MyCoffeeMaker.setInUse(true);
        System.out.println("Is coffee maker in use? " + MyCoffeeMaker.inUse());  // Prints "Is coffee maker in use? true"
    
            // Create a recipe book instance
            RecipeBook recipeBook = new RecipeBook(MyCoffeeMaker);

            // Associate the recipe book with the coffee maker
            MyCoffeeMaker.setRecipeBook(recipeBook);

            // Create an inventory instance
            Inventory inventory = new Inventory(MyCoffeeMaker);
            inventory.setMilk(5);
            inventory.setCoffee(10);
            inventory.setSugar(10);
            inventory.setCocoa(3);

            inventory.addCocoa(3);

            // Add a new recipe to the recipe book using the coffee maker
            Recipe newRecipe = new Recipe("Cappuccino", 150, 1, 1, 1, 0);
            

            recipeBook.addRecipe(newRecipe);
            


    
             System.out.println("Name: " +newRecipe.getName() +"\n" + 
                     "Cocoa Amount "+newRecipe.getCocoa()+"\n" + 
                             "Milk Amount "+newRecipe.getMilk()+"\n" + 
                                     "Sugar Amount "+ newRecipe.getSugar()+"\n" + 
                                             "Price Amount "+newRecipe.getPrice());
           
            

            // Create a purchase instance and check if it's possible
            Purchase purchase = new Purchase("Cappuccino", 150, 200, recipeBook, inventory);
            System.out.println("Can purchase? " + purchase.isProcess());  // Prints "Can purchase? true"

            // Print inventory after purchase
            System.out.println("Inventory after purchase: \n Milk: " + inventory.getMilk()+"\n Coffee: " + inventory.getCoffee()+"\n Sugar: " + inventory.getSugar()+"\n Cocoa: " + inventory.getCocoa());
        
        // Exit the coffee maker and recipe book
        recipeBook.exit();
        MyCoffeeMaker.setInUse(false);
    }
}
