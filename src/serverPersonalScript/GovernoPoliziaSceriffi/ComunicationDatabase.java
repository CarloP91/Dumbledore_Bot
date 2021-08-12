
package serverPersonalScript.GovernoPoliziaSceriffi;

import main.DumbledoreMain;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static serverPersonalScript.GovernoPoliziaSceriffi.MainDatabaseInfo.*;

public class ComunicationDatabase extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);

        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "sendIC")) {
            event.getJDA().getGuildById("869328725727137833").getTextChannelById(wolfsAssaultAnnunciIC).sendMessage("https://discord.gg/VJcpGmVQ \n" + "Ragazzi come sapete Stranger's Life è chiuso, e tutti i suoi membri ci stiamo spostando su questa nuova città, chiunque volesse ritrovare i vecchi amici potrà seguire il link! Vi aspettiamo ❤️|| @everyone ||").queue();
            event.getJDA().getGuildById(armeria60ID).getTextChannelById(armeria60CertMedici).sendMessage("https://discord.gg/VJcpGmVQ \n" + "Ragazzi come sapete Stranger's Life è chiuso, e tutti i suoi membri ci stiamo spostando su questa nuova città, chiunque volesse ritrovare i vecchi amici potrà seguire il link! Vi aspettiamo ❤️|| @everyone ||").queue();
            event.getJDA().getGuildById(armeria60ID).getTextChannelById(armeria60AnnunciIC).sendMessage("https://discord.gg/VJcpGmVQ \n" + "Ragazzi come sapete Stranger's Life è chiuso, e tutti i suoi membri ci stiamo spostando su questa nuova città, chiunque volesse ritrovare i vecchi amici potrà seguire il link! Vi aspettiamo ❤️|| @everyone ||").queue();
            event.getJDA().getGuildById(armeria60ID).getTextChannelById(armeria60testBall).sendMessage("https://discord.gg/VJcpGmVQ \n" + "Ragazzi come sapete Stranger's Life è chiuso, e tutti i suoi membri ci stiamo spostando su questa nuova città, chiunque volesse ritrovare i vecchi amici potrà seguire il link! Vi aspettiamo ❤️|| @everyone ||").queue();
            event.getJDA().getGuildById(conc682ID).getTextChannelById(conc682AnnunciIC).sendMessage("https://discord.gg/VJcpGmVQ \n" + "Ragazzi come sapete Stranger's Life è chiuso, e tutti i suoi membri ci stiamo spostando su questa nuova città, chiunque volesse ritrovare i vecchi amici potrà seguire il link! Vi aspettiamo ❤️|| @everyone ||").queue();
            event.getJDA().getGuildById("855854902185951234").getTextChannelById("868538815118209024").sendMessage("https://discord.gg/VJcpGmVQ \n" + "Ragazzi come sapete Stranger's Life è chiuso, e tutti i suoi membri ci stiamo spostando su questa nuova città, chiunque volesse ritrovare i vecchi amici potrà seguire il link! Vi aspettiamo ❤️|| @everyone ||").queue();
            event.getJDA().getGuildById("865697610042703882").getTextChannelById("866953627020427294").sendMessage("https://discord.gg/VJcpGmVQ \n" + "Ragazzi come sapete Stranger's Life è chiuso, e tutti i suoi membri ci stiamo spostando su questa nuova città, chiunque volesse ritrovare i vecchi amici potrà seguire il link! Vi aspettiamo ❤️|| @everyone ||").queue();
            event.getJDA().getGuildById(armeria200ID).getTextChannelById(armeria200AnnunciIC).sendMessage("https://discord.gg/VJcpGmVQ \n" + "Ragazzi come sapete Stranger's Life è chiuso, e tutti i suoi membri ci stiamo spostando su questa nuova città, chiunque volesse ritrovare i vecchi amici potrà seguire il link! Vi aspettiamo ❤️|| @everyone ||").queue();
            event.getJDA().getGuildById("872543651962703934").getTextChannelById("873240458334203935").sendMessage("https://discord.gg/VJcpGmVQ \n" + "Ragazzi come sapete Stranger's Life è chiuso, e tutti i suoi membri ci stiamo spostando su questa nuova città, chiunque volesse ritrovare i vecchi amici potrà seguire il link! Vi aspettiamo ❤️|| @everyone ||").queue();
            event.getJDA().getGuildById("857329585057038417").getTextChannelById("868161438416515222").sendMessage("https://discord.gg/VJcpGmVQ \n" + "Ragazzi come sapete Stranger's Life è chiuso, e tutti i suoi membri ci stiamo spostando su questa nuova città, chiunque volesse ritrovare i vecchi amici potrà seguire il link! Vi aspettiamo ❤️|| @everyone ||").queue();
            event.getJDA().getGuildById("857329585057038417").getTextChannelById("868161438416515222").sendMessage("https://discord.gg/VJcpGmVQ \n" + "Ragazzi come sapete Stranger's Life è chiuso, e tutti i suoi membri ci stiamo spostando su questa nuova città, chiunque volesse ritrovare i vecchi amici potrà seguire il link! Vi aspettiamo ❤️|| @everyone ||").queue();
            event.getJDA().getGuildById("853530009624903700").getTextChannelById("854879006208950272").sendMessage("https://discord.gg/VJcpGmVQ \n" + "Ragazzi come sapete Stranger's Life è chiuso, e tutti i suoi membri ci stiamo spostando su questa nuova città, chiunque volesse ritrovare i vecchi amici potrà seguire il link! Vi aspettiamo ❤️|| @everyone ||").queue();
            event.getJDA().getGuildById(lspdID).getTextChannelById(lspdAnnunciCondivisi).sendMessage("https://discord.gg/VJcpGmVQ \n" + "Ragazzi come sapete Stranger's Life è chiuso, e tutti i suoi membri ci stiamo spostando su questa nuova città, chiunque volesse ritrovare i vecchi amici potrà seguire il link! Vi aspettiamo ❤️|| @everyone ||").queue();
        }

    }
}

/*
        if (event.getAuthor().isBot()) {
            //
        } else {

            //DOCUMENTI
            if (event.getChannel().getId().equals(lspdDocumenti)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(governoID).getTextChannelById(govDocumenti).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiDocumenti).sendMessage(formMsg.build()).queue();

            }

            //FEDINE PENALI
            if (event.getChannel().getId().equals(govFedinePenali)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdFedinePenali).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiFedinePenali).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(armeria60ID).getTextChannelById(armieria60FedinePenali).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(armeria200ID).getTextChannelById(armeria200FedinePenali).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(lspdFedinePenali)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(governoID).getTextChannelById(govFedinePenali).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiFedinePenali).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(armeria60ID).getTextChannelById(armieria60FedinePenali).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(armeria200ID).getTextChannelById(armeria200FedinePenali).sendMessage(formMsg.build()).queue();

            } else if (event.getChannel().getId().equals(sceriffiFedinePenali)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(governoID).getTextChannelById(govFedinePenali).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdFedinePenali).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(armeria60ID).getTextChannelById(armieria60FedinePenali).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(armeria200ID).getTextChannelById(armeria200FedinePenali).sendMessage(formMsg.build()).queue();

            }

            //PULIZIA FEDINE
            if (event.getChannel().getId().equals(govPuliziaFedine)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdPuliziaFedine).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiPuliziaFedine).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(armeria60ID).getTextChannelById(armieria60FedinePenali).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(armeria200ID).getTextChannelById(armeria200FedinePenali).sendMessage(formMsg.build()).queue();
            }

            //MOD ANAGRAFICA
            if (event.getChannel().getId().equals(govModAnagrafica)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdModAnagrafica).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiModAnagrafica).sendMessage(formMsg.build()).queue();
            }

            //MULTE NON PAGATE
            if (event.getChannel().getId().equals(govMulteNonPagate)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdMulteNonPagate).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiMulteNonPagate).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(lspdMulteNonPagate)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:**" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(governoID).getTextChannelById(govMulteNonPagate).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiMulteNonPagate).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(sceriffiMulteNonPagate)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdMulteNonPagate).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(governoID).getTextChannelById(govMulteNonPagate).sendMessage(formMsg.build()).queue();
            }

            //PORTO D'ARMI
            if (event.getChannel().getId().equals(lspdPortoDarma)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(governoID).getTextChannelById(govPortoDarma).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiPortoDarma).sendMessage(formMsg.build()).queue();
            }

            //DENUNCE
            if (event.getChannel().getId().equals(govDenunce)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdDenunce).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiDenunce).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(lspdDenunce)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(governoID).getTextChannelById(govDenunce).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiDenunce).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(sceriffiDenunce)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdDenunce).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(governoID).getTextChannelById(govDenunce).sendMessage(formMsg.build()).queue();
            }

            //RICERCATI
            if (event.getChannel().getId().equals(govRicercati)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdRicercati).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiRicercati).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(lspdRicercati)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(governoID).getTextChannelById(govRicercati).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiRicercati).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(sceriffiRicercati)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdRicercati).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(governoID).getTextChannelById(govRicercati).sendMessage(formMsg.build()).queue();
            }

            //ALBO AVVOCATI
            if (event.getChannel().getId().equals(govAlboAvvocati)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                EmbedBuilder annunciGovEB = new EmbedBuilder()
                        .setColor(0x00e6e6)
                        .setTitle("ANNUNCIO GOVERNO")
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdAlboAvvocati).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiAlboAvvocati).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(alboAvvocati).sendMessage(annunciGovEB.build()).queue();
            }

            //PUNTI DROGA
            if (event.getChannel().getId().equals(govPuntiDroga)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdPuntiDroga).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiPuntiDroga).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(lspdPuntiDroga)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(governoID).getTextChannelById(govPuntiDroga).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiPuntiDroga).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(sceriffiPuntiDroga)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdPuntiDroga).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(governoID).getTextChannelById(govPuntiDroga).sendMessage(formMsg.build()).queue();
            }

            //MASK
            if (event.getChannel().getId().equals(govMask)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdMask).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiMask).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(MainAmbulanceStrangersLife.ambulanceID).getTextChannelById(MainAmbulanceStrangersLife.medAutMask).sendMessage(formMsg.build()).queue();
            }

            //PATCH REGOLAMENTO

            if (event.getChannel().getId().equals(MainStrangersLife.patcRegolamento)) {

                try {
//                System.out.println(event.getMessage().getAttachments().get(0).getUrl());
                    event.getJDA().getGuildById(governoID).getTextChannelById(govPatchRegolamento).sendMessage(event.getMessage().getContentRaw() + " \n" + event.getMessage().getAttachments().get(0).getUrl()).queue();
                    event.getJDA().getGuildById(governoID).getTextChannelById(lspdPatchRegolamento).sendMessage(event.getMessage().getContentRaw() + " \n" + event.getMessage().getAttachments().get(0).getUrl()).queue();
                } catch (IndexOutOfBoundsException exception) {
                    System.out.println(exception);
                }
            }

            //ANNUNCI CONDIVISI

            if (event.getChannel().getId().equals(govAnnunciCondivisi)) {
                EmbedBuilder annunciGovEB = new EmbedBuilder()
                        .setColor(0x00e6e6)
                        .setTitle("ANNUNCIO GOVERNO \uD83E\uDD85")
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(annunciGovEB.build()).queue();
                //          event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("```" + event.getMessage().getContentRaw() + "```").queue();
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();
            } else if (event.getChannel().getId().equals(lspdAnnunciCondivisi)) {
                EmbedBuilder annunciPolEB = new EmbedBuilder()
                        .setColor(0x0000ff)
                        .setTitle("ANNUNCIO POLIZIA \uD83D\uDC6E")
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(annunciPolEB.build()).queue();
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();

            } else if (event.getChannel().getId().equals(sceriffiAnnunciCondivisi)) {
                EmbedBuilder annunciSceEB = new EmbedBuilder()
                        .setColor(0xa88724)
                        .setTitle("ANNUNCIO SCERIFFI \uD83E\uDD20")
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(annunciSceEB.build()).queue();
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();

            } else if (event.getChannel().getId().equals(MainStrangersLife.annunciIC)
                    || event.getChannel().getId().equals(MainStrangersLife.annunciOOC)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(governoID).getTextChannelById(govAnnunciCondivisi).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdAnnunciCondivisi).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiAnnunciCondivisi).sendMessage(formMsg.build()).queue();

            } else if (event.getChannel().getId().equals(wolfsAssaultAnnunciIC)) {
                EmbedBuilder annunciWolfsAssault = new EmbedBuilder()
                        .setColor(Color.black)
                        .setTitle("ANNUNCIO CONCESSIONARIO 580 \uD83C\uDFCE")
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(annunciWolfsAssault.build()).queue();
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();

            } else if (event.getChannel().getId().equals(armeria60AnnunciIC)) {
                EmbedBuilder armeria60 = new EmbedBuilder()
                        .setColor(Color.red)
                        .setTitle("ANNUNCIO ARMERIA 60 \uD83D\uDCA3")
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(armeria60.build()).queue();
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();

            } else if (event.getChannel().getId().equals(conc682AnnunciIC)) {
                EmbedBuilder embConc682 = new EmbedBuilder()
                        .setColor(0xe88c8c)
                        .setTitle("ANNUNCIO CONCESSIONARIO 682 \uD83C\uDFCE")
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(embConc682.build()).queue();
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();

            } else if (event.getChannel().getId().equals(yacthClubAnnunciIC)) {
                EmbedBuilder embYachtClub = new EmbedBuilder()
                        .setColor(0xffab73)
                        .setTitle("ANNUNCIO YACHT CLUB \uD83D\uDEE5")
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(embYachtClub.build()).queue();
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();
            } else if (event.getChannel().getId().equals(vanillaAnnunciIC)) {
                EmbedBuilder embVanillaClub = new EmbedBuilder()
                        .setColor(0x800080)
                        .setTitle("ANNUNCIO VANILLA CLUB \uD83C\uDF68")
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(embVanillaClub.build()).queue();
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();
            } else if (event.getChannel().getId().equals(armeria200AnnunciIC))
            {EmbedBuilder armeria200 = new EmbedBuilder()
                    .setColor(Color.red)
                    .setTitle("ANNUNCIO ARMERIA 200 \uD83D\uDCA3")
                    .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(armeria200.build()).queue();
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();
            } else if (event.getChannel().getId().equals(grooveAnnunciIC))
            {EmbedBuilder grooveEmb = new EmbedBuilder()
                    .setColor(0x333300)
                    .setTitle("ANNUNCIO GROOVE CUSTOM \uD83D\uDD27")
                    .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(grooveEmb.build()).queue();
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();
            } else if (event.getChannel().getId().equals(import19AnnunciIC))
            {EmbedBuilder import19Emb = new EmbedBuilder()
                    .setColor(0x000066)
                    .setTitle("ANNUNCIO IMPORT 19 \uD83D\uDCCB")
                    .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(import19Emb.build()).queue();
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();
            } else if (event.getChannel().getId().equals(grooveCustomIC))
            {EmbedBuilder grooveCustomIC = new EmbedBuilder()
                    .setColor(0xac39ac)
                    .setTitle("ANNUNCIO GROOVE CUSTOM \uD83D\uDD27")
                    .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage(grooveCustomIC.build()).queue();
                event.getJDA().getGuildById(strangerLifeID).getTextChannelById(MainStrangersLife.annunciIC).sendMessage("<@&694128369716953159>").queue();
            }

            //RAPPORTI

            if (event.getChannel().getId().equals(govRapporti)) {
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdRapporti).sendMessage(
                        "```Rapporto proveniente da: " + event.getGuild().getName() + " " + event.getChannel().getName() + "\n "
                                + event.getMessage().getContentRaw() + "```").queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiRapporti).sendMessage(
                        "```Rapporto proveniente da: " + event.getGuild().getName() + " " + event.getChannel().getName() + "\n "
                                + event.getMessage().getContentRaw() + "```").queue();
            } else if (event.getChannel().getId().equals(lspdRapporti)) {
                event.getJDA().getGuildById(governoID).getTextChannelById(govRapporti).sendMessage(
                        "```Rapporto proveniente da: " + event.getGuild().getName() + " " + event.getChannel().getName() + "\n "
                                + event.getMessage().getContentRaw() + "```").queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiRapporti).sendMessage(
                        "```Rapporto proveniente da: " + event.getGuild().getName() + " " + event.getChannel().getName() + "\n "
                                + event.getMessage().getContentRaw() + "```").queue();
            } else if (event.getChannel().getId().equals(sceriffiRapporti)) {
                event.getJDA().getGuildById(governoID).getTextChannelById(govRapporti).sendMessage(
                        "```Rapporto proveniente da: " + event.getGuild().getName() + " " + event.getChannel().getName() + "\n "
                                + event.getMessage().getContentRaw() + "```").queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiRapporti).sendMessage(
                        "```Rapporto proveniente da: " + event.getGuild().getName() + " " + event.getChannel().getName() + "\n "
                                + event.getMessage().getContentRaw() + "```").queue();
            }

            //CERTIFICATI MEDICI
            if (event.getChannel().getId().equals(MainAmbulanceStrangersLife.certMedici)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(governoID).getTextChannelById(govCertMedici).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdCertMedici).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiCertMedici).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(armeria60ID).getTextChannelById(armeria60CertMedici).sendMessage(formMsg.build()).queue();
            }


            //TEST BALISTICI
            if (event.getChannel().getId().equals(armeria60testBall)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdTestBalistici).sendMessage(formMsg.build()).queue();

            }

            //SERIALE ARMI
            if (event.getChannel().getId().equals(armeria60SerialArma)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(governoID).getTextChannelById(govSerialArma).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdSerialArma).sendMessage(formMsg.build()).queue();
                //                 event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiSerialArma).sendMessage(formMsg.build()).queue();
            }

            //RICHIESTA MANDATI
            if (event.getChannel().getId().equals(lspdRichiestaMandato)){
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());
                event.getJDA().getGuildById(governoID).getTextChannelById(govRichiestaMandato).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(governoID).getTextChannelById(govRichiestaMandato).sendMessage("<@&867725245145415681>").queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiRichiestaMandato).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(sceriffiRichiestaMandato)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());
                event.getJDA().getGuildById(governoID).getTextChannelById(govRichiestaMandato).sendMessage(formMsg.build()).queue();
                event.getJDA().getGuildById(governoID).getTextChannelById(govRichiestaMandato).sendMessage("<@&867725245145415681>").queue();
                event.getJDA().getGuildById(lspdRichiestaMandato).getTextChannelById(lspdRichiestaMandato).sendMessage(formMsg.build()).queue();
            } else if (event.getChannel().getId().equals(govRichiestaMandato)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdRichiestaMandato).sendMessage(formMsg.build()).queue();;
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiRichiestaMandato).sendMessage(formMsg.build()).queue();
            }

            //MANDATI APPROVATI
            if (event.getChannel().getId().equals(govMandatiApprovati)) {
                try {
//                System.out.println(event.getMessage().getAttachments().get(0).getUrl());
                    event.getJDA().getGuildById(governoID).getTextChannelById(govRichiestaMandato).sendMessage(event.getMessage().getAttachments().get(0).getUrl()).queue();
                    event.getJDA().getGuildById(governoID).getTextChannelById(govRichiestaMandato).sendMessage("Il " + event.getMember().getNickname() + " ha approvato il mandato. Prima di entrare in azione bisogna ritirare la copia cartacea in Governo." ).queue();
                    event.getJDA().getGuildById(lspdID).getTextChannelById(lspdRichiestaMandato).sendMessage(event.getMessage().getAttachments().get(0).getUrl()).queue();
                    event.getJDA().getGuildById(lspdID).getTextChannelById(lspdRichiestaMandato).sendMessage("Il " + event.getMember().getNickname() + " ha approvato il mandato. Prima di entrare in azione bisogna ritirare la copia cartacea in Governo." ).queue();
                    event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiRichiestaMandato).sendMessage(event.getMessage().getAttachments().get(0).getUrl()).queue();
                    event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiRichiestaMandato).sendMessage("Il " + event.getMember().getNickname() + " ha approvato il mandato. Prima di entrare in azione bisogna ritirare la copia cartacea in Governo." ).queue();

                } catch (IndexOutOfBoundsException exception) {
                    System.out.println(exception);
                }
            }

            //CHAT ALTI RANGHI
            if (event.getChannel().getId().equals(govChatAltiRanghi)) {
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdChatAltiRanghi).sendMessage(
                        ">>> **MESSAGGIO IN ARRIVO DA: **" + event.getGuild().getName() + "\n \n"
                                + "Messaggio: \n"
                                + "```" +event.getMessage().getContentRaw() + " ``` \n"
                                + "Messaggio Scritto da: " + event.getMember().getNickname()
                                + "\n <@&860187874124103710>").queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiChatAltiRanghi).sendMessage(
                        ">>> **MESSAGGIO IN ARRIVO DA: **" + event.getGuild().getName() + "\n \n"
                                + "Messaggio: \n"
                                + "```" +event.getMessage().getContentRaw() + " ``` \n"
                                + "Messaggio Scritto da: " + event.getMember().getNickname()
                                + "\n <@&345647188027899906>").queue();
            } else if (event.getChannel().getId().equals(lspdChatAltiRanghi)) {
                event.getJDA().getGuildById(governoID).getTextChannelById(govChatAltiRanghi).sendMessage(
                        ">>> **MESSAGGIO IN ARRIVO DA: **" + event.getGuild().getName() + "\n \n"
                                + "Messaggio: \n"
                                + "```" +event.getMessage().getContentRaw() + " ``` \n"
                                + "Messaggio Scritto da: " + event.getMember().getNickname()
                                + "\n <@&866610818631991306>").queue();
                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiChatAltiRanghi).sendMessage(
                        ">>> **MESSAGGIO IN ARRIVO DA: **" + event.getGuild().getName() + "\n \n"
                                + "Messaggio: \n"
                                + "```" +event.getMessage().getContentRaw() + " ``` \n"
                                + "Messaggio Scritto da: " + event.getMember().getNickname()
                                + "\n <@&345647188027899906>").queue();
            } else if (event.getChannel().getId().equals(sceriffiChatAltiRanghi)) {
                event.getJDA().getGuildById(lspdID).getTextChannelById(lspdChatAltiRanghi).sendMessage(
                        ">>> **MESSAGGIO IN ARRIVO DA: **" + event.getGuild().getName() + "\n \n"
                                + "Messaggio: \n"
                                + "```" +event.getMessage().getContentRaw() + " ``` \n"
                                + "Messaggio Scritto da: " + event.getMember().getNickname()
                                + "\n <@&860187874124103710>").queue();
                event.getJDA().getGuildById(governoID).getTextChannelById(govChatAltiRanghi).sendMessage(
                        ">>> **MESSAGGIO IN ARRIVO DA: **" + event.getGuild().getName() + "\n \n"
                                + "Messaggio: \n"
                                + "```" +event.getMessage().getContentRaw() + " ``` \n"
                                + "Messaggio Scritto da: " + event.getMember().getNickname()
                                + "\n <@&866610818631991306>").queue();
            }

            //PATENTE AEREA

            if (event.getChannel().getId().equals(lspdPatenteAerea)) {
                EmbedBuilder formMsg = new EmbedBuilder()
                        .setColor(0x000000)
                        .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                        .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

                event.getJDA().getGuildById(governoID).getTextChannelById(govPatenteAerea).sendMessage(formMsg.build()).queue();
//                event.getJDA().getGuildById(sceriffiID).getTextChannelById(sceriffiPatenteAerea).sendMessage(formMsg.build()).queue();
            }

            //NEXT ONE

        }
    }
}

*/
