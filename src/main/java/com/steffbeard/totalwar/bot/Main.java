package com.steffbeard.totalwar.bot;

import java.util.HashMap;

import com.steffbeard.totalwar.bot.commands.Command;
import com.steffbeard.totalwar.bot.commands.moderation.Clear;
import com.steffbeard.totalwar.bot.listener.NewMemberListener;
import com.steffbeard.totalwar.bot.utils.CommandParser;
import com.steffbeard.totalwar.bot.utils.SQL;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

public class Main {
	
	public static JDA jda;
	
    public static HashMap<String, Command> commands = new HashMap<>();
    public static final CommandParser parser = new CommandParser();
	
	public static void main(String[] args) throws Exception {
		jda = new JDABuilder(AccountType.BOT)
				.setToken("TOKEN")
				.setStatus(OnlineStatus.ONLINE)
				.build();
		
		initializeListeners();
        initializeCommands();
		SQL.connect();

		System.out.println("> TotalBot is online!");
	}
	
	private static void initializeCommands() {
		commands.put("clear", new Clear());
	}
	
	private static void initializeListeners() {
		jda.addEventListener(new NewMemberListener());
	}

}
