package commands;

import db.DbCredentials;
import jdk.jshell.execution.Util;
import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.channel.voice.update.VoiceChannelUpdatePositionEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.requests.Route;
import serverList.StrangersLife.MainStrangersLife;
import utility.Utility;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

public class Commands extends ListenerAdapter {
    private String AssignedRole;
    private String IDNewTry;

    DbCredentials credentials = new DbCredentials();

    String username = credentials.getUsername();
    String password = credentials.getPassword();

    DateTimeFormatter itafmt = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
    int count = 0;


    // LISTA COMANDI

    String cVersion = DumbledoreMain.botVersion; //COMANDO 1
    String cWhoAllMembers = "who-all-members";
    String cRotto = "rotto";

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        Guild guild = event.getGuild();
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "version")) {
            event.getChannel().sendMessage("Versione attuale: " + cVersion).queue();
        }

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "help")) {

            event.getChannel().sendMessage
                    ("Sono il bot di Dominy, sono attualmente in sviluppo <3" +
                            "Lista Comandi: " +
                            "\r who @ruolo;" +
                            "\r" + cVersion +
                            "\r" + cWhoAllMembers
                    )
                    .queue();
        }

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "delete")) { // cancella un messaggio tramite id
            event.getChannel().deleteMessageById(args[1]).queue();
            event.getMessage().delete().queue();
        }

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "who")) {

            List<Role> roleList = guild.getRoles();
            List<Member> membersList = guild.getMembers();

            if (args.length > 1 && args.length < 3) {
                for (Role r1 : roleList) {
                    if (args[1].contains(r1.getId())) {
                        for (Member member : membersList) {
                            List<Role> memberRoles = member.getRoles();
                            for (Role m_role : memberRoles) {
                                if (m_role.equals(r1)) {
                                    event.getChannel().sendMessage("   \n" + "Ruolo: " + "<@&" + r1.getId() + ">" + " - Utente: " + "<@" + member.getUser().getId() + ">").queue();
                                    //  System.out.println(args[0] + args[1]);
                                    //  System.out.println(event.getGuild().getRoleById(args[1].replace("<@&", "").replace(">", "")));
                                }
                            }
                        }
                    }
                }
            }
            event.getChannel().sendMessage("**//------// FINE REPORT //------//** \n").queue();
            event.getMessage().delete().queue();
        }

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "info")) {
            if (args.length > 1 && args.length < 3) {
                try {
                    Member name = event.getMessage().getMentionedMembers().get(0);
                    //    System.out.println(name);

                    EmbedBuilder embB = new EmbedBuilder()
                            .setColor(0xF6BE00)
                            .setAuthor("Info riguardanti: " + name.getUser().getName(), "https://www.google.com", name.getUser().getAvatarUrl())
                            .setDescription("Entrato nel discord il: " + name.getTimeJoined().format(itafmt))
                            .addField("Status: ", name.getOnlineStatus().toString(), true)
                            .addField("Ruoli", Utility.getRoleAsStringID(name.getRoles()) + ".", true);

                    event.getChannel().sendMessage(embB.build()).queue();
                } catch (IndexOutOfBoundsException exception) {
                    event.getChannel().sendMessage("Non hai taggato un @nome").queue();
                }
            }
        }


        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + cRotto)) {
            event.getMessage().delete().queue();
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

        // STAMPA TUTTI I MEMBRI DEL DISCORD
        if (args[0].equalsIgnoreCase(cWhoAllMembers)) {

            List<Member> membersList = guild.getMembers();

            for (Member member : membersList) {
                event.getChannel().sendMessage("<@" + member.getUser().getId() + ">").queue();
            }
        }

        //RIMUOVERE RUOLO
        if (args[0].equalsIgnoreCase("modruolo") && args[1].equalsIgnoreCase("Animagus")
                && args[2].equalsIgnoreCase("to") && args[3].equalsIgnoreCase("RuoloTest")) {


            System.out.println(event.getGuild().getRoles());
            System.out.println(event.getGuild().getMembers());
            event.getChannel().sendMessage("sto funzionando").queue();
        }

        if (args[0].equalsIgnoreCase("add_react_on_req")) {
            String ActCh = "847831596178341908";
            if (event.getChannel().getId().equals(ActCh)) {
                event.getMessage().addReaction("❌").queue();
                event.getMessage().addReaction("✅").queue();
            }
        }

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "add")
                && args[1].equalsIgnoreCase("server")) {

            System.out.println(guild.getId() + " " + guild.getName());
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", username, password);
                String sql = "INSERT INTO `tab1` (server_id, server_name) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, guild.getId());
                statement.setString(2, guild.getName());
                int rows = statement.executeUpdate();
                if (rows > 0) {
                    System.out.println("Inserito");
                }
                statement.close();
                connection.close();
                System.out.println("Funge");
            } catch (SQLException e) {
                System.out.println("Non funge");
                e.printStackTrace();
            }
            event.getMessage().delete().queue();
        }

        if (args[0].equalsIgnoreCase("ChangeCHName")) {
            if (args.length >= 2) {
                StringBuilder builder = new StringBuilder();
                for (int x = 1; x < args.length; x++) {
                    builder.append(args[1]);
                }
                String nameCH;
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



    }
}
