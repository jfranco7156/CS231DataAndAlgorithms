package project5;

import java.util.Random;

public class SpawnerAgent{
	
	public SpawnerAgent(int numCust, Landscape scape) {
		Random rand = new Random();
		for(int i=0;i<numCust;i++) {
			scape.addCustomerAgent( new CustomerAgent( rand.nextDouble() * scape.getWidth(),
				 rand.nextDouble() * scape.getHeight(), rand.nextInt(3) ) );//Adds an agent to Landscape
		}
	}
	
	public void spawnMoreCustomers(int numCust, Landscape scape) {
		Random rand = new Random();
		for(int i=0;i<numCust;i++) {
			scape.addCustomerAgent( new CustomerAgent( rand.nextDouble() * scape.getWidth(),
				 rand.nextDouble() * scape.getHeight(), rand.nextInt(3) ) );//Adds an agent to Landscape
		}
	}
	
}
