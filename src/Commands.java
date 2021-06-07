import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.channel.voice.update.VoiceChannelUpdatePositionEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.requests.Route;
import serverList.AmbulanceStrangersLife;

import java.util.List;

public class Commands extends ListenerAdapter {
    private String AssignedRole;
    private String IDNewTry;

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
        if (args[0].equalsIgnoreCase("d-amb-pay")) {
            Guild guild = event.getGuild();
            List<Role> roleList = guild.getRoles(); //lista di tutti i ruoli del discord
            List<Member> membersList = guild.getMembers(); //lista di tutti i membri del discord

            for (Role role_m :roleList) { //TEST PER DISCORD
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AssignedRole = "847121910096723979";
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 0€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AssignedRole = "839071738654359572";
                    AmbulanceStrangersLife direttore = new AmbulanceStrangersLife();
                    AssignedRole = direttore.getDirettore();
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 0€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AmbulanceStrangersLife vicedirettore = new AmbulanceStrangersLife();
                    AssignedRole = vicedirettore.getViceDirettore();
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 900.000€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AmbulanceStrangersLife primario = new AmbulanceStrangersLife();
                    AssignedRole = primario.getPrimario();
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 700.000€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AmbulanceStrangersLife dottore = new AmbulanceStrangersLife();
                    AssignedRole = dottore.getDottore();
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 400.000€").queue();

                }

            }
            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AmbulanceStrangersLife paramedico = new AmbulanceStrangersLife();
                    AssignedRole = paramedico.getParamedico();
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 250.000€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AmbulanceStrangersLife ems = new AmbulanceStrangersLife();
                    AssignedRole = ems.getEms();
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 100.000€").queue();

                }

            }

        }
        if (args[0].equalsIgnoreCase("m_tryit")) { //ATTUALMENTE INUTILE
            List<Member> membersList = event.getGuild().getMembers();
            for (Member m_amb : membersList) {
                IDNewTry = "660208405172191250";
                if (m_amb.getId().equals(IDNewTry)) {
                    System.out.println(m_amb.getId());
                    event.getChannel().sendMessage(m_amb.getId()).queue();
                }
            }
        }

        if (args[0].equalsIgnoreCase("add_react_on_req")) {
            String ActCh = "847831596178341908";
            if (event.getChannel().getId().equals(ActCh)) {
                event.getMessage().addReaction("❌").queue();
                event.getMessage().addReaction("✅").queue();
            }

        }

        String nameCH;
        if (args[0].equalsIgnoreCase("ChangeCHName")) {
            if (args.length >= 2) {
                StringBuilder builder = new StringBuilder();
                for (int x = 1; x < args.length; x++) {
                    builder.append(args[1]);
                }
                nameCH = event.getMessage().getContentRaw();

                System.out.println(Route.Channels.MODIFY_CHANNEL.compile(event.getChannel().getId()));
                System.out.println(nameCH);
                System.out.println(event.getMessage());
                System.out.println(event.getChannel());
                System.out.println(event.getMessage().getMember());
                event.getChannel().getManager().setName(String.valueOf(builder)).queue();
                event.getChannel().sendMessage(event.getAuthor().getAsMention() + " has changed the title to: " + builder).queue();

            }
        }


    /*if (args[0].equalsIgnoreCase("clear_msg")) {

        //cancella il messaggio che scrive dopo 10 sec. LoL
        event.getChannel().sendMessage("Tentato Delete").queue(m -> m.delete().queueAfter(10, TimeUnit.SECONDS));


    }*/
    }
    @Override
    public void onVoiceChannelUpdatePosition(VoiceChannelUpdatePositionEvent positionEvent) {
        System.out.println(positionEvent.getChannel());
    }
}

