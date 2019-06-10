package Yahtzee;

public class ScoreCard {
	
	private final int TOTAL_ROUNDS = 13;
	private Score[] scores = new Score[TOTAL_ROUNDS];
	private int[] numValue = new int[6];
	private int[] tempScore = new int[13];
	
	public ScoreCard() {
		scores[0] = new OneScore("Ones", numValue[0]);
		scores[1] = new TwoScore("Twos", numValue[1]);
		scores[2] = new ThreeScore("Threes", numValue[2]);
		scores[3] = new FourScore("Fours", numValue[3]);
		scores[4] = new FiveScore("Fives", numValue[4]);
		scores[5] = new SixScore("Sixes", numValue[5]);
		scores[6] = new ThreeKindScore("Three of a kind");
		scores[7] = new FourKindScore("Four of a kind");
		scores[8] = new FullHouseScore("Full House");
		scores[9] = new SmallStraightScore("Small Straight");
		scores[10] = new LargeStraightScore("Large Straight");
		scores[11] = new ChanceScore("Chance");
		scores[12] = new YahtzeeScore("Yahtzee");	
	}
	
	public int[] makeScoreArrayOneToSix(int[] numValue) {
		for(int i = 0; i < 6; i++) {
			tempScore[i] = numValue[i] * (i + 1);
		}
		return tempScore;
	}
	
	public boolean alreadyChosen(int chosen) {
		return scores[chosen].isUsed();
	}
	
	public void setChosen(int chosen) {
		scores[chosen].setUsed();
	}

	public int totalScore() {
		int totalScore = 0;
		for(int i = 0; i < TOTAL_ROUNDS; i++) {
			totalScore += scores[i].getValue();
		}
		return totalScore;
	}

	public String getPotentialScores(int[] nums) {
		String result = "";
		int[] tempArray = new int[6];
		for(int i = 0; i < TOTAL_ROUNDS; i++) {
			result += String.format("%-25s", (i + 1) + ": " + scores[i].getName() + " (" + scores[i].calculateScore(nums) + ")");
			if(i > 0 && i % 3 == 0) {
				result += "\n";
			}
		} 
		return result;
	}
	
	public void storeScore(int[] nums) {
		for(int i = 0; i < TOTAL_ROUNDS; i++) {
			// System.out.println(scores[i].calculateScore(nums));
			int temp = scores[i].calculateScore(nums);
			scores[i].setValue(temp);
		} 
	}
	
	public int getScore(int choice) {
		return scores[choice].getValue();
	}
	
	public void setScore(int choice, int value) {
		scores[choice].setValue(value);
		
	}
	
	public String toString() {
		String result = "";
		for(int i = 0; i < TOTAL_ROUNDS; i++) {
			result += String.format("%-25s", scores[i].getName() + ": " + scores[i].getValue());
			if(i > 0 && i % 3 == 0) {
				result += "\n";
			}
		}
		return result;
	}
}
