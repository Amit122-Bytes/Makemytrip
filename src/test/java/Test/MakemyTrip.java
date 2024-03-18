package Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import PageObjects.Landing;

public class MakemyTrip extends BaseClass {

	@Test
	public void test() {

		Landing obj = new Landing(driver);
		obj.entefromcity();
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		WebElement destination = driver.findElement(By.xpath("//input[@placeholder='To']"));
		destination.sendKeys("Netaji");
		for (int i = 0; i < 8; i++) {
			destination.sendKeys(Keys.ARROW_DOWN);
		}
		destination.sendKeys(Keys.ENTER);

		// Function for Depature

		String month = "May 2024";// store desired data
		String day = "15";// store desired month

		while (true)// loop for serach exact match
		{
			String text = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
			if (text.equals(month)) {
				break;// once found break
			} else// keep moving forward untill matched
			{
				driver.findElement(By.xpath(
						"//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"))
						.click();
			}
		}

		// store all dates into list
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));
		// loop seatching for all dates and prints
		for (WebElement data : element) {
			// Now need to spearte price and date and store dates into array
			String extract = data.getText();
			String date[] = extract.split("\n");

			if (date[0].equals(day)) {
				data.click();
				break;
			}
		}

		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
		System.out.println("Test case passed");

	}

}
