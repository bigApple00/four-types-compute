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
		Assert.assertTrue("�ӷ�С��һ��", Ui.x + Ui.y < 100);
		
	}

	@Test
	public void testUnderHundred2() {
		 Ui.x = Logic.produceNumber1();
		 Ui.y = Logic.produceNumber1();
		Logic.underHundred2();
		Assert.assertTrue("�˷�С��һ��", Ui.x + Ui.y < 100);
	}

	@Test
	public void testBigSubtractsmall() {
		Ui.x = Logic.produceNumber1();
 		Logic.bigSubtractsmall();
		Assert.assertTrue("������С", Ui.x > Ui.y);
		
	}

	@Test
	public void testExactDivide() {
		Logic.exactDivide();
		Assert.assertTrue("��������", (Ui.x % Ui.y == 0));

	}



}
