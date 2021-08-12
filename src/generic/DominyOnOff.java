package generic;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static main.DumbledoreMain.prefix;

public class DominyOnOff extends ListenerAdapter {

    public static boolean dominyOn = false;

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);

        if (event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "dominyOn") && dominyOn == false) {
            dominyOn = true;
            event.getChannel().sendMessage("<@" + event.getMember().getUser().getId() + "> hai abilitato l'attesa Dominy").queue();
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "DominyOff") && dominyOn == true) {
            dominyOn = false;
            event.getChannel().sendMessage("<@" + event.getMember().getUser().getId() + "> hai disabilitato l'attesa Dominy").queue();
        }
    }
}
