package com.mico.synthesia;

import javax.security.auth.login.LoginException;

import com.mico.synthesia.events.UserJoinedEvent;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public final class Bot {

	private static final Dotenv dotenv = Dotenv.configure().directory("./assets").filename("env").load();
	private static final String token = dotenv.get("TOKEN");

	public static void main(String[] args) throws LoginException {
		JDA bot = JDABuilder.createDefault(token).enableIntents(GatewayIntent.GUILD_MEMBERS).build();
		bot.addEventListener(new UserJoinedEvent());

	}

}
