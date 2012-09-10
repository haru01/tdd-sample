import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SpaceTest {
	public static class 誕生_死んでいるセルに隣接する生きたセルがちょうど3つならば {
		private Space space;

		@Before
		public void setUp() {
			space =  new Space(new Integer[][] {{1,1,0},{1,0,0},{0,0,0}});
		}

		@Test
		public void 次の世代で誕生する() {
			assertThat(space.nextTime().cell(1,1).isAlive(), is(true));
		}
	}

	public static class 生存_2_生きているセルに隣接する生きたセルが2つならば_次の世代でも生存する {
		private Space space;

		@Before
		public void setUp() {
			space =  new Space(new Integer[][] {{1,1,0},{0,1,0},{0,0,0}});
		}

		@Test
		public void 次の世代で生存する() {
			assertThat(space.nextTime().cell(1,1).isAlive(), is(true));
		}
	}

	public static class 生存_3_生きているセルに隣接する生きたセルが3つならば_次の世代でも生存する {
		private Space space;

		@Before
		public void setUp() {
			space =  new Space(new Integer[][] {{1,1,1},{0,1,0},{0,0,0}});
		}

		@Test
		public void 次の世代で生存する() {
			assertThat(space.nextTime().cell(1,1).isAlive(), is(true));
		}
	}

	public static class 死滅_過疎_生きているセルに隣接する生きたセルが1つ以下ならば_過疎により死滅する {
		private Space space;

		@Before
		public void setUp() {
			space =  new Space(new Integer[][] {{0,1,0},{0,1,0},{0,0,0}});
		}

		@Test
		public void 次の世代で死滅する() {
			assertThat(space.nextTime().cell(1,1).isAlive(), is(false));
		}
	}

	public static class 死滅_過密_生きているセルに隣接する生きたセルが4つ以上ならば_過密により死滅する {
		private Space space;

		@Before
		public void setUp() {
			space =  new Space(new Integer[][] {{1,1,1},{0,1,1},{0,0,0}});
		}

		@Test
		public void 次の世代で死滅する() {
			assertThat(space.nextTime().cell(1,1).isAlive(), is(false));
		}
	}

// 補助問題
	public static class aroundCell {
		
		private Space space;

		private Integer[][] sampleCalse() {
			return new Integer[][] {{1,1,0},
									{1,0,0},
									{0,0,0}};
		}
		
		@Before
		public void setUp() {
			space = new Space(sampleCalse());
		}

		@Test
		public void 中央の場合の周りのセルが取得できること() throws Exception {
			List<Space.Cell> aroundCells = space.cell(1,1).aroundCells();

			assertThat(aroundCells.size(), is(8));
			assertThat(aroundCells, 
					hasItems(space.cell(0, 0),
							 space.cell(0, 1),
							 space.cell(0, 2),
							 space.cell(1, 0),
							 space.cell(1, 2),
							 space.cell(2, 0),
							 space.cell(2, 1),
							 space.cell(2, 2)));
			assertThat(aroundCells, 
					not(hasItems(
							 space.cell(1, 1))));
		}


		@Test
		public void 左上隅の場合の周りのセルが取得できること() throws Exception {
			List<Space.Cell> aroundCells = space.cell(0, 0).aroundCells();
			assertThat(aroundCells.size(), is(3));
			assertThat(aroundCells, 
					hasItems(space.cell(0, 1),
							 space.cell(1, 0),
							 space.cell(1, 1)));
			assertThat(aroundCells, 
					not(hasItems(
							 space.cell(0, 0))));
		}

		@Test
		public void 右下隅の場合の周りのセルが取得できること() throws Exception {
			List<Space.Cell> aroundCells = space.cell(2, 2).aroundCells();

			assertThat(aroundCells.size(), is(3));
			assertThat(aroundCells, 
					hasItems(space.cell(1, 1),
							 space.cell(1, 2),
							 space.cell(2, 1)));
			assertThat(aroundCells, 
					not(hasItems(
							 space.cell(2, 2))));
		}

		@Test
		public void 右上隅の場合の周りのセルが取得できること() throws Exception {
			List<Space.Cell> aroundCells = space.cell(0, 2).aroundCells();

			assertThat(aroundCells.size(), is(3));
			assertThat(aroundCells, 
					hasItems(space.cell(0, 1),
							 space.cell(1, 1),
							 space.cell(1, 2)));
			assertThat(aroundCells, 
					not(hasItems(
							 space.cell(0, 2))));
		}
	}
}