package Yahtzee;

public class FiveScore extends Score {	
	public FiveScore(String name, int numValue) {
		this.name = name;
	}
	
	public int calculateScore(int[] numValues) {
		return numValues[4] * 5;
	}
}
