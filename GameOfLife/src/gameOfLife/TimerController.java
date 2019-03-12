package gameOfLife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerController implements ActionListener {
	public TimerView panel;

	public TimerController(TimerView panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		panel.Pause();

	}
}