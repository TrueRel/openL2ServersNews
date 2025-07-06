package org.example.TelegramBot;

import org.example.ServerParserService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Component
public class MyWebhookBot extends TelegramWebhookBot {

    private final BotConfig config;
    private final ServerParserService parserService;

    public MyWebhookBot(BotConfig config, ServerParserService parserService) {
        this.config = config;
        this.parserService = parserService;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        System.out.println("Получен апдейт: " + update);

        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            System.out.println("Chat ID: " + chatId); // 👈 Вот здесь

            if (text.equals("/start")) {
                List<String> servers = parserService.getFilteredServers();

                String header = "Ближайшее открытие серверов:\n\n БС = Бонус Старт \n\n";
                String response = String.join("\n", servers);

                SendMessage message = new SendMessage();
                message.setChatId(chatId.toString());
                message.setText(header + (response.length() > 4000 ? response.substring(0, 4000) : response));

                return message;
            }
        }
        return null;
    }

    @Override
    public String getBotPath() {
        return config.getWebhookPath();
    }


    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getBotToken();
    }

}

