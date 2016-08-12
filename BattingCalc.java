package dayOne;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BattingCalc {

	public static void main(String[] args) {
		int atBats;
		double hits = 0;
		ArrayList<Double> battingData = new ArrayList<Double>();
		Scanner keyboard = new Scanner(System.in);
		boolean isValid = true;

		System.out.println("How many times did you go to bat?");

		atBats = keyboard.nextInt();
		do {
			for (int i = 0; i < atBats; i++) {
				double userInput = 0;
				System.out.println("How many bases did you get on bat number " + (i + 1) + "?");
				try {
					userInput = keyboard.nextDouble();
					isValid = false;
				} catch (InputMismatchException e) {
					System.out.println("Please enter either 0,1,2,3,or 4");
					i--;
					isValid = true;

				}
				keyboard.nextLine();

				if (userInput == 0 || userInput == 1 || userInput == 2 || userInput == 3 || userInput == 4) {
					battingData.add(userInput);
					isValid = false;

				} else {
					System.out.println("Please enter either 0,1,2,3,or 4");
					isValid = true;
					i--;
				}

			}
		} while (isValid);

		for (

				int i = 0; i < battingData.size(); i++) {

			hits += battingData.get(i);

			
		}
		double battingPercentage=(hits/atBats);
		System.out.println("Your batting percentage is: "+ battingPercentage);
		
		
keyboard.close();
	}
}
