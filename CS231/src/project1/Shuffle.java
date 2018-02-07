package project1;

/**
 * File: Shuffle.java
 * Author: FirstName LastName
 * Date: MM/DD/YYYY
 */

import java.util.ArrayList;
import java.util.Random;

public class Shuffle {

	public static void main(String[] args) {
		ArrayList arrayL = new ArrayList();
		Random rand = new Random();
		for(int i=0; i<10;i++) {
			arrayL.add(rand.nextInt(100));
		}
	}

}
