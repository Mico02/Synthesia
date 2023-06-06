package events;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class UserJoinedEvent extends ListenerAdapter {

	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent e) {
		String name = e.getUser().getAsMention();
		e.getGuild().getTextChannels().get(0).sendMessage("Welcome to the server! " + name).queue();
	}

}
