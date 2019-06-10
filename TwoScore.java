package Yahtzee;

public class TwoScore extends Score {
	public TwoScore(String name, int numValue) {
		this.name = name;
	}
	
	public int calculateScore(int[] numValues) {
		return numValues[1] * 2;
	}
}

