public class Inventory {

   private int milk;
   private int coffee;
   private int sugar;
   private int cocoa;
   private boolean invMsg;
   private MyCoffeeMaker coffeeMaker;  
   
   public Inventory(MyCoffeeMaker coffeeMaker) {
    this.coffeeMaker = coffeeMaker;
    this.coffeeMaker.setInUse(true);  // Set inUse to true when Inventory is accessed
}

    public int getMilk() {
        return milk;
    }
    public void setMilk(int milk) {
        this.milk = milk;
    }
    public int getCoffee() {
        return coffee;
    }
    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }
    public int getSugar() {
        return sugar;
    }
    public void setSugar(int sugar) {
        this.sugar = sugar;
    }
    public int getCocoa() {
        return cocoa;
    }
    public void setCocoa(int cocoa) {
        this.cocoa = cocoa;
    }
    public boolean isInvMsg() {
        return invMsg;
    }
    public void setInvMsg(boolean invMsg) {
        this.invMsg = invMsg;
    }
       // Method to add a specified quantity of milk to the inventory
   public void addMilk(int quantity) {
    milk += quantity;
    }

    // Method to add a specified quantity of coffee to the inventory
    public void addCoffee(int quantity) {
        coffee += quantity;
    }

    // Method to add a specified quantity of sugar to the inventory
    public void addSugar(int quantity) {
        sugar += quantity;
    }

    // Method to add a specified quantity of cocoa to the inventory
    public void addCocoa(int quantity) {
        cocoa += quantity;
    }

    // Method to call when Inventory is no longer being used
    public void exit() {
        this.coffeeMaker.setInUse(false);  // Set inUse to false when exiting Inventory
    }


    }
