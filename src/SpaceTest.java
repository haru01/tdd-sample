import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;


public class SpaceTest {
	public static int ALIVE = 1;

	@Test
	public void test誕生_死んでいるセルに隣接する生きたセルがちょうど3つあれば次の世代が誕生する() {
		Integer[][] cells = new Integer[][] {{1,1,0},
				                             {1,0,0},
											 {0,0,0}}; 
		assertThat(new Space(cells).nextTime().cell(1,1).status, 
				is(ALIVE));
	}
}
