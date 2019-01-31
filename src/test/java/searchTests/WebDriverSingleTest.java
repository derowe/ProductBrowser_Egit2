package searchTests;

import org.testng.annotations.Test;
import com.agiletestware.bumblebee.annotations.BooleanValue;
import com.agiletestware.bumblebee.annotations.Bumblebee;
import com.agiletestware.bumblebee.annotations.BumblebeeTestStep;


//method-level annotations values
@Bumblebee(testname = "WebDriverSingleTest", testplan = "Subject\\Product Browser\\Search", testlab = "Root\\Product Browser\\2019\\CCB 01-2019", 
testset = "CCB - Method Annotations", hasSteps = BooleanValue.TRUE)
public class WebDriverSingleTest {


		@BumblebeeTestStep(name = "methodOneStep", description = "Method One Step Description", expected = "Step 1 Expected Results")
    	@Test(priority = 1)
	    public void methodOne() {
	        System.out.println("Passed");
	    }
		@BumblebeeTestStep(name = "methodTwoStep", description = "Method Two Step Description", expected = "Step 2 Expected Results")
	    @Test(priority = 2)
	    public void methodTwo() {
	        throw new RuntimeException("ooops");
	    }
		@BumblebeeTestStep(name = "methodThreeStep", description = "Method Three Step Description", expected = "Step 3 Expected Results updated")
	    @Test(priority = 3)
	    public void methodThree() {
	        System.out.println("Passed");
	    }
	

}
