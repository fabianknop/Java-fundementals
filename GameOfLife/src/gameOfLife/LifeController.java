package gameOfLife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifeController implements ActionListener {
	LifeModel model;

	public LifeController(LifeModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		model.volgendeGeneratie();
	}
}