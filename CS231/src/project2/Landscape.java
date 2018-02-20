package project2;

import java.awt.Graphics;
import java.util.ArrayList;

public class Landscape {
	private Cell grid[][];
	
	public Landscape(int rows, int cols) {
		grid = new Cell[rows][cols];
	}
	
	public void reset() {
		for(int r=0; r<getRows(); r++) {
			for(int c=0; c<getCols(); c++) {
				grid[r][c].setAlive(false);
			}
		}
	}
	
	public int getRows() {
		return grid.length;
	}
	
	public int getCols() {
		return grid[0].length;
	}
	
	public Cell getCell(int row, int col) {
		return grid[row][col];
	}
	
	public String toString() {
		String s = "";
		for(int r=0;r<getRows();r++) {
			s += "\n";
			for(int c=0;c<getCols();c++) {
				s += getCell(r,c).toString();
			}
		}
		return s;
	}
	
	public ArrayList<Cell> getNeighbors (int row, int col){
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		
		int num1 = row-1;
		if(num1<0) num1=0;
		int num2 = row+1;
		if(num2>=getRows()) num2=getRows()-1;
		
		int num3 = col-1;
		int num4 = col+1;
		if(num3<0) num3=0;
		if(num4>=getCols()) num4 = getCols()-1;
		
		for(int r=num1; r<=num2;r++) {
			for(int c=num3; c<=num4; c++) {
				if(r!=row && c!=col) {
					neighbors.add(getCell(r,c));
				}
			}
		}
		return neighbors;
	}
	
	public static void main(String[] args) {
		
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
