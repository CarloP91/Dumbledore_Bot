import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.List;

public class Commands extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "info")) {

            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Dumbledore Bot dice:");
            info.addField("Creatore", "Dominy", false);
            info.setDescription("Check Box [member]");
            info.setColor(0xffffff);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();

            // event.getChannel().sendMessage("Messaggio di prova").queue();
        }

        if (args[0].equalsIgnoreCase("Lista")) {
            Guild guild = event.getGuild();
            Role role = guild.getRoleById("847121910096723979");

            try {
                List<Member> members = guild.findMembers(member -> {
                    if (member.getRoles().contains(role)){
                        return true;
                    }
                    return false;
                }).get();

                for (Member member : members) {
                    System.out.println(member);
                }
            }

            catch (UnsupportedOperationException exception) {
                System.out.println(exception);
            }
        }
    }
}

