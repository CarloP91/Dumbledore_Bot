package serverPersonalScript.BalbettanteBamboccionaBandaDiBabbuini;

import main.DumbledoreMain;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class BBBDBMessageReceived extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if (event.getGuild().getId().equals(MainBBBdB.dBbbdbID)
                && !event.getAuthor().getId().equals(DumbledoreMain.dumbledoreID)
                && !event.getAuthor().getId().equals("847417463447879680")){

            try {
                if (event.getGuild().getId().equals(MainBBBdB.dBbbdbID)) {
                    if (event.getMessage().getAuthor().getId().equals(MainBBBdB.Ciccina)) {
                        //  System.out.println(event.getMessage().getMember());
                        event.getMessage().addReaction("\uD83D\uDC96").queue();
                    }
                }
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("Eccezione Ciccia");
            }

        }

    }
}
