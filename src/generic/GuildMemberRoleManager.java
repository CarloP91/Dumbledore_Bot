/*
package generic;

import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class GuildMemberRoleManager extends ListenerAdapter {
  @Override
  public void onGuildMemberRoleAdd(@NotNull GuildMemberRoleAddEvent event) {
    super.onGuildMemberRoleAdd(event);

    AuditLogEntry entry = event.getGuild().retrieveAuditLogs().type(ActionType.MEMBER_ROLE_UPDATE).complete().get(0);

    System.out.println("Ruolo aggiunto: " + event.getRoles().get(0).getName() + " a " + event.getMember().getEffectiveName() + " da " + entry.getUser().getName());

  }

  public void  onGuildMemberRoleRemove(GuildMemberRoleRemoveEvent event) {
    AuditLogEntry entry = event.getGuild().retrieveAuditLogs().type(ActionType.MEMBER_ROLE_UPDATE).complete().get(0);

    System.out.println(event.getGuild().getName() +" Ruolo rimosso: " + event.getRoles().get(0).getName() + " a " + event.getMember().getEffectiveName() + " da " + entry.getUser().getName());
*/
/*    System.out.println(entry.getUser().isBot() + "bot");
    System.out.println(!entry.getUser().isBot() + "no bot");*//*


    }
}
*/
