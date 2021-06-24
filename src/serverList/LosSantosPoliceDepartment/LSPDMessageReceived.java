package serverList.LosSantosPoliceDepartment;

import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utility.BotExcp;

import java.awt.*;

public class LSPDMessageReceived extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        EmbedBuilder msgSlRoom = new EmbedBuilder()
                .setColor(Color.black)
                .setAuthor("ID MESSAGGIO: " + event.getMessageId())
                .setDescription("<@" + event.getMessage().getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw() + " in <#" + event.getChannel().getId() +">");

        if (event.getGuild().getId().equals(MainLSPD.lspdID)
                && !event.getAuthor().getId().equals(DumbledoreMain.dumbledoreID)
                && !event.getAuthor().getId().equals(BotExcp.ciroBot)){

            event.getGuild().getTextChannelById("857701176672649226").sendMessage(msgSlRoom.build()).queue();
        }
    }
}
