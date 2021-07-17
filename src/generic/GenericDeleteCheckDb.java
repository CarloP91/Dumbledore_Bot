package generic;

import db.DbCredentials;
import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import utility.BotExcp;

import java.awt.*;
import java.sql.*;
import java.util.List;

public class GenericDeleteCheckDb extends ListenerAdapter {
    @Override
    public void onMessageDelete(@NotNull MessageDeleteEvent event) {
        super.onMessageDelete(event);

        Guild guild = event.getGuild();
        AuditLogEntry entry = event.getGuild().retrieveAuditLogs().type(ActionType.MESSAGE_DELETE).complete().get(0);

        DbCredentials credentials = new DbCredentials();
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        java.util.List<Guild> serverList = event.getJDA().getGuilds();
        List<GuildChannel> channelList = event.getGuild().getChannels();

        EmbedBuilder delMsg = new EmbedBuilder()
                .setColor(Color.black)
                .setAuthor("ID MESSAGGIO: " + event.getMessageId())
                .setDescription("Il messaggio " + event.getMessageId() + " è stato cancellato in: " + event.getChannel().getName());

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

                if (row4 != null
                        && !event.getChannel().getId().equals(row4)) {
                    event.getGuild().getTextChannelById(row4)
                            .sendMessage(delMsg.build()).queue();
                }

            }


        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

}
