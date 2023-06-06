package com.mico.synthesia.events;

import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class UserLeftEvent extends ListenerAdapter {

	@Override
	public void onGuildMemberRemove(GuildMemberRemoveEvent e) {
		String name = e.getUser().getAsMention();
		e.getGuild().getTextChannels().get(0).sendMessage("Farewell! " + name).queue();
	}

}
