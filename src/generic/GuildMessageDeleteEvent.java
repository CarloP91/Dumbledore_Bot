package generic;

import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.pagination.AuditLogPaginationAction;
import serverList.AmbulanceStangersLife.MainAmbulanceStrangersLife;
import serverList.BalbettanteBamboccionaBandaDiBabbuini.MainBBBdB;
import serverList.StrangersLife.MainStrangersLife;

import java.util.concurrent.TimeUnit;

public class GuildMessageDeleteEvent extends ListenerAdapter {
    public void onMessageDelete(MessageDeleteEvent event) {

        Guild guild = event.getGuild();

        AuditLogEntry entry = event.getGuild().retrieveAuditLogs().type(ActionType.MESSAGE_DELETE).complete().get(0);

       if (event.getGuild().getId().equals(MainBBBdB.dBbbdbID)) {

          event.getGuild().getTextChannelById(MainBBBdB.chLogID).sendMessage("Il messaggio " + event.getMessageId() + " è stato cancellato in: " + event.getChannel().getName()).queue();
//        System.out.println("Il messaggio " + event.getMessageId() + " è stato cancellato in: " + event.getGuild().getName() + " " + event.getChannel().getName());
       }
       else if (event.getGuild().getId().equals(MainAmbulanceStrangersLife.ambulanceID)) {
           event.getGuild().getTextChannelById(MainAmbulanceStrangersLife.chLogID).sendMessage(  "Il messaggio " + event.getMessageId() + " è stato cancellato in: "  + event.getChannel().getName() + " da " + entry.getUser().getName()).queue();
       }
       if (!guild.getId().equals(MainStrangersLife.strangerLifeID)){
           System.out.println("Discord: " + event.getGuild().getName() + " è stato cancellato un messaggio in" + event.getChannel().getName() + " non segnato in questa pagina! " + entry.getUser().getName() + " " + entry.getUser().getId());
       }

    }
}
