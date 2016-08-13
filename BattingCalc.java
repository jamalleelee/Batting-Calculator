package dayOne;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BattingCalc {

	public static void main(String[] args) {
		double atBats = 0;
		double hits = 0;
		ArrayList<Double> battingData = new ArrayList<Double>();
		Scanner keyboard = new Scanner(System.in);
		boolean isValid = true;
		double totalHits = 0;
		boolean isAlsoValid = true;
		boolean validHitNumber = true;
		double sluggingPercentage = 0;
		double battingPercentage = 0;
		DecimalFormat df = new DecimalFormat("###.###");

		do {
			System.out.println("How many times did you go to bat?");
			try {
				atBats = keyboard.nextDouble();
				isAlsoValid = false;
			} catch (InputMismatchException e) {
				isAlsoValid = true;
			}
			keyboard.nextLine();

		} while (isAlsoValid);

		do {
			System.out.println("How many total hits did you get?");
			try {
				totalHits = keyboard.nextDouble();
				validHitNumber = false;
			} catch (InputMismatchException e) {
				validHitNumber = true;
			}
			keyboard.nextLine();

		} while (validHitNumber);

		do {
			for (int i = 0; i < totalHits; i++) {
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
		battingPercentage = (totalHits / atBats);
		System.out.println("Your batting percentage is: " + df.format(battingPercentage));
		sluggingPercentage = (hits / atBats);
		System.out.println("Your slugging percentage is: " + df.format(sluggingPercentage));

		keyboard.close();
	}
}
