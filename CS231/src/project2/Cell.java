package project2;

import java.awt.Graphics;

public class Cell {
	private boolean alive;
	public Cell() {
		alive = false;
	}
	public Cell(boolean alive) {
		this.alive = alive;
	}
	
	public boolean getAlive(){
		return alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public String toString() {
		if(alive) return "0";
		return " ";
	}
	
	
	public static void main(String[] args) {
		Cell cell1 = new Cell();
		Cell cell2 = new Cell(true);
		
		System.out.println(cell1.toString());
		System.out.println(cell2.toString());
		cell1.setAlive(true);
		System.out.println(cell1.toString());
	}
	public void draw(Graphics g, int i, int j, int gridScale) {
		// TODO Auto-generated method stub
		
	}

}
