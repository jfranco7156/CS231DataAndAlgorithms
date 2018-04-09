package project5;
/**
 * File: Agent.java
 * Author: Jenniber Franco
 * Date: 03/12/2018
 */
import java.awt.Graphics;

public class Agent {
	//fields
	double x0;//Stores the x-coordinate of the Agent
	double y0;//Stores the y-coordinate of the Agent
	
	public Agent(double x0, double y0) {
		this.x0 = x0;//Sets the x0 field to the x0 parameter
		this.y0 = y0;//Sets the y0 field to the y0 parameter
	}
	
	public double getX0() {
		return x0;//Returns the x0 field
	}

	public double getY0() {
		return y0;//Returns the y0 field
	}
	
	public void setX0(double x0) {
		this.x0 = x0;//Sets the x0 field to the x0 parameter
	}

	public void setY0(double y0) {
		this.y0 = y0;//Sets the y0 field to the y0 parameter
	}
	
	@Override
	public String toString() {
		return getX0()+", "+getY0();//Returns a string of the x0 and y0 integers
	}

	//A method that currently does not do anything
	public void updateState(Landscape scape) {
		
	}
	
	//A method that does not do anything
	public void draw(Graphics g) {
		
	}
	
	public static void main(String[] args) {
		Agent a = new Agent(1,3);//Initializes a new Agent
		System.out.println(a.toString());//Prints the position of Agent a
		a.setX0(5);//Changes the x-coordinate of Agent a
		a.setY0(7);//Changes the y-coordinate of Agent a
		System.out.println(a.toString());//Prints the position of Agent a
	}

}