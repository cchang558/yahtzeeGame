package Yahtzee;

public class SixScore extends Score {
	public SixScore(String name, int numValue) {
		this.name = name;
	}
	
	public int calculateScore(int[] numValues) {
		return numValues[5] * 6;
	}
}
