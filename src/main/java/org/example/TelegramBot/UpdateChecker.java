package org.example.TelegramBot;

import org.example.ServerParserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
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

    @Scheduled(fixedDelay = 300000) // каждые 5 минут
    public void checkForUpdates() {
        List<String> current = parserService.getFilteredServers();
        if (!current.equals(lastServers)) {
            lastServers = current;
            String message = String.join("\n", current);
            SendMessage msg = new SendMessage();
            msg.setChatId("291780876"); // chatId пользователя
            msg.setText(message.length() > 4000 ? message.substring(0, 4000) : message);
            try {
                bot.execute(msg);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
