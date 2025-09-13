package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class ServerParserService {
    private final DriverManager driverManager;

    public ServerParserService(DriverManager driverManager){
        this.driverManager = driverManager;
    }

    public List<String> getFilteredServers() {
        List<String> servers = new ArrayList<>();
        WebDriver driver = driverManager.getDriver();

        try {
            driver.get("https://l2oops.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement ulElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.flex.flex-col.gap-2"))
            );

            List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

            for (WebElement li : liElements) {
                String text = li.getText().replace("\n", " ").replace("\r", " ").trim();
                String lower = text.toLowerCase();

                if (!text.isEmpty() && (
                        lower.contains("scryde.net") ||
                                lower.contains("l2mad.net") ||
                                lower.contains("euro-pvp.net") ||
                                lower.contains("ketrawars.net") ||
                                lower.contains("e-global") ||
                                lower.contains("турнир") ||
                                lower.contains("moon-land.com") ||
                                lower.contains("l2etina.com") ||
                                lower.contains("interlude-online") ||
                                lower.contains("lu4") ||
                                lower.contains("flauron.com") ||
                                lower.contains("valhalla-age") ||
                                lower.contains("thebattle.club") ||
                                lower.contains("bohpts.org")
                )) {
                    servers.add(text);
                }
            }
        } catch (Exception e) {
            servers.add("Ошибка парсинга: " + e.getMessage());
        }
        return servers;
    }

}




