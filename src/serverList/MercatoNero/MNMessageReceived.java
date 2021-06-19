package serverList.MercatoNero;

import main.DumbledoreMain;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MNMessageReceived extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if (event.getGuild().getId().equals(MainMercatoNero.mercatoneroID) && !event.getAuthor().getId().equals(DumbledoreMain.dumbledoreID)) { // DISCORD MERCATO NERO
            System.out.println(event.getGuild().getName()
                    + " " + event.getAuthor().getName()
                    + ": " + event.getMessage().getContentRaw()
                    + " " + event.getChannel().getName());
        }
    }
}