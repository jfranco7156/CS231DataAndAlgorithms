package project3;

/**
 * File: CellStack.java
 * Author: Jenniber Franco
 * Date: 03/05/2018
 */

public class CellStack {
	//fields
	Cell[] stack;//Holds the array of Cells in the stack
	int max;//Indicates the maximum number of items that will fit in the stack
	int loc;//Indicates the next free location of the stack
	
	//Constructor with no parameters
	public CellStack() {
		stack = new Cell[10];//creates a cell array with size of 10
		max = 10;//sets the maximum size of 10
		loc = 0;//sets the location to 0
	}
	
	//Constructor with parameters of int size
	public CellStack(int size) {
		stack = new Cell[size];//creates a cell array with size parameter
		max = size;//sets the maximum size to size
		loc=0;//sets the location to 0
	}
	
	//Adds cell c to the stack
	public void push(Cell c) {
		if(loc<max) {//if location is less than max
			stack[loc] = c;//adds c to the stack in location
		}
		else {
			Cell[] temp = new Cell[max*2];//Creates a new cell array twice as big as stack
			max = max*2;//multiplies max by 2
			for(int i=0;i<max/2;i++) {
				temp[i] = stack[i];//Adds stack[i] to temp[i]
			}
			temp[max/2+1] = c;//Adds cells c to the temp array
			stack = temp;//Sets stack equal to temp
		}
		loc++;//increments location
	}
	
	//Deletes the last element in the stack and returns the cell
	public Cell pop() {
		if(loc>0) {
			Cell c = stack[loc-1];//Stores the last cell in stack in variable c
			stack[loc-1] = null;//Sets the location of the last cell to null
			loc--;//deletes location
			return c;//returns cell c
		}
		return null;//returns null if stack has nothing
	}
	
	//Returns the size of stack
	public int size() {
		return loc;//returns the location
	}
	
	//boolean of whether the stack is empty or not
	public boolean empty() {
		return stack[0] == null;//boolean value if the first index of stack is null 
	}

}
