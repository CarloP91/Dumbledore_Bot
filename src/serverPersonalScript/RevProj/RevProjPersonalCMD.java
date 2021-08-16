package serverPersonalScript.RevProj;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.utils.Helpers;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.PrintStream;
import java.util.List;

import static main.DumbledoreMain.botDiscordID;
import static main.DumbledoreMain.prefix;
import static commands.AdminCommands.DominyOnOff;

public class RevProjPersonalCMD extends ListenerAdapter {

    boolean bulkDelete = false;
    EmbedBuilder cmdDisabled;

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {

        super.onGuildMessageReceived(event);
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (event.getGuild().getId().equals("865247529314680852") && !event.getAuthor().isBot()) {
            if (args[0].equalsIgnoreCase("!ts")) {
                event.getChannel().sendMessage("Il Team Speak è: crypto.host3.fun <@" + event.getMember().getId() + ">").queue();
            }

            EmbedBuilder manutention;
            if (args[0].equalsIgnoreCase(prefix + "manutenzione") && args[1].equalsIgnoreCase("server") && args.length < 3) {
                try {
                    manutention = (new EmbedBuilder()).setColor(16711680).setTitle("UNDER MAINTENANCE").setThumbnail("https://i.postimg.cc/Xq5VZPMx/Cattura.png").setDescription("Il server è attualmente in Manutenzione.");
                    event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAgendaDominyRoom).sendMessage(manutention.build()).queue();
                } catch (IndexOutOfBoundsException var4) {
                    PrintStream var10000 = System.out;
                    String var10001 = event.getGuild().getName();
                    var10000.println("problema con il comando manutenzione server su " + var10001 + " " + event.getChannel().getName());
                }
            } else if (args[0].equalsIgnoreCase(prefix + "manutenzione") && args[1].equalsIgnoreCase("server") && args[2].equalsIgnoreCase("tempo")) {
                if (!Helpers.isNumeric(args[3])) {
                    event.getChannel().sendMessage("Devi inserire il tempo in minuti.").queue();
                } else if (Helpers.isNumeric(args[3])) {
                    manutention = (new EmbedBuilder()).setColor(16711680).setTitle("UNDER MAINTENANCE").setThumbnail("https://i.postimg.cc/Xq5VZPMx/Cattura.png").setDescription("Il server è attualmente in Manutenzione. \n Tornerà online tra " + args[3] + " minuti!");
                    event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAgendaDominyRoom).sendMessage(manutention.build()).queue();
                }
            }

            if (args[0].equalsIgnoreCase(prefix + "server") && args[1].equalsIgnoreCase("online")) {
                manutention = (new EmbedBuilder()).setColor(Color.green).setTitle("Il server è ONLINE").setDescription("PREMETE F8 E INCOLLATE \n ```connect revenge-project.servegame.com:30120```");
                event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAgendaDominyRoom).sendMessage(manutention.build()).queue();
            }

            EmbedBuilder betaON;
            if (event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "beta online")) {
                betaON = (new EmbedBuilder()).setColor(Color.CYAN).setTitle("IL BETA SERVER è ONLINE!!").setDescription("PREMETE F8 E INCOLLATE \n ```connect revenge-project.servegame.com:30120```");
               // event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAgendaDominyRoom).sendMessage(betaON.build()).queue();
                event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAgendaDominyRoom).sendMessage(betaON.build()).queue();
                event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAgendaDominyRoom).sendMessage("<@everyone>").queue();
            }

            if (!bulkDelete && event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "bulk del on")) {
                event.getMessage().delete().queue();
                bulkDelete = true;
                event.getChannel().sendMessage("CMD ON").queue();
            } else if (bulkDelete && event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "bulk del off")) {
                event.getMessage().delete().queue();
                bulkDelete = false;
                event.getChannel().sendMessage("CMD OFF").queue();
            } else if (bulkDelete && event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "bulk del on")) {
                event.getMessage().delete().queue();
                bulkDelete = true;
                event.getChannel().sendMessage("CMD già attivo!").queue();
            } else if (!bulkDelete && event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "bulk del off")) {
                event.getMessage().delete().queue();
                bulkDelete = false;
                event.getChannel().sendMessage("CMD già disattivo!").queue();
            }

            if (bulkDelete && args[0].equalsIgnoreCase(prefix + "bulk") && args[1].equalsIgnoreCase("delete")) {
                List<Message> msg = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[2])).complete();
                event.getChannel().deleteMessages(msg).queue();
            } else if (!bulkDelete && args[0].equalsIgnoreCase(prefix + "bulk") && args[1].equalsIgnoreCase("delete")) {
                cmdDisabled = new EmbedBuilder() .setColor(Color.red).setTitle("Comando disattivato dal Developer");
                event.getChannel().sendMessage(cmdDisabled.build()).queue();
            }

            if (DominyOnOff && event.getMessage().getContentRaw().contains("383035474807095296") && !event.getAuthor().isBot()) {
                event.getChannel().sendMessage("Ciao, <@" + event.getAuthor().getId() + ">, Dominy è attualmente a lavoro, tornerà per le ore 15. Salvo il tuo messaggio!").queue();
                event.getJDA().getGuildById(botDiscordID).getTextChannelById("857557884003287111").sendMessage("<@383035474807095296>, ti ha cercato " + event.getAuthor().getName() + " e questo è il suo messaggio: ```" + event.getMessage().getContentRaw() + "```").queue();
            } else if (!DominyOnOff && event.getMessage().getContentRaw().contains("383035474807095296") && !event.getAuthor().isBot()) {
        //        System.out.println("cmd disattivo");
            }



/*            StringBuilder description = new StringBuilder();
            EmbedBuilder Kewai = new EmbedBuilder()
                    .setColor(Color.CYAN).setTitle("IL BETA SERVER è ONLINE!!").setDescription("PREMETE F8 E INCOLLATE \n ```connect revenge-project.servegame.com:30120```");
                    description.append("<@383035474807095296>");
            Kewai.setDescription(description.toString());
            if (event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "kappa online")) {
                Kewai.setDescription(description.toString());
                event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAgendaDominyRoom).sendMessage(Kewai.build()).queue();
            }*/
        }

    }
}
