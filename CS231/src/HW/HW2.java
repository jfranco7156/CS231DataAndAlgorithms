package HW;

/**
 * CS 231 HW2
 * Email yingli@colby.edu with your answers and questions regarding the homework
 * if you have any. Please set the email subject in the format of 
 * CS231 Spring2018 HW2 -- Your Name
 *
 * Submit by Thursday (02/22/2018) 10:00 pm if you want a response.
 *
 * Grading is 1 if you submit a reasonable attempt, 0 if you don't.
 * 
 * The code compiles and runs. Use it to help you answer questions. 
 */
 
import java.util.ArrayList;

public class HW2 {
	int rows, cols;
	Student[] s1;
	Student[][] s2;
	ArrayList<Student> s3;
	ArrayList<ArrayList<Student>> s4;
	
	public HW2 (int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		
		// case 1
		s1 = new Student[rows * cols];
		
		// case 2
		s2 = new Student[rows][];
		
		for (int i = 0; i < rows; i++) {
			s2[i] = new Student[cols];
		}
		
		// case 3
		s3 = new ArrayList<Student>(rows * cols);
		for (int i = 0; i < rows * cols; i++) {
			s3.add(new Student(i));
		}
		
		// case 4
		s4 = new ArrayList<ArrayList<Student>>(rows);
		for (int i = 0; i < rows; i++) {
			s4.add(new ArrayList<Student>(cols));
			for (int j = 0; j < cols; j++) {
				s4.get(i).add(new Undergraduate(cols * i + j, i+1));
			}
		}
	}
	
	// Q4: sets the given value to the item at row r, column c
	public void set (int r, int c, Student value) {
		// sets the given value to the item at row r, column c for field s1
		s1[r*cols+c] = value;
		// sets the given value to the item at row r, column c for field s2
		s2[r][c] = value;
		// sets the given value to the item at row r, column c for field s3
		s3.set(r*cols+c, value);
		// sets the given value to the item at row r, column c for field s4
		s4.get(r).set(c, value);
	} 
	
	public static void main (String[] args) {
		int rows = 2;
		int cols = 3;
		
		HW2 hw = new HW2(rows, cols);
		
		int r = 1, c = 2;
		
		hw.s1[r*cols + c] = new Student(4);
		hw.s2[r][c] = new Student(5);
		hw.s3.set(r*cols + c, new Undergraduate(6, 1));
		hw.s4.get(r).set(c, new Student(7));
		
		// uncomment the following line to test the set method
		//hw.set(0, 1, new Student(15)); 
			
		System.out.println("s1:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(hw.s1[i*cols+j] + " ");
			}
			System.out.println();
		}	
		
		System.out.println("s2:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(hw.s2[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("s3:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(hw.s3.get(i*cols+j) + "   ");
			}
			System.out.println();
		}
		
		System.out.println("s4:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(hw.s4.get(i).get(j) + "   ");
			}
			System.out.println();
		}	
	}
}

class Student {
	private int ID;
	
	public Student (int id) {
		ID = id;
	}
	
	public int getID () {
		return ID;
	}
	
	public void setID (int id) {
		ID = id;
	} 
	
	public String toString () {
		return "student_" + ID;
	}
}

class Undergraduate extends Student {
	private int year;
	
	public Undergraduate (int id, int year) {
		super(id);
		this.year = year;
	}
	
	public String toString () {
		return "undergrad_" + getID() + "_year_" + year;
	}
}