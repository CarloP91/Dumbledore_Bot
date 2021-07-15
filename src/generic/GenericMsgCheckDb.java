    package generic;

    import db.DbCredentials;
    import main.DumbledoreMain;
    import net.dv8tion.jda.api.EmbedBuilder;
    import net.dv8tion.jda.api.entities.Guild;
    import net.dv8tion.jda.api.entities.GuildChannel;
    import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
    import net.dv8tion.jda.api.hooks.ListenerAdapter;
    import org.jetbrains.annotations.NotNull;
    import serverList.StrangersLife.MainStrangersLife;
    import utility.BotExcp;
    import utility.Utility;

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


            EmbedBuilder msgSlRoom = new EmbedBuilder()
                    .setColor(Color.black)
                    .setAuthor("ID MESSAGGIO: " + event.getMessageId())
                    .setDescription("<@" + event.getMessage().getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw() + " in <#" + event.getChannel().getId() +">");



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
                    String row4 = result.getString(4);
                    count++;

                    if (row4 != null
                            && !event.getMessage().getAuthor().getId().equals(DumbledoreMain.dumbledoreID)
                            && !event.getMessage().getAuthor().getId().equals(BotExcp.ciroBot)
                            && !event.getChannel().getId().equals(row4)
                            && !guild.getId().equals(MainStrangersLife.strangerLifeID)
                            && !guild.getId().equals(DumbledoreMain.botDiscordID)) {
                        event.getJDA().getGuildById(guild.getId()).getTextChannelById(row4)
                                .sendMessage(msgSlRoom.build()).queue();
                    } else if (row4 == null){
                        System.out.println("ch-log non impostato nel discord " + event.getGuild().getName() + " " + event.getGuild().getId());

                    }

                }


            } catch (SQLException e) {

                e.printStackTrace();
            }

        }

    }
