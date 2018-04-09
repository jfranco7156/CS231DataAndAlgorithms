package project5;
/**
 * File: CustomerAgent.java
 * Author: Jenniber Franco
 * Date: 03/23/2018
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import project4.Agent;

public class CustomerAgent extends Agent {
	/**
	 * Strategy 1 - Selects a random aisle to join
	 * Strategy 2 - Randomly selects two aisles, compares the length, and goes to the shortest aisle
	 * Strategy 3 - Compares every aisle and goes to the shortest line
	 */
	//fields
	private int items;//Stores the number of items the Customer has in their basket for purchase
	private String state;//Stores the state in which the Agent is in
	private int strategy;//Stores the integer strategy that will be used to represent the method they performed to choose a checkout line
	private int waitTime;//Constant time (will increment in the simulation)
	
	//Constructor
	public CustomerAgent(double x0, double y0, int strategy) {
		super(x0, y0);//Calls the constructor of Agent
		items = 1;//Sets the customer to only have one item
		state = "selection";//Initially sets the status of the customer to be selecting a checkout aisle
		this.strategy = strategy;//Sets the strategy to be equal to the strategy parameter
		if(strategy==1) {
			waitTime = 1;//Automatically adds a waitTime of 1 when strategy 1 is used
		}
		else if(strategy==2) {
			waitTime = 2;//Automatically adds a waitTime of 2 when strategy 2 is used
		}
		else if(strategy==3) {
			waitTime = 4;//Automatically adds a waitTime of 4 when strategy 3 is used
		}
		else {
			waitTime = 0;//No strategy was selected so sets wait time to 0
			System.out.println("Please enter a valid type of Strategy");//Prints the statement in the console
			System.exit(0);//Exits and closes the program
		}
		
	}
	
	public void updateState(Landscape scape) {
		if(state.equals("selection")) {//if the customer is in a selecting state
			Random rand = new Random();//Initializes the Random object
			int totalLanes = scape.getCheckout().size();//Sets the totalLanes to be the number of checkouts available
			if(strategy==1) {//if strategy 1 is being used
				int lane = rand.nextInt(totalLanes);//Randomly selects a number between 0 and the length of the checkout aisles available
				scape.getCheckout().get(lane).addCustomer(this);//Adds the customer to the checkout aisle randomly selected
			}
			else if(strategy==2) {//if strategy 2 is being used
				int lane1 = rand.nextInt(totalLanes);//Randomly selects a lane between the checkout aisles
				int lane2;//Initializes a second lane to be compares
				do {
					lane2 = rand.nextInt(totalLanes);//Randomly selects a second lane between the checkout aisles
				}while(lane2==lane1);//Keeps looping if lane1 and lane2 are the same
				if(scape.getCheckout().get(lane1).size()<scape.getCheckout().get(lane2).size()) {//If the first lane size is less than the second lane
					scape.getCheckout().get(lane1).addCustomer(this);//Adds the customer to the first lane
				}
				else {
					scape.getCheckout().get(lane2).addCustomer(this);//Adds the customer to the second lane
				}
			}
			else if(strategy==3) {//if strategy 3 is being used
				int shortestLine = 0;//Initializes the shortest line to be 0
				int shortestCust = scape.getCheckout().get(0).size();//Initializes the shortest line size to be the the first lane size
				for(int i=1; i < scape.getCheckout().size(); i++) {
					if(scape.getCheckout().get(i).size()<shortestCust) {//If the size of the i lane is shorter than the current shortest line
						shortestCust = scape.getCheckout().get(i).size();//Changes the shortest size to be the current size of lane i
						shortestLine = i;//Changes the shortestLine variable to be i
					}
				}
				scape.getCheckout().get(shortestLine).addCustomer(this);//Adds the customer to the shortest checkout
			}
			state = "waiting";//Changes the state to waiting
			return;//returns nothing to leave the method
		}
		else if(state.equals("waiting")) {//if the customer is in a waiting state
			waitTime++;//Increment the waitTime by 1
			return;//returns nothing to leave the method
		}
		else if(state.equals("checkout"))return; //if the customer is in checkout state, it returns nothing to leave the method
	}
	
	//Returns the strategy used by the customer
	public int getStrategy() {
		return strategy;
	}
	
	//Returns the item number the customer has
	public int getItems() {
		return items;
	}
	
	//Sets the item field to the parameter items
	public void setItems(int items) {
		this.items = items;
	}
	
	//returns the amount if time the customer has waited in the checkout
	public int getWait() {
		return waitTime;
	}
	
	//Sets the waitTime field to the parameter t
	public void setWait(int t) {
		waitTime = t;
	}
	
	//Sets the state field to the parameter s
	public void setState(String s) {
		state = s;
	}
	
	//Draws rectangle at the coordinates to represent an CustomerAgent
	public void draw(Graphics g) {
		if(strategy==1)g.setColor(Color.BLACK);//Changes the color of the graphics component to blue to distinguish the customer using strategy 1
		if(strategy==2)g.setColor(Color.CYAN);//Changes the color of the graphics component to blue to distinguish the customer using strategy 2
		if(strategy==3)g.setColor(Color.gray);//Changes the color of the graphics component to blue to distinguish the customer using strategy 3
		
		g.fillRect((int)getX0(), (int)getY0(), 10, 10);//Draws a filled rectangle to represent the customer
		if(state.equals("checkout") && items==0) g.clearRect((int)getX0(), (int)getY0(), 10, 10);
	}
	
}
