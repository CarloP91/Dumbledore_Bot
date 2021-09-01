/*
package generic;

import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.events.role.update.GenericRoleUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class UpdateRole extends ListenerAdapter {
    public void onGenericRoleUpdate(GenericRoleUpdateEvent event) {

        AuditLogEntry entry = event.getGuild().retrieveAuditLogs().type(ActionType.ROLE_UPDATE).complete().get(0);

        System.out.println("Qualuno ha aggiornato il ruolo: " + event.getNewValue() + " in " + event.getNewValue() + " nome tel tipo: "+ entry.getUser().getName() );

        System.out.println(event.getEntity().getName());
        System.out.println(event.getNewValue());



    }
}
*/
