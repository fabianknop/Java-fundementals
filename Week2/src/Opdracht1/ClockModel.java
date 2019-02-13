package Opdracht1;

import java.time.LocalTime;
import java.util.Observable;

public class ClockModel extends Observable{
	private int hour, minute;
	
	public ClockModel(){
		getDateTime();
	}

	public void getDateTime() {
		LocalTime time = LocalTime.now();
		hour = time.getHour();
		minute = time.getMinute();
	}

	public int getHour() {
		return hour;
	}
	
	public int getMinute(){
		return minute;
	}
	
	public void nextMinute(){
		if(minute < 59){
			minute++;
		}else if(hour < 23) {
			hour++;
			minute = 00;
		} else {
			hour = 0;
			minute = 0;
		}
		setChanged();
		notifyObservers();
	}
}
