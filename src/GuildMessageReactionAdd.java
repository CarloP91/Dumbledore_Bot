import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class GuildMessageReactionAdd extends ListenerAdapter {
    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
        if (event.getReactionEmote().getName().equals("❌") &&
                !Objects.equals(event.getMember().getUser(), event.getJDA().getSelfUser())); //controllo su utente ! da bot

    }
}
