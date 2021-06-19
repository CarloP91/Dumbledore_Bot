package generic;

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import serverList.AmbulanceStangersLife.MainAmbulanceStrangersLife;
import serverList.BalbettanteBamboccionaBandaDiBabbuini.MainBBBdB;
import serverList.LosSantosPoliceDepartment.MainLSPD;
import serverList.MercatoNero.MainMercatoNero;
import serverList.StrangersLife.MainStrangersLife;

import java.time.format.DateTimeFormatter;

public class GenericMessageReceived extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateTimeFormatter itafmt = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");

        Guild guild = event.getGuild();

        int count = 0;// count++;


        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("!ping")) {
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage("Pong!") /* => RestAction<Message> */
                    .queue(response /* => Message */ -> {
                        response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
                    });
        }

        if (!guild.getId().equals(MainBBBdB.dBbbdbID)
                && !guild.getId().equals(MainAmbulanceStrangersLife.ambulanceID)
                && !guild.getId().equals(MainStrangersLife.strangerLifeID)
                && !guild.getId().equals(MainMercatoNero.mercatoneroID)
                && !guild.getId().equals(MainLSPD.lspdID)
                && !event.getMessage().getAuthor().isBot()) {
            System.out.println("Messaggio da Discord non registrato: " + event.getGuild().getName() + " ID:" + event.getGuild().getId() + " \n"
            + event.getAuthor().getName() + " " + event.getAuthor().getId());
        }
    }
}

