package Dobbelsteen;

public class DieConsoleView {

	private Die die;

	public DieConsoleView(Die die) {
		this.die = die;
	}

	public void refresh() {
		System.out.print("[");
		System.out.print(die.getValue());
		System.out.print(" ]");
	}
}
