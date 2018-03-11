package project3;

/**
 * File: Board.java
 * Author: Jenniber Franco
 * Date: 03/05/2018
 */

import java.awt.Font;
import java.awt.Graphics;
import java.io.*;
import java.util.Scanner;

public class Board {
	//fields
	private Cell[][] stack;//stores the 2D-array of cells
	public static int size = 9;
	static Scanner input;//Scanner field to take user input
	
	//constructor
	public Board() {
		input = new Scanner(System.in);//new Scanner item is initiated
		stack = new Cell[size][size];//Creates a new array with size 9 by 9
		for(int i=0; i<stack.length;i++) {
			for(int j=0; j<stack[i].length;j++) {
				stack[i][j] = new Cell(i,j,0);//Creates a new Cell in stack[i][j]
			}
		}
	}
	
	//Generates a string version of the stack
	public String toString() {
		String s = "";//Creates a string variable s
		for(int i=0; i<stack.length;i++) {
			s+="\n";//Adds to s to go to next line
			if(i%3==0 && i!=0) s+="\n";//Adds to s to go to next line if imod3==0 and i is not equal to 0. 
			for(int j=0; j<stack[i].length;j++) {
				if(j%3==0) s+="  ";//Creates a space for every 3rd number to generate columns
				s += stack[i][j].getValue();//Adds the value of the Cell to the string
			}
		}
		return s;//returns the string
	}
	
	//Returns the number of rows in stack
	public int getRows() {
		return stack.length;
	}
	
	//returns the number of columns in stack
	public int getCols() {
		return stack[0].length;
	}
	
	//returns the Cell in row r and column c
	public Cell getCell(int r, int c) {
		return stack[r][c];
	}
	
	//returns a boolean value of whether the cell in row r and column c is locked or not
	public boolean isLocked(int r, int c) {
		return getCell(r,c).isLocked();
	}
	
	//returns the value of the cell in row r and column c
	public int getValue(int r, int c) {
		return getCell(r,c).getValue();
	}
	
	//Sets the value of Cell in row r and column c to the value parameter
	public void setValue(int r, int c, int value) {
		getCell(r,c).setValue(value);
	}
	
	//Sets the value and locked of Cell in row r and column c to the value parameter and locked parameter
	public void setLocked(int r, int c, int value, boolean locked) {
		getCell(r,c).setValue(value);
		getCell(r,c).setLocked(locked);
	}
	
	//returns whether value in row and column is valid according to sudoku rules
	public boolean validValue(int row, int col, int value) {
		for(int i=0;i<getRows();i++) {
			if(i!=row && getValue(i,col)==value)return false;//returns false if the same value is in another row
			if(i!=col && getValue(row,i)==value)return false;//returns false if the same value is in another column
		}
		int cSec = Math.floorDiv(col, 3);//floors and stores the returned value of col divided by 3
		int rSec = Math.floorDiv(row, 3);//floors and stores the returned value of row divided by 3
		for(int i=3*rSec;i<3*rSec+3;i++) {
			for(int j=3*cSec;j<3*cSec+3;j++) {
				if(i==row && j==col);//does not do anything if i and j are equal to row and column
				else {
					if(getValue(i,j)==value)return false;//returns false if the same value is found within the smaller 3 by 3 in baord
				}
			}
		}
		
		return true;//returns true if none of the above conditions are met
	}
	
	//Returns whether the entire board is a valid solution
	public boolean validSolution() {
		for(int i=0; i<getRows();i++) {
			for(int j=0; j<getCols();j++) {
				int val = getValue(i,j);//stores the value in row i and column j
				if(val==0 || !validValue(i,j,val)) return false;//returns false if value is 0 or it is not a valid value
			}
		}
		
		return true;//returns true if none of the above conditions are met
	}
	
	public boolean read(String filename) {
	    try {
	    	FileReader fr = new FileReader(filename);//Creates a FileReader type of the filename
	    	BufferedReader br = new BufferedReader(fr);//Creates a BufferedReader type of fr
	    	int i=0;//Creates and sets int i to 0
	    	while(true) {
	    		String s = br.readLine();//reads the line in BufferedReader
	    		if(s==null)break;//breaks the loop if s is null
	    		else {
	    			String[] strings = s.split("[ ]+");//Assigns a String array by splitting s
	    			for(int j=0;j<strings.length;j++) {
	    				if(Integer.parseInt(strings[j])!=0) {//if the int value of string is not equal to 0
	    					setLocked(i,j,Integer.parseInt(strings[j]),true);//Set the cell to locked in position i,j with value of the string
	    				}
	    				else {
	    					setValue(i,j,Integer.parseInt(strings[j]));//Set the cell to value in position i,j
	    				}
	    			}
	    			i++;//increment i
	    		}
	    	}
	    	br.close();//close BufferedReader
	    	return true;//return true
	    }
	    catch(FileNotFoundException ex) {
	    	//returns the message of the file is not found
	      System.out.println("Board.read():: unable to open file " + filename );
	    }
	    catch(IOException ex) {
	    	//returns the message if it could not properly read the file
	      System.out.println("Board.read():: error reading file " + filename);
	    }

	    return false;//return false
	}
	
	//returns the input of user when prompted
	public static String promptInput() {
		String userInput = input.nextLine();//Stores the users input
		return userInput;//returns the users input
	}
	
	//Draws the board using graphics
	public void draw(Graphics g, int scale) {
		g.drawRect(0, 0, scale*9, scale*9);//Draws a rectangle to display the baord
		g.drawLine(scale*3, 0, scale*3, scale*9);//Draws a line to create a section
		g.drawLine(scale*6, 0, scale*6, scale*9);//Draws a line to create a section
		g.drawLine(0, scale*3, scale*9, scale*3);//Draws a line to create a section
		g.drawLine(0, scale*6, scale*9, scale*6);//Draws a line to create a section
		g.setFont(new Font("Dialog",Font.PLAIN,scale));//Sets the font to write the cell values
		
		for(int i=0;i<getRows();i++) {
			for(int j=0; j<getCols();j++) {
				getCell(i,j).draw(g,20+j*scale,90+i*scale, scale);//Calls the draw method of cell i,j
			}
		}
	}
	
	public static void main(String[] args) {
		Board b = new Board();
		//b.read("resources/test1.txt");
		//b.read("resources/test2.txt");
		//System.out.println(b.toString());
		//System.out.println("Cols: "+b.getRows()+"\nRows:"+b.getRows()+"\nCell has value "+b.getValue(0,0)+"\nand it is "+b.isLocked(0,0)+" that it is locked");//Testing the utility methods
		System.out.println("Please type in a path for a file...");
		//b.read(promptInput());
		b.read("resources/board_nsp_10_solved.txt");
		for(int i=0;i<b.getRows();i++) {
			for(int j=0; j<b.getCols();j++) {
				System.out.println(b.validValue(i, j, b.getValue(i, j)));
			}
		}
	}

}
