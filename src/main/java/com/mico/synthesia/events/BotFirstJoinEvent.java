package com.mico.synthesia.events;

import java.util.EnumSet;

import com.mico.synthesia.Bot;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotFirstJoinEvent extends ListenerAdapter {
	@Override
	public void onGuildJoin(GuildJoinEvent e) {
		/*
		 * Creating a private channel when the bot first joins a server with only the
		 * owner and bot
		 */
		Guild g = e.getGuild();
		g.createTextChannel(Bot.botName + " Setup")
				.addMemberPermissionOverride(g.getOwnerIdLong(), EnumSet.of(Permission.ADMINISTRATOR), null)
				.addPermissionOverride(g.getPublicRole(), null, EnumSet.of(Permission.VIEW_CHANNEL)).complete();
	}
}
