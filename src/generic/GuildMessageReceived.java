package generic;

import main.DumbledoreMain;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import serverList.BalbettanteBamboccionaBandaDiBabbuini.MainBBBdB;
import utility.Utility;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class GuildMessageReceived extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateTimeFormatter itafmt = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        String Ciccina = "720912809206218776";

        //CONTROLLO PER 2 BOT SENZA ID
        if (event.getChannel().getId().equals("839615144107048961")) {
            // System.out.println("è il bot di K che rompe e quindi non faccio nulla");
        } else if (event.getGuild().getId().equals("572807400902492161")) {

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

            } else if (event.getGuild().getId().equals(MainBBBdB.dBbbdbID)) {
                TextChannel textChannel = event.getGuild().getTextChannelById("851440485721178184");
                textChannel.sendMessage("<@" + event.getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw() + " in <#" + event.getChannel().getId() + "> \n || **ID MESSAGGIO:** " + event.getMessageId() + "||").queue();

            } /*else if (event.getMessage().getContentRaw().contains("383035474807095296")) {
                TextChannel textChannel = event.getGuild().getTextChannelById("851440485721178184");
                textChannel.sendMessage("<@" + event.getMember().getId() + "> ha scritto: " + event.getMessage().getContentRaw() + " in <#" + event.getChannel().getId() + ">").queue();
            }*/ else {

                List<Role> roleList = event.getGuild().getRoles();


                        //  event.getGuild().getTextChannelById("851440485721178184").sendMessage("Sono nell'else del MessageReceived per: " + event.getGuild().getName() + " " + event.getMember().getEffectiveName() + " " + event.getMessage().getContentRaw() + " in " + event.getChannel().getName()).queue();
                      System.out.println("Sono nell'else del MessageReceived per: "
                                + event.getGuild().getName()
                                + " "
                                + event.getMember().getEffectiveName()
                                + " "
                                + event.getMessage().getContentRaw()
                                + " in " + event.getChannel().getName());
                      System.out.println(Utility.getRoleAsStringToPrint(event.getMember().getRoles()) + ".");
                     /* System.out.println(event.getMember().getRoles().toString()
                              .replace("[", "")
                              .replace("R:Direttore(839071738654359572)", "Direttore")
                              .replace("R:➖\uD83D\uDCBC STATUS \uD83D\uDCBC➖(839073494707994626)", "-STATUS-")
                              .replace("]", "")
                              .replace("R:MOD DI STRANGER(839072092996501504)", "MOD DI STRANGER")
                              .replace("R:Elicotterista(839117976498208852)", "Elicotterista")
                              .replace("R:Discord Manager(839114549864300584)", "Discord Manager"));*/
                      System.out.println(event.getAuthor().getTimeCreated().format(itafmt));
                }
            }
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("!ping"))
        {
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage("Pong!") /* => RestAction<Message> */
                    .queue(response /* => Message */ -> {
                        response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
                    });
        }
    }
        }
