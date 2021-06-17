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

        // AGGIUNGE UN CHECK AD OGNI MESSAGGIO NEL CANALE ANNUNCI
        if (event.getChannel().getId().equals(MainAmbulanceStrangersLife.chAnnunciID)) {
            event.getMessage().addReaction("\uD83C\uDD97").queue();
        }

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "ambstipendi")) {
            if (args.length > 1 && args.length < 3) {
                try {
                    Role ambrole = event.getMessage().getMentionedRoles().get(0);
                    System.out.println(ambrole);

                    event.getChannel().sendMessage(Utility.getMemberAsStringID(ambrole.getGuild().getMembers())).queue();
                  //  System.out.println(Utility.getRoleAsStringID(ambrole.getGuild().getMembers()));
                } catch (IndexOutOfBoundsException exception) {
                    System.out.println("Qui non stampo una sega!");
                }
            }
        }
    }
}