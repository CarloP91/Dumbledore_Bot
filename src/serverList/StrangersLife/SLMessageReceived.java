package serverList.StrangersLife;


import main.DumbledoreMain;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import serverList.AmbulanceStangersLife.MainAmbulanceStrangersLife;


public class SLMessageReceived extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (event.getGuild().getId().equals(MainStrangersLife.StrangerLifeID) && !event.getAuthor().getId().equals(DumbledoreMain.dumbledoreID)) { // SE E' IL DISCORD DI STRANGER'S LIFE
            if (event.getChannel().getId().equals(MainStrangersLife.bandiStaffRoom)) { // SE NELLA ROOM BANDI STAFF
                if (event.getMessage().getMember().getId().equals(MainStrangersLife.dominy)) {  // SE IL MESSAGGIO E' SCRITTO DA ID
                    //nu face nu cazzu
                }
                else { //ALTRIMENTI
                    event.getGuild().getTextChannelById(MainStrangersLife.agendaDominyID) //IN QUESTO TEXT CHANNEL
                            .sendMessage("<@" + MainStrangersLife.dominy + "> " + "nuovo **bando STAFF** arrivato da: <@" + event.getMessage().getMember().getId() + ">").queue();
                }

            }
            if (event.getChannel().getId().equals(MainStrangersLife.whitelistatiRoom)) {
                event.getGuild().getTextChannelById(MainStrangersLife.ChMsglogIDRoom)
                        .sendMessage("|| **ID MESSAGGIO:** " + event.getMessageId() + " || \n" + "<@" + event.getMessage().getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw() + " in <#" + event.getChannel().getId() +">").queue();
            }
            else if (event.getChannel().getId().equals(MainStrangersLife.rimandatiRoom)) {
                event.getGuild().getTextChannelById(MainStrangersLife.ChMsglogIDRoom)
                        .sendMessage("|| **ID MESSAGGIO:** " + event.getMessageId() + " || \n" + "<@" + event.getMessage().getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw() + " in <#" + event.getChannel().getId() +">").queue();
            }
            /*else if (event.getChannel().getId().equals(MainStrangersLife.richiamiRoom)) {
                event.getGuild().getTextChannelById(MainStrangersLife.ChMsglogIDRoom)
                        .sendMessage("<@" + event.getMessage().getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw() + " in <#" + event.getChannel().getId() +">").queue();
            }*/
        }
    }
}