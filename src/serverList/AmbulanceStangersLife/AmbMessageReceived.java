package serverList.AmbulanceStangersLife;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AmbMessageReceived extends ListenerAdapter {

    public void onMessageReceived( MessageReceivedEvent event) {

        // AGGIUNGE UN CHECK AD OGNI MESSAGGIO NEL CANALE ANNUNCI
       if (event.getChannel().getId().equals(MainAmbulanceStrangersLife.chAnnunciID)) {
           event.getMessage().addReaction("\uD83C\uDD97").queue();
       }
    }
}
