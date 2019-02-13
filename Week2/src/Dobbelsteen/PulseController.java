package Dobbelsteen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PulseController implements ActionListener {
	private SetOfDice setOfDice;

	public PulseController(SetOfDice setOfDice) {
		this.setOfDice = setOfDice;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		setOfDice.cast();
	}
}