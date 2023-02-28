/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
import java.util.Scanner;
public class BetterTicket
{
    // The price of a ticket from this machine.
    private Integer price;
    // The amount of money entered by a customer so far.
    private Integer balance;
    // The total amount of money collected by this machine.
    private Integer total;
    // The number of tickets printed.
    private Integer ticketNumber;
    private Integer budget;
    private Integer discount;
    private Integer savings;
    int status;

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    public BetterTicket()
    {
        price = 1000;
        balance = 0;
        total = 0;
        ticketNumber = 0;
        budget = 100;
    }
    
    public BetterTicket(int cost)
    {
        price = cost;
        balance = 0;
        total = 0;
        ticketNumber = 0;
    }

    /**
     * Return the price of a ticket.
     */
    public Integer getPrice()
    {
        return price;
    }
    
    /**
     * Return ticketNumber.
     * (Increments on each print.)
     */
    public Integer getTicketNumber()
    {
        return ticketNumber;
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public Integer getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money in cents from a customer.
     */
    public Integer insertMoney(Integer amount)
    {
        if(amount >=0){
            balance = balance + amount;
        }
        return balance;
    }
    
    public void prompt(){
        System.out.println("Please insert the correct amount of money");
    }
    
    public void empty(){
        total = 0;
    }
    
    public void showPrice(){
        System.out.println("The price of a ticket is" + price + "cents.");
    }
    
    public void setPrice(int cost){
        price = cost;
    }
    
    public void setSavings(){
        savings = price * discount;
    }
    
    public void getMeanCost(){
        if(price > budget){
            System.out.println("Too expensive, keep it to" + budget);
        }
        else{
            System.out.println("Just right");
        }
    }
    
    public int emptyMachine(){
        int temp = total;
        total = 0;
        return temp;
        
    }
    
    public Integer calculateTotal(){
        total = balance + total;
        return total;
    }
    
    public void discount(int amount){
        discount = amount;
    }
    
    public Integer incrementTicketNumber(){
        ticketNumber++;
        return ticketNumber;
    }
    
    public Integer getTotal(){
        return total;
    }
    

    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public String printTicket()
    {
        Scanner in = new Scanner(System.in);
        price = in.nextInt();
        int amountLeftToPay = price - balance;
        if(amountLeftToPay > 0){
            return "Error: not enough funds, balance is:" + balance + "and price is:" + price;
        }
        //Increment the number of tickets printed
        incrementTicketNumber();
        // Update the total collected with the balance.
        total = total + balance;
        // Clear the balance.
        balance = 0;
        
        return "Ticket price: " + price + " cents. " + "Your total is " + total + ".";
    }
}
