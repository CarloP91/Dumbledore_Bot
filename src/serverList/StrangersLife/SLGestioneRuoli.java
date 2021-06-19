package serverList.StrangersLife;

import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;



public class SLGestioneRuoli extends ListenerAdapter {
    @Override
    public void onGuildMemberRoleAdd(@NotNull GuildMemberRoleAddEvent event) {
        super.onGuildMemberRoleAdd(event);

        AuditLogEntry entry = event.getGuild().retrieveAuditLogs().type(ActionType.MEMBER_ROLE_UPDATE).complete().get(0);

        if (event.getGuild().getId().equals(MainStrangersLife.strangerLifeID)){
            if (event.getRoles().get(0).getId().equals("694128369716953159") || event.getRoles().get(0).getId().equals("710139692145705080")) {
                event.getGuild().getTextChannelById(MainStrangersLife.ChMsglogIDRoom)
                        .sendMessage("<@" + entry.getUser().getId() + "> ha aggiunto il ruolo <@&" + event.getRoles().get(0).getId() + "> a <@" + event.getMember().getId() + ">").queue();
            }
        }

    }

    public void  onGuildMemberRoleRemove(GuildMemberRoleRemoveEvent event) {
        AuditLogEntry entry = event.getGuild().retrieveAuditLogs().type(ActionType.MEMBER_ROLE_UPDATE).complete().get(0);

        if (event.getGuild().getId().equals(MainStrangersLife.strangerLifeID)){
            if (event.getRoles().get(0).getId().equals("694128369716953159") || event.getRoles().get(0).getId().equals("710139692145705080"))  {
                event.getGuild().getTextChannelById(MainStrangersLife.ChMsglogIDRoom)
                        .sendMessage("<@" + entry.getUser().getId() + "> ha rimosso il ruolo <@&" + event.getRoles().get(0).getId() + "> a <@" + event.getMember().getId() + ">").queue();
            }
        }

    }
}
