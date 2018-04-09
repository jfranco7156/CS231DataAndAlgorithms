package project5;
/**
 * File: CheckoutAgent.java
 * Author: Jenniber Franco
 * Date: 03/23/2018
 */
import java.awt.Color;
import java.awt.Graphics;

public class CheckoutAgent extends Agent {
	//fields
	private MyQueue<CustomerAgent> aisle;//MyQueue field to store the number of customers in the aisle
	
	public CheckoutAgent(double x0, double y0) {
		super(x0, y0);//Calls the super constructor (Agent constructor)
		aisle = new MyQueue<CustomerAgent> ();//Initializes the MyQueue aisle
	}
	
	//Returns the MyQueue<CustomerAgnet> aisle field
	public MyQueue<CustomerAgent> getAisle(){
		return aisle;
	}
	
	//Adds the customer to the aisle
	public void addCustomer(CustomerAgent c) {
		aisle.offer(c);//Adds the customer to the end of the queue
		c.setX0(getX0()+20);//Sets the x position of the customer relative to the 
		c.setY0(getY0()-(20*(size()-1)));//Sets the y position of the customer relative to the length customers in the aisle
	}
	
	//Returns the number of customers in the aisle
	public int size() {
		return aisle.size();
	}
	
	//updates the state of the customers in the aisle
	public void updateState(Landscape scape) {
		if(size()==0) {
			return;//Return and exits the method if the aisle has no customers
		}
		else if(size()>0) {
			CustomerAgent cust = aisle.peek();//Retrieves the first customer in the queue without removing it from the queue
			cust.setState("checkout");//Changes the state of the customer
			if(cust.getItems()>0) cust.setItems(cust.getItems()-1);//
			else {
				CustomerAgent c = aisle.poll();//returns and removes the first CustomerAgent in the queue
				scape.addTime(c);//Adds the wait time of the customer to the scape ArrayList of times
				scape.getCustomers().remove(c);//removes the customer from the queue in scape
				int i = 0;//initializes the int i to 0
				for (CustomerAgent customer: aisle) {
					customer.setY0(getY0()-20*i);//Changes the y postion based on its position in the aisle queue
					i++;//increments i by 1
				}
			}
		}
	}
		
	//Draws a circle centered at the coordinates to represent an Agent
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);//Changes the graphics color to BLUE
		g.fillRect((int)getX0(), (int)getY0(), 10, 30);//Draws the CustomerAgent using graphics rectangle property
	}
	
	public static void main(String[] args) {
		CheckoutAgent c = new CheckoutAgent(100,100);//Initialized a CheckoutAgent object
		c.addCustomer(new CustomerAgent(50,50,1));//Added a CustomerAgent to the aisle queue in c
		System.out.println("Initialized Checkout Successful");//Prints statement if initialized successfully
	}
	
}
