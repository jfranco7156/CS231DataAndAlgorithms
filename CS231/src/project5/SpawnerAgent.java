package project5;
/**
 * File: SpawnerAgent.java
 * Author: Jenniber Franco
 * Date: 03/23/2018
 */
import java.util.Random;

public class SpawnerAgent{
	/*
	 * Constructor that only requires the total number of customers to spawn and the scape
	 */
	public SpawnerAgent(int numCust, Landscape scape) {
		Random rand = new Random();//Initializes a Random object
		for(int i=0;i<numCust;i++) {
			scape.addCustomerAgent( new CustomerAgent( rand.nextDouble() * scape.getWidth(),
				 rand.nextDouble() * scape.getHeight(), rand.nextInt(3)+1 ) );//Adds a customer agent to Landscape
		}
	}
	
	/*
	 * Constructor that takes 3 integers to represent the number of customers to generate for each strategy
	 * strategy1C - Generates the number of customers using strategy 1
	 * strategy2C - Generates the number of customers using strategy 2
	 * strategy3C - Generates the number of customers using strategy 3
	 */
	public SpawnerAgent(int strategy1C, int strategy2C, int strategy3C, Landscape scape) {
		Random rand = new Random();//Initializes a Random object
		for(int i=0;i<strategy1C;i++) {
			scape.addCustomerAgent( new CustomerAgent( rand.nextDouble() * scape.getWidth(),
				 rand.nextDouble() * scape.getHeight(), 1 ) );//Adds an agent to Landscape with strategy 1
		}
		
		for(int i=0;i<strategy2C;i++) {
			scape.addCustomerAgent( new CustomerAgent( rand.nextDouble() * scape.getWidth(),
				 rand.nextDouble() * scape.getHeight(), 2 ) );//Adds an agent to Landscape with strategy 2
		}
		
		for(int i=0;i<strategy3C;i++) {
			scape.addCustomerAgent( new CustomerAgent( rand.nextDouble() * scape.getWidth(),
				 rand.nextDouble() * scape.getHeight(), 3 ) );//Adds an agent to Landscape with strategy 3
		}
	}
	
}
