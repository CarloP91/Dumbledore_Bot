import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.channel.voice.update.VoiceChannelUpdatePositionEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
        if (args[0].equalsIgnoreCase("faf")) {
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
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 0€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AssignedRole = "839071683976495155"; //VICE DIRETTORE
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 900.000€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AssignedRole = "840159576905089044"; //PRIMARIO
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 700.000€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AssignedRole = "839071597327024129"; //DOTTORE
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 400.000€").queue();

                }

            }
            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AssignedRole = "839069751073832980"; //PARAMEDICO
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 250.000€").queue();

                }

            }

            for (Role role_m :roleList) {
                if (event.getMessage().toString().contains("@" + role_m.getName())) {
                    AssignedRole = "844289989831557120";//EMS
                    if (role_m.getId().equals(AssignedRole))
                        event.getChannel().sendMessage("Il " + "<@&" + role_m.getId() + ">" + " prenderà di stipendio: 100.000€").queue();

                }

            }

        }
        if (args[0].equalsIgnoreCase("m_tryit")) {
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

        if (args[0].equalsIgnoreCase("try")){
            String Ciccina = "383035474807095296";
            if (event.getMessage().getMember().getId().equals(Ciccina)) {
                System.out.println(event.getMessage().getMember());
                event.getMessage().addReaction("\uD83D\uDC96").queue();
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

