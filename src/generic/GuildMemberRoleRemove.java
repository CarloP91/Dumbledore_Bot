package generic;

import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberRoleRemove extends ListenerAdapter {
  public void  onGuildMemberRoleRemove(GuildMemberRoleRemoveEvent event) {
    AuditLogEntry entry = event.getGuild().retrieveAuditLogs().type(ActionType.MEMBER_ROLE_UPDATE).complete().get(0);

    System.out.println("Ruolo rimosso: " + event.getRoles().get(0).getName() + " " + event.getMember().getEffectiveName());
    System.out.println(entry.getUser().getName());
    }
}
