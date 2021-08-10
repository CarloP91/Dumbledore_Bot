package serverPersonalScript.RevProj;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static main.DumbledoreMain.botDiscordID;

public class RevProjPersonalCMD extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);

        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (event.getGuild().getId().equals("865247529314680852")
                && !event.getAuthor().isBot()) {

            if (args[0].equalsIgnoreCase("!ts")) {
                event.getChannel().sendMessage("Il Team Speak è: crypto.host3.fun <@" + event.getMember().getId() + ">").queue();
            }
        }
    }
}
