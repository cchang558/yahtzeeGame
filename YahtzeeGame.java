package Yahtzee;

public class YahtzeeGame {

	private static final int ROUNDS = 3;
	private static final int TOTAL_ROUNDS = 13;
	YahtzeeDice dice = new YahtzeeDice();
	ScoreCard currentScoreCard = new ScoreCard();
	ScoreCard potentialScoreCard = new ScoreCard();
	
	int[] numValues = new int[6];

	public static void main(String[] args) {
		YahtzeeGame game = new YahtzeeGame();
		System.out.println("***Starting Game***");
		for(int i = TOTAL_ROUNDS; i > 0; i--) {
			System.out.println("***Starting Round*** (" + i + " rounds left).");
			System.out.println("You have a max of 3 turns per round.");
			game.startRound();	
		}
		System.out.println("GAME OVER");
		System.out.println("Final score: " + game.currentScoreCard.totalScore());
	}
	
	public void startRound() {
		int j = 0;
		dice.rollAll();
		for(j = ROUNDS - 1; j > 0; j--) {
			System.out.println("Rolling...");
			System.out.println(dice);
			System.out.println(j + " turns left in this round.");
			System.out.print("Would you like to roll again? (y) for yes, (n) for no: ");
			char input = TextIO.getlnChar();
			boolean inputCheck = false;
			while(!inputCheck) {
				if(input == 'y') {
					if(j == 1) {
						inputCheck = true;
						dice.rollAgain();
						getScorecard();
						break;
					} else {
						inputCheck = true;
						dice.rollAgain();
						break;
					}
				} else if(input == 'n') {
					inputCheck = true;
					getScorecard();
					j = 0;
					break;
					// If it's a no, should automatically start new round.
				} else {
					System.out.print("Choose (y) or (n): ");
					input = TextIO.getlnChar();
				}
			}
		}
	}
	
	public void getScorecard() {
		System.out.println(dice);
		System.out.println("***Current Scorecard***");
		System.out.println(currentScoreCard);
		System.out.println("***Potential Scores***");
		numValues = dice.makeNumberArray(dice.getDiceValues(), numValues);
		System.out.println(potentialScoreCard.getPotentialScores(numValues));
		potentialScoreCard.storeScore(numValues);
		System.out.print("Make a choice: ");
		int choice = TextIO.getlnInt();
		while(true) {
			if(currentScoreCard.alreadyChosen(choice - 1)) {
				System.out.print("Make another choice: ");
				choice = TextIO.getlnInt();
			} else {
				int temp = potentialScoreCard.getScore(choice - 1);
				currentScoreCard.setScore(choice - 1, temp);
				currentScoreCard.setChosen(choice - 1);
				System.out.println("***Current Scorecard (Updated)***");
				System.out.println(currentScoreCard);
				System.out.println("Total Score : " + currentScoreCard.totalScore());
				break;
			}	
		}
	}
}