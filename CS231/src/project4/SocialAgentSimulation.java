package project4;
/**
 * File: SocialAgentSimulation.java
 * Author: Jenniber Franco
 * Date: 03/12/2018
 */
import java.util.Random;

public class SocialAgentSimulation{

	public static void main(String[] args) throws InterruptedException {
        Landscape scape = new Landscape(400,400);//Creates a new Landscape object
        Random gen = new Random();//Initializes a Random object
        for(int i=0;i<200;i++) {
			scape.addAgent( new SocialAgent( gen.nextDouble() * scape.getWidth(),
				 gen.nextDouble() * scape.getHeight() ) );//Adds a SocialAgent to scape
		}
        
        LandscapeDisplay display = new LandscapeDisplay(scape);//Initializes a new LandscapeDisplay
        for(int i=0; i< 100; i++) {
        	scape.updateAgents();//Calls the updateAgents to update the position of Agents
        	display.repaint();//Repaints the display window
        	Thread.sleep(250);//Makes the thread sleep for 250 milliseconds
        }
	}

}