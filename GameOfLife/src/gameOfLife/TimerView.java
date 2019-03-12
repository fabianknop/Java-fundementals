package gameOfLife;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerView extends JPanel {
	public Timer tick;

	public TimerView(Timer tick) {
		this.tick = tick;
		JButton pauzeKnop = new JButton("Pause");
		pauzeKnop.addActionListener(new TimerController(this));
		add(pauzeKnop);
	}

	public void Pause() {
		if (tick.isRunning()) {
			tick.stop();
		} else
			tick.start();
	}
}
