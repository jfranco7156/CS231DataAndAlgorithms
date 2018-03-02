package project2;
/**
 * File: Landscape.java
 * Author: Jenniber Franco
 * Date: 02/26/2018
 */
import java.awt.Graphics;
import java.util.ArrayList;

public class Landscape {
	private Cell grid[][];//field to store the information of each Cell on the grid
	
	//Constructor to make the Landscape class
	public Landscape(int rows, int cols) {
		grid = new Cell[rows][cols];//Initializes the field grid with rows and cols from the parameter
		for(int r=0; r<rows; r++) {
			for(int c=0; c<cols; c++){
				grid[r][c] = new Cell();//Creates a new Cell in grid[r][c]
			}
		}
	}
	
	//Resets all the Cells in the grid to false
	public void reset() {
		for(int r=0; r<getRows(); r++) {
			for(int c=0; c<getCols(); c++) {
				grid[r][c].setAlive(false);
			}
		}
	}
	
	//Returns the number of rows in the grid
	public int getRows() {
		return grid.length;
	}
	
	//Returns the number of columns in the grid
	public int getCols() {
		return grid[0].length;
	}
	
	//Returns Cell in row,col from the grid field
	public Cell getCell(int row, int col) {
		return grid[row][col];
	}
	
	//Returns a string of the cells aligned according to the grid
	public String toString() {
		String s = "";
		for(int r=0;r<getRows();r++) {
			for(int c=0;c<getCols();c++) {
				s += getCell(r,c).toString()+" ";
			}
			s += "\n";
		}
		return s;
	}
	
	//Returns an ArrayList of the neighbors surrounding the cell at location i,j
	public ArrayList<Cell> getNeighbors (int row, int col){
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		for(int i=-1; i<=1;i++) {
			for(int j=-1; j<=1; j++) {
				if(i==0 && j==0);
				else if(row+i>=0 && row+i<getRows() && col+j>=0 && col+j<getCols()) {
					neighbors.add(getCell(row+i,col+j));
				}
			}
		}
		return neighbors;
	}
	
	//Moves the cells forwards on the grid
	public void advance() {
		//Creates a temporary landscape with the same information from the current Landscape
		Landscape scape = new Landscape(this.getRows(),this.getCols());
		//Loops through the temporary landscape to assign it the Cells value of whether it is alive or not
		for(int i=0; i<this.getRows(); i++) {
			for(int j=0; j<this.getCols(); j++) {
				scape.getCell(i,j).setAlive(getCell(i,j).getAlive());
			}
		}
		//Updates the cell depending on the neighbors from the Landscape scape status
		for(int i=0; i<scape.getRows(); i++) {
			for(int j=0; j<scape.getCols(); j++) {
				scape.getCell(i,j).updateState(this.getNeighbors(i, j));
			}
		}
		//Sets the status of the Cell in the grid to the status of the Cell in the temporary Landscape
		for(int i=0; i<this.getRows(); i++) {
			for(int j=0; j<this.getCols(); j++) {
				getCell(i,j).setAlive(scape.getCell(i,j).getAlive());
			}
		}
		
	}
	
	public static void main(String[] args) {
		Landscape land = new Landscape(3,4);
		System.out.println(land);
		ArrayList<Cell> n = land.getNeighbors(0, 0);
		System.out.println(""+n.size());
		for(int i =0; i<n.size();i++) {
			System.out.println(n.get(i).toString());
		}
	}

	public void draw(Graphics g, int gridScale) {
		// draw all the cells
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {
				this.grid[i][j].draw(g, i*gridScale, j*gridScale, gridScale);
			}
		}
	}

}
