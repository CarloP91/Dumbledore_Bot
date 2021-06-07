import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildVoiceJoin extends ListenerAdapter {
    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {

        event.getGuild().getTextChannelById("851440485721178184")
                .sendMessage("<@" + event.getMember().getId() + "> è entrato nel canale <#" + event.getChannelJoined().getId() + ">").queue();

//        System.out.println(event.getMember().getEffectiveName() + " è entrato nel canale " + event.getChannelJoined().getName());
//        System.out.println(event.getNewValue().getName());


    }
}
