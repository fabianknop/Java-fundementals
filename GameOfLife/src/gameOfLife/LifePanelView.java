package gameOfLife;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LifePanelView extends JPanel implements Observer {
	LifeModel model;
	public boolean[][] grid;

	public LifePanelView(LifeModel model) {
		this.model = model;
		model.addObserver(this);
		GridLayout layout = new GridLayout(20, 30);
		setLayout(layout);
		for (int rij = 0; rij < model.getGrid().length; rij++) {
			for (int kolom = 0; kolom < model.getGrid()[0].length; kolom++) {
				if (model.isLevend(rij, kolom)) {
					CelController celController = new CelController(model, rij, kolom);
					JButton knop = new JButton();
					knop.setBackground(Color.white);
					knop.addActionListener(celController);
					add(knop);
				} else {
					CelController celController = new CelController(model, rij, kolom);
					JButton knop = new JButton();
					knop.setBackground(Color.white);
					knop.addActionListener(celController);
					add(knop);
				}
			}
		}
	}

	public void displayCel(int row, int column) {
		JButton knop = new JButton();
		CelController celController = new CelController(model, row, column);
		if (model.isLevend(row, column)) {
			knop.setBackground(Color.white);
			knop.addActionListener(celController);
			add(knop);
		} else {
			knop.setBackground(Color.black);
			knop.addActionListener(celController);
		}
		add(knop);
	}

	private void refresh() {
		grid = model.getGrid();
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 30; j++) {
				displayCel(i, j);
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 != null) {
			CelPosition celPos = (CelPosition) arg1;
			displayCel(celPos.rij, celPos.kolom);
		}
		this.removeAll();
		refresh();
		this.updateUI();
	}
}
