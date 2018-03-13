package project4;
import java.awt.Color;
/**
 * File: SocialAgent.java
 * Author: Jenniber Franco
 * Date: 03/12/2018
 */
import java.awt.Graphics;
import java.util.Random;
/**
 * File: SocialAgent.java
 * Author: Jenniber Franco
 * Date: 03/12/2018
 */
public class SocialAgent extends Agent {

	public SocialAgent(double x0, double y0) {
		super(x0, y0);//Calls the super class constructor
	}
	
	//Updates the x and y-coordinate of CategorizedSocialAgent's
	public void updateState(Landscape scape) {
		Random rand = new Random();//Initializes Random type variable
		
		double randX = rand.nextDouble()*5;//Generates a random double number between and 1.0 and multiplies by 5
		double randY = rand.nextDouble()*5;//Generates a random double number between and 1.0 and multiplies by 5
		
		if(rand.nextInt(2)==0)randX = randX*-1;//Generates a random integer between 0 and 2 and if the integer is 1, then it sets the randX to a negative
		if(rand.nextInt(2)==0)randY = randY*-1;//Generates a random integer between 0 and 2 and if the integer is 1, then it sets the randY to a negative
		
		if(scape.getNeighbors(getX0(), getY0(), 15).size()>3) {
			double randNum = rand.nextDouble();//Generates a random double number between and 1.0
			if(randNum<=0.01) {
				setX0(getX0()+randX);//Set x0 to its value plus the value of the randomly generated double
				setY0(getY0()+randY);//Set y0 to its value plus the value of the randomly generated double
			}
		}
		else {
			setX0(getX0()+randX);//Set x0 to its value plus the value of the randomly generated double
			setY0(getY0()+randY);//Set y0 to its value plus the value of the randomly generated double
		}
	}
	
	//Draws and centers the SocialAgent
	public void draw(Graphics g) {
		int cX = (int) (getX0()-2.5);//Creates a center for x-coordinate
		int cY = (int) (getY0()-2.5);//Creates a center for y-coordinate
		
		g.setColor(Color.MAGENTA);//Sets the graphics color to magenta
		
		g.fillOval(cX, cY, 5, 5);//Draws the CategorizedSocialAgent using graphics
	}
	
	public static void main(String[] args) {
		SocialAgent a = new SocialAgent(1,3);//Initializes a new SocialAgent object
		System.out.println(a.toString());//Prints the position of SocialAgent a
		a.setX0(5);//Changes the x-coordinate of SocialAgent a
		a.setY0(7);//Changes the y-coordinate of SocialAgent a
		System.out.println(a.toString());//Prints the position of SocialAgent a
	}
}
