package project3;

/**
 * File: Cell.java
 * Author: Jenniber Franco
 * Date: 03/05/2018
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Cell {
	//fields
	private int row;//store the row in which the cell is stored on the grid
	private int col;//store the column in which the cell is stored on the grid
	private int value;//store the value of the cell
	private boolean locked;//boolean to determine whether the value can be changed or not
	
	//constructor to initialize the Cell
	public Cell() {
		row = 0;//initializes the row to 0
		col = 0;//initializes the column to 0
		value = 0;//initializes the value to 0
		locked = false;//sets lock to false
	}
	
	public Cell(int row, int col, int value) {
		this.row = row;//initializes the row field to the row parameter
		this.col = col;//initializes the column field to the column parameter
		this.value = value;//initializes the value field to the value parameter
		locked = false;//sets lock to false
	}
	
	public Cell(int row, int col, int value, boolean locked) {
		this.row = row;//initializes the row field to the row parameter
		this.col = col;//initializes the column field to the column parameter
		this.value = value;//initializes the value field to the value parameter
		this.locked = locked;//initializes the locked field to the locked parameter
	}
	
	//returns the int row field
	public int getRow() {
		return row;
	}

	//returns the int column field
	public int getCol() {
		return col;
	}
	
	//returns the int value field
	public int getValue() {
		return value;
	}

	//sets the value field to the value parameter
	public void setValue(int value) {
		this.value = value;
	}

	//returns the boolean locked field
	public boolean isLocked() {
		return locked;
	}

	//sets the locked field to the locked parameter
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	//creates a new cell with the same fields as its parent cell
	public Cell clone() {
		return new Cell(row, col, value, locked);
	}
	
	//returns a String stating the value, row, column, and whether the cell is locked or not.
	public String toString() {
		String l = " not locked";
		if(locked) l = " locked";
		return "The value "+value+" is in row "+row+" and col "+col+ " and it is"+l+".";
	}
	
	//Draws out the Cell value using Graphics
	public void draw(Graphics g, int x0, int y0, int scale) {
		Random rand = new Random();//Creates a new Random()
		float r = rand.nextFloat();//Generates a random Float from 0 to 1
		float gr = rand.nextFloat();//Generates a random Float from 0 to 1
		float b = rand.nextFloat();//Generates a random Float from 0 to 1
		Color randC = new Color(r,gr,b);//Creates a new color with the stored r, gr, and b
		
		g.setColor(randC);//Sets the color of graphics to the randomly generated color
		
		g.drawString(String.valueOf(this.value), x0, y0);//Draws the String with the value of the x0 and y0
	}
	
	public static void main(String[] args) {
		Cell c1 = new Cell();//Creates a new cell with no parameter
		Cell c2 = new Cell(2,3,1);//Creates a new cell with determined value at row and column
		Cell c3 = new Cell(1,1,5,false);//Creates a new cell with determined value at row and column and determined whether it is locked or not
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
}
