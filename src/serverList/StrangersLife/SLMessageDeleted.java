package serverList.StrangersLife;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class SLMessageDeleted extends ListenerAdapter {
    @Override
    public void onMessageDelete(@NotNull MessageDeleteEvent event) {
        super.onMessageDelete(event);

        Guild guild = event.getGuild();
        AuditLogEntry entry = event.getGuild().retrieveAuditLogs().type(ActionType.MESSAGE_DELETE).complete().get(0);

        EmbedBuilder msgSlRoom = new EmbedBuilder()
                .setColor(Color.black)
                .setAuthor("ID MESSAGGIO: " + event.getMessageId())
                .setDescription("Il messaggio " + event.getMessageId() + " è stato cancellato in: " + event.getChannel().getName());


        if (guild.getId().equals(MainStrangersLife.strangerLifeID)) {

            if (event.getChannel().getId().equals(MainStrangersLife.whitelistatiRoom))  {
                event.getGuild().getTextChannelById(MainStrangersLife.logWhitelist)
                        .sendMessage(msgSlRoom.build()).queue();
            }

            if (event.getChannel().getId().equals(MainStrangersLife.richiamiRoom))  {
                event.getGuild().getTextChannelById(MainStrangersLife.logWhitelist)
                        .sendMessage(msgSlRoom.build()).queue();
            }

            if (event.getChannel().getId().equals(MainStrangersLife.rimandatiRoom))  {
                event.getGuild().getTextChannelById(MainStrangersLife.logWhitelist)
                        .sendMessage(msgSlRoom.build()).queue();
            }


        }
    }
}
