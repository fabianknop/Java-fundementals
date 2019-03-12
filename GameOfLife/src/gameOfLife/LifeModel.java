package gameOfLife;

import java.util.Observable;
import java.util.Random;

public class LifeModel extends Observable {
	private boolean[][] grid = new boolean[20][30];

	public boolean[][] getGrid() {
		return grid;
	}

	public void setGrid(boolean[][] grid) {
		this.grid = grid;
	}

	public LifeModel() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 30; j++) {
				if (i == 0 || i == 19) {
					grid[i][j] = false;
				}
				Random generator = new Random();
				int valueOfCel = generator.nextInt(10);
				if (valueOfCel == 1) {
					grid[i][j] = true;
				} else
					grid[i][j] = false;
			}
		}
	}

	public void toggle(int rij, int kolom) {
		grid[rij][kolom] = !grid[rij][kolom];
		setChanged();
		notifyObservers(new CelPosition(rij, kolom));
	}

	public boolean isLevend(int rij, int kolom) {
		return grid[rij][kolom];
	}

	public void toon() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 30; j++) {
				if (isLevend(i, j)) {
					System.out.print("X");
				} else
					System.out.print(".");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	private int telBuren(int rij, int kolom) {
		int count = 0;
		for (int i = rij - 1; i <= rij + 1; i++) {
			if (i >= 0 && i < grid.length)
				for (int j = kolom - 1; j <= kolom + 1; j++)
					if (j >= 0 && j < grid[i].length)
						if (i != rij || j != kolom)
							if (grid[i][j] == true)
								count++;
		}

		return count;
	}

	private boolean evalueer(int rij, int kolom) {
		int aantalBuren = telBuren(rij, kolom);
		if (isLevend(rij, kolom)) {
			if (aantalBuren < 2 || aantalBuren > 3) {
				return false;
			} else
				return true;
		} else if (aantalBuren == 3) {
			return true;
		} else
			return false;
	}

	public void volgendeGeneratie() {
		boolean[][] nieuwGrid = new boolean[20][30];

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 30; j++) {
				nieuwGrid[i][j] = evalueer(i, j);
				grid[i][j] = nieuwGrid[i][j];
			}
		}
		setChanged();
		notifyObservers();
	}

	public void test() {
		int aantalBuren = telBuren(1, 3);
		System.out.println("Rij: " + 1 + " Kolom: " + 3 + " Buren: " + aantalBuren);

		aantalBuren = telBuren(0, 7);
		System.out.println("Rij: " + 0 + " Kolom: " + 7 + " Buren: " + aantalBuren);

		System.out.println("Oud: " + grid[1][3] + " Nieuw: " + evalueer(1, 3));
		System.out.println("Oud: " + grid[1][3] + " Nieuw: " + evalueer(0, 7));
	}
}
