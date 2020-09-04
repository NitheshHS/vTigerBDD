package browserStack;

import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest {
	@Test(dataProvider="readData")
	public void getData(Platform platform,String browserName,String browserVaersion) {
		
		System.out.println(platform.toString()+" "+browserName+" "+browserVaersion);
		
	}
	@DataProvider
	public Object[][] readData(){
		Object[][] testdata=new Object[][] {
			{Platform.WIN10,"chrome","81"},
			{Platform.WIN8,"chrome","80"},
			{Platform.MAC,"safari","13"}
		};
		return testdata;
	}
//Object[3][3]
}
