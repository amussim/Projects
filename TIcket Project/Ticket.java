package Project6;
/*Aneesh Mussim
  Project 6: ticket class
  11/2/2020
  CMSC 255 sec 002
 */
public class Ticket {
    //insance variables
    private Location location;
    private Food_Option food;
    private Drink_Option drink;
    private Discount discount;

    //default constructor
    public Ticket() {
        //used from the enum classes and as objects
        location = Location.FRONT;
        food = Food_Option.NONE;
        drink = Drink_Option.NONE;
        discount = Discount.NONE;
    }
    //paramater constructor
    public Ticket(Location location) {
        this.location = location;
        food = Food_Option.NONE;
        drink = Drink_Option.NONE;
        discount = Discount.NONE;
    }
    //getters and setter for instance variables
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Food_Option getFood() {
        return food;
    }

    public void setFood(Food_Option food) {
        this.food = food;
    }

    public Drink_Option getDrink() {
        return drink;
    }

    public void setDrink(Drink_Option drink) {
        this.drink = drink;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    //to String for Ticket class
    public String toString() {
        return "\n"+"\t"+location+"\n"+"\t"+food+"\n"+"\t"+drink+"\n"+"\t"+discount+"\n";
    }
}
