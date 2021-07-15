package serverPersonalScript.AmbulanceStangersLife;

import main.DumbledoreMain;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AmbMessageReceived extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split("\\s+");
        MainAmbulanceStrangersLife direttore = new MainAmbulanceStrangersLife();
        MainAmbulanceStrangersLife vicedirettore = new MainAmbulanceStrangersLife();

        if (event.getGuild().getId().equals(MainAmbulanceStrangersLife.ambulanceID)
                && !event.getAuthor().getId().equals(DumbledoreMain.dumbledoreID)) {

            // AGGIUNGE UN CHECK AD OGNI MESSAGGIO NEL CANALE ANNUNCI
            if (event.getChannel().getId().equals(MainAmbulanceStrangersLife.chAnnunciID)) {
                event.getMessage().addReaction("\uD83C\uDD97").queue();
            }
        }
    }
}