package Dobbelsteen;

import java.util.Observable;
import java.util.Observer;

public class DiceView implements Observer {
	private SetOfDice setOfDice;
	private DieConsoleView[] dieViews;

	public DiceView(SetOfDice setOfDice) {
		this.setOfDice = setOfDice;
		setOfDice.addObserver(this);
		int number = setOfDice.getNumberOfDice();
		dieViews = new DieConsoleView[number];
		for (int i = 0; i < number; i++)
			dieViews[i] = new DieConsoleView(setOfDice.getDie(i));
	}

	public void refresh() {
		for (DieConsoleView view : dieViews)
			view.refresh();
		System.out.println("total: " + setOfDice.getValue());
	}

	@Override
	public void update(Observable setOfDice, Object info) {
		refresh();
	}
}
