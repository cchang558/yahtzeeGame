package Yahtzee;

public class FourScore extends Score {
	public FourScore(String name, int numValue) {
		this.name = name;
	}
	
	public int calculateScore(int[] numValues) {
		return numValues[3] * 4;
	}
}

