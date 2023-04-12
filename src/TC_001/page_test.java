package TC_001;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class page_test {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	  driver=new ChromeDriver(options);

       driver.get("https://github.com/");
 
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
	@Test(priority=0)
	public void VarifyTitle()
	{
		
		String actualTitle=driver.getTitle();
		//String ExceptionTitle="Github: Log In or Sign in";
		//Assert.assertEquals(actualTitle, ExceptionTitle);
		System.out.println(actualTitle);
}
	@Test(priority=1)
	 public void VerifyLogo()//2
		{
			boolean flag=driver.findElement(By.xpath("//*[@href='/login']")).isDisplayed();
			Assert.assertTrue(flag);
		}
		@Test(priority=2)
		public void login() throws InterruptedException//3
		{
			driver.findElement(By.xpath("//a[@href='/login']")).click();
			/*WebElement Email=driver.findElement(By.name("login"));
            Email.sendKeys("muktarasal200@gmail.com");
			WebElement pass=driver.findElement(By.id("password"));
			pass.sendKeys("MastiZade09");
			WebElement status=driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[11]"));
            status.click();*/
			driver.findElement(By.name("login")).sendKeys("muktarasal");
			driver.findElement(By.id("password")).sendKeys("MastiZade09");
			driver.findElement(By.name("commit")).click();
		}

		@Test(priority=3)
		public void Screen()
		{
			driver.manage().window().maximize();
		}
		@Test(priority=4)
		public void scroll()
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("window.scrollBy(0,1000)");
			
		}
		@AfterMethod
		public void close()
		{
			driver.quit();
			
		}}
            
			