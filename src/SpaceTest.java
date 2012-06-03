import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;


public class SpaceTest {
	public static int ALIVE = 1;

	@Test
	public void test’a¶_€‚ñ‚Å‚¢‚éƒZƒ‹‚É—×Ú‚·‚é¶‚«‚½ƒZƒ‹‚ª‚¿‚å‚¤‚Ç3‚Â‚ ‚ê‚ÎŸ‚Ì¢‘ã‚ª’a¶‚·‚é() {
		Integer[][] cells = new Integer[][] {{1,1,0},
				                             {1,0,0},
											 {0,0,0}}; 
		assertThat(new Space(cells).nextTime().cell(1,1).status, 
				is(ALIVE));
	}
}
