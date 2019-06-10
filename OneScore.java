package Yahtzee;

public class OneScore extends Score {
	public OneScore(String name, int numValue) {
		this.name = name;
	}
	
	public int calculateScore(int[] numValues) {
		return numValues[0] * 1;
	}
}