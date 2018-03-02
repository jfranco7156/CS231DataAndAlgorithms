package HW;

/**
 * CS 231 HW3
 * Email yingli@colby.edu with your answers and questions regarding the homework
 * if you have any. Please set the email subject in the format of 
 * CS231 Spring2018 HW3 -- Your Name
 *
 * Submit by Thursday (03/01/2018) 10:00 pm if you want a response.
 *
 * Grading is 1 if you submit a reasonable attempt, 0 if you don't.
 * 
 * The code compiles and runs. Use it to help you answer questions. 
 */

import java.util.ArrayList;

public class HW3 {
	public static void main (String[] args) {
		FruitBusket<Apple> busket1 = new FruitBusket<Apple>(); 
		FruitBusket<Pear> busket2 = new FruitBusket<Pear>(); 
	}
}

class FruitBusket<T> implements FruitStack<T> {
	ArrayList<T> fruits;
	public FruitBusket () {fruits = new ArrayList<T>();}
	@Override
	public void pushFruit(T t) {
		System.out.println(t);
	}
}

class Fruit {}

class Apple extends Fruit {}

class Pear extends Fruit {}

interface FruitStack<T> {
	void pushFruit(T t);
}
