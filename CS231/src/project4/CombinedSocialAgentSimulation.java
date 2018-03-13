package project4;
/**
 * File: CobinesSocialAgentSimulation.java
 * Author: Jenniber Franco
 * Date: 03/12/2018
 */
import java.util.Scanner;

public class CombinedSocialAgentSimulation {
	//fields
	private static Scanner input;//Used to ask the user for an input
	private static String[] agentSubs = {"categorized social agent","social agent"};//List to store the Agent subclass (can be increased later)
	
	public static void main(String[] args) throws InterruptedException {
		input = new Scanner(System.in);//Initializes the input field
		
		System.out.println("What type of Agent simulation would you like to do?\nPlease type 'Categorized Social Agent' or 'Social Agent'.");//Asks the user a question
		String response = promptInput().toLowerCase();//Prompts for the users input
		while(!isAgentSub(response)){
			System.out.println("ONLY type 'Categorized Social Agent' or 'Social Agent'\n**It is space sensitive**");//Tells the user to be careful with spacing
			response = promptInput().toLowerCase();//Prompts the user for a response
		}
		
		if(response.equals(agentSubs[0]))CategorizedSocialAgentSimulation.main(args);//Calls the main method in CategorizedSocialAgentSimulation class
		else if(response.equals(agentSubs[1]))SocialAgentSimulation.main(args);//Calls the main method in SocialAgentSimulatio class
	}
	
	public static boolean isAgentSub(String response) {
		for(String a: agentSubs) {
			if(a.equals(response))return true;//Returns true if the response is an Agent subclass
		}
		
		return false;//Returns false if it is not an Agent subclass
	}
	
	//Prompts for the users input
	public static String promptInput() {
		return input.nextLine();//Returns users input
	}
}
