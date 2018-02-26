package project3;

import java.io.*;

public class Board {
	
	public Board() {
		
	}
	public boolean read(String filename) {
	    try {
	      // start an infinite loop (e.g. while(true) or for(;;)
	          // assign to a String variable the result of calling the readLine method of your BufferedReader object.
	          // if the String is null, break out of the loop
	          // assign to a String array variable the result of calling split on the String with the argument "[ ]+"
	          // print the String
	          // print the size of the String array
	    	FileReader fr = new FileReader(filename);
	    	BufferedReader br = new BufferedReader(fr);
	    	while(true) {
	    		String s = br.readLine();
	    		if(s==null) {
	    			break;
	    		}
	    		String[] strings = s.split("[ ]+");
	    		for(int i=0;i<strings.length;i++) {
	    			System.out.println(strings[i]);
	    		}
	    		System.out.println(strings.length);
	    	}
	    	br.close();
	    	return true;
	    }
	    catch(FileNotFoundException ex) {
	      System.out.println("Board.read():: unable to open file " + filename );
	    }
	    catch(IOException ex) {
	      System.out.println("Board.read():: error reading file " + filename);
	    }

	    return false;
	}  
	
	public static void main(String[] args) {
		Board b = new Board();
		b.read("test1.txt");
	}

}
