import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;


public class SpaceTest {
	public static int ALIVE = 1;

	@Test
	public void test�a��_����ł���Z���ɗאڂ��鐶�����Z�������傤��3����Ύ��̐��オ�a������() {
		Integer[][] cells = new Integer[][] {{1,1,0},
				                             {1,0,0},
											 {0,0,0}}; 
		assertThat(new Space(cells).nextTime().cell(1,1).status, 
				is(ALIVE));
	}
}
