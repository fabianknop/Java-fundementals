package gameOfLife;

import java.util.Scanner;

import javax.swing.Timer;

public class LifeApplication {

	public static void main(String[] args) {
		LifeModel lifemodel = new LifeModel();
		new LifeConsoleView(lifemodel);
		Timer tick = new Timer( 1000, new LifeController( lifemodel ) );
		tick.start();
		lifemodel.toon();
		WaitForEnter();
	}
	
	private static void WaitForEnter() {
		new Scanner(System.in).nextLine();
		System.exit(0);
	}
}
