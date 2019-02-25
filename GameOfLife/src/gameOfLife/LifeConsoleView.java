package gameOfLife;

import java.util.Observable;
import java.util.Observer;

public class LifeConsoleView implements Observer{
	LifeModel model; 
	public boolean[][] grid;
	public LifeConsoleView(LifeModel model){
		this.model = model;
		model.addObserver(this);
	}
	
	public void displayCel(int row, int column){
		if(model.isLevend(row, column)){
			System.out.print("X");
		} else System.out.print(".");
	}
	
	private void refresh(){
		grid = model.getGrid();
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 30; j++){
				displayCel(i,j);
			}
			System.out.println("");
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		refresh();		
	}
}
