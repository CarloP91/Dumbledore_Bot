package generic;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildVoiceLeave extends ListenerAdapter {

    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {

/*        event.getGuild().getTextChannelById("851440485721178184")
                .sendMessage("<@" + event.getMember().getId() + "> è uscito nel canale <#" + event.getChannelLeft().getId() + ">").queue();*/

//        System.out.println(event.getChannelLeft());


    }


}
