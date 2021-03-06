package project2;
/**
 * File: Cell.java
 * Author: Jenniber Franco
 * Date: 02/26/2018
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Cell {
	private boolean alive;//field to store the status of the Cell
	
	//Constructor to create a new Cell and set the alive status to false
	public Cell() {
		alive = false;
	}
	
	//Constructor to create a new Cell and set the alive status according to the parameter
	public Cell(boolean alive) {
		this.alive = alive;
	}
	
	//Returns the status of the Cell
	public boolean getAlive(){
		return alive;
	}
	
	//Sets the status of the cell according to the parameter
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	//Returns a different type of string depending on the status of the Cell
	public String toString() {
		if(alive) return "0";
		return " ";
	}
	
	//Updates the state of the cell depending on the ArrayList neighbors parameter that is passed down
	public void updateState(ArrayList<Cell> neighbors) {
		int cellsAlive = 0;
		for(int i=0; i<neighbors.size(); i++) {
			if(neighbors.get(i).getAlive()) {
				cellsAlive++;//Adds one every time a neighbor of the cells is alive
			}
		}
		if(getAlive() && (cellsAlive==3 || cellsAlive>4)) {
			setAlive(true);//If the cell is alive and there are either 3 or more than 4 Cell neighbors that are alive, then the Cell is alive
		}
		else if(!getAlive() && cellsAlive==3){
			setAlive(true);//If the cell is dead and there is 3 Cell neighbors that are alive, then the Cell is alive
		}
		else if(getAlive() && cellsAlive==2) {
			setAlive(false);//If the cell is alive and there are 2 Cell neighbors that are alive, then the Cell is dead
		}
		else {
			setAlive(false);//If the above conditions fail, then the Cell is dead
		}
	}
	
	public void draw(Graphics g, int i, int j, int gridScale) {
		
		if(this.getAlive()) {
			g.setColor(new Color(149,32,32));
			g.fillRect(i,j,gridScale,gridScale);
		}
		else {
			g.setColor(new Color(71,77,161));
			g.fillRect(i,j,gridScale,gridScale);
		}
	}
	
	public static void main(String[] args) {
		Cell cell1 = new Cell();
		Cell cell2 = new Cell(true);
		
		System.out.println(cell1.toString());
		System.out.println(cell2.toString());
		cell1.setAlive(true);
		System.out.println(cell1.toString());
	}

}
