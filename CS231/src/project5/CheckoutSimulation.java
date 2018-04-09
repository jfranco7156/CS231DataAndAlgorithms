package project5;
/**
 * File: CheckoutSimulation.java
 * Author: Jenniber Franco
 * Date: 03/23/2018
 */
public class CheckoutSimulation {
	private static Landscape scape;
	
	public static void main(String[] args) throws InterruptedException {
		scape = new Landscape(1500,1500);//Creates a new Landscape object
		new SpawnerAgent(2000,scape);//Adds the customers to the scape
		
		for(int i=0; i<6; i++) {
			scape.addCheckoutAgent(new CheckoutAgent((scape.getWidth()/15)+(.15*i)*scape.getWidth(),0.9*scape.getHeight()));//Adds a checkout agent to the scape
		}
		
		LandscapeDisplay display = new LandscapeDisplay(scape);//Initializes a new LandscapeDisplay
		
		for(int i=0; i<2500; i++) {
			scape.updateAgents();//Calls the updateAgents to update the position of Agents
        	display.repaint();//Repaints the display window
        	Thread.sleep(200);//Makes the thread sleep for 250 milliseconds
		}
	}

}
