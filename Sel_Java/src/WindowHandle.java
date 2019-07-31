import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AE12849\\Desktop\\Selenium Jars\\chromedriver_win32 (1)\\chromedriver.exe");
		 driver = new ChromeDriver();
		  driver.get("https://int.us.axa.com/home.html");
		  driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  Thread.sleep(5000);
		  driver.findElement(By.id("header-desktop-login")).click();
		  
		  driver.findElement(By.id("loginId")).sendKeys("UW15");
		  driver.findElement(By.id("loginPassword")).sendKeys("Life1234");
		  driver.findElement(By.id("panel-desktop-login")).click();
		  
		  driver.findElement(By.cssSelector("a[href*='/axae/myportal/r/tools']")).click();
		/*  driver.findElement(By.cssSelector("a[href*='DEV']")).click();
		  driver.findElement(By.cssSelector("a[href*='QA1']")).click();
		  driver.findElement(By.cssSelector("a[href*='QA2']")).click();
		  driver.findElement(By.cssSelector("a[href*='LifenbA_UAT']")).click();*/

		  
		  
		  
		//  String homePage = "https://int.us.axa.com/home.html";
	        String url = "";
	        HttpURLConnection huc = null;
	        int respCode = 200;
	        driver.get("https://www.facebook.com/");
		  List<WebElement> links = driver.findElements(By.tagName("a"));
	        
	        Iterator<WebElement> it = links.iterator();
	        
	        while(it.hasNext()){
	            
	            url = it.next().getAttribute("href");
	            System.out.println("");
	            System.out.println(url);
	        
	            if(url == null || url.isEmpty()){
	System.out.println("URL is either not configured for anchor tag or it is empty");
	                continue;
	            }
	            
	         /*   if(!url.startsWith(homePage)){
	                System.out.println("URL belongs to another domain, skipping it.");
	                continue;
	            }*/
	            
	            try {
	                huc = (HttpURLConnection)(new URL(url).openConnection());
	                
	                huc.setRequestMethod("HEAD");
	                
	                huc.connect();
	                
	                respCode = huc.getResponseCode();
	                
	                if(respCode >= 400){
	                    System.out.println(url+" is a broken link");
	                }
	                else{
	                    System.out.println(url+" is a valid link");
	                }
	                    
	            } catch (MalformedURLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
		  
		  
		  
		  
		  
		  
		  Set<String> handler = driver.getWindowHandles();
		HashMap <String,String> hm = new HashMap<String,String>();
		for(String s:handler){
			
			hm.put(driver.getTitle(), driver.getWindowHandle());
			driver.switchTo().window(s);
		}
		
		
		System.out.println(hm.entrySet());
		
		
		
		
		
		//driver.switchTo().window(hm.get(key))
	}

}
