import java.io.*;
import java.util.*;

/**
 * 
 * @author Bhavin Tandel
 * @since  09/03/2016; 13:36
 */

class GuessGame{
	public static int countSteps(int maxRange){
		return (int)(Math.log(maxRange)/Math.log(2)+1e-10);
	}
	
	public static String userInput(int midPoint) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		System.out.println("Is the number larger (y or yes) than " + midPoint);
	
			String input = (String) br.readLine();
			System.out.println(input);
			return input;

	}
	
	public static int searchNum(int minRange, int maxRange, int steps) throws Exception{
	
		int midPoint = (int) Math.floor(((minRange + maxRange)/2));
		int range;
		do{
			midPoint = (int) Math.floor(((minRange + maxRange)/2));
			String input = userInput(midPoint) ;
			
			if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")){
				minRange = midPoint;
			}
			else{
				maxRange = midPoint;
			}
			
			steps--;
			range = maxRange - minRange;
		}while (steps >=0);

		if (range == 1){
			midPoint++;
		}
		
	return midPoint ;
	}
}


public class MainExGuessGame extends GuessGame {
	public static void main(String[] args){
		int maxRange = 0;
		Boolean flag = false;
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		try{
			do{
				System.out.println("Enter the maximum range : ");
				flag = false;
				maxRange = Integer.parseInt(br.readLine());
				if(maxRange < 1){
					System.out.println("Maximum range should be non-negative and non-zero");
					flag = true;
				}
			}while(flag);
			
				int steps = (countSteps(maxRange));
				System.out.println("You guessed number : " + searchNum(1,maxRange,steps));
		}
		catch (Exception e){
			e.getMessage();
			e.printStackTrace();
		}
		
		
		
	}


}
