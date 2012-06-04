import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;

public class BowlingGameTest {

//  score
	@Test
	public void サンプルのスコア計算できること() {
		BowlingGame game = new BowlingGame(new Integer[] {5, 4, 0, 0, 10, 0, 9, 1, 6, 3, 7, 0, 6, 2, 10, 0, 10, 0, 1, 9, 5});
		assertThat(game.score(), is(125));
	}

	@Test
	public void スペアストライクなしの場合のスコア計算ができること() {
		BowlingGame game = new BowlingGame(new Integer[] {5, 4, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
		assertThat(game.score(), is((5+4) + (3+2)));
	}

	@Test
	public void スペアの場合のスコア計算ができること() {
		BowlingGame game = new BowlingGame(new Integer[] {6, 4, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 7, 6, 4, 1});
		assertThat(game.score(), is((6+4+3) + (3+2) + (3+7+6) + (6+4+1)));
	}

	@Test
	public void パーフェクトゲームのスコア計算できること() {
		BowlingGame game = new BowlingGame(new Integer[] {10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 10, 10});
		assertThat(game.score(), is(300));
	}

	@Test
	public void 一フレーム目ストライクの場合のスコア計算ができること() {
		BowlingGame game = new BowlingGame(new Integer[] {10, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
		assertThat(game.score(), is((10+0+3+2) + (3+2)));
	}

	@Test
	public void 十フレーム目ストライクの場合のスコア計算ができること() {
		BowlingGame game = new BowlingGame(new Integer[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 10});
		assertThat(game.score(), is((10+10+10)));
	}

	@Test
	public void 九フレーム目ストライクの場合のスコア計算ができること() {
		BowlingGame game = new BowlingGame(new Integer[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 10, 2, 0});
		assertThat(game.score(), is((10+0+10+2) + (10+2+0)));
	}

// ------------------------------------------------------------------------------------
	@Test
	public void スペアストライクなしの場合のサブスコア計算用の配列変換ができること() {
		// arrange
		BowlingGame game = new BowlingGame(new Integer[] {5, 4, 3, 2});
		// act assert
		assertThat(game.subScoreRolls(1), hasItems(5, 4));
		assertThat(game.subScoreRolls(2), hasItems(3, 2));
	}

	@Test
	public void スペアの場合のサブスコア計算用の配列変換ができること() {
		// arrange
		BowlingGame game = new BowlingGame(new Integer[] {6, 4, 3, 2});
		// act assert
		assertThat(game.subScoreRolls(1), hasItems(6, 4, 3));
	}

	@Test
	public void ストライクの場合のサブスコア計算用の配列変換ができること() {
		// arrange
		BowlingGame game = new BowlingGame(new Integer[] {10, 0, 3, 2});
		// act assert
		assertThat(game.subScoreRolls(1), hasItems(10, 0, 3, 2));
	}

	@Test
	public void 連続ストライクの場合のサブスコア計算用の配列変換ができること() {
		// arrange
		BowlingGame game = new BowlingGame(new Integer[] {10, 0, 10, 0, 3, 4});
		// act assert
		assertThat(game.subScoreRolls(1), hasItems(10, 0, 10, 0, 3));
	}

	// isSpare
	@Test
	public void ストライクの場合はfalseを返す() {
		// arrange
		BowlingGame game = new BowlingGame(new Integer[] {10, 0});
		// act assert
		assertThat(game.isSpare(0), is(false));
	}

	@Test
	public void スペアの場合はtrueを返す() {
		// arrange
		BowlingGame game = new BowlingGame(new Integer[] {6, 4});
		// act assert
		assertThat(game.isSpare(0), is(true));
	}

	@Test
	public void 通常の場合はfalseを返す() {
		// arrange
		BowlingGame game = new BowlingGame(new Integer[] {6, 3});
		// act assert
		assertThat(game.isSpare(0), is(false));
	}
}
