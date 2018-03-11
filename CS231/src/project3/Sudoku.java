package project3;

/**
 * File: Sodoku.java
 * Author: Jenniber Franco
 * Date: 03/05/2018
 */

import java.util.Random;

public class Sudoku {
	//fields
	Board board;//created Board type 
	LandscapeDisplay display;//created LandscapeDisplay field
	
	//Constructor with no parameters
	public Sudoku() {
		board = new Board();//Initializes board type
		display = new LandscapeDisplay(board,100);//initializes display
	}
	
	//Constructor with parameter int n
	public Sudoku(int n) {
		board = new Board();//initializes board type 
		Random rand = new Random();//Creates a Random type
		for(int i=0;i<=n;i++) {
			int r = rand.nextInt(9);//Generates a random int between 0 and 9 and sets it to r
			int c = rand.nextInt(9);//Generates a random int between 0 and 9 and sets it to c
			int value;//Creates int value
			do {
				value = rand.nextInt(10);//Geneates a random int between 0 and 10 and sets it to value
			}while(value==0);//Keeps generating a new value if value is 0
			if(board.validValue(r, c, value) && board.getValue(r, c)==0) {
				board.setLocked(r, c, value, true);//Sets the new value to r,c and sets locked to true
			}
			else {
				i--;//Goes back one if it chooses an r,c that already has a locked value
			}
		}
		
		display = new LandscapeDisplay(board,100);//initializes display
	}
	
	//solves the Sudoku game
	public boolean solve(int delay) {
		CellStack stack = new CellStack(100);//Creates a new CellStack with size of 100
		
		int curRow = 0;//sets curRow to 0
		int curCol = 0;//sets curCol to 0
		int curValue = 1;//sets curvalue to 0
		int time = 0;//sets the time to 0
		while(stack.size()<Board.size * Board.size) {
			time++;//increments time
			
			if(delay>0) {
				try {
					Thread.sleep(delay);//delays the thread by delay milliseconds
				}
				catch(InterruptedException ex) {
					System.out.println("Interrupted");
				}
				display.repaint();//Redraws the grid using graphcs
			}
			
			if(board.isLocked(curRow, curCol)) {
				stack.push(board.getCell(curRow, curCol));//pushes the cell of the board into the stack
				curCol++;//increments curCol
				if(curCol>=board.getCols()) {//checks if curCol is greater than the size of columns of board
					curCol=0;//sets curCol to 0
					curRow++;//increments curRow
				}
			}

			for(;curValue<10;curValue++) {
				if(board.validValue(curRow, curCol, curValue)) {//checks if the curValue is valid
					break;//breaks the loop
				}
			}
			
			if(curValue<10) {
				Cell c = new Cell(curRow, curCol,curValue);//creates a new cell with curValue in curRow and curCol
				stack.push(c);//adds cell into stack
				board.setValue(curRow, curCol, curValue);//sets the value of board in curRow and curCol to curValue
				curCol++;//increments curCol
				if(curCol>=board.getCols()) {//checks if curCol is greater than the size of columns of board
					curCol = 0;//sets curCol to 0
					curRow++;//increments curRow
				}
				curValue = 1;//sets curValue to 1
			}
			else {
				if(stack.size()>0) {
					Cell c = stack.pop();//pops the last cell in stack and stores it in c
					while(c.isLocked()) {//if cell is locked
						if(stack.size()>0) {
							c = stack.pop();//pops the last cell in stack and stores it in c
						}
						else {
							System.out.println("Steps taken: "+time);//prints the number of steps taken
							return false;//returns false because could not solve
						}
					}
					curRow = c.getRow();//sets curRow to row of cell c
					curCol = c.getCol();//sets curCol to column of cell c
					curValue = c.getValue()+1;//sets curValue to value+1 of cell c
					board.setValue(curRow, curCol, 0);//sets the value of cell at curRow,curCol to 0
				}
				else {
					System.out.println("Steps taken: "+time);//prints the number of steps taken
					return false;//returns false because could not solve
				}
			}
		}
		
		System.out.println("Steps taken: "+time);//prints the number of steps taken
		return true;//returns true because it could solve
	}
	
	public static void main(String[] args) {
		Sudoku game = new Sudoku(10);
		//game.board.read("resources/board_nsp_10.txt");
		//System.out.println(game.board.toString());
		System.out.println(game.solve(10));
		//System.out.println(game.board.toString());
		//game.board.read("resources/board_nsp_10.txt");
		//System.out.println(game.board.toString());
		//System.out.println(game.solve());
		//System.out.println(game.board.toString());
	}

}
