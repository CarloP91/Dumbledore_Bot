package serverPersonalScript.GovernoPoliziaSceriffi;

import main.DumbledoreMain;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.emote.EmoteAddedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GenericGuildMessageReactionEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import utility.Utility;

import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static main.DumbledoreMain.*;
import static serverPersonalScript.GovernoPoliziaSceriffi.MainDatabaseInfo.*;

public class PersonalGovernoScript extends ListenerAdapter {

    @Override
    public void onGenericGuildMessageReaction(@NotNull GenericGuildMessageReactionEvent event) {
        super.onGenericGuildMessageReaction(event);

        if (event.getGuild().getId().equals(governoID)
                && event.getChannel().getId().equals(govAssegnazioneCaso)
                && !event.getUser().getId().equals(dumbledoreID)
                && event.getReactionEmote().getName().equals("\uD83D\uDCD9")) { //caso
            System.out.println("sto funzionando - listener reaction");
//            String txtCHName = event.getMember().getNickname();
            String txtCHName = "richiesta-apertura-caso-" + event.getUser().getName();
            try {
                event.getChannel().sendMessage("L'apertura di un caso è soggetta all'autorizzazione del <@&867725245145415681>.").queue();

                long userId = event.getUser().getIdLong();
                long allow = Permission.VIEW_CHANNEL.getRawValue() | Permission.MESSAGE_WRITE.getRawValue();
                long deny = Permission.MANAGE_CHANNEL.getRawValue();

                event.getGuild().getCategoryById(govCATGestioneGoverno).createTextChannel(txtCHName)
                        .addMemberPermissionOverride(userId, allow, deny)
                        .queue(channel -> {
                            event.getChannel().sendMessage("E' stata mandata una notifica e aperto il canale di contatto <#" + channel.getId() +">. Esponi le motivazioni e le prove per aprire il caso").queue();
                            event.getJDA().getGuildById(governoID).getTextChannelById(channel.getId()).sendMessage("<@&866610818631991306>, <@&866611057204396033> e <@&867725245145415681>, è stata richiesta l'apertura di un caso da <@" + event.getUser().getId() + ">.").queue();

                        });

//               System.out.println(event.getGuild().getTextChannelsByName(txtCHName, false));
//               System.out.println(Utility.getChannelListNameID(channelList));
            } catch (IndexOutOfBoundsException exception) {

                System.out.println("non funziono govcaso" + exception);
            }

        } else if (event.getGuild().getId().equals(governoID)
                && event.getChannel().getId().equals(govAssegnazioneCaso)
                && !event.getUser().getId().equals(dumbledoreID)
                && event.getReactionEmote().getName().equals("\uD83D\uDCD7")) { //indagine
            System.out.println("sto funzionando - listener reaction");
//            String txtCHName = event.getMember().getNickname();
            String txtCHName = "indagine personale " + event.getUser().getName();
            try {

                long userId = event.getUser().getIdLong();
                long allow = Permission.ALL_CHANNEL_PERMISSIONS;
                long deny = Permission.NICKNAME_CHANGE.getRawValue();

                event.getGuild().getCategoryById(govCATPoliziaFederale).createTextChannel(txtCHName)
                        .addMemberPermissionOverride(userId, allow, deny)
                        .queue(channel -> {
                            event.getChannel().sendMessage("Agente <@" + event.getUser().getId() + "> è stato aperto il canale personale" + "<#" + channel.getId() +">. Qui potrai lasciare traccia dei tuoi appunti, rapporti, e prove.").queue();
                            event.getJDA().getGuildById(governoID).getTextChannelById(channel.getId()).sendMessage("Agente <@" + event.getUser().getId() + ">, ti consiglio di essere il più dettagliato possibile nell'indagine, cosi da poter aprire un caso federale.").queue();
                        });

            } catch (IndexOutOfBoundsException exception) {

                System.out.println("non funziono govindagine" + exception);
            }

        }else if (event.getGuild().getId().equals(governoID)
                && event.getChannel().getId().equals(govAssegnazioneCaso)
                && !event.getUser().getId().equals(dumbledoreID)
                && event.getReactionEmote().getName().equals("\uD83D\uDCD8")) { //rapporto
            System.out.println("sto funzionando - listener reaction");
//            String txtCHName = event.getMember().getNickname();
            String txtCHName = "rapporto personale " + event.getUser().getName();
            try {

                long userId = event.getUser().getIdLong();
                long allow = Permission.ALL_CHANNEL_PERMISSIONS;
                long deny = Permission.NICKNAME_CHANGE.getRawValue();

                event.getGuild().getCategoryById(govCATPoliziaFederale).createTextChannel(txtCHName)
                        .addMemberPermissionOverride(userId, allow, deny)
                        .queue(channel -> {
                            event.getChannel().sendMessage("Agente <@" + event.getUser().getId() + "> è stato aperto il canale personale" + "<#" + channel.getId() +">. Qui potrai scrivere un rapporto personale.").queue();
                            event.getJDA().getGuildById(governoID).getTextChannelById(channel.getId()).sendMessage("Agente <@" + event.getUser().getId() + ">, ti consiglio di essere il più dettagliato possibile nel rapporto, cosi da rendere chiara la lettura.").queue();
                        });

            } catch (IndexOutOfBoundsException exception) {

                System.out.println("non funziono" + exception);
            }
        }
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);
        String[] args = event.getMessage().getContentRaw().split("\\s+");

/*        if (event.getChannel().getId().equals(govAssegnazioneCaso)
                && event.getAuthor().getId().equals(dumbledoreID)){ //da togliere dopo l'inizializzazione

            event.getMessage().addReaction("\uD83D\uDCD9").complete();
            event.getMessage().addReaction("\uD83D\uDCD7").complete();
            event.getMessage().addReaction("\uD83D\uDCD8").complete();

        }*/

        if (event.getChannel().getId().equals(govAssegnazioneCaso)
                && args[0].equalsIgnoreCase(prefix + "xyz")){

            event.getChannel().sendMessage(
                    "Cliccare su \uD83D\uDCD9 per aprire un nuovo caso \n" +
                            "Cliccare su \uD83D\uDCD7 per aprire una nuova indagine \n" +
                            "Cliccare su \uD83D\uDCD8 per compilare un rapporto personale \n").queue();

        }
    }
}
