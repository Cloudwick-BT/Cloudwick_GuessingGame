import java.io.*;
import java.util.*;

/**
 * 
 * @author Bhavin Tandel
 * @since  09/03/2016; 13:36
 */

class GuessGame{
	public static int countSteps(int maxRange){
		return (int)Math.ceil((Math.log(maxRange)/Math.log(2))); //+1e-10
	}
	
	public static String userInput(int midPoint) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		System.out.println("Is the number strictly larger (y or yes) than " + midPoint);
	
			String input = (String) br.readLine();
			System.out.println(input);
			return input;

	}
	
	public static int searchNum(int minRange, int maxRange, int steps) throws Exception{
	
		int midPoint = (int) Math.floor(((minRange + maxRange)/2));
		int range;
		Boolean flag = false;
		do{
			midPoint = (int) Math.floor(((minRange + maxRange)/2));
			String input = userInput(midPoint) ;
			
			if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")){
				minRange = midPoint;
				// to check if program run in 
				if( (maxRange - minRange) == 1){
					flag = true;
				}
			}
			else{
				maxRange = midPoint;
			}
			
			steps--;
			range = maxRange - minRange;
		}while (steps >0);

		if (flag){
			midPoint++;
		}
		
	return midPoint ;
	}
}


public class MainExGuessGame extends GuessGame {
	public static void main(String[] args){
		int maxRange = 0;
		int minRange = 0;
		Boolean flag = false;
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		try{
			do{
				System.out.println("Enter the minimum range : ");
				minRange = Integer.parseInt(br.readLine());
				System.out.println("Enter the maximum range : ");
				maxRange = Integer.parseInt(br.readLine());
				flag = false;
				if(maxRange < 1 || minRange < 1 || (maxRange < minRange) ){
					System.out.println("Maximum range should be non-negative and non-zero");
					flag = true;
				}
			}while(flag);
			
				int steps = (countSteps((maxRange-minRange)+1));
				System.out.println("You guessed number was guessed in " + steps + " steps: " + searchNum(minRange,maxRange,steps));
		}
		catch (Exception e){
			e.getMessage();
			e.printStackTrace();
		}
			
		
	}


}
