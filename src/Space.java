import java.util.ArrayList;
import java.util.List;

public class Space {
	
	private Cell[][] cells;
	public Space(Cell[][] cells) {
		this.cells = cells;
	}

	public Space(Integer[][] nodeCells) {
		this.cells = new Space.Cell[nodeCells.length][];
		for (int row = 0; row < nodeCells.length; row++) {
			this.cells[row] = new Space.Cell[nodeCells[row].length];
			for (int column = 0; column < nodeCells[row].length; column++) {
				this.cells[row][column] = new Cell(nodeCells[row][column], row, column);
			}
		}
	}

	public Space nextTime() {
		Cell[][] nextCells = new Cell[this.cells.length][];
		for (int row = 0; row < this.cells.length; row++) {
			nextCells[row] = new Cell[this.cells[row].length];
			for (int column = 0; column < this.cells[row].length; column++) {
				nextCells[row][column] = this.cells[row][column].nextTime();
			}
		}
		return new Space(nextCells);
	}

	public Space.Cell cell(int row, int column) {
		return cells[row][column];
	}
	
	public class Cell {
		private static final int ALIVE = 1;
		public final int status;
		public final int row;
		public final int column;
		private Cell(int status, int row, int column) {
			this.status = status;
			this.row = row;
			this.column = column;
		}

		public Boolean isAlive() {
			return !isDead();
		}

		public Boolean isDead() {
			return this.status == 0;
		}
		
		private Cell nextTime() {
			if (countAroundAlive() == 3) {
				return new Cell(ALIVE, this.row, this.column);
			}
			// TODO;
			return this;
		}

		public int countAroundAlive() {
			int counter = 0;
			for (Cell cell : aroundCells()) {
				if (cell.isAlive()) {
					counter ++;
				}
			}
			return counter;
		}

		public List<Cell> aroundCells() {
			List<Cell> results = new ArrayList<Cell>();
			for (int rowIndex = row - 1; rowIndex <= row + 1; rowIndex++) {
				for (int columnIndex = column - 1; columnIndex <= column + 1; columnIndex++) {
					if(rowIndex == row && columnIndex == column) {
						continue;
					}
					if (inSapce(rowIndex, columnIndex)) { 
						results.add(cells[rowIndex][columnIndex]);
					}
				}
			}
			return results;
		}
		
		private boolean inSapce(int row, int column) {
			return 0 <= row && 0 <= column &&
				  row <= cells.length - 1 && column <= cells[row].length - 1;
		}

		@Override
		public String toString() {
			return "[staus:" + status + ", row:" + row + ", column:" + column + "]";
		}
	}
}
