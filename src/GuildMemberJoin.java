import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class GuildMemberJoin extends ListenerAdapter {

    String[] messages = {
            "Benvenuto [member], sei nel canale sbagliato!",
            "Ciao [member]!"

    };

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        //Add Role

    }

}
