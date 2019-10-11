import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MusicDownload {
	public static WebDriver driver = new ChromeDriver();
	public static String mainwindow;
	public static int numberofpagesrequired =20;
	public static int i=2;
public static void main(String[] args) throws InterruptedException {
	driver.manage().window().maximize();
	driver.get("https://minimalfreaks.co/category/beatport-music/");
	System.out.println("my page Title is "+driver.getTitle());
	mainwindow = driver.getWindowHandle();
	System.out.println("main window handle is "+mainwindow);
	Thread.sleep(8000);
	clicknkonlinks();
	
	/*for(int i=2; i<=numberofpagesrequired;i++) {
		
		driver.navigate().to("https://minimalfreaks.co/category/beatport-music/page/"+i+"/");
		Thread.sleep(9000);
         String pagetitle= driver.getTitle();
         if(pagetitle.equals("ERROR 404 - Not Found!")) {
    	  break;
      }
      
      else {
    	  
    	  clicknkonlinks();
      }
	
	}*/
	
	while(i>1) {
	
		driver.navigate().to("https://minimalfreaks.co/category/beatport-music/page/"+i+"/");
		Thread.sleep(9000);
         String pagetitle= driver.getTitle();
         if(pagetitle.equals("ERROR 404 - Not Found!")) {
    	  break;
      }
      
      else {
    	  
    	  clicknkonlinks();
      }
	i++;	
	}
	
	}
		

		
		public static void clicknkonlinks() throws InterruptedException {
	
			List<WebElement> links = driver.findElements(By.xpath("//*[@id='content']/div/div/div[1]/div[1]/article/div/h2/a"));
			
			System.out.println("Number os links are "+links.size());
			
			for (int i=0;i<links.size();i++) {
				String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
				links.get(i).sendKeys(selectLinkOpeninNewTab);
			}
			
		Thread.sleep(10000);
		
		Set<String> winhandles = driver.getWindowHandles();
		System.out.println(winhandles.size());
		Iterator<String> myiterator = winhandles.iterator();
		while(myiterator.hasNext()) {
		String newwindow = myiterator.next();
		System.out.println(newwindow);
		if(!(newwindow).equals(mainwindow)) {
		driver.switchTo().window(newwindow);
		System.out.println("title is "+driver.getTitle());
		 	driver.close();
		}
	}
		driver.switchTo().window(mainwindow);
			
		}
	
		}

	


