package project3;

public class Cell {
	private int row;
	private int col;
	private int value;
	private boolean locked;
	
	public Cell() {
		row = 0;
		col = 0;
		value = 0;
		locked = false;
	}
	
	public Cell(int row, int col, int value) {
		this.row = row;
		this.col = col;
		this.value = value;
		locked = false;
	}
	
	public Cell(int row, int col, int value, boolean locked) {
		this.row = row;
		this.col = col;
		this.value = value;
		this.locked = locked;
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	public Cell clone() {
		return new Cell(row, col, value, locked);
	}
	
	public String toString() {
		String l = " not locked";
		if(locked) l = " locked";
		return "The value "+value+" is in row "+row+" and col "+col+ " and it is"+l+".";
	}
	
	public static void main(String[] args) {
		Cell c1 = new Cell();
		Cell c2 = new Cell(2,3,1);
		Cell c3 = new Cell(1,1,5,false);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}

}
