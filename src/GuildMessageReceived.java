import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import serverList.BBBdB;

public class GuildMessageReceived extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String Ciccina = "720912809206218776";

        if (event.getMessage().getMember().getId().equals(Ciccina)) {
            //  System.out.println(event.getMessage().getMember());
            event.getMessage().addReaction("\uD83D\uDC96").queue();
        }

        //PER OGNI MESSAGGIO SCRITTO in Balbettante bambocciona banda di babbuini
        if (event.getMessage().getMember().getId().equals(DumbledoreMain.dumbledore)) {

         //   System.out.println(event.getMessage().getAuthor().getName() + " ha scritto: " + event.getMessage().getContentRaw());

        } else if (event.getGuild().getId().equals(BBBdB.dBbbdbID)){
            TextChannel textChannel = event.getGuild().getTextChannelById("851440485721178184");
            textChannel.sendMessage("<@" + event.getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw() + " in <#" + event.getChannel().getId() + ">").queue();

        } else if (event.getMessage().getContentRaw().contains("Dominy")) {
            TextChannel textChannel = event.getGuild().getTextChannelById("851440485721178184");
            textChannel.sendMessage("<@" + event.getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw() + " in <#" + event.getChannel().getId() + ">").queue();
        } else {
            System.out.println("Sono nell'else del MessageReceived per: " + event.getGuild() + " " + event.getMessage().getContentRaw() + " in " + event.getChannel().getName());
            System.out.println(event.getMember().getRoles());
        }
    }
}
