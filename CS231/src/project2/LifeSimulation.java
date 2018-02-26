package project2;

import java.util.Random;

/**
 * Create a new LifeSimulation.java class that is modeled on LandscapeDisplay.main(). It should include a loop that (1 iteration per time step) calls the advance() method of the Landscape, calls the repaint() method of LandscapeDisplay, and calls Thread.sleep( 250 ) to pause for 250 milliseconds between time steps.

Test your simulation with random initial conditions. Consider using a command line argument to control the grid size and the number of time steps in the simulation.

If you want to test your program using a known pattern, go to the Wikipedia page on the Game of Life and look up an example. Then create a new initialization method that sets the Landscape to the specified pattern.

Now make an animated gif so that you can include the output of your simulation in your write-up. After the display is repainted (in the loop you wrote above), add the following line:

display.saveImage( "data/life_frame_" + String.format( "%03d", i ) + ".png" 
 * */
public class LifeSimulation{

	public static void main(String[] args) throws InterruptedException {
        Landscape scape = new Landscape(200,200);
        Random gen = new Random();
        double density = 0.3;
        for (int i = 0; i < scape.getRows(); i++) {
            for (int j = 0; j < scape.getCols(); j++ ) { 
                scape.getCell( i, j ).setAlive( gen.nextDouble() <= density );
            }
        }
        
        LandscapeDisplay display = new LandscapeDisplay(scape, 4);
        for(int i=0; i< 20; i++) {
        	scape.advance();
        	display.repaint();
        	Thread.sleep(250);
        }
	}

}
