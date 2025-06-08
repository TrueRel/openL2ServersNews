package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Selenium2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "F:\\chrome-win64\\Version 137.0.7151.68\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("F:\\chrome-win64\\Version 137.0.7151.68\\chrome-win64\\chrome.exe");
        options.addArguments("--headless");
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

            System.out.println("Открываю сайт...");
            driver.get("https://l2oops.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement ulElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.flex.flex-col.gap-2"))
            );

            // Получаем список дочерних элементов <li> внутри <ul>
            List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
            System.out.println("Найдено вложенных элементов li: " + liElements.size());

            // Получаем текст из ul
            String combinedText = ulElement.getText();

            // 1. Принудительное добавление пробела между датами (если нужно)
            combinedText = combinedText.replaceAll("(\\d{2}\\.\\d{2}\\.\\d{2})(?=\\d{2}\\.\\d{2}\\.\\d{2})", "$1 ");

            // 2. Очистка лишних символов сразу после даты
            combinedText = combinedText.replaceAll("(\\d{2}\\.\\d{2}\\.\\d{2}).{1,5}", "$1");

            // 3. Разделяем текст перед каждой датой
            String[] servers = combinedText.split("(?=\\d{2}\\.\\d{2}\\.\\d{2})");

            for (String server : servers) {
                // Удаление повторяющихся дат внутри строки
                String cleanedServer = server.replaceAll("(\\d{2}\\.\\d{2}\\.\\d{2})\\1", "$1");

                if (!cleanedServer.trim().isEmpty() &&
                        (cleanedServer.contains("scryde.net") ||
                                cleanedServer.contains("l2mad.net") ||
                                cleanedServer.contains("euro-pvp.net") ||
                                cleanedServer.contains("ketrawars.net") ||
                                cleanedServer.contains("e-global") ||
                                cleanedServer.contains("Турнир") ||
                                cleanedServer.contains("moon-land.com") ||
                                cleanedServer.contains("l2etina.com") ||
                                cleanedServer.contains("interlude-online.com")
                        )) {
                    System.out.println(cleanedServer.trim());
                }
            }
        } finally {
            // Закрываем драйвер, чтобы освободить ресурсы
            driver.quit();
            System.out.println("Драйвер закрыт");
        }
    }
}
