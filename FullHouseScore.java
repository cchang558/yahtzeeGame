package Yahtzee;

public class FullHouseScore extends Score {
	public FullHouseScore(String name) {
		this.name = name;
	}
	
	public int calculateScore(int[] numValues) {
		int check = 0;
		int check1 = 0;
		for(int i = 0; i < numValues.length; i++) {
			if(numValues[i] == 2) {
				check = 1;
			}
			if(numValues[i] == 3) {
				check1 = 1;
			}
		}
		if(check == 1 && check1 == 1) {
			return 25;
		}
		return 0;
	}
}
