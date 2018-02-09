package project1;

/**
 * File: Shuffle.java
 * Author: Jenniber Franco
 * Date: 02/09/2018
 */

import java.util.ArrayList;
import java.util.Random;

public class Shuffle {

	public static void main(String[] args) {
		ArrayList arrayL = new ArrayList();
		Random rand = new Random();
		for(int i=0; i<10;i++) {
			int r = rand.nextInt(100);
			arrayL.add(r);
			System.out.println(r);
		}
		for(int i=0; i<arrayL.size(); i++) {
			System.out.println(arrayL.get(i));
		}
		for(int i=0; i<10;i++) {
			int num = rand.nextInt(arrayL.size());
			System.out.println(arrayL.remove(num));
			System.out.println(arrayL);
		}
	}

}
