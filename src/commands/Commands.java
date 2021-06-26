package commands;

import db.DbCredentials;
import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.requests.Route;
import utility.Utility;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Commands extends ListenerAdapter {

    DbCredentials credentials = new DbCredentials();

    String username = credentials.getUsername();
    String password = credentials.getPassword();

    DateTimeFormatter itafmt = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
    int count = 0;


    // LISTA COMANDI
    ArrayList<String> baseCMD = new ArrayList<String>();

    String cVersion = DumbledoreMain.botVersion; //COMANDO 1
    String cmdWhoAllMembers = "who-all-members";
    String cRotto = "rotto";
    String cmdVersione = "version";
    String cmdHelp = "help";
    String cmdDeleteMsgByID = "deletemsg";
    String cmdWho = "who";
    String cmdInfo = "info";
    String cmdAdd = "add";

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {


        Guild guild = event.getGuild();
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        baseCMD.add(cmdHelp);
        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "help")) {

            event.getChannel().sendMessage
                    ("Sono il bot di Dominy, sono attualmente in sviluppo <3" +
                            "Lista Comandi: " +
                            "\n - who @ruolo;" +
                            "\n - " + cVersion +
                            "\n -" + cmdWhoAllMembers +
                            "\n - add server"
                    )
                    .queue();
        }

        baseCMD.add(cmdVersione);
        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + cmdVersione)) {
            event.getChannel().sendMessage("Versione attuale: " + cVersion).queue();
        }

        baseCMD.add(cmdDeleteMsgByID);
        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + cmdDeleteMsgByID)) { // cancella un messaggio tramite id
            event.getChannel().deleteMessageById(args[1]).queue();
            event.getMessage().delete().queue();
        }

        baseCMD.add(cmdWho);
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
                                    event.getChannel().sendMessage(event.getMessage().getAuthor() + "HA RICHIESTO:   \n" + "Ruolo: " + "<@&" + r1.getId() + ">" + " - Utente: " + "<@" + member.getUser().getId() + ">").queue();
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

        baseCMD.add(cmdInfo);
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

        if (args[0].equalsIgnoreCase("d_Offline")) {

            EmbedBuilder off = new EmbedBuilder();
            off.setTitle("Dumbledore Bot dice:");
            off.setDescription("Yes, sir! \n ... \n Il BOT si sta spegnendo.. \uD83E\uDDED️");
            off.setColor(0xff3300);
            event.getChannel().sendMessage(off.build()).queue();
            off.clear();
        }

        // STAMPA TUTTI I MEMBRI DEL DISCORD
        baseCMD.add(cmdWhoAllMembers);
        if (args[0].equalsIgnoreCase(cmdWhoAllMembers)) {

            List<Member> membersList = guild.getMembers();

            for (Member member : membersList) {
                event.getChannel().sendMessage("<@" + member.getUser().getId() + ">").queue();
            }
        }

        baseCMD.add(cmdAdd);
        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + cmdAdd)
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
            } catch (SQLException e) {
                System.out.println("Non funge cmdADD");
                e.printStackTrace();
            }
            event.getMessage().delete().queue();
        }
    }
}

