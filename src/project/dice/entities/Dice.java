package project.dice.entities;

import java.util.Random;

public class Dice {
	
	private final Random randomNumberGenerator;
	private final int diceFaceAmmount;
	
	public Dice(int sides) {
		
		this.randomNumberGenerator = new Random(System.nanoTime());
		this.diceFaceAmmount = sides;
		
	}
	
	public int roll() {
		return randomNumberGenerator.nextInt(diceFaceAmmount) + 1;
	}
	

}