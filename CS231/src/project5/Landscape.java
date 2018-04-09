package project5;
/**
 * File: Landscape.java
 * Author: Jenniber Franco
 * Date: 03/23/2018
 */
import java.awt.Color;
import java.awt.Font;
/* File: Landscape.java
* Author: Jenniber Franco
* Date: 03/12/2018
*/
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Landscape {
	//fields
	private int width;//int to store the width of Landscape
	private int height;//int to store the height of Landscape
	private int numCust;//int to the store the number of customers that were initialized
	
	private ArrayList<CheckoutAgent> checkouts;//Stores the CheckoutAgents
	private ArrayList<CustomerAgent> customers;//Stores the CustomerAgents
	
	private ArrayList<Integer> time1;//Stores the waitTime value of strategy 1 - choosing a random aisle
	private ArrayList<Integer> time2;//Stores the waitTime values of strategy 2 - choosing 2 aisles and selecting the best one
	private ArrayList<Integer> time3;//Stores the waitTime values of strategy 3 - looking at all the aisles for the shortest one
	
	private double dAvg1;//double to store the average for strategy 1
	private double dAvg2;//double to store the average for strategy 2
	private double dAvg3;//double to store the average for strategy 3
	
	private double dStandard1;//double to store the standard deviation for strategy 1
	private double dStandard2;//double to store the standard deviation for strategy 2
	private double dStandard3;//double to store the standard deviation for strategy 3
	
	//Constructor the create the Landscape
	public Landscape(int w, int h) {
		width = w;//Sets the width field to the w parameter
		height = h;//Sets the height field to the h parameter
		numCust = 0;//Sets the number of customers to 0
		
		checkouts = new ArrayList<CheckoutAgent>();//new ArrayList<CheckoutAgent> is initiated
		customers = new ArrayList<CustomerAgent>();//new ArrayList<CustomerAgent> is initiated
		
		time1 = new ArrayList<Integer>();//new ArrayList to store the wait time of the customers 
		time2 = new ArrayList<Integer>();//new ArrayList to store the wait time of the customers
		time3 = new ArrayList<Integer>();//new ArrayList to store the wait time of the customers
		
		dAvg1 = 0; dAvg2 = 0; dAvg3 = 0;//Initializes the average of the strategies to 0
		dStandard1 = 0; dStandard2 = 0; dStandard3 = 0;//Initializes the standard deviation of the strategies to 0 
		
	}
	
	//Returns the ArrayList of checkouts
	public ArrayList<CheckoutAgent> getCheckout(){
		return checkouts;
	}
	
	//Returns the ArrayList of customers
	public ArrayList<CustomerAgent> getCustomers(){
		return customers;
	}
	
	//Adds a customer to the customers ArrayList and changes the  numCust when a customer is added
	public void addCustomerAgent(CustomerAgent c) {
		customers.add(c);//Adds the customer agent to the customers ArrayList
		numCust = customers.size();//Changes the number of customers to the size of the list
	}
	
	//Adds a checkout to the checkouts ArrayList
	public void addCheckoutAgent(CheckoutAgent c) {
		checkouts.add(c);
	}
	
	//Adds the customers waitTime to its respective ArrayList depending on the strategy
	public void addTime(CustomerAgent c) {
		if(c.getStrategy()==1) {
			time1.add(c.getWait());//Adds the customer waitTime to the ArrayList storing waitTimes of strategy 1
		}
		else if(c.getStrategy()==2) {
			time2.add(c.getWait());//Adds the customer waitTime to the ArrayList storing waitTimes of strategy 2
		}
		else if(c.getStrategy()==3) {
			time3.add(c.getWait());//Adds the customer waitTime to the ArrayList storing waitTimes of strategy 3
		}

	}
	
	public int getHeight() {
		return height;//Returns the height field
	}
	
	public int getWidth() {
		return width;//Returns the width field
	}
	
	//Returns the average of the ArrayList parameter
	public double getAverage(ArrayList<Integer> times) {
		int avg = 0;//Initializes the int avg to 0
		
		for(Integer i: times) {
			avg += i;//Increments the avg by the value of i in times
		}
		
		avg = avg/times.size();//Divides the avg total by the length of times
		
		return avg;//returns the avg
	}
	
	//Calculates the standard variation for the ArrayList parameter
	public double getStandardDeviation(ArrayList<Integer> times) {
		ArrayList<Double> t  = new ArrayList<Double>();//Initializes the ArrayList double to store the the square root of the number-mean
		double mean = getAverage(times);//Stores the average of the ArrayList times
		
		for(Integer i: times) {
			t.add(Math.pow(i-mean,2));//Adds the square of the value of time-mean to the t ArrayList
		}
		
		double standard = 0;//Sets the standard double to 0
		for(Double d: t) {
			standard += d;//Increments the standard by double D
		}
		
		standard = standard/t.size();//Divides the standard by the size of the t ArrayList
		return standard;//returns the standard
	}
	
	//Returns a String with the size of the list
	public String toString() {
		return "Number of Customer: "+checkouts.size();
	}
	
	//Calls the Agents updateState methods to update their locations
	public void updateAgents() {
			for(CheckoutAgent a : checkouts) {
				if(a.size()>0) a.updateState(this);//Updates the state of CheckoutAgent a
			}
			for(CustomerAgent c: customers) {
				c.updateState(this);//Updates the state of CustomerAgent c
			}
	}
	
	//Loops through the list and calls their draw methods
	public void draw(Graphics g) {
		for(CheckoutAgent c: checkouts) {
			c.draw(g);//Calls the individual CheckoutAgent draw method
		}
		for(CustomerAgent a : customers) {
			a.draw(g);//Calls the individual CustomerAgent draw method
		}
		
		
		g.setColor(Color.LIGHT_GRAY);//Changes the color to light gray
		g.fillRect(0, 0, getWidth(), (int)(getHeight()*.2));//Draws a filled rectangle at the top of the JPanel 
		g.setColor(Color.BLACK);//Changes the color to black
		
		g.setFont(new Font("TimesRoman", Font.BOLD, 24));//Changes the font to times new roman, bold, and size 24
		
		if(customers.size()%100==0) {//for every 100 customers removed from customer list
			if(time1.size()!=0) {//if there is a time added for strategy 1
				dAvg1 = getAverage(time1);//retrieves the average for strategy 1 
				dStandard1 = getStandardDeviation(time1);//retrieves the standard deviation for strategy 1
			}
			if(time2.size()!=0) {//if there is a time added for strategy 2
				dAvg2 = getAverage(time2);//retrieves the average for strategy 2
				dStandard2 = getStandardDeviation(time2);//retrieves the standard deviation for strategy 2
			}
			if(time3.size()!=0) {//if there is a time added for strategy 3
				dAvg3 = getAverage(time3);//retrieves the average for strategy 3
				dStandard3 = getStandardDeviation(time3);//retrieves the standard deviation for strategy 3
			}
		}
		DecimalFormat df = new DecimalFormat("#.##");//Initializes the object of DecimalFormat
		
		int x0 = getWidth()/20;//Sets the x-position to be 20 percent of the width
		int y0 = getHeight()/7;//Sets the x-position to be 20 percent of the width
		
		g.drawString("Strategy 1 Average: "+dAvg1, x0, y0);//Draws the string to display the average for strategy 1
		g.drawString("Strategy 1 Standard Deviation: "+df.format(dStandard1), x0, y0+(getHeight()/40));//Draws the string to display the standard deviation for strategy 1
		
		g.drawString("Strategy 2 Average: "+dAvg2, x0*7, y0);//Draws the string the display the average for strategy 2
		g.drawString("Strategy 2 Standard Deviation: "+df.format(dStandard2), x0*7, y0+(getHeight()/40));//Draws the string to display the standard deviation for strategy 2
		
		g.drawString("Strategy 3 Average: "+dAvg3, x0*14, y0);//Draws the string the display the average for strategy 3
		g.drawString("Strategy 3 Standard Deviation: "+df.format(dStandard3),  x0*14, y0+(getHeight()/40));//Draws the string to display the standard deviation for strategy 3
	}
	
	public static void main(String[] args) {
		Landscape scape = new Landscape(100,100);//Initializes the Landscape object
		SpawnerAgent s = new SpawnerAgent(50, scape);//Spawns the CustomerAgents
		System.out.println(scape.customers.size());//Prints the size of the number of customers
		System.out.println(scape.getHeight());//Prints the height of scape
		System.out.println(scape.getWidth());//Prints the width of scape
		//System.out.println(scape.customers);
	}

}
