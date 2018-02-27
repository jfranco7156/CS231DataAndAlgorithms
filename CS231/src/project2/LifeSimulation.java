package project2;
/**
 * File: LifeSimulation.java
 * Author: Jenniber Franco
 * Date: 02/26/2018
 */
import java.util.Random;

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
