package gameOfLife;

import java.awt.BorderLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.Timer;

public class LifeApplication extends JFrame {

	public LifeApplication() {
		LifeModel model = new LifeModel();
		setBounds(150, 150, 1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Conway Game of Life");
		 Timer tick = new Timer(1000, new LifeController(model));
		LifeConsoleView view = new LifeConsoleView(model);
		LifePanelView panelView = new LifePanelView(model);
		TimerView timerView = new TimerView(tick);
		add(new TimerView(tick),  BorderLayout.NORTH);
		add(new LifePanelView(model));

		setVisible(true);
		 tick.start();
	}

	public static void main(String[] args) {
		new LifeApplication();
	}
}
