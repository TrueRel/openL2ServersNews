package org.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;
import java.io.File;
import java.nio.file.Paths;

@Component
public class DriverManager {
    private WebDriver driver;
    private final String driverPath;
    private final String chromePath;

    public DriverManager() {
//        String currentDir = Paths.get("").toAbsolutePath().toString();
        String currentDir = Paths.get("").toAbsolutePath().toString();
        System.out.println("Current dir: " + currentDir);

        //  09.09.25 изменил абсолютный путь на относительный чтчо бы запускать на любом компе
        driverPath = Paths.get(currentDir, "TestSelenium", "drivers", "chromedriver-win64", "chromedriver.exe").toString();
        chromePath = Paths.get(currentDir,"TestSelenium",  "drivers", "chrome-win64", "chrome.exe").toString();
        System.setProperty("webdriver.chrome.driver", driverPath);

        File f = new File(driverPath);
        System.out.println("Driver exists? " + f.exists());
    }

    public WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.setBinary(chromePath);
            options.addArguments("--headless");
            options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                    "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
