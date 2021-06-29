package serverList.StrangersLife;


import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utility.BotExcp;

import java.awt.*;


public class SLMessageReceived extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split("\\s+");


        if (event.getGuild().getId().equals(MainStrangersLife.strangerLifeID)
                && !event.getAuthor().getId().equals(DumbledoreMain.dumbledoreID)
                && !event.getAuthor().getId().equals(BotExcp.mee6)){ // SE E' IL DISCORD DI STRANGER'S LIFE
            EmbedBuilder msgSlRoom = new EmbedBuilder()
                    .setColor(Color.black)
                    .setAuthor("ID MESSAGGIO: " + event.getMessageId())
                    .setDescription("<@" + event.getMessage().getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw() + " in <#" + event.getChannel().getId() +">");

            if (event.getChannel().getId().equals(MainStrangersLife.bandiStaffRoom)) { // SE NELLA ROOM BANDI STAFF
                if (event.getMessage().getMember().getId().equals(MainStrangersLife.dominy)) {  // SE IL MESSAGGIO E' SCRITTO DA ID
                    //nu face nu cazzu
                }
                else { //ALTRIMENTI
                    event.getGuild().getTextChannelById(MainStrangersLife.agendaDominyID) //IN QUESTO TEXT CHANNEL
                            .sendMessage(msgSlRoom.build()).queue();
                }

            }
            if (event.getChannel().getId().equals(MainStrangersLife.whitelistatiRoom)) {
                event.getGuild().getTextChannelById(MainStrangersLife.logWhitelist)
                        .sendMessage(msgSlRoom.build()).queue();
            }
            else if (event.getChannel().getId().equals(MainStrangersLife.rimandatiRoom)) {
                event.getGuild().getTextChannelById(MainStrangersLife.logWhitelist)
                        .sendMessage(msgSlRoom.build()).queue();
            }
            /*else if (event.getChannel().getId().equals(MainStrangersLife.richiamiRoom)) {
                event.getGuild().getTextChannelById(MainStrangersLife.ChMsglogIDRoom)
                        .sendMessage("<@" + event.getMessage().getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw() + " in <#" + event.getChannel().getId() +">").queue();
            }*/
        }
    }
}