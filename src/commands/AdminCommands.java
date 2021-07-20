package commands;

import db.DbCredentials;
import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import utility.Utility;

import java.awt.*;
import java.sql.*;
import java.util.EnumSet;
import java.util.List;

public class AdminCommands extends ListenerAdapter {
    @Override
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

            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "admin")
                    && args[1].equalsIgnoreCase("command")) {
                event.getChannel()
                        .sendMessage("Lista di comandi ADMIN: \n"
                                + "- check serverlist \n"
                                + "- print serverListID (from DB)\n"
                                + "- print serverListName (from DB)\n"
                                + "- print guildchannel (GuID)\n"
                                + "- ~~reload serverlistID~~ (disabled) \n"
                                + "- add channel-log (ChID) \n"
                                + "- add remote channel-log (GuID) \n"
                                + "- sendcmd (GuID) (ChID) (Args) (Args) \n"
                                + "- modify channel-permission (chID) (guildID) (memberID)\n"
                                + "- compile modify channel-permission\n"
                                + "- manutention\n"
                                + "- search channel (guID)"
                        ).queue();

            }
            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "search")
                    && args[1].equalsIgnoreCase("channel")) {
                System.out.println(event.getJDA().getGuildById(args[2]).getTextChannelsByName("bot-channel-log", true));

            }

            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "check")
                    && args[1].equalsIgnoreCase("serverlist")) {


                List<Guild> serverList = event.getJDA().getGuilds();
                List<GuildChannel> channelList = event.getGuild().getChannels();

                event.getChannel().sendMessage(Utility.getServerListNameID(serverList)).queue();
                event.getChannel().sendMessage(activeCommand.build()).queue();

            }

            if (guild.getId().equals(DumbledoreMain.botDiscordID)
                    && args[0].equalsIgnoreCase(DumbledoreMain.prefix + "print")
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

                    e.printStackTrace();
                }

            }*/

            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "print")
                    && args[1].equalsIgnoreCase("guildchannel")) {
                String idCh = args[2];
                List<GuildChannel> channelList = event.getGuild().getChannels();
                List<GuildChannel> guildChannelList = event.getJDA().getGuildById(args[2]).getChannels();

                try {
                    event.getChannel().sendMessage(Utility.getChannelListNameID(guildChannelList)).queue();
                }
                catch (IndexOutOfBoundsException exception) {
                    event.getChannel().sendMessage("Non ho abbastanza poteri per controllare").queue();
                }


                event.getChannel().sendMessage(activeCommand.build()).queue();
            }

            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "add")
                    && args[1].equalsIgnoreCase("channel-log")) {
                String chName = args[2];
                event.getGuild().createTextChannel(chName).queue();
            } else if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "add")
                    && args[1].equalsIgnoreCase("remote")
                    && args[2].equalsIgnoreCase("channel-log")) {

                String guildID = args[3];

                event.getJDA().getGuildById(args[3]).createTextChannel("channel-log")
                        .queue();

                event.getChannel().sendMessage(activeCommand.build()).queue();

            }

            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "modify")
                    && args[1].equalsIgnoreCase("channel-permission")) {


                String chID = args[2];
                String guildID = args[3];
                String memberID = args[4];

                event.getJDA().getGuildById(guildID).getTextChannelById(chID)
                        .createPermissionOverride(event.getJDA().getGuildById(guildID)
                                .getMemberById(memberID))
                        .setAllow(Permission.ALL_PERMISSIONS)
                        .queue();


            } else if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "compile")
                    && args[1].equalsIgnoreCase("modify")
                    && args[2].equalsIgnoreCase("channel-permission")) {

                event.getChannel().sendMessage("modify channel-permission (chID) (guildID) (memberID)").queue();
            }

            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "read")
                    && args[1].equalsIgnoreCase("history-channel")) {

                MessageHistory h = event.getChannel().getHistory();
                h.retrievePast(30).complete();
                List<Message> ml = h.getRetrievedHistory();
                String tempml = ml + "\r";

                System.out.println(tempml);
            }

        }

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "sendcmd")) {

            String guildID = args[1];
            String chID = args[2];

            event.getJDA().getGuildById(guildID)
                    .getTextChannelById(chID).sendMessage(args[3] + " " + args[4]).queue();
        }

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "manutention")) {

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
    }

}
