package project3;

public class CellStack {
	Cell[] stack;//Holds the array of Cells in the stack
	int max;//Indicates the maximum number of items that will fit in the stack
	int loc;//Indicates the next free location of the stack
	
	public CellStack() {
		stack = new Cell[10];
		max = 10;
		loc = 0;
	}
	
	public CellStack(int size) {
		stack = new Cell[size];
		max = size;
		loc=0;
	}
	
	public void push(Cell c) {
		if(loc<max) {
			stack[loc] = c;
		}
		else {
			Cell[] temp = new Cell[max*2];
			max = max*2;
			for(int i=0;i<max/2;i++) {
				temp[i] = stack[i];
			}
			temp[max/2+1] = c;
			stack = temp;
		}
		loc++;
	}
	
	public Cell pop() {
		if(loc>0) {
			Cell c = stack[loc-1];
			stack[loc-1] = null;
			loc--;
			return c;
		}
		return null;
	}
	
	public int size() {
		return max;
	}
	
	public boolean empty() {
		//return stack.length==0;
		return stack[0] == null;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
