package generic;

import db.DbCredentials;
import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import serverList.AmbulanceStangersLife.MainAmbulanceStrangersLife;
import serverList.BalbettanteBamboccionaBandaDiBabbuini.MainBBBdB;
import serverList.LosSantosPoliceDepartment.MainLSPD;
import serverList.StrangersLife.MainStrangersLife;
import utility.BotExcp;
import utility.Utility;

import java.awt.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GenericMessageReceived extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateTimeFormatter itafmt = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");

        Guild guild = event.getGuild();


        DbCredentials credentials = new DbCredentials();
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        int count = 0;// count++;

    /*    event.getJDA().getGuildById(DumbledoreMain.botDiscordID)
                .getTextChannelById("857557884003287111").sendMessage(guild.getName() + " " + event.getChannel().createInvite().complete().getUrl()).queue();
*/

        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("d-ping")) {
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage("Pong!") /* => RestAction<Message> */
                    .queue(response /* => Message */ -> {
                        response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
                    });
        }


        if (guild.getId().equals("858674220628049920")
                && !event.getAuthor().getId().equals(DumbledoreMain.dumbledoreID)
                && !event.getAuthor().getId().equals(BotExcp.ciroBot)) {

            EmbedBuilder msgSlRoom = new EmbedBuilder()
                    .setColor(Color.black)
                    .setAuthor("ID MESSAGGIO: " + event.getMessageId())
                    .setDescription("<@" + event.getMessage().getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw() + " in <#" + event.getChannel().getId() +">");



            event.getJDA().getGuildById(DumbledoreMain.botDiscordID).getTextChannelById("859384555893948476")
                        .sendMessage(msgSlRoom.build()).queue();


        }
    }
}

