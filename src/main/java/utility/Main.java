package utility;

import automationFramework.Apache_POI_TC;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Main {
	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { Apache_POI_TC.class });
		testng.addListener(tla);
		testng.run();
	}
}
