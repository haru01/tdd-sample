
public class Space {
	private static int ALIVE = 1;
	private static int DEAD = 0;
	
	private Cell[][] cells;
	public class Cell {
		public final int status;
		private Cell(int status) {
			this.status = status;
		}
	};
	
	public Space(Integer[][] cells) {
		this.cells = new Space.Cell[cells.length][];
		for (int row = 0; row < cells.length; row++) {
			this.cells[row] = new Space.Cell[cells[row].length];
			for (int colum = 0; colum < cells[row].length; colum++) {
				this.cells[row][colum] = new Cell(cells[row][colum]);
			}
		}
	}

	public Space(Space.Cell[][] cells) {
		this.cells = cells;
	}

	public Space nextTime() {
		// TODO
		return new Space(this.cells);
	}

	public Space.Cell cell(int row, int colum) {
		return new Space.Cell(ALIVE);
	}
}
