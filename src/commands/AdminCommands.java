package commands;

import db.DbCredentials;
import main.DumbledoreMain;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import utility.Utility;

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

        //ADMIN COMMAND LIST

        // ------------------------------------------------------------------------------------------------- //

        if (guild.getId().equals(DumbledoreMain.botDiscordID)
                && event.getAuthor().getId().equalsIgnoreCase("383035474807095296")) {
            // SE L'AUTORE DEL MESSAGGIO E' DOMINY

            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "admin")
                    && args[1].equalsIgnoreCase("command")) {
                event.getChannel()
                        .sendMessage("Lista di comandi ADMIN: \n"
                                + "- check serverlist \n"
                                + "- print serverListID \n"
                                + "- print serverListName").queue();

            }

            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "check")
                    && args[1].equalsIgnoreCase("serverlist")
                    && guild.getId().equals(DumbledoreMain.botDiscordID)) {


                System.out.println("Mostro server list");
//            System.out.println(event.getJDA().getGuilds());

                List<Guild> serverList = event.getJDA().getGuilds();
                List<GuildChannel> channelList = event.getGuild().getChannels();



                event.getChannel().sendMessage(Utility.getServerListName(serverList)).queue();

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

                    int count = 0;

                    while (result.next()) {
                        String row1 = result.getString(1);
                        String row2 = result.getString(2);
                        String row3 = result.getString(3);
                        count++;
                        event.getChannel().sendMessage(row1 + ") Server ID: " + row2).queue();
                        //  System.out.println(row1 + ") Server ID: " + row2 + "Server NAME: " + row3);
                    }

                    System.out.println();
                } catch (SQLException e) {

                    e.printStackTrace();
                }
            } else if (guild.getId().equals(DumbledoreMain.botDiscordID)
                    && args[0].equalsIgnoreCase(DumbledoreMain.prefix + "print")
                    && args[1].equalsIgnoreCase("serverListName")) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", username, password);

                    // SELECT FROM DB MYSQL
                    String sql = "SELECT * FROM `tab1`";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

                    int count = 0;

                    while (result.next()) {
                        String row1 = result.getString(1);
                        String row2 = result.getString(2);
                        String row3 = result.getString(3);
                        count++;
                        event.getChannel().sendMessage(row1 + ") Server NAME: " + row3).queue();
                        //  System.out.println(row1 + ") Server ID: " + row2 + "Server NAME: " + row3);
                    }
                    System.out.println();
                } catch (SQLException e) {

                    e.printStackTrace();
                }

            }
        }
    }
}
