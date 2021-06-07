import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildVoiceMove extends ListenerAdapter {
    public void onGuildVoiceMove (GuildVoiceMoveEvent event) {

//        event.getGuild().getTextChannelById("847831596178341908")
//                .sendMessage("<@" + event.getMember().getId() + "> è entrato nel canale <#" + event.getChannelJoined().getId() + ">").queue();


//        System.out.println(event.getMember().getEffectiveName() + " è entrato in " + event.getChannelJoined());
//        System.out.println(event.getMember().getEffectiveName() + " è stato spostato da " + event.getOldValue().getName() + " a " + event.getNewValue().getName());

        event.getGuild().getTextChannelById("851440485721178184")
                .sendMessage("<@" + event.getMember().getId() + ">  è stato spostato da  <#" + event.getOldValue().getId() + "> a <#" + event.getNewValue().getId() + ">").queue();

    }


}
