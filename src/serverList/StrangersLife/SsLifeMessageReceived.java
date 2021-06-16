package serverList.StrangersLife;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import serverList.AmbulanceStangersLife.MainAmbulanceStrangersLife;


public class SsLifeMessageReceived extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (event.getGuild().getId().equals(MainStrangersLife.StrangerLifeID)) { // SE E' IL DISCORD DI STRANGER'S LIFE
                if (event.getChannel().getId().equals(MainStrangersLife.bandiStaffRoom)) { // SE NELLA ROOM BANDI STAFF
                    event.getGuild().getTextChannelById(MainStrangersLife.agendaDominyID)
                            .sendMessage("<@" + MainStrangersLife.dominy + "> " + "nuovo **bando STAFF** arrivato da: <@" + event.getMessage().getMember().getId() + ">" ).queue();
                }
            }
        }
    }