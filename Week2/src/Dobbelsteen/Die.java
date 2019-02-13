package Dobbelsteen;

import java.util.Random;

public class Die {
	private int value;
	private static final Random generator = new Random();

	public Die() {
		cast();
	}

	public void cast() {
		value = generator.nextInt(6) + 1;
	}

	public int getValue() {
		return value;
	}

}
