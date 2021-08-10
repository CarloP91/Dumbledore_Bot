package serverPersonalScript.RevProj;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class RevProjGestioneRole extends ListenerAdapter {

    @Override
    public void onGuildMemberRoleAdd(@NotNull GuildMemberRoleAddEvent event) {
        super.onGuildMemberRoleAdd(event);

        AuditLogEntry entry = event.getGuild().retrieveAuditLogs().type(ActionType.MEMBER_ROLE_UPDATE).complete().get(0);

        if (event.getGuild().getId().equals("865247529314680852")) {
                try {
                    EmbedBuilder builderRoleADD = new EmbedBuilder()
                            .setColor(0x4dff4d)
                            .addField("Staff: ", "<@" + entry.getUser().getId() + ">", true)
                            .setDescription("Ruolo Aggiunto")
                            .addField("Ruolo: ", "<@&" + event.getRoles().get(0).getId() + ">", true)
                            .addField("A: ", "<@" + event.getMember().getId() + ">", true);
                    event.getGuild().getTextChannelById("874399897158316043")
                            .sendMessage(builderRoleADD.build()).queue();
                } catch (IndexOutOfBoundsException exception) {
                    System.out.println("Non funge il builder ADD su " + event.getGuild().getName());
                }
            }
        }

    public void onGuildMemberRoleRemove(GuildMemberRoleRemoveEvent event) {
        AuditLogEntry entry = event.getGuild().retrieveAuditLogs().type(ActionType.MEMBER_ROLE_UPDATE).complete().get(0);

        if (event.getGuild().getId().equals("865247529314680852")) {
                try {
                    EmbedBuilder builderRoleRemove = new EmbedBuilder()
                            .setColor(0xff1a1a)
                            .addField("Staff: ", "<@" + entry.getUser().getId() + ">", true)
                            .setDescription("Ruolo Rimosso")
                            .addField("Ruolo: ", "<@&" + event.getRoles().get(0).getId() + ">", true)
                            .addField("A: ", "<@" + event.getMember().getId() + ">", true);
                    event.getGuild().getTextChannelById("874399897158316043")
                            .sendMessage(builderRoleRemove.build()).queue();
                } catch (IndexOutOfBoundsException exception) {
                    System.out.println("Non funge il builder Remove su " + event.getGuild().getName());
                }
            }
        }
    }

