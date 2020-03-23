package com.steffbeard.totalwar.bot.utils;

import java.awt.Color;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Logger {
    public static void logCommand(String command, GuildMessageReceivedEvent event){
        Guild guild = event.getGuild();
        String prefix = SQL.getValue(guild, "prefix");
        String logchannel = SQL.getValue(guild, "logchannel");
        if (SQL.getValue(guild, "logchannel").equals("0")) return;
        String us = event.getMember().getNickname();
        TextChannel channel = guild.getTextChannelById(logchannel);
        if(us == null) us = event.getAuthor().getName();
        EmbedSender.sendEmbed("[Command] `" + Statics.PREFIX +  command + "` was executed by **" + us + " (" + event.getAuthor().getName()+ "#" + event.getAuthor().getDiscriminator() + ")**", channel, Color.cyan);
    }
}