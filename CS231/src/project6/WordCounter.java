package project6;

/**
 * File: WordCounter.java
 * Author: Jenniber Franco
 * Date: 04/09/2018
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WordCounter {
	//fields
	private BSTMap<String,Integer> map;//Stores the map of the tree
	private int wordC;//Keeps track of the number of words
	
	public WordCounter() {
		map = new BSTMap<String,Integer>(new StringAscending());//Initializes the map
		wordC = 0;//Sets the word count to 0
	}
	
	//Generates the word counts from a file od words
	public boolean analyze(String filename) {
		try {
	    	FileReader fr = new FileReader(filename);//Creates a FileReader type of the filename
	    	BufferedReader br = new BufferedReader(fr);//Creates a BufferedReader type of fr
	    	while(true) {
	    		String s = br.readLine();//reads the line in BufferedReader
	    		if(s==null)break;//breaks the loop if s is null
	    		// split line into words. The regular expression can be interpreted
	    	    // as split on anything that is not (^) (a-z or A-Z or 0-9 or ').
	    	    String[] words = s.split("[^a-zA-Z0-9']");//Splits the string
	    	    for (int i = 0; i < words.length; i++) {
	    	        String word = words[i].trim().toLowerCase();
	    	        // Might want to check for a word of length 0
	    	        if(word.length()==0) {
	    	        	continue;
	    	        }
	    	        // Write code to update the map
	    	        if(map.containsKey(word)) {
	    	        	map.put(word, map.get(word)+1);//Update the value of the word
	    	        }
	    	        else {
	    	        	map.put(word, 1);//Adds the new word to the map
	    	        }
	    	        wordC++;//Increments the word count
	    	    }
	    	}
	    	br.close();//close BufferedReader
	    	return true;//return true
	    }
	    catch(FileNotFoundException ex) {
	    	//returns the message of the file is not found
	      System.out.println("WordCounter.read():: unable to open file " + filename );
	    }
	    catch(IOException ex) {
	    	//returns the message if it could not properly read the file
	      System.out.println("WordCounter.read():: error reading file " + filename);
	    }

	    return false;//return false
	}
	
	//Writes the contents of the BSTMap to a word count file
	public void writeWordCountFile(String filename) {
		try {
			FileWriter fw = new FileWriter(filename);//Creates a FileWriter object
			fw.write("totalWordCount : "+wordC);//Writes the first line
			//Stores the elements in the binary tree in an ArrayList
			ArrayList<KeyValuePair<String, Integer>> list = map.entrySet();
			for(int i = 0; i < list.size(); i++) {
				//Writes the key and value in a new line
				fw.write("\n"+list.get(i).getKey()+" "+list.get(i).getValue());
			}
			fw.close();//Closes the FileWriter object
		}
		catch(IOException ex) {
	    	//returns the message if it could not properly write the file
	    	System.out.println("WordCounter.writeFile():: error writing file " + filename);
	    }
	}
	
	//Reads the contents of a word count file and reconstructs fields of the wordC object
	public void readWordCountFile(String filename) {
		try {
			FileReader fr = new FileReader(filename);//Creates a FileReader type of the filename
	    	BufferedReader br = new BufferedReader(fr);//Creates a BufferedReader type of fr
			boolean first = true;//boolean to check whether it is the first word
			while(true) {
				String s = br.readLine();//reads the line in BufferedReader
				if(s == null) break;//breaks if s is null
				String[] words = s.split("[^a-zA-Z0-9']");//Splits the string
				if(first) {
					wordC = Integer.parseInt(words[words.length-1]);//Sets the wordC
					first = false;//Sets first to false
					continue;
				}
				//If the word is not first, adds the words to the map with the occurence
				map.put(words[0], Integer.parseInt(words[1]));
			}
		}
		catch(FileNotFoundException ex) {
	    	//returns the message of the file is not found
	      System.out.println("WordCounter.readFile():: unable to open file " + filename );
	    }
	    catch(IOException ex) {
	    	//returns the message if it could not properly read the file
	      System.out.println("WordCounter.readFile():: error reading file " + filename);
	    }
	}
	
	//returns the total word count
	public int getTotalWordCount() {
		return wordC;
	}
	
	//returns the value for the word
	public int getCount(String word) {
		if(map.get(word) == null) return 0;
		return map.get(word);
	}
	
	//Returns the frequency in which the word occurs 
	//divided by the total number of words
	public double getFrequency(String word) {
		if(map.get(word) == null) return 0;//returns 0 when the word is not found
		return (double)map.get(word)/wordC;//returns the occurence divided by the total words
	}
	
	//returns a string of the map
	public String toString() {
		return map.toString();
	}
	
	public static void main(String[] args) {
		WordCounter counter = new WordCounter();
		//String input = args[0];
		String input = "resources/counts_ct.txt";
		String output = "resources/analyzed_" + input;
		double start = System.currentTimeMillis();
		System.out.print(counter.analyze(input));
		double end = System.currentTimeMillis();
		System.out.println((end-start)/1000+" seconds");
		counter.writeWordCountFile(output);
	}

}
