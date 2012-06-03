import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.util.List;
import org.junit.Test;

public class SpaceTest {
	public static int ALIVE = 1;

	private Integer[][] sampleCalse() {
		return aliveCase();
	}
	
	private Integer[][] aliveCase() {
		return new Integer[][] {{1,1,0},
				                {1,0,0},
								{0,0,0}};
	}

	private Integer[][] survival2Case() {
		return new Integer[][] {{1,1,0},
								{0,1,0},
								{0,0,0}};
	}

	private Integer[][] survival3Case() {
		return new Integer[][] {{1,1,1},
								{0,1,0},
								{0,0,0}};
	}

	@Test
	public void �a��_����ł���Z���ɗאڂ��鐶�����Z�������傤��3����Ύ��̐��オ�a������() {
		assertThat(new Space(aliveCase()).nextTime().cell(1,1).isAlive(), 
				is(true));
	}

	@Test
	public void ����_����ł���Z���ɗאڂ��鐶�����Z�����Q��3����Ύ��̐��オ�a������() {
		assertThat(new Space(survival2Case()).nextTime().cell(1,1).isAlive(), 
				is(true));
		assertThat(new Space(survival3Case()).nextTime().cell(1,1).isAlive(), 
				is(true));

	}



	// Cell#countAroundAlive()
	@Test
	public void ����̐����Ă���Z���̐����J�E���g�ł��邱��() throws Exception {
		assertThat(new Space(aliveCase()).cell(1, 1).countAroundAlive(), is(3));
	}

	// Cell#aroundCells()
	
	@Test
	public void �����̏ꍇ�̎���̃Z�����擾�ł��邱��() throws Exception {
		Space space = new Space(aliveCase());
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
	public void ������̏ꍇ�̎���̃Z�����擾�ł��邱��() throws Exception {
		Space space = new Space(sampleCalse());
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
	public void �E�����̏ꍇ�̎���̃Z�����擾�ł��邱��() throws Exception {
		Space space = new Space(sampleCalse());
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
	public void �E����̏ꍇ�̎���̃Z�����擾�ł��邱��() throws Exception {
		Space space = new Space(sampleCalse());
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
