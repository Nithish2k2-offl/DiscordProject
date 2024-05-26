package com.example;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class App {
    public static void main(String[] args) {
        JDA api = JDABuilder.createDefault("x").enableIntents(GatewayIntent.MESSAGE_CONTENT).build();
        api.addEventListener(new MyListener());
    }
}
