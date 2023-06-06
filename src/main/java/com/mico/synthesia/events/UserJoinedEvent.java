package com.mico.synthesia.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class UserJoinedEvent extends ListenerAdapter {

	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent e) {
		String newMemberName = e.getUser().getAsMention(); // Getting the new member name in for @NAME
		String serverName = e.getGuild().getName(); // Getting the server name

		TextChannel welcomeChannel = null; // Intializing a TextChannelß
		;
		try {
			// Sets welcomeChannel to the existing #welcome channel on the server
			welcomeChannel = e.getGuild().getTextChannelsByName("welcome", true).get(0);
		} catch (IndexOutOfBoundsException exp) {
			/*
			 * If #welcome channel does not exist, then #welcome channel is created and
			 * welcomeChannel is set accordingly
			 */
			e.getGuild().createTextChannel("welcome").complete();
			System.out.println("CAUGHT EXCEPTION");
			welcomeChannel = e.getGuild().getTextChannelsByName("welcome", true).get(0);
		}

		// Sending welcome message to user
		welcomeChannel.sendMessage("Welcome to " + serverName + "! " + newMemberName).queue();
	}

}
