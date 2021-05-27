import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class PrintMembers extends ListenerAdapter {
    @Override
    public void onPrintMembers(PrintMembersEvent event) {

        List<Role> roles = event.("Prova Ruolo", true);
        Role role = guild.getRoleById(847121910096723979);
        List<Member> members = guild.getMembersWithRoles(roles);


    }
}
