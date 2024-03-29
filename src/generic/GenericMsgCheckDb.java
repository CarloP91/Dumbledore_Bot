/*
    package generic;

    import db.DbCredentials;
    import main.DumbledoreMain;
    import net.dv8tion.jda.api.EmbedBuilder;
    import net.dv8tion.jda.api.entities.Guild;
    import net.dv8tion.jda.api.entities.GuildChannel;
    import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
    import net.dv8tion.jda.api.hooks.ListenerAdapter;
    import org.jetbrains.annotations.NotNull;
    import serverPersonalScript.StrangersLife.MainStrangersLife;
    import utility.BotExcp;

    import java.awt.*;
    import java.sql.*;
    import java.time.format.DateTimeFormatter;
    import java.util.List;

    public class GenericMsgCheckDb extends ListenerAdapter {

        @Override
        public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
            super.onGuildMessageReceived(event);

            DateTimeFormatter itafmt = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");

            Guild guild = event.getGuild();

            DbCredentials credentials = new DbCredentials();
            String username = credentials.getUsername();
            String password = credentials.getPassword();

            List<Guild> serverList = event.getJDA().getGuilds();
            List<GuildChannel> channelList = event.getGuild().getChannels();


            int count = 0;// count++;


            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", username, password);

                // SELECT FROM DB MYSQL
                String sql = "SELECT * FROM `tab1` WHERE `server_id` = " + guild.getId();

                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                while (result.next()) {
                    //           String row1 = result.getString(1);
                    String row2 = result.getString(2);
                    String row3 = result.getString(3);
                    String row4 = result.getString(4); //bot_channel_log
                    String row5 = result.getString(5); //init
                    count++;



                    if (row4 != null
                        && !event.getAuthor().isBot()){
                        EmbedBuilder msgSlRoom = new EmbedBuilder()
                                .setColor(Color.black)
                                .setAuthor("ID MESSAGGIO: " + event.getMessageId())
                                .setDescription("<@" + event.getMessage().getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw() + " in <#" + event.getChannel().getId() +">");

                        event.getJDA().getGuildById(guild.getId()).getTextChannelById(row4)
                                .sendMessage(msgSlRoom.build()).queue();

//                        System.out.println(event.getMessage().getMember().getId() + " " + event.getGuild().getName());
                    }

                }


            } catch (SQLException e) {

                e.printStackTrace();
                System.out.println(event.getMessage().getMember().getId() + " " + event.getGuild().getName());
            }

        }

    }
*/
