package Dobbelsteen;

import java.util.Observable;

public class SetOfDice extends Observable {
	private Die[] dice;

	public SetOfDice(int number) {
		dice = new Die[number];
		for (int i = 0; i < number; i++)
			dice[i] = new Die();
		cast();
	}

	public void cast() {
		for (Die die : dice)
			die.cast();
		setChanged();
		notifyObservers();
	}

	public int getValue() {
		int diceValue = 0;
		for (Die die : dice) {
			diceValue = diceValue + die.getValue();
		}
		return diceValue;
	}

	public int getNumberOfDice() {
		return dice.length;
	}

	public Die getDie(int number) {
		return dice[number];
	}
}
