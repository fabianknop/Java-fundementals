package Opdracht1;

import java.util.Scanner;

import javax.swing.Timer;

import Opdracht1.PulseController;

public class ClockApplication {

	public ClockApplication() {
		ClockModel model = new ClockModel();
		new ClockConsoleView(model);
		Timer pulse = new Timer(60000, new PulseController(model));
		pulse.start();
		WaitForEnter();
	}

	public static void main(String[] args) {
		new ClockApplication();
	}

	private void WaitForEnter() {
		new Scanner(System.in).nextLine();
		System.exit(0);
	}

}
