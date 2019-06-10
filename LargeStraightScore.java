package Yahtzee;

public class LargeStraightScore extends Score {
	public LargeStraightScore(String name) {
		this.name = name;
	}
	
	public int calculateScore(int[] numValues) {
		int i = 0;
		if(numValues[i] > 0 && numValues[i + 1] > 0 && numValues[i + 2] > 0 && numValues[i + 3] > 0 && numValues[i + 4] > 0) {
				return 40;
		} else {
			return 0;
		}
	}
}

