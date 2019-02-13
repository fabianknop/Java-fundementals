package Opdracht1;

import java.util.Observable;
import java.util.Observer;

import Dobbelsteen.DieConsoleView;

public class ClockConsoleView implements Observer {
	ClockModel model = new ClockModel();
	int hour = model.getHour();
	int minute = model.getMinute();

	public ClockConsoleView(ClockModel model) {
		this.model = model;
		model.addObserver(this);
		refresh();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		refresh();
	}

	public void refresh() {
		int hour = model.getHour();
		int minute = model.getMinute();
		if(minute < 10){
			System.out.println(hour + ":0" + minute);
		} else System.out.println(hour + ":" + minute);
	}

}
