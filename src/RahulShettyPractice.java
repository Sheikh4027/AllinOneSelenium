

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RahulShettyPractice {


	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ahmad\\Downloads\\Documents\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("//div[@class='block large-row-spacer']/div[1]/fieldset/label[1]")).click();

		driver.findElement(By.xpath("//div[@id='radio-btn-example']//label[1]//input[1]")).click();
		WebElement country= driver.findElement(By.cssSelector("input.inputs.ui-autocomplete-input"));
		country.sendKeys("Ban");
		Thread.sleep(2000);
		country.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ENTER));
		
		System.out.println(driver.findElement(By.xpath("//legend[text()='Suggession Class Example']")).getText());
		
		
		Select s= new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByValue("option2");
		System.out.println(driver.findElement(By.xpath("//legend[text()='Dropdown Example']")).getText());
		
		
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.xpath("//legend[text()='Checkbox Example']")).getText());

		
		
		driver.findElement(By.id("openwindow")).click();
		Set<String> handles=driver.getWindowHandles();
		System.out.println(handles.size());
		
		
		Iterator<String> it=handles.iterator();
		String Parent = it.next();
		
		
		
		String Child = it.next();
		
		driver.switchTo().window(Child);
		
		System.out.println(driver.getTitle());
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C:\\Users\\ahmad\\Desktop\\TA.png")); 
		driver.close();
		
		driver.switchTo().window(Parent);
		
		driver.findElement(By.id("opentab")).click();
		System.out.println(driver.getCurrentUrl());
	
		driver.switchTo().window(Parent);		
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("name")).sendKeys("Tufail", Keys.ENTER);
		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirmbtn")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		
		System.out.println(driver.findElement(By.xpath("//table/tbody/tr[2]")).getText());
		//System.out.println(driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]")).getText());
		

		driver.findElement(By.id("displayed-text")).sendKeys("Ahmad");
		driver.findElement(By.id("hide-textbox")).click();
		
		
		
		
		WebElement reload= driver.findElement(By.xpath("//a[contains(text(),'Reload')]"));
		WebElement sr= driver.findElement(By.id("mousehover"));
		Actions act = new Actions (driver); 
	    act.moveToElement(sr).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN).click().build().perform();
		act.click(reload).build().perform();
		
		
		
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		driver.switchTo().frame(0);
		
		WebElement Art= driver.findElement(By.xpath("//div[@class='nav-outer clearfix']//a[contains(text(),'Articles')]"));
		Art.sendKeys(Keys.CONTROL, Keys.ENTER);
		
		
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]")).getText());
		
		
		
		driver.switchTo().defaultContent();
	
	
	WebElement column=driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
    
	int footers =column.findElements(By.tagName("a")).size();
	
	for(int i=1; i<footers; i++)
	{
		String clickonlink=Keys.chord(Keys.CONTROL,Keys.ENTER);
		
		column.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
		
		Thread.sleep(4000);
	}
		
				
	Set<String> allHandles=driver.getWindowHandles();
	Iterator<String>it2=allHandles.iterator();

	while(it2.hasNext())
	{
		driver.switchTo().window(it2.next());
	
		System.out.println(driver.getTitle());
		//driver.close();
	}
	
	driver.switchTo().window(Parent);
	System.out.println(driver.findElement(By.cssSelector("div.col-sm-8.right-align")).getText());
	
	
	driver.quit();
	
	
	}

}
