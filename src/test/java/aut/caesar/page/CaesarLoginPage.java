package aut.caesar.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.config.IConstants;
import com.testreport.IReporter;

import aut.pages.SoftCoLoginPage;
import aut.pages.templates.PageTemplate;

public class CaesarLoginPage extends PageTemplate {
	
	private static final Logger LOG = Logger.getLogger(SoftCoLoginPage.class);
	public CaesarLoginPage(WebDriver webDriver, IReporter testReport) {
		super(webDriver, testReport);
		
	}
	
	public boolean login(String url, String userName, String password) throws Exception
	{
		boolean isSuccess = false;
		try
		{
			String bySignin = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME,"SignIn");
			this.driver.get(url);
			this.waitUntilElementIsClickable(By.xpath(bySignin));
			this.Click(By.xpath(bySignin));
			
			String byUserName = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME,"SignIn");
			String byPassword = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME,"SignIn");
			
			this.SendKeys(By.xpath(byUserName), userName);
			this.SendKeys(By.xpath(byPassword), userName);
			
			
			isSuccess = true;
		}
		catch(Exception ex)
		{
			isSuccess = false;
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
			this.testReport.logFailure(
					String.format("Class Name - %s , Method Name - %s, Line Number - %s, Exception Encountered - %s",
					ex.getStackTrace()[2].getClassName(), ex.getStackTrace()[2].getMethodName(),
					ex.getStackTrace()[2].getLineNumber(), ex.getMessage()));
			throw ex;
		}
		
		return isSuccess;
	}
	


}
