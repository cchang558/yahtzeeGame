package Yahtzee;

public class YahtzeeDice {

	// Member variable: static
	public static final int NUM_OF_DICE = 5; 
	
	// Member variable: non-static (instance variable, each YahtzeeDice object has own copy).
	// Declare instance variable 'dice', which will point to an array of Die objects.  
	private Die[] dice = new Die[NUM_OF_DICE]; 

	// Constructors.
	public YahtzeeDice() {  
		for(int i = 0; i < NUM_OF_DICE; i++) {
			dice[i] = new Die(); 
		}
	}

	public YahtzeeDice(int numSides) {
		for(int i = 0; i < NUM_OF_DICE; i++) {
			dice[i] = new Die(numSides); 
		}
	}
	
	// Rolls all 5 dice and returns the total of the dice.
	public int rollAll() { 
		int sum = 0;
		for(int i = 0; i < NUM_OF_DICE; i++) {
			sum += dice[i].roll();
		}
		return sum;
	}
	
	public int rollAgain() {
		int sum = 0;
		for(int i = 1; i <= NUM_OF_DICE; i++) {
			System.out.print("Hold die " + i + "? ");
			char input = TextIO.getlnChar();
			boolean inputCheck = false;
			while(!inputCheck) {
				if(input == 'y') {
					sum += dice[i - 1].getCurrentValue();
					break;
				} else if(input == 'n') {
					sum += dice[i - 1].roll();
					break;
				} else {
					System.out.println("Choose (y) or (n): ");
					input = TextIO.getlnChar();
				}
			}
		}
		return sum;
	}
	
	// Returns the dice array.
	public Die[] getDice() {  
		return dice;
	}
	
	// Returns an int[] containing the values of the 5 dice.
	public int[] getDiceValues() {  
		int[] diceValues = new int[NUM_OF_DICE];
		for(int i = 0; i < dice.length; i++) {
			diceValues[i] = dice[i].getCurrentValue(); 
		}
		return diceValues;
	}
	
	public int[] makeNumberArray(int[] dice, int[] numValues) {
		int[] tempArray = new int[6];
		numValues =  new int[6];
		tempArray = dice;
		for(int i = 0; i < numValues.length; i++) {
			numValues[i] = 0;
		}
		for(int j = 0; j < YahtzeeDice.NUM_OF_DICE; j++) {
			numValues[tempArray[j] - 1]++;
		}
		return numValues;
	}
	
	// Returns a String representation of the object.
	public String toString() {
		String yahtzee = "The " + NUM_OF_DICE + " dice read: ";
		
		for(int i = 0; i < dice.length; i++) {
			if(i < dice.length - 1) {
				yahtzee += dice[i].getCurrentValue() + ", ";
			} else {
				yahtzee += dice[i].getCurrentValue() + ".";
			}
		}
		return yahtzee;
	}
}