package TestCasesForListener;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class CalculatorTestCases {
	
	
	int a= 10, b = 20 , c;
	
	@Test(priority = 1)
	public void add()
	{
		c = a+b;
		Assert.assertEquals(30,30);
	}
	
	@Test(priority = 2)
	public void minus()
	{
		c = a-b;
		Assert.assertEquals(10,-10);
	}
	
	@Test(priority = 3)
	public void multiplication()
	{
		c = a*b;
		Assert.assertEquals(200,200);
	}

	@Test(priority = 4)
	public void divide()
	{
		c =a/b;
		if(c>-10)
			throw new SkipException("Test Skipped");
	}
	
	
}
