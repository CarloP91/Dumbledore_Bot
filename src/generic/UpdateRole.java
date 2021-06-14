package generic;

import net.dv8tion.jda.api.events.role.update.GenericRoleUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class UpdateRole extends ListenerAdapter {
    public void onGenericRoleUpdate(GenericRoleUpdateEvent event) {


        System.out.println("funziono");
        System.out.println(event.getEntity().getName());
        System.out.println(event.getNewValue());



    }
}
