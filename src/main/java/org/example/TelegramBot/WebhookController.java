package org.example.TelegramBot;

import org.example.TelegramBot.MyWebhookBot;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class WebhookController {
    private final MyWebhookBot bot;

    public WebhookController(MyWebhookBot bot) {
        this.bot = bot;
    }

    @PostMapping("/webhook")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update){
        return bot.onWebhookUpdateReceived(update);
    }
}