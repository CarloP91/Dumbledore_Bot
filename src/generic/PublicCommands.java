package generic;

import db.DbCredentials;
import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.requests.Route;
import utility.Utility;
import commands.PublicCmdList;

import java.awt.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class PublicCommands extends ListenerAdapter {

    DbCredentials credentials = new DbCredentials();

    String username = credentials.getUsername();
    String password = credentials.getPassword();

    String cVersion = DumbledoreMain.botVersion; //COMANDO 1

    DateTimeFormatter itafmt = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
    int count = 0;


    // LISTA COMANDI
    ArrayList<String> baseCMD = new ArrayList<String>();
    ArrayList<String> explainCMD = new ArrayList<String>();



    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        EmbedBuilder activeCommand = new EmbedBuilder()
                .setColor(Color.green)
                .setDescription("Comando Eseguito");


        Guild guild = event.getGuild();
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        baseCMD.add(PublicCmdList.cmdVersione); explainCMD.add("Show the actual BOT version.");
        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + PublicCmdList.cmdVersione)) {
            event.getChannel().sendMessage("Versione attuale: " + cVersion).queue();
        }

        baseCMD.add(PublicCmdList.cmdDeleteMsgByID); explainCMD.add(" msgID: delete a message by ID.");
        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + PublicCmdList.cmdDeleteMsgByID)) { // cancella un messaggio tramite id
            event.getChannel().deleteMessageById(args[1]).queue();
            event.getMessage().delete().queue();
        }

        baseCMD.add(PublicCmdList.cmdWho); explainCMD.add(" @role: show all member of mentioned role!");
        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "who")) {

            List<Role> roleList = guild.getRoles();
            List<Role> mentRole = event.getMessage().getMentionedRoles();
            List<Member> membersList = guild.getMembers();

            EmbedBuilder whoReq = new EmbedBuilder()
                    .setDescription("<@" + event.getMessage().getAuthor().getId() + ">" + " HA RICHIESTO: " + Utility.getRoleAsStringID(mentRole) + " \n")
                    .setColor(Color.green);


            event.getChannel().sendMessage(whoReq.build()).queue();

            if (args.length > 1 && args.length < 3) {
                StringBuilder buildLoop = new StringBuilder();
                for (Role r1 : roleList) {
                    if (args[1].contains(r1.getId())) {
                        for (Member member : membersList) {
                            List<Role> memberRoles = member.getRoles();
                            for (Role m_role : memberRoles) {
                                if (m_role.equals(r1)) {

                                    buildLoop.append("Ruolo: " + "<@&" + r1.getId() + ">" + " - Utente: " + "<@" + member.getUser().getId() + "> \r");

                                }
                            }
                        }
                    }
                }
                EmbedBuilder whoPrint = new EmbedBuilder()
                        .setDescription(buildLoop.toString());

                event.getChannel().sendMessage(whoPrint.build()).queue();
            }
            EmbedBuilder endReport = new EmbedBuilder()
                    .setDescription("**//------// FINE REPORT //------//**")
                    .setColor(Color.green);
            event.getChannel().sendMessage(endReport.build()).queue();
            event.getMessage().delete().queue();
        }

        baseCMD.add(PublicCmdList.cmdInfo); explainCMD.add(" @member: show the information about mentioned member.");
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

       /* // STAMPA TUTTI I MEMBRI DEL DISCORD
        baseCMD.add(PublicCmdList.cmdWhoAllMembers); explainCMD.add("do not use if you have very much member in your guild.");
        if (args[0].equalsIgnoreCase(PublicCmdList.cmdWhoAllMembers)) {

            List<Member> membersList = guild.getMembers();

            for (Member member : membersList) {
                event.getChannel().sendMessage("<@" + member.getUser().getId() + ">").queue();
            }
        }*/

        baseCMD.add(PublicCmdList.cmdAdd); explainCMD.add(" server: add your discord server in BOT DB.");
        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + PublicCmdList.cmdAdd)
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

        //baseCMD.add(PublicCmdList.cmdHelp);
        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "help")) {

            event.getChannel().sendMessage
                    ("Sono il bot di Dominy, sono attualmente in sviluppo \uD83D\uDC97 \n \n" +
                            "Lista Comandi: \r")
                    .queue();


            for (int i = 0; i < baseCMD.size(); i++) {
                event.getChannel().sendMessage(i + 1 + " **" + baseCMD.get(i) + "** " + explainCMD.get(i)).queue();
            }

            event.getChannel().sendMessage(activeCommand.build()).queue();
        }

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "testinv")) {

            String idCHInv = guild.getId();
            String inviteCH = event.getChannel().createInvite().complete().getUrl();

           System.out.println(idCHInv);

            try {
                event.getJDA().getGuildById(DumbledoreMain.botDiscordID)
                        .getTextChannelById("660202751032033280").sendMessage("Mando il mex").queue();
//                event.getChannel().sendMessage().queue();

            } catch (IndexOutOfBoundsException exception) {
                System.out.println("Problema con comando testinv");
            }
        }

    }
}

