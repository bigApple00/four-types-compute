package ind.calc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestUi {
	Ui g;

	@Before
	public void setUp() throws Exception {
		g = new Ui();
	}

	@Test
	public void testUi() {
	
		g.setResizable(false);
		assertNotNull("构造成功", new Ui());
		
		
	}
	
    @Test
	public void testActionPerformed() {
		
	}

	@Test
	public void testMain() {
	}

	
	
}
