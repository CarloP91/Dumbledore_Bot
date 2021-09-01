package serverPersonalScript.RevProj.DsCommunication;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class DatabaseCondivisoRP extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {


        if (event.getChannel().getId().equals(MainCommunication.poliziaPermTeaser)) {
            event.getJDA().getGuildById(MainCommunication.armeria60ID).getTextChannelById(MainCommunication.armeria60PermTeaser).sendMessage("**PERMESSO TEASER** \n" + event.getMessage().getContentRaw()).queue();
    }

    //CERT MEDICO

    if (event.getChannel().getId().equals(MainCommunication.emsCertMedici)) {
        event.getJDA().getGuildById(MainCommunication.poliziaID).getTextChannelById(MainCommunication.poliziaCertMedici).sendMessage(event.getMessage().getContentRaw());
    }

    //PORTI D'ARMA

        if (event.getChannel().getId().equals(MainCommunication.emsPortoDarma)) {
            event.getJDA().getGuildById(MainCommunication.armeria60ID).getTextChannelById(MainCommunication.armeria60PortoDarmaEms).sendMessage(event.getMessage().getContentRaw()).queue();
        }

        if (event.getChannel().getId().equals(MainCommunication.armeria60PortoDarma)) {
            event.getJDA().getGuildById(MainCommunication.poliziaID).getTextChannelById(MainCommunication.poliziaTestBall).sendMessage(event.getMessage().getContentRaw()).queue();
        }

        if (event.getChannel().getId().equals(MainCommunication.poliziaLspdtoArmy)) {
            event.getJDA().getGuildById(MainCommunication.armeria60ID).getTextChannelById(MainCommunication.armeria60LpsdtoArmy).sendMessage(event.getMessage().getContentRaw()).queue();
        }

        if (event.getChannel().getId().equals(MainCommunication.poliziaPortoDarma)) {
            event.getJDA().getGuildById(MainCommunication.governoID).getTextChannelById(MainCommunication.govPortoDarma).sendMessage(event.getMessage().getContentRaw()).queue();
        }

        if (event.getChannel().getId().equals(MainCommunication.poliziaPermTeaser)) {
            event.getJDA().getGuildById(MainCommunication.governoID).getTextChannelById(MainCommunication.govPermTeaser).sendMessage(event.getMessage().getContentRaw()).queue();
        }


    //DOCUMENTI POL - GOV

        if (event.getChannel().getId().equals(MainCommunication.poliziaDocumenti)) {
            event.getJDA().getGuildById(MainCommunication.governoID).getTextChannelById(MainCommunication.govDocumenti).sendMessage(event.getMessage().getContentRaw()).queue();
        }

        if (event.getChannel().getId().equals(MainCommunication.govAnagrafe)) {
            event.getJDA().getGuildById(MainCommunication.poliziaID).getTextChannelById(MainCommunication.poliziaAnagrafe).sendMessage(event.getMessage().getContentRaw()).queue();
        }

    //FEDINE PENALI POL - GOV

        if (event.getChannel().getId().equals(MainCommunication.poliziaFedinePenali)) {
            event.getJDA().getGuildById(MainCommunication.governoID).getTextChannelById(MainCommunication.govFedinePenali).sendMessage(event.getMessage().getContentRaw()).queue();
        }

        if (event.getChannel().getId().equals(MainCommunication.govPuliziaFedine)) {
            event.getJDA().getGuildById(MainCommunication.poliziaID).getTextChannelById(MainCommunication.poliziaPuliziaFedine).sendMessage(event.getMessage().getContentRaw()).queue();
        }

    //PERMESSO MASCHERE

        if (event.getChannel().getId().equals(MainCommunication.govPermMask)) {
            event.getJDA().getGuildById(MainCommunication.poliziaID).getTextChannelById(MainCommunication.poliziaPermMask).sendMessage(event.getMessage().getContentRaw()).queue();
        }

    }
}
