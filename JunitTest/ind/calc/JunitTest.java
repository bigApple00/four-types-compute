package ind.calc;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JunitTest {
	

	@Before
	public void setUp() throws Exception {
		
		}

	@Test
	public void testUnderHundred() {
		 Ui.x = Logic.produceNumber1();
		 Ui.y = Logic.produceNumber1();
		Logic.underHundred();
		Assert.assertTrue("加法小于一百", Ui.x + Ui.y < 100);
		
	}

	@Test
	public void testUnderHundred2() {
		 Ui.x = Logic.produceNumber1();
		 Ui.y = Logic.produceNumber1();
		Logic.underHundred2();
		Assert.assertTrue("乘法小于一百", Ui.x + Ui.y < 100);
	}

	@Test
	public void testBigSubtractsmall() {
		Ui.x = Logic.produceNumber1();
 		Logic.bigSubtractsmall();
		Assert.assertTrue("满足大减小", Ui.x > Ui.y);
		
	}

	@Test
	public void testExactDivide() {
		Logic.exactDivide();
		Assert.assertTrue("可以整除", (Ui.x % Ui.y == 0));

	}



}
