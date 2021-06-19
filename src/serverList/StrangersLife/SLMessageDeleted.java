package serverList.StrangersLife;

import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class SLMessageDeleted extends ListenerAdapter {
    @Override
    public void onMessageDelete(@NotNull MessageDeleteEvent event) {
        super.onMessageDelete(event);

        Guild guild = event.getGuild();
        AuditLogEntry entry = event.getGuild().retrieveAuditLogs().type(ActionType.MESSAGE_DELETE).complete().get(0);

        if (guild.getId().equals(MainStrangersLife.strangerLifeID)) {

            if (event.getChannel().getId().equals(MainStrangersLife.whitelistatiRoom))  {
                System.out.println("Il messaggio " + event.getMessageId() + " è stato cancellato in: " + event.getChannel().getName() + " da " + entry.getUser().getName());
            }

            if (event.getChannel().getId().equals(MainStrangersLife.richiamiRoom))  {
                System.out.println("Il messaggio " + event.getMessageId() + " è stato cancellato in: " + event.getChannel().getName() + " da " + entry.getUser().getName());
            }

            if (event.getChannel().getId().equals(MainStrangersLife.rimandatiRoom))  {
                System.out.println("Il messaggio " + event.getMessageId() + " è stato cancellato in: " + event.getChannel().getName() + " da " + entry.getUser().getName());
            }


        }
    }
}
