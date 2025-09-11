package org.example.TelegramBot;

import org.example.ServerParserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UpdateChecker {

    private final ServerParserService parserService;
    private final MyWebhookBot bot;

    private List<String> lastServers = new ArrayList<>();

    public UpdateChecker(ServerParserService parserService, MyWebhookBot bot) {
        this.parserService = parserService;
        this.bot = bot;
    }

    @Scheduled(fixedDelay = 60*60*1000) // каждый 1 час
   //@Scheduled(fixedDelay = 60000) // каждый 10sec
    public void checkForUpdates() {
        System.out.println("Проверка обновлений: " + System.currentTimeMillis());
        String header = "Ближайшее открытие серверов:\n\n БС = Бонус Старт \n\n";

        List<String> currentServers = parserService.getFilteredServers();
        Collections.sort(currentServers);
        Collections.sort(lastServers);

        if (!currentServers.equals(lastServers)) {
            lastServers = new ArrayList<>(currentServers);
            String message = String.join("\n", currentServers);
            SendMessage msg = new SendMessage();
            msg.setChatId("291780876"); // chatId пользователя
            msg.setText(header+( message.length() > 4000 ? message.substring(0, 4000) : message));
            try {
                bot.execute(msg);
                System.out.println("Обновления отправлены в Telegram");
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Нет изменений — сообщение не отправлено.");
        }
    }
}
