import static org.junit.Assert.*;

import org.junit.Test;


public class TestLRS 
{
	private LRS lrs;
	
	public TestLRS()
	{
		lrs = new LRS();
	}
	@Test
	public void test() 
	{
		String test = "banana";
		String answer = lrs.LRS(test);
		String expected = "ana";
		assertTrue(answer.equals(expected));
	}

	
	@Test
	public void testTwo() 
	{
		String test = "bananabanana";
		String answer = lrs.LRS(test);
		String expected = "banana";
		assertTrue(answer.equals(expected));
	}
}
