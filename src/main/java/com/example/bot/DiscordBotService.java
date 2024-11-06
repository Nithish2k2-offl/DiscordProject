package com.example.bot;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDA;
import org.springframework.stereotype.Service;

import jakarta.annotation.*;

@Service
public class DiscordBotService {

    private JDA jda;

    @PostConstruct
    public void init() throws Exception {
        jda = JDABuilder.createDefault("abc")
                .addEventListeners(new MessageListener())
                .build();
        jda.awaitReady();
    }
}
