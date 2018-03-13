package project4;
import java.awt.Color;
/**
 * File: CategorizedSocialAgent.java
 * Author: Jenniber Franco
 * Date: 03/12/2018
 */
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class CategorizedSocialAgent extends SocialAgent {
	int cat;//field to set the category
	
	public CategorizedSocialAgent(double x0, double y0, int cat) {
		super(x0, y0);//Calls the super class constructor
		this.cat = cat;
	}

	public int getCategory() {
		return cat;//Returns the category of the CategorizedSocialAgent
	}
	
	public String toString() {
		return "The categroy is "+cat;//Returns the category of the CategorizedSocialAgent in a String
	}
	
	//Updates the x and y-coordinate of CategorizedSocialAgent's
	public void updateState(Landscape scape) {
		Random rand = new Random();//Initializes Random type variable
		
		double randNum = rand.nextDouble();//Generates a random double number between and 1.0
		double randX = rand.nextDouble()*5;//Generates a random double number between and 1.0 and multiplies by 5
		double randY = rand.nextDouble()*5;//Generates a random double number between and 1.0 and multiplies by 5
		
		if(rand.nextInt(2)==0)randX = randX*-1;//Generates a random integer between 0 and 2 and if the integer is 1, then it sets the randX to a negative
		if(rand.nextInt(2)==0)randY = randY*-1;//Generates a random integer between 0 and 2 and if the integer is 1, then it sets the randY to a negative
		
		int sameCat = 0;//Stores the number of Agents with the same categories
		
		ArrayList<Agent> neighbors =scape.getNeighbors(getX0(), getY0(), 20);
		for(Agent a : neighbors) {
			if(((CategorizedSocialAgent) a).getCategory()==getCategory()) {
				sameCat++;//Increments by one if the same CategorizedSocialAgent is in the same category
			}
		}
		
		int difCat = neighbors.size()-sameCat;//Stores the number of Agents with different categories
		
		if(sameCat>=1) {
			if(randNum<=0.01) {
				setX0(getX0()+randX);//Set x0 to its value plus the value of the randomly generated double
				setY0(getY0()+randY);//Set y0 to its value plus the value of the randomly generated double
			}
		}
		else {
			setX0(getX0()+randX);//Set x0 to its value plus the value of the randomly generated double
			setY0(getY0()+randY);//Set ys0 to its value plus the value of the randomly generated double
		}
	}
	
	//Draws and centers the CategorizedSocialAgent
	public void draw(Graphics g) {
		int cX = (int) (getX0()-2.5);//Creates a center for x-coordinate
		int cY = (int) (getY0()-2.5);//Creates a center for y-coordinate
		
		//EXTENSION: Edited graphics color to differentiate between categories
		if(getCategory()==0) {
			g.setColor(Color.RED);//Sets the graphics color to red
		}
		else if(getCategory()==1) {
			g.setColor(Color.BLUE);//Sets the graphics color to blue
		}
		else if(getCategory()==2) {
			g.setColor(Color.GREEN);//Sets the graphics color to green
		}
		
		
		g.fillOval(cX, cY, 5, 5);//Draws the CategorizedSocialAgent using graphics
	}

	public static void main(String[] args) {
		SocialAgent a = new SocialAgent(1,3);//Initializes a new CategorizedSocialAgent object
		System.out.println(a.toString());//Prints the position of CategorizedSocialAgent a
		a.setX0(5);//Changes the x-coordinate of CategorizedSocialAgent a
		a.setY0(7);//Changes the y-coordinate of CategorizedSocialAgent a
		System.out.println(a.toString());//Prints the position of CategorizedSocialAgent a
	}

}
