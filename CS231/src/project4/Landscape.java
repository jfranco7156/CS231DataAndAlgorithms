package project4;
/**
 * File: Landscape.java
 * Author: Jenniber Franco
 * Date: 03/12/2018
 */
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Landscape {
	//fields
	int width;//int to store the width of Landscape
	int height;//int to store the height of Landscape
	LinkedList<Agent> list;
	
	public Landscape(int w, int h) {
		width = w;//Sets the width field to the w parameter
		height = h;//Sets the height field to the h parameter
		list = new LinkedList<Agent>();//new LinkedList<Agent> is initiated
	}
	
	public int getHeight() {
		return height;//Returns the height field
	}
	
	public int getWidth() {
		return width;//Returns the width field
	}
	
	public void addAgent(Agent a) {
		list.addFirst(a);//Adds an Agent to the list
	}
	
	public String toString() {
		return "Number of Agents: "+list.size();//Returns a String with the size of the list
	}
	
	public ArrayList<Agent> getNeighbors(double x0, double y0, double radius){
		ArrayList<Agent> agents = new ArrayList<Agent>();//
		for(Agent a : list) {
			//Applied the distance formula to determine the distance between the Agent a and the position (x0,y0)
			double distance = Math.sqrt((Math.pow(a.getX0()-x0,2)+Math.pow(a.getY0()-y0, 2)));
			if(distance < radius && distance!=0) {
				agents.add(a);//Adds the Agent a to the list if the distance is less than the radius and not equal to 0
			}
		}
		return agents;//Returns the ArrayLst of agents
	}
	
	//Calls the Agents updateState methods
	public void updateAgents() {
		ArrayList<Agent> list = this.list.toShuffledList();//Returns the ArrayList of Agents that are shuffled
		for(Agent a : list) {
			a.updateState(this);//Updates the state of Agent a
		}
	}
	
	//Loops through the list and calls their draw methods
	public void draw(Graphics g) {
		for(Agent a : list) {
			a.draw(g);//Calls the individual Agent draw method
		}
	}
	
	public static void main(String[] args) {
		Landscape scape = new Landscape(100,100);//Initializes the Landscape object
		Random gen = new Random();//Initializes the Random object
		for(int i=0;i<200;i++) {
			scape.addAgent( new SocialAgent( gen.nextDouble() * scape.getWidth(),
				 gen.nextDouble() * scape.getHeight() ) );//Adds an agent to Landscape
		}
		System.out.println(scape.getHeight());//Prints the height of scape
		System.out.println(scape.getWidth());//Prints the width of scape
		System.out.println(scape.getNeighbors(10,10,25));//Prints the neighbors of scape
	}

}
