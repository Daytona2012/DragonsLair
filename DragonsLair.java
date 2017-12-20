package GOTBattle;

import java.util.ArrayList;
import java.util.*;

public class DragonsLair {

		private DragonsHelper helper = new DragonsHelper();
		private ArrayList<DragonsBane> GOTDragon = new ArrayList<DragonsBane>();
		private int numOfGuesses = 0;
		
		private void setUpGame() {
		//Make some GotKnights
		DragonsBane one = new DragonsBane();
		one.setName("Balerion the Dredd");
		DragonsBane two = new DragonsBane();
		two.setName("Drogon");
		DragonsBane three = new DragonsBane();
		three.setName("Caraxes the Red Worm");
		GOTDragon.add(one);
		GOTDragon.add(two);
		GOTDragon.add(three);
		
		System.out.println("Welcome, I hear your a dragon slayer.");
		System.out.println("Our people have an infestation of Dragons, they are eating our live stock "
				+ " and destroy our live stock.");
		System.out.println("If you chould choose to stay and defend us from the dragons you will be handsomely rewarded.");
		System.out.println("Your goal is to take down 3 Dragons located in HighGarden.");
		System.out.println("Balerion the Black Dredd, Drogon, and Caraxes the Red Worm.");
		System.out.println("Try to take them down before you run out of Scorpion Bolts");
		
		for (DragonsBane DragonsLairSet : GOTDragon) {
			
			ArrayList<String> newLocation = helper.placeDragonsBane(3);
			
			DragonsLairSet.setLocationCells(newLocation);
			
		}
	}	
		
		private void startPlaying() {
			
			while(!GOTDragon.isEmpty()) {
				
				String slayerGuess = helper.getUserInput("Enter a guess");
				dragonSlayerGuess(slayerGuess);
				
			}
			finishGame();
		}
		
		private void dragonSlayerGuess (String slayerGuess) {
			
			numOfGuesses++;
			
			String result = "miss";
			
			for (DragonsBane DragonsLairTest : GOTDragon) {
				
				result = DragonsLairTest.checkYourself(slayerGuess);
				
				if (result.equals("kill")) {
					
					GOTDragon.remove(DragonsLairTest);
					break;
				}
			}
			System.out.println(result);
		}
		
		private void finishGame() {
			System.out.println("All Dragons are dead! Praise be to the 7."
					+ " You are a true warrior, and your reward"
					+ "is much deserving... A pint of ale, Sister's Stew,"
					+ "a lemon cake and the great Castle called Harrenhal,");
			
			if  (numOfGuesses <= 18) {
				System.out.println("It only took you " + numOfGuesses + " guesses");
				System.out.println(" Its good your aim was true or else you would be toast.");
			} else {
				System.out.println("7 help us, you finally killed the beast. " + numOfGuesses + " guesses.");
				System.out.println("Now we must go fetch all those scorpions you lost... Some warrior.");
			}
		}
		
		public static void main (String[] args) {
			DragonsLair game = new DragonsLair ();
			game.setUpGame();
			game.startPlaying();
		}
}
