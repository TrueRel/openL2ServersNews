package org.example.TelegramBot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BotConfig {

    private final String botName;
    private final String botToken;
    private final String webhookPath;

    public BotConfig(
            @Value("${bot.name}") String botName,
            @Value("${bot.token}") String botToken,
            @Value("${bot.path}") String webhookPath
    ) {
        this.botName = botName;
        this.botToken = botToken;
        this.webhookPath = webhookPath;
    }

    public String getBotName() {
        return botName;
    }

    public String getBotToken() {
        return botToken;
    }

    public String getWebhookPath() {
        return webhookPath;
    }
}
