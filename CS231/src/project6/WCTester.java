package project6;
/**
 * File: WCTester.java
 * Author: Jenniber Franco
 * Date: 04/09/2018
 */
public class WCTester {

	public static void main(String[] args) {
		WordCounter counter = new WordCounter();
		counter.analyze("resources/counttest.txt");
		counter.writeWordCountFile("resources/counts_ct.txt");
		counter.readWordCountFile("resources/counts_ct.txt");
		counter.writeWordCountFile("resources/counts_ct_v2.txt");
	}

}
