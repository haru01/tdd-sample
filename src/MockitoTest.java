import static org.mockito.Mockito.*;

import org.junit.Test;


public class MockitoTest {
	@Test
	public void モックテスト例() throws Exception {
		ExternalComponent mock = mock(ExternalComponent.class);
		Target target = new Target(mock);
		target.run("message");
		verify(mock).send("MESSAGE"); 
	}
}

interface ExternalComponent {
	public void send(String message);
}

class Target {
	private ExternalComponent component;
	public Target(ExternalComponent component) {
		this.component = component;
	}
	public void run(String message) {
		this.component.send(message.toUpperCase());
	}
}

