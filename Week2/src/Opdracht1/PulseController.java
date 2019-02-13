package Opdracht1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PulseController implements ActionListener {
	private ClockModel model;

	public PulseController(ClockModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		model.nextMinute();
	}
}