package gameOfLife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelController implements ActionListener {
	private LifeModel model;
	private int rij;
	private int kolom;

	public CelController(LifeModel model, int rij, int kolom) {
		this.model = model;
		this.rij = rij;
		this.kolom = kolom;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		model.toggle(rij, kolom);
	}
}
