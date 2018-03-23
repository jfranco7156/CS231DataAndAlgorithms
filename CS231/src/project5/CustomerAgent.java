package project5;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import project4.Agent;

public class CustomerAgent extends Agent {
	//fields
	private int items;//Stores the number of items the Customesr has
	private String state;//Stores the state in which the Agent is in
	private int timeStep;//Stores the time (will be decrmented)
	private int strategy;
	private int waitTime;//Constant time (will increment in the simualtion)
	
	public CustomerAgent(double x0, double y0, int strategy) {
		super(x0, y0);
		items = 1;
		state = "selection";
		this.strategy = strategy;
		if(strategy==0) {
			timeStep = 1;
			waitTime = 1;
		}
		else if(strategy==1) {
			timeStep = 2;
			waitTime = 2;
		}
		else if(strategy==2) {
			timeStep = 4;
			waitTime = 4;
		}
		else {
			timeStep = 0;
			waitTime = 0;
			System.out.println("Please enter a valid type of Strategy");
			System.exit(0);
		}
		
	}
	
	public void updateState(Landscape scape) {
		if(state.equals("selection")) {
			if(timeStep>0) {
				this.timeStep--;
				return;
			}
			Random rand = new Random();
			int totalLanes = scape.getCheckout().size();
			if(strategy==0) {
				int lane = rand.nextInt(totalLanes);
				timeStep = scape.getCheckout().get(lane).size();
				scape.getCheckout().get(lane).addCustomer(this);
			}
			else if(strategy==1) {
				int lane1 = rand.nextInt(totalLanes);
				int lane2;
				do {
					lane2 = rand.nextInt(totalLanes);
				}while(lane2==lane1);
				if(scape.getCheckout().get(lane1).size()<scape.getCheckout().get(lane2).size()) {
					timeStep = scape.getCheckout().get(lane1).size();
					scape.getCheckout().get(lane1).addCustomer(this);
				}
				else {
					timeStep = scape.getCheckout().get(lane2).size();
					scape.getCheckout().get(lane2).addCustomer(this);
				}
			}
			else if(strategy==2) {
				int shortestLine = 0;
				int shortestCust = scape.getCheckout().get(0).size();
				for(int i=1; i < scape.getCheckout().size(); i++) {
					if(scape.getCheckout().get(i).size()<shortestCust) {
						shortestCust = scape.getCheckout().get(i).size();
						shortestLine = i;
					}
				}
				timeStep = scape.getCheckout().get(shortestLine).size();
				scape.getCheckout().get(shortestLine).addCustomer(this);
			}
			state = "waiting";
			return;
		}
		else if(state.equals("waiting")) {
			waitTime++;
			timeStep--;
			return;
		}
		else if(state.equals("checkout"))return; 
	}
	
	public int getItems() {
		return items;
	}
	
	public void setItems(int items) {
		this.items = items;
	}

	public int getWait() {
		return waitTime;
	}
	
	public void setWait(int t) {
		waitTime = t;
	}
	
	public void setState(String s) {
		state = s;
	}
	
	//Draws rectangle at the coordinates to represent an CustomerAgent
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);//Changes the color of the graphics component to blue to distinguish the customer
		g.fillRect((int)getX0(), (int)getY0(), 10, 10);//Draws a filled rectangle to represent the customer
		if(state.equals("checkout") && items==0) g.clearRect((int)getX0(), (int)getY0(), 10, 10);
	}	
}
