package Yahtzee;

public class ThreeScore extends Score {
	public ThreeScore(String name, int numValue) {
		this.name = name;
	}
	
	public int calculateScore(int[] numValues) {
		return numValues[2] * 3;
	}
}
