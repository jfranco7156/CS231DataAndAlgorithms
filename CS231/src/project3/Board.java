package project3;

import java.io.*;
import java.util.Scanner;

public class Board {
	private Cell[][] stack;
	public static int size = 9;
	static Scanner input;
	
	public Board() {
		input = new Scanner(System.in);
		stack = new Cell[size][size];
		for(int i=0; i<stack.length;i++) {
			for(int j=0; j<stack[i].length;j++) {
				stack[i][j] = new Cell(i,j,0);
			}
		}
	}
	
	public String toString() {
		String s = "";
		for(int i=0; i<stack.length;i++) {
			s+="\n";
			if(i%3==0 && i!=0) s+="\n";
			for(int j=0; j<stack[i].length;j++) {
				if(j%3==0) s+="  ";
				s += stack[i][j].getValue();
			}
		}
		return s;
	}
	
	public int getRows() {
		return stack.length;
	}
	
	public int getCols() {
		return stack[0].length;
	}
	
	public Cell getCell(int r, int c) {
		return stack[r][c];
	}
	
	public boolean isLocked(int r, int c) {
		return getCell(r,c).isLocked();
	}
	
	public int getValue(int r, int c) {
		return getCell(r,c).getValue();
	}
	
	public void setValue(int r, int c, int value) {
		getCell(r,c).setValue(value);
		System.out.println("Set value to "+value+" in row "+r+" and col "+c );
	}
	
	public void setLocked(int r, int c, int value, boolean locked) {
		getCell(r,c).setValue(value);
		getCell(r,c).setLocked(locked);
	}
	
	public boolean validValue(int row, int col, int value) {
		for(int i=0;i<getRows();i++) {
			if(i!=row && getValue(i,col)==value)return false;
		}
		for(int i=0;i<getCols();i++) {
			if(i!=col && getValue(row,i)==value)return false;
		}
		int cSec = Math.floorDiv(col, 3);
		int rSec = Math.floorDiv(row, 3);
		//System.out.println("cSec is "+cSec+"\nrSec is "+rSec);
		for(int i=3*rSec;i<3*rSec+3;i++) {
			for(int j=3*cSec;j<3*cSec+3;j++) {
				if(i==row && j==col);
				else {
					if(getValue(i,j)==value)return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean validSolution() {
		for(int i=0; i<getRows();i++) {
			for(int j=0; j<getCols();j++) {
				int val = getValue(i,j);
				if(val==0 || !validValue(i,j,val)) return false;
			}
		}
		
		return true;
	}
	
	public boolean read(String filename) {
	    try {
	    	FileReader fr = new FileReader(filename);
	    	BufferedReader br = new BufferedReader(fr);
	    	int i=0;
	    	while(true) {
	    		String s = br.readLine();
	    		if(s==null && i>=9) {
	    			break;//breaks the loop if the
	    		}
	    		else if(s==null);
	    		else {
	    			//s.replaceAll("\\s","");
	    			String[] strings = s.split("[ ]+");//Assigns a String array
	    			System.out.println(strings.length);//prints the size of the String array
	    			/*
	    			for(int k=0; k<strings.length; k++) {
	    				System.out.println(k+": "+strings[k]);
	    			}*/
	    			for(int j=0;j<strings.length;j++) {
	    				setValue(i,j,Integer.parseInt(strings[j]));
	    			}
	    			i++;
	    		}
	    	}
	    	br.close();
	    	return true;
	    }
	    catch(FileNotFoundException ex) {
	      System.out.println("Board.read():: unable to open file " + filename );
	    }
	    catch(IOException ex) {
	      System.out.println("Board.read():: error reading file " + filename);
	    }

	    return false;
	}
	
	public static String promptInput() {
		String userInput = input.nextLine();
		return userInput;
	}
	
	public static void main(String[] args) {
		Board b = new Board();
		//b.read("resources/test1.txt");
		//b.read("resources/test2.txt");
		//System.out.println(b.toString());
		//System.out.println("Cols: "+b.getRows()+"\nRows:"+b.getRows()+"\nCell has value "+b.getValue(0,0)+"\nand it is "+b.isLocked(0,0)+" that it is locked");//Testing the utility methods
		System.out.println("Please type in a path for a file...");
		//b.read(promptInput());
		b.read("resources/board_nsp_10_solved=.txt");
		for(int i=0;i<b.getRows();i++) {
			for(int j=0; j<b.getCols();j++) {
				System.out.println(b.validValue(i, j, b.getValue(i, j)));
			}
		}
	}

}
