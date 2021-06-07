import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildVoiceMove extends ListenerAdapter {
    public void onGuildVoiceMoveEvent (GuildVoiceMoveEvent event) {


        System.out.println(event.getMember().getId());
        System.out.println(event.getChannelJoined().getId());
        System.out.println(event.getChannelLeft());
        System.out.println(event.getNewValue());
        System.out.println(event.getOldValue());

    }


}
