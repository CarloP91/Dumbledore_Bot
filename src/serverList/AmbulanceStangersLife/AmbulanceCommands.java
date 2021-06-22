package serverList.AmbulanceStangersLife;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import serverList.AmbulanceStangersLife.MainAmbulanceStrangersLife;
import java.util.List;

public class AmbulanceCommands extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split("\\s+");
        // AMBULANCE COMMANDS

        if (args[0].equalsIgnoreCase( "orario-riunione")) {
            event.getChannel().sendMessage("Riunione ore 17").queue();
        }

        String AssignedRole;

        if (args[0].equalsIgnoreCase( "payamb")) {
            Guild guild = event.getGuild();
            List<Role> roleList = guild.getRoles(); //lista di tutti i ruoli del discord


            for (Role role_m :roleList) { //TEST PER DISCORD
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AssignedRole = "847121910096723979";
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 0€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    MainAmbulanceStrangersLife direttore = new MainAmbulanceStrangersLife();
                    AssignedRole = direttore.getDirettore();
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 0€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    System.out.println(role_m.getName());
                    System.out.println(event.getMessage());
                    MainAmbulanceStrangersLife vicedirettore = new MainAmbulanceStrangersLife();
                    System.out.println(vicedirettore.getViceDirettore());
                    AssignedRole = vicedirettore.getViceDirettore();
                    System.out.println(AssignedRole);
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 900.000€").queue();

                }

            }


            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    MainAmbulanceStrangersLife primario = new MainAmbulanceStrangersLife();
                    AssignedRole = primario.getPrimario();
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 700.000€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    MainAmbulanceStrangersLife dottore = new MainAmbulanceStrangersLife();
                    AssignedRole = dottore.getDottore();
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 400.000€").queue();

                }

            }
            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    MainAmbulanceStrangersLife paramedico = new MainAmbulanceStrangersLife();
                    AssignedRole = paramedico.getParamedico();
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 250.000€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    MainAmbulanceStrangersLife ems = new MainAmbulanceStrangersLife();
                    AssignedRole = ems.getTirocinante();
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 100.000€").queue();

                }

            }

            event.getMessage().delete().queue();
        }
    }
}
