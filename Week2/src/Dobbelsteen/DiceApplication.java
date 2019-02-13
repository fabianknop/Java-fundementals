package Dobbelsteen;

import java.util.Scanner;

import javax.swing.Timer;

public class DiceApplication {
	public DiceApplication() {
		SetOfDice setOfDice = new SetOfDice(5);
		new DiceView(setOfDice);
		Timer pulse = new Timer(1000, new PulseController(setOfDice));
		pulse.start();
		WaitForEnter();
	}

	public static void main(String[] args) {
		new DiceApplication();
	}

	private void WaitForEnter() {
		new Scanner(System.in).nextLine();
		System.exit(0);
	}
}
