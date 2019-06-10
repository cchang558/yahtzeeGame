package Yahtzee;

public abstract class Score {
	protected String name = "";
	private int value;
	private int potentialValue;
	private int numValue;
	private boolean used = false;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getNumValue() {
		return numValue;
	}
	
	public void setNumValue(int numValue) {
		this.numValue = numValue;
	}
	
	public int getPotentialValue() {
		return potentialValue;
	}
	
	public void setPotentialValue(int potentialValue) {
		this.potentialValue = potentialValue;
	}
	
	public boolean isUsed() {
		return used;
	}
	
	public void setUsed() {
		used = true;
	}

	public abstract int calculateScore(int[] numValues);
}