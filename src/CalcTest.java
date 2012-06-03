import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class CalcTest {
	@Test
	public void �����Z�ł���() {
		Calc calc = new Calc();
		assertThat(calc.add(1, 2), is(3));
	}

	@Test(expected=ArithmeticException.class)
	public void �[���Ŋ���Ɨ�O����������() throws Exception {
		Calc calc = new Calc();
		calc.div(1, 0);
	}
}
