package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SeleniumExample {
    public static void main(String[] args) {
        // Установить путь расположение хром драйвера
        System.setProperty("webdriver.chrome.driver", "F:\\chrome-win64\\Version 137.0.7151.68\\chromedriver-win64\\chromedriver.exe");

        //создаем обьект настроек
        ChromeOptions optionsFromConnectDriverAndChrome = new ChromeOptions();

        //установить путь где находится chrom для теста
        optionsFromConnectDriverAndChrome.setBinary("F:\\chrome-win64\\Version 137.0.7151.68\\chrome-win64\\chrome.exe");

//        //запуск хром в скрытом режиме без UI оболочки
//        optionsFromConnectDriverAndChrome.addArguments("--headless");

        //добавляем user-agent как будь то мы испульзуем другой браузер
        optionsFromConnectDriverAndChrome.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");

        // передаем Настройки подключения, Chrome в драйвер и создаем его обьект
        WebDriver driver = new ChromeDriver(optionsFromConnectDriverAndChrome);

        // Устанавливаем пользовательские заголовки
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Открываем сайт
        System.out.println("Открываю сайт...");
        driver.get("https://l2oops.com");

        // Печатаем заголовок страницы
        System.out.println("Заголовок страницы: " + driver.getTitle());


        try {
            //закрывать драйвер через 15 секунд
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Текущий URL: " + driver.getCurrentUrl());
        // Закрываем драйвер
        driver.quit();
        System.out.println("Закрываю страницу");
    }
}

