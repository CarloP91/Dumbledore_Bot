import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

    public class Commands extends ListenerAdapter {
        public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
            String[] args = event.getMessage().getContentRaw().split("\\s+");

            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "info")) {
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("Dumbledore Bot dice:");
    //          info.addField("Creatore", "Dominy", false);
                info.setDescription("Check Box");
                info.setColor(0xffffff);
                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
            }
        }
    }

