package generic;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ClasseTest extends ListenerAdapter {
    public void onGuildMemberRoleRemove(GuildMemberRoleRemoveEvent event) {

       String user = event.getUser().getName();
/*
       System.out.println(user);
       System.out.println(event.getMember());
       System.out.println(event.getMember().getAsMention());
       System.out.println(event.getJDA().getSelfUser());

        System.out.println(" ha rimosso il ruolo " + event.getMember().getRoles() +  " a " + user);
        //  System.out.println("Un ruolo è stato rimosso");*/
    }
}
