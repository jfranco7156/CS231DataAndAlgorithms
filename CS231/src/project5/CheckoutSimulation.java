package project5;

import java.util.ArrayList;

public class CheckoutSimulation {
	private static Landscape scape;
	
	public static void main(String[] args) throws InterruptedException {
		scape = new Landscape(1000,1000);//Creates a new Landscape object
		SpawnerAgent s = new SpawnerAgent(2000,scape);
		
		for(int i=0; i<6; i++) {
			scape.addCheckoutAgent(new CheckoutAgent((scape.getWidth()/15)+(.15*i)*scape.getWidth(),0.9*scape.getHeight()));
		}
		
		LandscapeDisplay display = new LandscapeDisplay(scape);//Initializes a new LandscapeDisplay
		
		for(int i=0; i<5; i++) {
			//System.out.println("There are "+ scape.getCustomers().size());
        	scape.updateAgents();//Calls the updateAgents to update the position of Agents
        	display.repaint();//Repaints the display window
        	Thread.sleep(200);//Makes the thread sleep for 250 milliseconds
		}
		
		while(customersLeft()) {
			System.out.println("There are "+ scape.getCustomers().size());
        	scape.updateAgents();//Calls the updateAgents to update the position of Agents
        	display.repaint();//Repaints the display window
        	Thread.sleep(50);//Makes the thread sleep for 250 milliseconds
        }
		
		//System.exit(0);
	}
	
	public static boolean customersLeft() {
		ArrayList<CheckoutAgent> checkouts = scape.getCheckout();
		for(int i=0; i<checkouts.size(); i++) {
			if(checkouts.get(i).size()>0) return true;
		}
		System.out.println("false");
		return false;//returns false when no checkout aisle has a customer
	}

}
