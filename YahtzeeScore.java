package Yahtzee;

public class YahtzeeScore extends Score {
	public YahtzeeScore(String name) {
		this.name = name;
	}
	
	public int calculateScore(int[] numValues) {
		for(int i = 0; i < numValues.length; i++) {
			if(numValues[i] == 5) {
				return 50;
			}
		}
		return 0;
	}
}
