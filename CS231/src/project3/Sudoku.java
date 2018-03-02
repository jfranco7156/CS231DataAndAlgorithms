package project3;

import java.util.Random;

public class Sudoku {
	Board board;
	
	public Sudoku() {
		board = new Board();
	}
	
	public Sudoku(int n) {
		board = new Board();
		Random rand = new Random();
		for(int i=0;i<=n;i++) {
			int r = rand.nextInt(9);
			int c = rand.nextInt(9);
			int value;
			do {
				value = rand.nextInt(10);
			}while(value==0);
			if(board.validValue(r, c, value) && board.getValue(r, c)==0) {
				board.setLocked(r, c, value, true);
			}
			else {
				i--;
			}
		}
	}
	
	public boolean solve() {
		CellStack stack = new CellStack(100);
		
		int curRow = 0;
		int curCol = 0;
		int curValue = 1;
		int time = 0;
		
		while(stack.size()<Board.size*Board.size) {
			time++;
			
			if(board.isLocked(curRow, curCol)) {
				stack.push(board.getCell(curRow, curCol));
				curCol++;
				if(curCol>=board.getCols()) {
					curCol=0;
					curRow++;
				}
			}
			//Ask professor if this interpretation of instructions was correct
			for(int i=curValue;i<=10;i++) {
				if(board.validValue(curRow, curCol, i)) {
					curValue = i;
					break;
				}
			}
			
			if(board.validValue(curRow, curCol, curValue)) {
				Cell c = new Cell(curRow, curCol,curValue);
				stack.push(c);
				curCol++;
				if(curCol>=board.getCols()) {
					curCol = 0;
					curRow++;
				}
				curValue = 1;
			}
			else {
				if(stack.size()>0) {
					Cell c = stack.pop();
					while(c.isLocked()) {
						if(stack.size()>0) {
							c = stack.pop();
						}
						else {
							System.out.println(time);
							return false;
						}
					}
					curRow = c.getRow();
					curCol = c.getCol();
					curValue = c.getValue();
					board.setValue(curRow, curCol, 0);
				}
				else {
					System.out.println(time);
					return false;
				}
			}
		}
		
		System.out.println(time);
		return true;
	}
	
	public static void main(String[] args) {
		Sudoku game = new Sudoku();
		System.out.println(game.solve());
		System.out.println(game.board.toString());
		game.board.read("resources/board_nsp_10_solved.txt");
		System.out.println(game.solve());
		System.out.println(game.board.toString());
	}

}
