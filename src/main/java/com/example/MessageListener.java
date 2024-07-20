package com.example;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class MessageListener extends ListenerAdapter {
    Message message;
    String content;
    public static void main(String[] args) {
        JDA jda = JDABuilder.createDefault("abc")
                .enableIntents(GatewayIntent.MESSAGE_CONTENT) // enables explicit access to message.getContentDisplay()
                .build();
        // You can also add event listeners to the already built JDA instance
        // Note that some events may not be received if the listener is added after
        // calling build()
        // This includes events such as the ReadyEvent
        jda.addEventListener(new MessageListener());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.isFromType(ChannelType.PRIVATE)) {
            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(),
                    event.getMessage().getContentDisplay());
        } else {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
                    event.getChannel().getName(), event.getMember().getEffectiveName(),
                    event.getMessage().getContentDisplay());
        }
        message = event.getMessage();
        content = message.getContentRaw(); 
        if (content.equals("ping") && event.getGuild().getName().equals("sample2"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Pong!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }
        else if(content.equals("ping") && event.getGuild().getName().equals("sample server"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("not Pong!").queue(); 
        }
    }

}
