import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.channel.voice.update.VoiceChannelUpdatePositionEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class Commands extends ListenerAdapter {
    private String AssignedRole;

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "info")) {

          /*  EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Dumbledore Bot dice:");
            info.addField("Creatore", "Dominy", false);
            info.setDescription("Check Box [member]");
            info.setColor(0xffffff);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();*/
            event.getChannel().sendMessage
                    ("Lista Comandi: " +
                            "\r who @ruolo;" +
                            "\r who-all-role; " +
                            "\r d-ambulance-payment")
                    .queue();
        }

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "rotto")) {

            EmbedBuilder off = new EmbedBuilder();
            off.setTitle("Dumbledore Bot dice:");
            off.setDescription("Sono rotto! Sono rotto!️");
            off.setColor(0xff3300);
            event.getChannel().sendMessage(off.build()).queue();
            off.clear();
        }

        if (args[0].equalsIgnoreCase("d_Offline")) {

            EmbedBuilder off = new EmbedBuilder();
            off.setTitle("Dumbledore Bot dice:");
            off.setDescription("Yes, sir! \n ... \n Il BOT si sta spegnendo.. \uD83E\uDDED️");
            off.setColor(0xff3300);
            event.getChannel().sendMessage(off.build()).queue();
            off.clear();
        }

        if (args[0].equalsIgnoreCase("who")) {
            Guild guild = event.getGuild();
            List<Role> roleList = guild.getRoles();
            List<Member> membersList = guild.getMembers();
            List<Role> memberRoles;

            for (Role r : roleList) {
                if (event.getMessage().toString().contains("@" + r.getName())) {
                    for (Member member : membersList) {
                        memberRoles = member.getRoles();
                        for (Role m_role : memberRoles) {
                            if (m_role.equals(r)) {
                                event.getChannel().sendMessage("Ruolo: " + "<@&" + r.getId() + ">" + " - Utente: " + "<@" + member.getUser().getId() + ">").queue();
                            }
                        }
                    }
                }
            }
        }

        // STAMPA TUTTI I MEMBRI DEL DISCORD
        if (args[0].equalsIgnoreCase("who-all-role")) {
            Guild guild = event.getGuild();
            List<Member> membersList = guild.getMembers();

                for (Member member : membersList) {
                    event.getChannel().sendMessage("<@" + member.getUser().getId() + ">").queue();
                        }
                    }


//        / - - - - - - - / AMBULANCE / - - - - - - - /

        // DA IMPLEMENTARE PER DISCORD AMBULANCE CON DATI EXCEL
        if (args[0].equalsIgnoreCase("d-ambulance-payment")) {
            Guild guild = event.getGuild();
            List<Member> membersList = guild.getMembers();
            for (Member member : membersList) {
                event.getChannel().sendMessage("<@" + member.getUser().getId() + ">" + " " + "- `[0/7]` - `[0 €]` - `[NO]`").queue();
            }
        }

/* DEFAULT ASSEGNAZIONE RUOLO
        if (args[0].equalsIgnoreCase("d-a-p")) {
            Guild guild = event.getGuild();
            List<Role> roleList = guild.getRoles(); //lista di tutti i ruoli del discord
            List<Member> membersList = guild.getMembers(); //lista di tutti i membri del discord
            List<Role> memberRolesAmb;
            AssignedRole = "Ruolo Test";

            for (Role role_m :roleList) {
                if (role_m.getName().equals(AssignedRole))
                event.getChannel().sendMessage(role_m.getName()).queue();
            }

        }
*/
        if (args[0].equalsIgnoreCase("d-pay-amb")) {
            Guild guild = event.getGuild();
            List<Role> roleList = guild.getRoles(); //lista di tutti i ruoli del discord
            List<Member> membersList = guild.getMembers(); //lista di tutti i membri del discord
            List<Role> memberRolesAmb;


            for (Role role_m :roleList) { //TEST PER DISCORD
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AssignedRole = "Ruolo Test";
                    if (role_m.getName().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 0€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AssignedRole = "Direttore";
                    if (role_m.getName().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 0€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AssignedRole = "Vice Direttore";
                    if (role_m.getName().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 0€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AssignedRole = "Primario";
                    if (role_m.getName().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 700.000€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AssignedRole = "Dottore";
                    if (role_m.getName().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 500.000€").queue();

                }

            }
            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AssignedRole = "Paramedico";
                    if (role_m.getName().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 300.000€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AssignedRole = "E.M.S.";
                    if (role_m.getName().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 100.000€").queue();

                }

            }

        }


/* non funziona ancora
    if (args[0].equalsIgnoreCase("clear_msg")) {
        Guild guild = event.getGuild();
        event.getMessage().delete().queue();

    }*/
}
    @Override
    public void onVoiceChannelUpdatePosition(VoiceChannelUpdatePositionEvent positionEvent) {
        System.out.println(positionEvent.getChannel());
    }
}

