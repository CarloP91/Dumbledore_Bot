package serverList.BalbettanteBamboccionaBandaDiBabbuini;

import main.DumbledoreMain;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class BBBDBMessageReceived extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if (event.getGuild().getId().equals(MainBBBdB.dBbbdbID) && !event.getAuthor().getId().equals(DumbledoreMain.dumbledoreID)){

            TextChannel textChannel = event.getGuild().getTextChannelById("851440485721178184");
            textChannel.sendMessage("<@" + event.getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw()
                    + " in <#" + event.getChannel().getId() + "> \n || **ID MESSAGGIO:** " + event.getMessageId() + "||").queue();


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
