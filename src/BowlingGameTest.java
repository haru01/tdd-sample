import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;

public class BowlingGameTest {

//  score
	@Test
	public void �T���v���̃X�R�A�v�Z�ł��邱��() {
		BowlingGame game = new BowlingGame(new Integer[] {5, 4, 0, 0, 10, 0, 9, 1, 6, 3, 7, 0, 6, 2, 10, 0, 10, 0, 1, 9, 5});
		assertThat(game.score(), is(125));
	}

	@Test
	public void �X�y�A�X�g���C�N�Ȃ��̏ꍇ�̃X�R�A�v�Z���ł��邱��() {
		BowlingGame game = new BowlingGame(new Integer[] {5, 4, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
		assertThat(game.score(), is((5+4) + (3+2)));
	}

	@Test
	public void �X�y�A�̏ꍇ�̃X�R�A�v�Z���ł��邱��() {
		BowlingGame game = new BowlingGame(new Integer[] {6, 4, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 7, 6, 4, 1});
		assertThat(game.score(), is((6+4+3) + (3+2) + (3+7+6) + (6+4+1)));
	}

	@Test
	public void �p�[�t�F�N�g�Q�[���̃X�R�A�v�Z�ł��邱��() {
		BowlingGame game = new BowlingGame(new Integer[] {10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 10, 10});
		assertThat(game.score(), is(300));
	}

	@Test
	public void ��t���[���ڃX�g���C�N�̏ꍇ�̃X�R�A�v�Z���ł��邱��() {
		BowlingGame game = new BowlingGame(new Integer[] {10, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
		assertThat(game.score(), is((10+0+3+2) + (3+2)));
	}

	@Test
	public void �\�t���[���ڃX�g���C�N�̏ꍇ�̃X�R�A�v�Z���ł��邱��() {
		BowlingGame game = new BowlingGame(new Integer[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 10});
		assertThat(game.score(), is((10+10+10)));
	}

	@Test
	public void ��t���[���ڃX�g���C�N�̏ꍇ�̃X�R�A�v�Z���ł��邱��() {
		BowlingGame game = new BowlingGame(new Integer[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 10, 2, 0});
		assertThat(game.score(), is((10+0+10+2) + (10+2+0)));
	}

// ------------------------------------------------------------------------------------
	@Test
	public void �X�y�A�X�g���C�N�Ȃ��̏ꍇ�̃T�u�X�R�A�v�Z�p�̔z��ϊ����ł��邱��() {
		// arrange
		BowlingGame game = new BowlingGame(new Integer[] {5, 4, 3, 2});
		// act assert
		assertThat(game.subScoreRolls(1), hasItems(5, 4));
		assertThat(game.subScoreRolls(2), hasItems(3, 2));
	}

	@Test
	public void �X�y�A�̏ꍇ�̃T�u�X�R�A�v�Z�p�̔z��ϊ����ł��邱��() {
		// arrange
		BowlingGame game = new BowlingGame(new Integer[] {6, 4, 3, 2});
		// act assert
		assertThat(game.subScoreRolls(1), hasItems(6, 4, 3));
	}

	@Test
	public void �X�g���C�N�̏ꍇ�̃T�u�X�R�A�v�Z�p�̔z��ϊ����ł��邱��() {
		// arrange
		BowlingGame game = new BowlingGame(new Integer[] {10, 0, 3, 2});
		// act assert
		assertThat(game.subScoreRolls(1), hasItems(10, 0, 3, 2));
	}

	@Test
	public void �A���X�g���C�N�̏ꍇ�̃T�u�X�R�A�v�Z�p�̔z��ϊ����ł��邱��() {
		// arrange
		BowlingGame game = new BowlingGame(new Integer[] {10, 0, 10, 0, 3, 4});
		// act assert
		assertThat(game.subScoreRolls(1), hasItems(10, 0, 10, 0, 3));
	}

	// isSpare
	@Test
	public void �X�g���C�N�̏ꍇ��false��Ԃ�() {
		// arrange
		BowlingGame game = new BowlingGame(new Integer[] {10, 0});
		// act assert
		assertThat(game.isSpare(0), is(false));
	}

	@Test
	public void �X�y�A�̏ꍇ��true��Ԃ�() {
		// arrange
		BowlingGame game = new BowlingGame(new Integer[] {6, 4});
		// act assert
		assertThat(game.isSpare(0), is(true));
	}

	@Test
	public void �ʏ�̏ꍇ��false��Ԃ�() {
		// arrange
		BowlingGame game = new BowlingGame(new Integer[] {6, 3});
		// act assert
		assertThat(game.isSpare(0), is(false));
	}
}
