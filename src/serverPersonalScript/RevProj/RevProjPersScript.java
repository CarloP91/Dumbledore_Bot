package serverPersonalScript.RevProj;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class RevProjPersScript extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);

        if (event.getGuild().getId().equals(MainRevengeProject.revengeProjectID)) {
            if (event.getChannel().getId().equals(MainRevengeProject.rpBugDaRisolvere)) {


            }
        }
    }
}
