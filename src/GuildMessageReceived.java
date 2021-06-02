import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReceived extends ListenerAdapter {
    public void  onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String Ciccina = "720912809206218776";
        if (event.getMessage().getMember().getId().equals(Ciccina)) {
            //  System.out.println(event.getMessage().getMember());
            event.getMessage().addReaction("\uD83D\uDC96").queue();
        }

    }
}
