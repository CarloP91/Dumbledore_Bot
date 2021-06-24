package serverList.LosSantosPoliceDepartment;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import serverList.StrangersLife.MainStrangersLife;

import java.awt.*;

public class LSPDDeleted extends ListenerAdapter {
    @Override
    public void onMessageDelete(@NotNull MessageDeleteEvent event) {
        super.onMessageDelete(event);

        Guild guild = event.getGuild();
        AuditLogEntry entry = event.getGuild().retrieveAuditLogs().type(ActionType.MESSAGE_DELETE).complete().get(0);

        EmbedBuilder msgSlRoom = new EmbedBuilder()
                .setColor(Color.black)
                .setAuthor("ID MESSAGGIO: " + event.getMessageId())
                .setDescription("Il messaggio " + event.getMessageId() + " è stato cancellato in: " + event.getChannel().getName());


        if (guild.getId().equals(MainLSPD.lspdID)) {

            {
                event.getGuild().getTextChannelById("857701176672649226")
                        .sendMessage(msgSlRoom.build()).queue();
            }


        }
    }
}
