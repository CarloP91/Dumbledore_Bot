import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReceived extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String Ciccina = "720912809206218776";
        if (event.getMessage().getMember().getId().equals(Ciccina)) {
            //  System.out.println(event.getMessage().getMember());
            event.getMessage().addReaction("\uD83D\uDC96").queue();
        }

        //PER OGNI MESSAGGIO SCRITTO in Balbettante bambocciona banda di babbuini
        if (event.getMessage().getMember().getId().equals(DumbledoreMain.dumbledore)) {

            System.out.println(event.getMessage().getAuthor().getId() + " ha scritto: " + event.getMessage().getContentRaw());

        } else if (event.getGuild().getId().equals(DumbledoreMain.dBbbdb)){
            TextChannel textChannel = event.getGuild().getTextChannelById("847831596178341908");
            textChannel.sendMessage("<@" + event.getMessage().getAuthor().getId() + "> ha scritto: " + event.getMessage().getContentRaw()).queue();

        }
    }
}
