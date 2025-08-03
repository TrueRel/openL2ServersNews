//package org.example;
//
//
//import java.util.List;
//
//@Deprecated
//public class SeleniumMain {
//    public static void main(String[] args) {
//        DriverManager driverManager = new DriverManager();
//        ServersSiteService siteService = new ServersSiteService(driverManager.getDriver());
//
//        try {
//            siteService.openSite("https://l2oops.com");
//
//            List<String> servers = siteService.getFilteredServers();
//            for (String server : servers){
//                System.out.println(server);
//            }
//
//        }catch (Exception e ){
//            System.out.println("Ошибка открытиия сайта " + e);
//        }finally {
//            driverManager.quit();
//        }
//
//    }
//}
////        System.setProperty("webdriver.chrome.driver", "F:\\chrome-win64\\Version 137.0.7151.68\\chromedriver-win64\\chromedriver.exe");
////
////
////        ChromeOptions optionsSetUpDriverAndChrome = new ChromeOptions();
////        optionsSetUpDriverAndChrome.setBinary("F:\\chrome-win64\\Version 137.0.7151.68\\chrome-win64\\chrome.exe");
////        optionsSetUpDriverAndChrome.addArguments("--headless");
////        optionsSetUpDriverAndChrome.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
////                "AppleWebKit/537.36 " +
////                "(KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
////
////        WebDriver driver = new ChromeDriver(optionsSetUpDriverAndChrome);
////
////        try {
////            //Установить максимальное время ожидания загрузки страницы: 30 секунд
////            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
////
////            System.out.println("Открываю сайт...");
////            driver.get("https://l2oops.com");
////
////            //Ожидание появления элемента на странице
////            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////
////            //Ожидание видимости элемента с нужным CSS-селектором
////            WebElement ulElement = wait.until(
////                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.flex.flex-col.gap-2"))
////            );
////
////            List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
////            System.out.println("Найдено вложенных элементов li: " + liElements.size());
////
////            for (WebElement li : liElements) {
////                String text = li.getText().replace("\n", " ").replace("\r", " ").trim();
////                String textLower = text.toLowerCase();
////
////                if (!text.isEmpty() && (
////                                textLower.contains("scryde.net") ||
////                                textLower.contains("l2mad.net") ||
////                                textLower.contains("euro-pvp.net") ||
////                                textLower.contains("ketrawars.net") ||
////                                textLower.contains("e-global") ||
////                                textLower.contains("турнир") ||
////                                textLower.contains("moon-land.com") ||
////                                textLower.contains("l2etina.com") ||
////                                textLower.contains("interlude-online") ||
////                                textLower.contains("lu4")
////                )) {
////                    System.out.println(text);
////                }
////            }
////            //конечный блок finally который будет всегда выполняться в конце а именно закрывать драйвер
////        } finally {
////            driver.quit();
////        }
////    }
////}
////
//////            // Получаем список дочерних элементов <li> внутри <ul>
//////            List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
//////            System.out.println("Найдено вложенных элементов li: " + liElements.size());
//////
//////            // Получаем текст из ul
//////            String combinedText = ulElement.getText();
//////
//////            // 1. Принудительное добавление пробела между датами (если нужно)
//////            combinedText = combinedText.replaceAll("(\\d{2}\\.\\d{2}\\.\\d{2})(?=\\d{2}\\.\\d{2}\\.\\d{2})", "$1 ");
//////
//////            // 2. Очистка лишних символов сразу после даты
//////            combinedText = combinedText.replaceAll("(\\d{2}\\.\\d{2}\\.\\d{2}).{1,5}", "$1");
//////
//////            // 3. Разделяем текст перед каждой датой
//////            String[] servers = combinedText.split("(?=\\d{2}\\.\\d{2}\\.\\d{2})");
//////
//////            for (String server : servers) {
//////                String cleanedServer = server.replaceAll("(\\d{2}\\.\\d{2}\\.\\d{2})\\1", "$1").trim();
//////                String cleanedServerLower = cleanedServer.toLowerCase();
//////
//////                if (!cleanedServer.isEmpty() &&
//////                        (cleanedServerLower.contains("scryde.net") ||
//////                                cleanedServerLower.contains("l2mad.net") ||
//////                                cleanedServerLower.contains("euro-pvp.net") ||
//////                                cleanedServerLower.contains("ketrawars.net") ||
//////                                cleanedServerLower.contains("e-global") ||
//////                                cleanedServerLower.contains("турнир") ||
//////                                cleanedServerLower.contains("moon-land.com") ||
//////                                cleanedServerLower.contains("l2etina.com") ||
//////                                cleanedServerLower.contains("interlude-online.com")
//////                        )) {
//////                    // Просто выводим, каждая строка — свой сервер
//////                    cleanedServer = cleanedServer.replace("\n", " ").replace("\r", " ").trim();
//////                    String[] individualServers = cleanedServer.split("(?=\\d{2}\\.\\d{2}\\.\\d{2})");
//////
//////                    for (String srv : individualServers) {
//////                        if (!srv.trim().isEmpty()) {
//////                            System.out.println(srv.trim());
//////                        }
//////                    }
//////                    System.out.println(cleanedServer);
//////                }
//////            }
//////
//////        } catch (Exception e) {
//////            throw new RuntimeException(e);
//////        }
////
