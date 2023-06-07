package com.mico.synthesia.events;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class UserJoinedEvent extends ListenerAdapter {

	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent e) {
		String newMemberName = e.getUser().getAsMention(); // Getting the new member name in for @NAME
		String serverName = e.getGuild().getName(); // Getting the server name
		Guild guild = e.getGuild();
		TextChannel welcomeChannel = null; // Initializing a TextChannel
		try {
			// Sets welcomeChannel to the existing #welcome channel on the server
			welcomeChannel = guild.getTextChannelsByName("welcome", true).get(0);
		} catch (IndexOutOfBoundsException exp) {
			/*
			 * If #welcome channel does not exist, then #welcome channel is created and put
			 * in a welcome category. If welcome category does not exist, then one is
			 * created.
			 */
			Category welcomeCategory = (guild.getCategoriesByName("welcome", true).size() < 1)
					? guild.createCategory("Welcome").complete()
					: guild.getCategoriesByName("welcome", true).get(0);
			guild.modifyCategoryPositions().selectPosition(welcomeCategory).moveTo(0).queue();
			welcomeChannel = guild.createTextChannel("welcome", welcomeCategory).complete();
			guild.modifyTextChannelPositions().selectPosition(welcomeChannel).moveTo(0).queue();
		}

		// Sending welcome message to user in the #welcome channel
		welcomeChannel.sendMessage("Welcome to " + serverName + "! " + newMemberName).queue();
	}

}
