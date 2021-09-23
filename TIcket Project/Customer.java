package Project6;
/*Aneesh Mussim
  Project 6: customer class
  11/2/2020
  CMSC 255 sec 002
 */


import java.util.ArrayList;
//instance variables
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private ArrayList<Ticket> tickets;

    //default constructor
    public Customer(){
        firstName= "";
        lastName = "";
        email = "";
        age = 0;
        tickets = new ArrayList<Ticket>();
    }
    //parameter constructor
    public Customer (String lastName, String firstName, int age, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.email = email;
        this.tickets = new ArrayList<Ticket>();
    }
    //getters and setter for customer class
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //this will add tickets to the list
    public void purchaseTicket(Ticket ticket) {
            tickets.add(ticket);
    }

    //this method will let you know how many ticket objects are associated with the customer object
    public int getNumTickets() {
        int number = tickets.size();
        return number;
    }
    //get method for arraylist tickets
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
    //To string method for customer classs
    //NOTE: made a mistake by directly using the toString method from ticket class(It will show default values from that class
    //by using the get method from ticket it was able to obtain the values to loop through and print
    public String toString() {
        String ticketFormatted = firstName+" "+ lastName +"\n" + age + "\n" + email + "\nTicket Order:" +"\n";
        for(Ticket ticket: tickets) {
            ticketFormatted += "\n"+"\t"+ticket.getLocation();
            ticketFormatted += "\n"+"\t"+ticket.getFood();
            ticketFormatted += "\n"+"\t"+ticket.getDrink();
            ticketFormatted += "\n"+"\t"+ticket.getDiscount() +"\n";
        }
        return ticketFormatted;
    }
}
