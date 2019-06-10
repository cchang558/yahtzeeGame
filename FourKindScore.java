package Yahtzee;

public class FourKindScore extends Score {	
	public FourKindScore(String name) {
		this.name = name;
	}
	
	public int calculateScore(int[] numValues) {
		int check = 0;
		for(int i = 0; i < numValues.length; i++) {
			if(numValues[i] == 4) {
				check = 1;
			}
		}
		if(check == 1) {
			int sum = 0;
			for(int i = 0; i < numValues.length; i++) {
				sum += numValues[i] * (i + 1);
			}
			return sum; 
		}
		return 0;
	}
}
