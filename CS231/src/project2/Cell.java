package project2;

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
		if(getAlive() && (cellsAlive==2 || cellsAlive==3)) {
			setAlive(false);//If the cell is alive and there are either 2 or 3 Cell neighbors that are alive, then the Cell is dead
		}
		else if(!getAlive() && cellsAlive==3){
			setAlive(true);//If the cell is dead and there is 3 Cell neighbors that are alive, then the Cell is alive
		}
		else {
			setAlive(false);//If the above conditions fail, then the Cell is dead
		}
	}
	
	public void draw(Graphics g, int i, int j, int gridScale) {
		if(this.getAlive()) {
			g.drawRect(i,j,gridScale,gridScale);
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
