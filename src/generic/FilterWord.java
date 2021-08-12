package generic;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static main.DumbledoreMain.prefix;

public class FilterWord extends ListenerAdapter {

    public static boolean filterOn = true;

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);

        if (event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "wordfilter") && filterOn) {
            filterOn = false;
            event.getChannel().sendMessage("<@" + event.getMember().getUser().getId() + "> hai disabilitato il filtro parole").queue();
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "wordfilter") && filterOn == false) {
            filterOn = true;
            event.getChannel().sendMessage("<@" + event.getMember().getUser().getId() + "> hai abilitato il filtro parole").queue();
        }
    }
}
