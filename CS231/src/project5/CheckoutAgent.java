package project5;

import java.awt.Color;
import java.awt.Graphics;

public class CheckoutAgent extends Agent {
	//fields
	private MyQueue<CustomerAgent> aisle;
	
	public CheckoutAgent(double x0, double y0) {
		super(x0, y0);
		aisle = new MyQueue<CustomerAgent> ();
	}
	
	public MyQueue<CustomerAgent> getAisle(){
		return aisle;
	}
	
	public CustomerAgent checkoutCustomer() {
		return aisle.poll();
	}
	
	public void addCustomer(CustomerAgent c) {
		aisle.offer(c);
		c.setX0(getX0()+20);
		c.setY0(getY0()-(20*(size()-1)));
	}
	
	public int size() {
		return aisle.size();
	}
	
	//Checkout the Customer if it has a 
	public void updateState(Landscape scape) {
		if(size()==0) {
			return;
		}
		else if(size()>0) {
			CustomerAgent cust = aisle.peek();
			cust.setState("checkout");
			if(cust.getItems()>0) cust.setItems(cust.getItems()-1);
			else {
				aisle.poll();//returns and removes the first CustomerAgent in the queue
				int i = 0;
				for (CustomerAgent customer: aisle) {
					customer.setY0(getY0()-20*i);
					i++;
				}
			}
		}
	}
		
	//Draws a circle centered at the coordinates to represent an Agent
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int)getX0(), (int)getY0(), 10, 30);//Draws the CustomerAgent using graphics
	}
	
	public static void main(String[] args) {
		CheckoutAgent c = new CheckoutAgent(100,100);
		
	}
	
}
