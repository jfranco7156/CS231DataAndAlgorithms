package project4;
/**
 * File: CategorizedSocialAgentSimulation.java
 * Author: Jenniber Franco
 * Date: 03/12/2018
 */
import java.util.Random;

public class CategorizedSocialAgentSimulation{

	public static void main(String[] args) throws InterruptedException {
        Landscape scape = new Landscape(400,400);//Creates a new Landscape object
        Random gen = new Random();//Initializes a Random object
        for(int i=0;i<200;i++) {
			scape.addAgent( new CategorizedSocialAgent( gen.nextDouble() * scape.getWidth(),
				 gen.nextDouble() * scape.getHeight(), gen.nextInt(3) ) );//Adds a CategorizedSocialAgent to scape
		}
        
        LandscapeDisplay display = new LandscapeDisplay(scape);//Initializes a new LandscapeDisplay
        for(int i=0; i< 100; i++) {
        	scape.updateAgents();//Calls the updateAgents to update the position of Agents
        	display.repaint();//Repaints the display window
        	Thread.sleep(250);//Makes the thread sleep for 250 milliseconds
        }
	}

}