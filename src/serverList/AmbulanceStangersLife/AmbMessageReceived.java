package serverList.AmbulanceStangersLife;

import main.DumbledoreMain;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utility.Utility;

public class AmbMessageReceived extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split("\\s+");
        MainAmbulanceStrangersLife direttore = new MainAmbulanceStrangersLife();
        MainAmbulanceStrangersLife vicedirettore = new MainAmbulanceStrangersLife();

        if (event.getGuild().getId().equals(MainAmbulanceStrangersLife.ambulanceID) && !event.getAuthor().getId().equals(DumbledoreMain.dumbledoreID)) {

            //CONTROLLO PER 2 BOT SENZA ID
            if (event.getChannel().getId().equals("839615144107048961")) {
                System.out.println("è il bot di K che rompe e quindi non faccio nulla");
            }

            // AGGIUNGE UN CHECK AD OGNI MESSAGGIO NEL CANALE ANNUNCI
            if (event.getChannel().getId().equals(MainAmbulanceStrangersLife.chAnnunciID)) {
                event.getMessage().addReaction("\uD83C\uDD97").queue();
            }
        }
    }
}