
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.Reporter;
import org.testng.ITestResult;


public class CalculatorTest {

    @BeforeSuite
    public void setUp() throws Exception {

    }

    @AfterSuite
    public void tearDown() throws Exception {
    }



    @DataProvider
    public Object[][] ValidDataProvider() {
        return new Object[][]{
                {  1, 2, 3 },
                {  2, 3, 4 },  // error or the data itself :)
                { -1, 1, 0 }
        };
    }


    @Test(dataProvider = "ValidDataProvider")
    public void CanAddNumbersFromGivenData(final int a, final int b, final int c)
    {
        Assert.assertEquals(Calculator.Add(a, b), c);
        ITestResult result = Reporter.getCurrentTestResult();
        result.setAttribute("requirement", "CALC-1234");
        result.setAttribute("test", "CALC-2");
    }


    @Test
    public void CanAddNumbers()
    {
        Assert.assertEquals(Calculator.Add(1, 1),2);
        Assert.assertEquals(Calculator.Add(-1, 1),0);
        ITestResult result = Reporter.getCurrentTestResult();
        result.setAttribute("requirement", "CALC-1234");
        result.setAttribute("test", "CALC-2");
        result.setAttribute("labels", "core addition");
    }


    @Test
    public void CanSubtract()
    {
        Assert.assertEquals(Calculator.Subtract(1, 1), 0);
        Assert.assertEquals(Calculator.Subtract(-1, -1), 0);
        Assert.assertEquals(Calculator.Subtract(100, 5), 95);
        ITestResult result = Reporter.getCurrentTestResult();
        result.setAttribute("requirement", "CALC-1235");
        result.setAttribute("labels", "core");
    }


    @Test
    public void CanMultiplyX()
    {
        Assert.assertEquals(Calculator.Multiply(1, 1), 1);
        Assert.assertEquals(Calculator.Multiply(-1, -1), 1);
        Assert.assertEquals(Calculator.Multiply(100, 5), 500);
        ITestResult result = Reporter.getCurrentTestResult();
        result.setAttribute("requirement", "CALC-1236");
    }


    @Test
    public void CanDivide()
    {
        Assert.assertEquals(Calculator.Divide(1, 1), 1);
        Assert.assertEquals(Calculator.Divide(-1, -1), 1);
        Assert.assertEquals(Calculator.Divide(100, 5), 20);
        ITestResult result = Reporter.getCurrentTestResult();
        result.setAttribute("requirement", "CALC-1237");
    }


    @Test
    public void CanDoStuff()
    {
        Assert.assertNotEquals(true, true);
        ITestResult result = Reporter.getCurrentTestResult();
    }

}