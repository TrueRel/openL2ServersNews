package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ServersSiteService {

    private WebDriver driver;

    public ServersSiteService(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite(String url) {
        driver.get(url);
    }


    public List<String> getFilteredServers() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ulElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.flex.flex-col.gap-2"))
        );

        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
        List<String> filtered = new ArrayList<>();

        System.out.println(">>> [БС] = Бонус Старт <<<" + "\n");
        for (WebElement li : liElements) {
            String text = li.getText().replace("\n", " ").replace("\r", " ").trim();
            String textLower = text.toLowerCase();

            if (!text.isEmpty() &&(
                    textLower.contains("scryde.net") ||
                            textLower.contains("l2mad.net") ||
                            textLower.contains("euro-pvp.net") ||
                            textLower.contains("ketrawars.net") ||
                            textLower.contains("e-global") ||
                            textLower.contains("турнир") ||
                            textLower.contains("moon-land.com") ||
                            textLower.contains("l2etina.com") ||
                            textLower.contains("interlude-online") ||
                            textLower.contains("lu4")

            )) {
                filtered.add(text);
            }
        }
        return filtered;
    }
}
