package all;

import main.DumbledoreMain;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import serverList.BBBdB;

import java.util.List;

public class GuildMessageReceived extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String Ciccina = "720912809206218776";

        //CONTROLLO PER 2 BOT SENZA ID
        if (event.getChannel().getId().equals("839615144107048961")) {
            // System.out.println("è il bot di K che rompe e quindi non faccio nulla");
        } else {

            if (event.getMessage().getMember().getId().equals(Ciccina)) {
                //  System.out.println(event.getMessage().getMember());
                event.getMessage().addReaction("\uD83D\uDC96").queue();
            } else {
                event.getMember().getId().equalsIgnoreCase("");
            }

            //PER OGNI MESSAGGIO SCRITTO in Balbettante bambocciona banda di babbuini
            if (event.getMessage().getMember().getId().equals(DumbledoreMain.dumbledore)) {

                //   System.out.println(event.getMessage().getAuthor().getName() + " ha scritto: " + event.getMessage().getContentRaw());

            } else if (event.getGuild().getId().equals(BBBdB.dBbbdbID)) {
                TextChannel textChannel = event.getGuild().getTextChannelById("851440485721178184");
                textChannel.sendMessage("<@" + event.getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw() + " in <#" + event.getChannel().getId() + ">").queue();

            } else if (event.getMessage().getContentRaw().contains("383035474807095296")) {
                TextChannel textChannel = event.getGuild().getTextChannelById("851440485721178184");
                textChannel.sendMessage("<@" + event.getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw() + " in <#" + event.getChannel().getId() + ">").queue();
            } else {

                List<Role> roleList = event.getGuild().getRoles();


                        //  event.getGuild().getTextChannelById("851440485721178184").sendMessage("Sono nell'else del MessageReceived per: " + event.getGuild().getName() + " " + event.getMember().getEffectiveName() + " " + event.getMessage().getContentRaw() + " in " + event.getChannel().getName()).queue();
                      System.out.println("Sono nell'else del MessageReceived per: "
                                + event.getGuild().getName()
                                + " "
                                + event.getMember().getEffectiveName()
                                + " "
                                + event.getMessage().getContentRaw()
                                + " in " + event.getChannel().getName());
                      System.out.println(event.getMember().getRoles());
                      System.out.println(event.getAuthor().getTimeCreated());

                }
            }
        }
    }
