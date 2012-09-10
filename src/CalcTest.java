import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class CalcTest {
	@Test
	public void 足し算できる() {
		Calc calc = new Calc();
		assertThat(calc.add(1, 2), is(3));
	}

	@Test(expected=ArithmeticException.class)
	public void ゼロで割ると例外が発生する() throws Exception {
		Calc calc = new Calc();
		calc.div(1, 0);
	}
}
