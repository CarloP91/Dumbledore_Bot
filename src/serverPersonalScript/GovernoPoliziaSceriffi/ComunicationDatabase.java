package serverPersonalScript.GovernoPoliziaSceriffi;

import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import serverPersonalScript.AmbulanceStangersLife.MainAmbulanceStrangersLife;
import serverPersonalScript.StrangersLife.MainStrangersLife;
import utility.BotExcp;

import java.awt.*;

import static serverPersonalScript.GovernoPoliziaSceriffi.MainDatabaseInfo.*;

public class ComunicationDatabase extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);

        EmbedBuilder formMsg = new EmbedBuilder()
                .setColor(0x000000)
                .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                .addField(event.getAuthor().getName(), event.getMessage().getContentRaw(), true);

        EmbedBuilder annunciGovEB = new EmbedBuilder()
                .setColor(0x00e6e6)
                .setTitle("ANNUNCIO GOVERNO")
                .addField("Messaggio:", event.getMessage().getContentRaw(), true);

        EmbedBuilder annunciPolEB = new EmbedBuilder()
                .setColor(0x0000ff)
                .setTitle("ANNUNCIO POLIZIA")
                .addField("Messaggio:", event.getMessage().getContentRaw(), true);

        EmbedBuilder annunciSceEB = new EmbedBuilder()
                .setColor(0xa88724)
                .setTitle("ANNUNCIO SCERIFFI")
                .addField("Messaggio:", event.getMessage().getContentRaw(), true);

        EmbedBuilder annunciWolfsAssault = new EmbedBuilder()
                .setColor(Color.black)
                .setTitle("ANNUNCIO PERLA CLUB")
                .addField("Messaggio:", event.getMessage().getContentRaw(), true);

        EmbedBuilder armeria60 = new EmbedBuilder()
                .setColor(Color.red)
                .setTitle("ANNUNCIO ARMERIA 60")
                .addField("Messaggio:", event.getMessage().getContentRaw(), true);

        EmbedBuilder embConc682 = new EmbedBuilder()
                .setColor(0xe88c8c)
                .setTitle("ANNUNCIO CONCESSIONARIO 682")
                .addField("Messaggio:", event.getMessage().getContentRaw(), true);

        EmbedBuilder embYachtClub = new EmbedBuilder()
                .setColor(0xffab73)
                .setTitle("ANNUNCIO YACHT CLUB")
                .addField("Messaggio:", event.getMessage().getContentRaw(), true);

        if (!event.getAuthor().getId().equals(DumbledoreMain.dumbledoreID)
                && !event.getAuthor().getId().equals(BotExcp.ciroBot)) {

            //DOCUMENTI
            if (event.getChannel().getId().equals(MainDatabaseInfo.lspdDocumenti)) {
                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govDocumenti).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiDocumenti).sendMessage(formMsg.build()).queue();

            }

            //FEDINE PENALI
            if (event.getChannel().getId().equals(MainDatabaseInfo.govFedinePenali)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(MainDatabaseInfo.lspdFedinePenali).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiFedinePenali).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(MainDatabaseInfo.lspdFedinePenali)) {
                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govFedinePenali).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiFedinePenali).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(sceriffiFedinePenali)) {
                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govFedinePenali).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(MainDatabaseInfo.lspdFedinePenali).sendMessage(formMsg.build()).queue();
            }

            //PULIZIA FEDINE
            if (event.getChannel().getId().equals(MainDatabaseInfo.govPuliziaFedine)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(MainDatabaseInfo.lspdPuliziaFedine).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiPuliziaFedine).sendMessage(formMsg.build()).queue();
            }

            //MOD ANAGRAFICA
            if (event.getChannel().getId().equals(MainDatabaseInfo.govModAnagrafica)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(MainDatabaseInfo.lspdModAnagrafica).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiModAnagrafica).sendMessage(formMsg.build()).queue();
            }

            //MULTE NON PAGATE
            if (event.getChannel().getId().equals(MainDatabaseInfo.govMulteNonPagate)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(MainDatabaseInfo.lspdMulteNonPagate).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiMulteNonPagate).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(MainDatabaseInfo.lspdMulteNonPagate)) {
                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govMulteNonPagate).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiMulteNonPagate).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(sceriffiMulteNonPagate)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(MainDatabaseInfo.lspdMulteNonPagate).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govMulteNonPagate).sendMessage(formMsg.build()).queue();
            }

            //PORTO D'ARMI
            if (event.getChannel().getId().equals(MainDatabaseInfo.lspdPortoDarma)) {
                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govPortoDarma).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiPortoDarma).sendMessage(formMsg.build()).queue();
            }

            //DENUNCE
            if (event.getChannel().getId().equals(MainDatabaseInfo.govDenunce)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(MainDatabaseInfo.lspdDenunce).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiDenunce).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(MainDatabaseInfo.lspdDenunce)) {
                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govDenunce).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiDenunce).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(sceriffiDenunce)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(MainDatabaseInfo.lspdDenunce).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govDenunce).sendMessage(formMsg.build()).queue();
            }

            //RICERCATI
            if (event.getChannel().getId().equals(MainDatabaseInfo.govRicercati)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(lspdRicercati).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiRicercati).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(lspdRicercati)) {
                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govRicercati).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(MainDatabaseInfo.sceriffiRicercati).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(sceriffiRicercati)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(lspdRicercati).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.governoID).getTextChannelById(MainDatabaseInfo.govRicercati).sendMessage(formMsg.build()).queue();
            }

            //ALBO AVVOCATI
            if (event.getChannel().getId().equals(MainDatabaseInfo.govAlboAvvocati)) {
                event.getJDA().getGuildById(MainDatabaseInfo.lspdID).getTextChannelById(lspdAlboAvvocati).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainDatabaseInfo.sceriffiID).getTextChannelById(sceriffiAlboAvvocati).sendMessage(formMsg.build()).queue();
            }

            //PUNTI DROGA
            if (event.getChannel().getId().equals(govPuntiDroga)) {
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdPuntiDroga).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiPuntiDroga).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(lspdPuntiDroga)) {
                event.getJDA().getGuildById(governoID).getTextChannelById(govPuntiDroga).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiPuntiDroga).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(sceriffiPuntiDroga)) {
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdPuntiDroga).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(governoID).getTextChannelById(govPuntiDroga).sendMessage(formMsg.build()).queue();
            }

            //MASK
            if (event.getChannel().getId().equals(govMask)) {
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdMask).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiMask).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainAmbulanceStrangersLife.ambulanceID).getTextChannelById(MainAmbulanceStrangersLife.medAutMask).sendMessage(formMsg.build()).queue();
            }

            //PATCH REGOLAMENTO

            if (event.getChannel().getId().equals(MainStrangersLife.patcRegolamento)) {

                event.getJDA().getGuildById(governoID).getTextChannelById(govPatchRegolamento).sendMessage(event.getMessage().getContentRaw()).queue();
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdPatchRegolamento).sendMessage(event.getMessage().getContentRaw()).queue();
                //                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiPatchRegolamento).sendMessage(event.getMessage().getContentRaw()).queue();
                    /*event.getJDA().getGuildById(MainStrangersLife.strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC)
                            .sendMessage("** Messaggio da: ** <#822117897010413598> \r REGOLAMENTO MODIFICATO \r" +
                                   event.getMessage().getContentRaw()).queue();*/
            }

            //ANNUNCI CONDIVISI
            
            if (event.getChannel().getId().equals(govAnnunciCondivisi)) {
                event.getJDA().getGuildById(MainStrangersLife.strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(annunciGovEB.build()).queue();
                event.getJDA().getGuildById(MainStrangersLife.strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();
            } else if (event.getChannel().getId().equals(lspdAnnunciCondivisi)) {
                event.getJDA().getGuildById(MainStrangersLife.strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(annunciPolEB.build()).queue();
                event.getJDA().getGuildById(MainStrangersLife.strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();

            } else if (event.getChannel().getId().equals(sceriffiAnnunciCondivisi)) {
                event.getJDA().getGuildById(MainStrangersLife.strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(annunciSceEB.build()).queue();
                event.getJDA().getGuildById(MainStrangersLife.strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();

            } else if (event.getChannel().getId().equals(MainStrangersLife.annunciIC)
                    || event.getChannel().getId().equals(MainStrangersLife.annunciOOC)) {
                event.getJDA().getGuildById(governoID).getTextChannelById(govAnnunciCondivisi).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdAnnunciCondivisi).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiAnnunciCondivisi).sendMessage(formMsg.build()).queue();

            } else if (event.getChannel().getId().equals(wolfsAssaultAnnunciIC)) {
                event.getJDA().getGuildById(MainStrangersLife.strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(annunciWolfsAssault.build()).queue();
                event.getJDA().getGuildById(MainStrangersLife.strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();

            } else if (event.getChannel().getId().equals(armeria60AnnunciIC)) {
                event.getJDA().getGuildById(MainStrangersLife.strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(armeria60.build()).queue();
                event.getJDA().getGuildById(MainStrangersLife.strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();

            } else if (event.getChannel().getId().equals(conc682AnnunciIC)) {
                event.getJDA().getGuildById(MainStrangersLife.strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(embConc682.build()).queue();
                event.getJDA().getGuildById(MainStrangersLife.strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();

            } else if (event.getChannel().getId().equals(yacthClubAnnunciIC)) {
                event.getJDA().getGuildById(MainStrangersLife.strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(embYachtClub.build()).queue();
                event.getJDA().getGuildById(MainStrangersLife.strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();
            }

            //CERTIFICATI MEDICI

            if (event.getChannel().getId().equals(MainAmbulanceStrangersLife.certMedici)) {
                event.getJDA().getGuildById(governoID).getTextChannelById(govCertMedici).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdCertMedici).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiCertMedici).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(armeria60ID).getTextChannelById(armeria60CertMedici).sendMessage(formMsg.build()).queue();
            }

            //RAPPORTI

            if (event.getChannel().getId().equals(govRapporti)){
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdRapporti).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiRapporti).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(lspdRapporti)) {
                event.getJDA().getGuildById(governoID).getTextChannelById(govRapporti).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiRapporti).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(sceriffiRapporti)) {
                event.getJDA().getGuildById(governoID).getTextChannelById(govRapporti).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiRapporti).sendMessage(formMsg.build()).queue();
            }

            //TEST BALISTICI
            if (event.getChannel().getId().equals(armeria60testBall)) {
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdTestBalistici).sendMessage(formMsg.build()).queue();

            }

            //NEXT ONE
        }
    }
}
