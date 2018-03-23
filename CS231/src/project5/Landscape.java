package project5;

import java.awt.Color;
/* File: Landscape.java
* Author: Jenniber Franco
* Date: 03/12/2018
*/
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Random;

public class Landscape {
	//fields
	int width;//int to store the width of Landscape
	int height;//int to store the height of Landscape
	private ArrayList<CheckoutAgent> checkouts;
	private ArrayList<CustomerAgent> customers;
	
	public Landscape(int w, int h) {
		width = w;//Sets the width field to the w parameter
		height = h;//Sets the height field to the h parameter
		checkouts = new ArrayList<CheckoutAgent>();//new ArrayList<CheckoutAgent> is initiated
		customers = new ArrayList<CustomerAgent>();//new ArrayList<CustomerAgent> is initiated
	}
	
	public ArrayList<CheckoutAgent> getCheckout(){
		return checkouts;
	}
	
	public ArrayList<CustomerAgent> getCustomers(){
		return customers;
	}
	
	public void addCustomerAgent(CustomerAgent c) {
		customers.add(c);
	}
	
	public void addCheckoutAgent(CheckoutAgent c) {
		checkouts.add(c);
	}
	
	public int getHeight() {
		return height;//Returns the height field
	}
	
	public int getWidth() {
		return width;//Returns the width field
	}
	
	public String toString() {
		return "Number of Customer: "+checkouts.size();//Returns a String with the size of the list
	}
	
	//Calls the Agents updateState methods
	public void updateAgents() {
			for(CheckoutAgent a : checkouts) {
				if(a.size()>0) a.updateState(this);//Updates the state of Agent a
			}
			for(CustomerAgent c: customers) {
				c.updateState(this);
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
		
		//char [] rgc = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };

	   //g.drawChars(rgc, 0, 5, 25, 25);
	   //g.drawChars(rgc, 5, 5, 25, 50);
		g.setColor(Color.BLUE);
		//g.fillRect(getWidth()/20, getHeight()/20, (int)(getWidth()*.8), (int)(getHeight()*.2));
		//g.setColor(Color.WHITE);
	    g.drawString("WALMART", getWidth()/20, getHeight()/20);
	}
	
	public static void main(String[] args) {
		Landscape scape = new Landscape(100,100);//Initializes the Landscape object
		SpawnerAgent s = new SpawnerAgent(50, scape);
		System.out.println(scape.customers.size());
		System.out.println(scape.getHeight());//Prints the height of scape
		System.out.println(scape.getWidth());//Prints the width of scape
		//System.out.println(scape.customers);
	}

}
