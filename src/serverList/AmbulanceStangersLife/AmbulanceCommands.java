package serverList.AmbulanceStangersLife;

import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import serverList.AmbulanceStangersLife.MainAmbulanceStrangersLife;

import java.awt.*;
import java.util.List;

public class AmbulanceCommands extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split("\\s+");
        // AMBULANCE COMMANDS

        Guild guild = event.getGuild();
        MainAmbulanceStrangersLife ambulanceRole = new MainAmbulanceStrangersLife();

        EmbedBuilder activeCommand = new EmbedBuilder()
                .setColor(Color.green)
                .setDescription("Comando Eseguito");

        if (guild.getId().equals(MainAmbulanceStrangersLife.ambulanceID)) {

            if (args[0].equalsIgnoreCase("orario-riunione")) {
                event.getChannel().sendMessage("Nessuna Riunione in programma").queue();
            }

            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "pay")) {


                if (args.length > 1 && args.length < 3) {

                    System.out.println(args[0] + " 0");
                    System.out.println(args[1] + " 1");

                    event.getChannel().sendMessage(activeCommand.build()).queue();

                    if (event.getMessage().getMentionedRoles().get(0).getId().contains(ambulanceRole.getDirettore())) {
                        System.out.println("Funziona la stampa del direttore");
                    } else if (event.getMessage().getMentionedRoles().get(0).getId().contains(ambulanceRole.getViceDirettore())) {
                        System.out.println("Funziona la stampa del vice direttore");
                    } else if (event.getMessage().getMentionedRoles().get(0).getId().contains(ambulanceRole.getPrimario())) {
                        System.out.println("Funziona la stampa del primario");

                    } else if (event.getMessage().getMentionedRoles().get(0).getId().contains(ambulanceRole.getDottore())) {
                        System.out.println("Funziona la stampa del dottore");
                    } else if (event.getMessage().getMentionedRoles().get(0).getId().contains(ambulanceRole.getParamedico())) {
                        System.out.println("Funziona la stampa del paramedico");
                    } else if (event.getMessage().getMentionedRoles().get(0).getId().contains(ambulanceRole.getTirocinante())) {
                        System.out.println("Funziona la stampa del tirocinante");
                    }
                }
            }

            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "print")
                    && args[1].equalsIgnoreCase("payall")) {

                event.getMessage().delete().queue();

              //  event.getChannel().sendMessage(activeCommand.build()).queue();

                event.getChannel().sendMessage("STIPENDI: \n"
                        + "<@&" + ambulanceRole.getDirettore() + ">: 0 €; \n"
                        + "<@&" + ambulanceRole.getViceDirettore() + ">: 1.500.000 €; \n"
                        + "<@&" + ambulanceRole.getPrimario() + ">: 800.000 €; \n"
                        + "<@&" + ambulanceRole.getDottore() + ">: 500.000 €; \n"
                        + "<@&" + ambulanceRole.getParamedico() + ">: 300.000 €; \n"
                        + "<@&" + ambulanceRole.getTirocinante() + ">: 0 €; \n" ).queue();
            }




        }

    }
}


