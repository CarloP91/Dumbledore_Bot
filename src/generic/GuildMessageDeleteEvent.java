package generic;

import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import serverList.AmbulanceStangersLife.MainAmbulanceStrangersLife;
import serverList.BalbettanteBamboccionaBandaDiBabbuini.MainBBBdB;
import serverList.StrangersLife.MainStrangersLife;

public class GuildMessageDeleteEvent extends ListenerAdapter {
    public void onMessageDelete(net.dv8tion.jda.api.events.message.MessageDeleteEvent event) {

       if (event.getGuild().getId().equals(MainBBBdB.dBbbdbID)) {
           event.getGuild().getTextChannelById(MainBBBdB.chLogID).sendMessage("Il messaggio " + event.getMessageId() + " è stato cancellato in: " + event.getChannel().getName()).queue();
//        System.out.println("Il messaggio " + event.getMessageId() + " è stato cancellato in: " + event.getGuild().getName() + " " + event.getChannel().getName());
       } else if (event.getGuild().getId().equals(MainAmbulanceStrangersLife.ambulanceID)) {
           event.getGuild().getTextChannelById(MainAmbulanceStrangersLife.chLogID).sendMessage(  "Il messaggio " + event.getMessageId() + " è stato cancellato in: "  + event.getChannel().getName()).queue();
       } else if (event.getChannel().getId().equals(MainStrangersLife.whitelistatiRoom))  {
           event.getGuild().getTextChannelById(MainStrangersLife.ChMsglogIDRoom).sendMessage("Il messaggio " + event.getMessageId() + " è stato cancellato in: " + event.getChannel().getName()).queue();
       } else if (event.getChannel().getId().equals(MainStrangersLife.richiamiRoom))  {
           event.getGuild().getTextChannelById(MainStrangersLife.ChMsglogIDRoom).sendMessage("Il messaggio " + event.getMessageId() + " è stato cancellato in: " + event.getChannel().getName()).queue();
       } else if (event.getChannel().getId().equals(MainStrangersLife.rimandatiRoom))  {
           event.getGuild().getTextChannelById(MainStrangersLife.ChMsglogIDRoom).sendMessage("Il messaggio " + event.getMessageId() + " è stato cancellato in: " + event.getChannel().getName()).queue();
       } else {
           System.out.println("Hanno cancellato un messaggio in un server/canale non segnato in questa pagina!");
       }
    }
}
