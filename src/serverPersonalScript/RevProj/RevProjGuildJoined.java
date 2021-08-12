package serverPersonalScript.RevProj;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class RevProjGuildJoined extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        super.onGuildMemberJoin(event);


        if (event.getGuild().getId().equals(MainRevengeProject.revengeProjectID)) {
            try {
                Member member = event.getMember();
  /*           Role role =  event.getJDA().getRoleById("866609806788526090");
            event.getGuild().addRoleToMember(member, role).queue();*/

                Role role2 = event.getJDA().getRoleById(MainRevengeProject.rpAllowlistatoRole);
                event.getGuild().addRoleToMember(member, role2).queue();

                System.out.println("ho aggiunto 1 ruolo a " + event.getMember().getEffectiveName());
            } catch (IndexOutOfBoundsException exception) {
                exception.printStackTrace();
            }
        }

    }
}
