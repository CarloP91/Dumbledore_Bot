package serverList.LosSantosPoliceDepartment;

import main.DumbledoreMain;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utility.BotExcp;

public class LSPDMessageReceived extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if (event.getGuild().getId().equals(MainLSPD.lspdID)
                && !event.getAuthor().getId().equals(DumbledoreMain.dumbledoreID)
                && !event.getAuthor().getId().equals(BotExcp.ciroBot)){

            System.out.println(event.getGuild().getName()
                    + " " + event.getAuthor().getName()
                    + ": " + event.getMessage().getContentRaw()
                    + " " + event.getChannel().getName());
        }
    }
}
