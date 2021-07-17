package serverPersonalScript.GovernoPoliziaSceriffi;

import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import utility.BotExcp;

import static serverPersonalScript.GovernoPoliziaSceriffi.MainDatabaseInfo.*;

public class ComunicationDatabase extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);

        EmbedBuilder formMsg = new EmbedBuilder()
                .setColor(0x000000)
                .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                .addField(event.getAuthor().getName(), event.getMessage().getContentRaw(), true);

        if (!event.getAuthor().getId().equals(DumbledoreMain.dumbledoreID)
                && !event.getAuthor().getId().equals(BotExcp.ciroBot)) {

            //DOCUMENTI
            if (event.getChannel().getId().equals(MainDatabaseInfo.lspdDocumenti)) {
                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govDocumenti).sendMessage(formMsg.build()).queue();
//            event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiDocumenti).sendMessage(formMsg.build()).queue();

            }

            //FEDINE PENALI
            if (event.getChannel().getId().equals(MainDatabaseInfo.govFedinePenali)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(MainDatabaseInfo.lspdFedinePenali).sendMessage(formMsg.build()).queue();
//            event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiFedinePenali).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(MainDatabaseInfo.lspdFedinePenali)) {

                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govFedinePenali).sendMessage(formMsg.build()).queue();
//            event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiFedinePenali).sendMessage(formMsg.build()).queue();
            }

            //PULIZIA FEDINE
            if (event.getChannel().getId().equals(MainDatabaseInfo.govPuliziaFedine)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(MainDatabaseInfo.lspdPuliziaFedine).sendMessage(formMsg.build()).queue();
//            event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiPuliziaFedine).sendMessage(formMsg.build()).queue();
            }

            //MOD ANAGRAFICA
            if (event.getChannel().getId().equals(MainDatabaseInfo.govModAnagrafica)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(MainDatabaseInfo.lspdModAnagrafica).sendMessage(formMsg.build()).queue();
//            event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiModAnagrafica).sendMessage(formMsg.build()).queue();
            }

            //MULTE NON PAGATE
            if (event.getChannel().getId().equals(MainDatabaseInfo.govMulteNonPagate)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(MainDatabaseInfo.lspdMulteNonPagate).sendMessage(formMsg.build()).queue();
//            event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiMulteNonPagate).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().equals(MainDatabaseInfo.lspdMulteNonPagate)) {
                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govMulteNonPagate).sendMessage(formMsg.build()).queue();
//            event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiMulteNonPagate).sendMessage(formMsg.build()).queue();

            }

            //PORTO D'ARMI
            if (event.getChannel().getId().equals(MainDatabaseInfo.lspdPortoDarma)) {
                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govPortoDarma).sendMessage(formMsg.build()).queue();
//            event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiPortoDarma).sendMessage(formMsg.build()).queue();
            }

            //DENUNCE
            if (event.getChannel().getId().equals(MainDatabaseInfo.govDenunce)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(MainDatabaseInfo.lspdDenunce).sendMessage(formMsg.build()).queue();
//            event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiDenunce).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(MainDatabaseInfo.lspdDenunce)) {
                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govDenunce).sendMessage(formMsg.build()).queue();
//            event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiDenunce).sendMessage(formMsg.build()).queue();
            }

            //RICERCATI
            if (event.getChannel().getId().equals(MainDatabaseInfo.govRicercati)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(lspdRicercati).sendMessage(formMsg.build()).queue();
//            event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiRicercati).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(lspdRicercati)) {
                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govRicercati).sendMessage(formMsg.build()).queue();
//            event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiRicercati).sendMessage(formMsg.build()).queue();
            }

            //ALBO AVVOCATI
            if (event.getChannel().getId().equals(MainDatabaseInfo.govAlboAvvocati)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(lspdAlboAvvocati).sendMessage(formMsg.build()).queue();
//                event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(sceriffiAlboAvvocati).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(lspdAlboAvvocati)) {
                event.getJDA().getGuildById(governoID).getTextChannelById(govAlboAvvocati).sendMessage(formMsg.build()).queue();
//                event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(sceriffiAlboAvvocati).sendMessage(formMsg.build()).queue();
            }

            //PUNTI DROGA
            if (event.getChannel().getId().equals(govPuntiDroga)) {
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdPuntiDroga).sendMessage(formMsg.build()).queue();
//                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiPuntiDroga).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(lspdPuntiDroga)) {
                event.getJDA().getGuildById(governoID).getTextChannelById(govPuntiDroga).sendMessage(formMsg.build()).queue();
//                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiPuntiDroga).sendMessage(formMsg.build()).queue();

            }

            //NEXT ONE
        }
    }
}
