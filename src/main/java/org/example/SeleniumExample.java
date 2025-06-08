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

public class SeleniumExample {
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

            List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
            System.out.println("Найдено вложенных элементов li: " + liElements.size());

            for (WebElement li : liElements) {
                String text = li.getText().replace("\n", " ").replace("\r", " ").trim();
                String textLower = text.toLowerCase();

                if (!text.isEmpty() && (
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
                    System.out.println(text);
                }
            }
        } finally {

        }
    }
}

//            // Получаем список дочерних элементов <li> внутри <ul>
//            List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
//            System.out.println("Найдено вложенных элементов li: " + liElements.size());
//
//            // Получаем текст из ul
//            String combinedText = ulElement.getText();
//
//            // 1. Принудительное добавление пробела между датами (если нужно)
//            combinedText = combinedText.replaceAll("(\\d{2}\\.\\d{2}\\.\\d{2})(?=\\d{2}\\.\\d{2}\\.\\d{2})", "$1 ");
//
//            // 2. Очистка лишних символов сразу после даты
//            combinedText = combinedText.replaceAll("(\\d{2}\\.\\d{2}\\.\\d{2}).{1,5}", "$1");
//
//            // 3. Разделяем текст перед каждой датой
//            String[] servers = combinedText.split("(?=\\d{2}\\.\\d{2}\\.\\d{2})");
//
//            for (String server : servers) {
//                String cleanedServer = server.replaceAll("(\\d{2}\\.\\d{2}\\.\\d{2})\\1", "$1").trim();
//                String cleanedServerLower = cleanedServer.toLowerCase();
//
//                if (!cleanedServer.isEmpty() &&
//                        (cleanedServerLower.contains("scryde.net") ||
//                                cleanedServerLower.contains("l2mad.net") ||
//                                cleanedServerLower.contains("euro-pvp.net") ||
//                                cleanedServerLower.contains("ketrawars.net") ||
//                                cleanedServerLower.contains("e-global") ||
//                                cleanedServerLower.contains("турнир") ||
//                                cleanedServerLower.contains("moon-land.com") ||
//                                cleanedServerLower.contains("l2etina.com") ||
//                                cleanedServerLower.contains("interlude-online.com")
//                        )) {
//                    // Просто выводим, каждая строка — свой сервер
//                    cleanedServer = cleanedServer.replace("\n", " ").replace("\r", " ").trim();
//                    String[] individualServers = cleanedServer.split("(?=\\d{2}\\.\\d{2}\\.\\d{2})");
//
//                    for (String srv : individualServers) {
//                        if (!srv.trim().isEmpty()) {
//                            System.out.println(srv.trim());
//                        }
//                    }
//                    System.out.println(cleanedServer);
//                }
//            }
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

