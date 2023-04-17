package automationTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

public class OwnPlayedSongs {
	
	
	    private static WebDriver driver;
	    private static HashMap<String, ArrayList<String>> Songbox = new HashMap<String, ArrayList<String>>();
	    private static int MaxSongs = 3;

	    public static void main(String[] args) {
	    	WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("Url For songs"); 
			driver.manage().window().maximize();

	        SongTOplay("user1", "S1");
	        SongTOplay ("user1", "S2");
	        SongTOplay ("user1", "S3");

	        ArrayList<String> playlist = Songbox.get("user1");
	        if (playlist.size() == 3 && playlist.get(0).equals("S1") && playlist.get(1).equals("S2") && playlist.get(2).equals("S3")) {
	        	 SongTOplay("user1", "S4");
	 	        SongTOplay ("user1", "S2");
	 	        SongTOplay ("user1", "S3");
	            playlist = Songbox.get("user1");
	            if (playlist.size() == 3 && playlist.get(0).equals("S4") && playlist.get(1).equals("S2") && playlist.get(2).equals("S1")) {
	                System.out.println("Playlist is correct");
	            } else {
	                System.out.println("Error-  playlist is not correct");
	            }
	        } else {
	            System.out.println("Error- playlist is not correct ");
	        }


	        driver.close();
	        driver.quit();
	    }

	    public static void SongTOplay(String user, String song) {
	    	//identifying the User
	        WebElement userE = driver.findElement(By.id("user"));
	        userE.sendKeys(user);
	        
	        //identifying the songs
	        WebElement songE = driver.findElement(By.id("song"));
	        songE.sendKeys(song);	
	      
	        //Click on play
	        WebElement playButton = driver.findElement(By.id("play"));
	        playButton.click();

	        if (!Songbox.containsKey(user)) {
	            Songbox.put(user, new ArrayList<String>());
	        }
	        ArrayList<String> playlist = Songbox.get(user);
	        if (playlist.size() == MaxSongs) {
	            playlist.remove(0);
	        }
	        playlist.add(song);
	    }
	}


