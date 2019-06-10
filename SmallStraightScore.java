package Yahtzee;

public class SmallStraightScore extends Score {
	public SmallStraightScore(String name) {
		this.name = name;
	}
	
	public int calculateScore(int[] numValues) {
		for(int i = 0; i < 2; i++) {
			if(numValues[i] > 0 && numValues[i + 1] > 0 && numValues[i + 2] > 0 && numValues[i + 3] > 0) {
				return 30;
			}
		}
		return 0;
	}	
}
