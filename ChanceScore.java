package Yahtzee;

public class ChanceScore extends Score {
	public ChanceScore(String name) {
		this.name = name;
	}
	
	public int calculateScore(int[] numValues) {
		int sum = 0;
		for(int i = 0; i < numValues.length; i++) {
			sum += numValues[i] * (i + 1);
		}
		return sum;
	}
}