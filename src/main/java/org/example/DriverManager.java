package org.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private WebDriver driver;


    public DriverManager() {
        System.setProperty("webdriver.chrome.driver", "F:\\chrome-win64\\Version 137.0.7151.68\\" +
                "chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("F:\\chrome-win64\\Version 137.0.7151.68\\chrome-win64\\chrome.exe");
        options.addArguments("--headless");
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) "+
                "AppleWebKit/537.36 "+
                "(KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
        driver = new ChromeDriver(options);

    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public void quit(){
        if(driver != null){
            driver.quit();
        }
    }

}
