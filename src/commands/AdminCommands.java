package commands;

import db.DbCredentials;
import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import utility.Utility;

import java.awt.*;
import java.sql.*;
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
                /*&& event.getChannel().getId().equalsIgnoreCase("856626062779088966")*/) {
            // SE L'AUTORE DEL MESSAGGIO E' DOMINY

            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "admin")
                    && args[1].equalsIgnoreCase("command")) {
                event.getChannel()
                        .sendMessage("Lista di comandi ADMIN: \n"
                                + "- check serverlist \n"
                                + "- print serverListID \n"
                                + "- print serverListName \n"
                                + "- print guildchannel (GuID)\n"
                                + "- ~~reload serverlistID~~ (disabled) \n"
                                + "- add channel-log (ChID)"
                        ).queue();

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
                    && args[1].equalsIgnoreCase("serverListID")) {

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
                        event.getChannel().sendMessage(row1 + ") Server ID: " + row2).queue();

                    }


                } catch (SQLException e) {

                    e.printStackTrace();
                }
                event.getChannel().sendMessage(activeCommand.build()).queue();
            } else if (guild.getId().equals(DumbledoreMain.botDiscordID)
                    && args[0].equalsIgnoreCase(DumbledoreMain.prefix + "print")
                    && args[1].equalsIgnoreCase("serverListName")) {
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
                        event.getChannel().sendMessage(row1 + ") Server NAME: " + row3).queue();
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

/*        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "sendmsg")) {
            event.getJDA().getGuildById("858674220628049920")
                    .getTextChannelById("858679284872249355").sendMessage(args[1]).queue();
        }*/

            /*else if (guild.getId().equals(DumbledoreMain.botDiscordID)
                && !event.getAuthor().getId().equals("383035474807095296")) {
            event.getChannel().sendMessage("Non sei un admin, non puoi farlo!").queue();*/
        }

    }
