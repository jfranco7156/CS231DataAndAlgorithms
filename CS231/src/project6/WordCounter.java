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
	private BSTMap<String,Integer> map;
	private int wordC;//Keeps track of the number of words
	
	public WordCounter() {
		map = new BSTMap<String,Integer>(new StringAscending());
		wordC = 0;	
	}
	
	public boolean analyze(String filename) {
		try {
	    	FileReader fr = new FileReader(filename);//Creates a FileReader type of the filename
	    	BufferedReader br = new BufferedReader(fr);//Creates a BufferedReader type of fr
	    	while(true) {
	    		String s = br.readLine();//reads the line in BufferedReader
	    		if(s==null)break;//breaks the loop if s is null
	    		// split line into words. The regular expression can be interpreted
	    	    // as split on anything that is not (^) (a-z or A-Z or 0-9 or ').
	    	    String[] words = s.split("[^a-zA-Z0-9']");
	    	    for (int i = 0; i < words.length; i++) {
	    	        String word = words[i].trim().toLowerCase();
	    	        // Might want to check for a word of length 0
	    	        if(word.length()==0) {
	    	        	continue;
	    	        }
	    	        // Write code to update the map
	    	        if(map.get(word) == null) {
	    	        	map.put(word, 1);
	    	        }
	    	        else {
	    	        	map.put(word, map.get(word)+1);
	    	        }
	    	        wordC++;
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
			FileWriter fw = new FileWriter(filename);
			fw.write("total Word Count: "+wordC);//Writes the first line
			ArrayList<KeyValuePair<String, Integer>> list = map.entrySet();
			for(int i = 0; i < list.size(); i++) {
				fw.write("\n"+list.get(i).getKey()+" "+list.get(i).getValue());
			}
			fw.close();
		}
		catch(IOException ex) {
	    	//returns the message if it could not properly read the file
	      System.out.println("WordCounter.writeFile():: error writing file " + filename);
	    }
	}
	
	//Reads the contents of a word count file and reconstructs fields of the wordC object
	public void readWordCountFiel(String filename) {
		try {
			FileReader fr = new FileReader(filename);//Creates a FileReader type of the filename
	    	BufferedReader br = new BufferedReader(fr);//Creates a BufferedReader type of fr
			boolean first = true;
			while(true) {
				String s = br.readLine();
				if(s == null) break;
				String[] words = s.split("[^a-zA-Z0-9']");
				if(first) {
					//specific to me, check the words to the list to see breaks
					wordC = Integer.parseInt(words[3]);
					first = false;
					continue;
				}
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
	
	
	
	public int getTotalWordCount() {
		return wordC;
	}
	
	public int getCount(String word) {
		if(map.get(word) == null) return 0;
		return map.get(word);
	}
	
	public double getFrequency(String word) {
		if(map.get(word) == null) return 0;
		return (double)map.get(word)/wordC;
	}
	
	public String toString() {
		return map.toString();
	}
	
	public String mostFreq() {
		ArrayList<KeyValuePair<String,Integer>> value = map.entrySet();
		int max= 0;
		String tracker = "";
		for(int i=0; i<value.size();i++) {
			int check = value.get(i).getValue();
			if(check>max) {
				max = check;
				tracker = value.get(i).getKey();
			}
		}
		return tracker;
	}
	
	public static void main(String[] args) {
		WordCounter counter = new WordCounter();
		String input = args[0];
		String output = "analyzed" + input;
		double start = System.currentTimeMillis();
		counter.analyze(input);
		double end = System.currentTimeMillis();
		System.out.println((end-start)/1000+" seconds");
		counter.writeWordCountFile(output);
	}

}
