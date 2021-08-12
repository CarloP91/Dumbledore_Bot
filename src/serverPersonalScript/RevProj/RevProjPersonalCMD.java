package serverPersonalScript.RevProj;

import java.awt.Color;
import java.io.PrintStream;
import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.utils.Helpers;
import org.jetbrains.annotations.NotNull;

public class RevProjPersonalCMD extends ListenerAdapter {
    public RevProjPersonalCMD() {
    }

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {

        super.onGuildMessageReceived(event);
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (event.getGuild().getId().equals("865247529314680852") && !event.getAuthor().isBot()) {
            if (args[0].equalsIgnoreCase("!ts")) {
                event.getChannel().sendMessage("Il Team Speak è: crypto.host3.fun <@" + event.getMember().getId() + ">").queue();
            }

            EmbedBuilder manutention;
            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "manutenzione") && args[1].equalsIgnoreCase("server") && args.length < 3) {
                try {
                    manutention = (new EmbedBuilder()).setColor(16711680).setTitle("UNDER MAINTENANCE").setThumbnail("https://i.postimg.cc/Xq5VZPMx/Cattura.png").setDescription("Il server è attualmente in Manutenzione.");
                    event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAgendaDominyRoom).sendMessage(manutention.build()).queue();
                } catch (IndexOutOfBoundsException var4) {
                    PrintStream var10000 = System.out;
                    String var10001 = event.getGuild().getName();
                    var10000.println("problema con il comando manutenzione server su " + var10001 + " " + event.getChannel().getName());
                }
            } else if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "manutenzione") && args[1].equalsIgnoreCase("server") && args[2].equalsIgnoreCase("tempo")) {
                if (!Helpers.isNumeric(args[3])) {
                    event.getChannel().sendMessage("Devi inserire il tempo in minuti.").queue();
                } else if (Helpers.isNumeric(args[3])) {
                    manutention = (new EmbedBuilder()).setColor(16711680).setTitle("UNDER MAINTENANCE").setThumbnail("https://i.postimg.cc/Xq5VZPMx/Cattura.png").setDescription("Il server è attualmente in Manutenzione. \n Tornerà online tra " + args[3] + " minuti");
                    event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAgendaDominyRoom).sendMessage(manutention.build()).queue();
                }
            }

            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "server") && args[1].equalsIgnoreCase("online")) {
                manutention = (new EmbedBuilder()).setColor(Color.green).setTitle("Il server è ONLINE").setDescription("PREMETE F8 E INCOLLATE \n ```connect revenge-project.servegame.com:30100```");
                event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAgendaDominyRoom).sendMessage(manutention.build()).queue();
            }
        }

    }
}
