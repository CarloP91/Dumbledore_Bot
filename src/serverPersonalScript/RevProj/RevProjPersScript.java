package serverPersonalScript.RevProj;

import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static generic.FilterWord.filterOn;
import static generic.PublicCommands.DominyOnOff;
import static serverPersonalScript.RevProj.MainRevengeProject.revengeProjectID;

public class RevProjPersScript extends ListenerAdapter {

    boolean assistInit = false;

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);

        if (event.getGuild().getId().equals(MainRevengeProject.revengeProjectID)) {

            if (filterOn == true && !event.getAuthor().isBot()) {
                String[] banWords = {"negro", "negri", "negr0", "negr1", "negr3", "nigga", "n1gga", "nigger", "n1gger", "n1gg3r", "nigg3r", "neggro", "n3ggro", "dio", "diocane", "diocan3", "d1ocan3", "d1ocane", "di0", "d10", "porc0dio", "porcamadonna", "puttana", "troia", "zoccola", "mignotta", "discord.gg", ".ru", "simp", "cs:go", "tradoffer", "nitroforyou", "steamcommunity"};
                String[] msg = event.getMessage().getContentRaw().split(" ");

                for (int i = 0; i < msg.length; i++) {
                    for (int j = 0; j < banWords.length; j++) {
                        if (msg[i].equalsIgnoreCase(banWords[j])) {
                            event.getMessage().delete().queue();
                            event.getChannel().sendMessage("Bad Word Detected! \n <@" + event.getAuthor().getId() + "> stai usando brutte parole. Ho cancellato il tuo messaggio. Continuando potresti prendere un Warn.").queue();
                            event.getJDA().getGuildById(revengeProjectID).getTextChannelById(MainRevengeProject.rpBadWordsRoom).sendMessage("<@&" + MainRevengeProject.rpAdminRole + "> <@" + event.getAuthor().getId() + "> sta usando brutte parole in <#" + event.getChannel().getId()  + ">. \n - Messaggio: " + event.getMessage().getContentRaw()).queue();

                        } else if (filterOn == false) {
                            //
                        }
                    }
                }
            }

            if (DominyOnOff == false) {
             //   System.out.println("CMD Dominy OFF");
            } else if (DominyOnOff) {
                if (event.getMessage().getContentRaw().contains("383035474807095296")
                        && !event.getAuthor().isBot()
                        && !event.getAuthor().getId().equals("323058900771536898")) {
                    event.getChannel().sendMessage("Ciao <@" + event.getAuthor().getId() + ">, <@383035474807095296> attualmente è a lavoro, tornerà per le ore 18.00. Salvo il tuo messaggio.").queue();
                }
            }

           if (event.getMessage().getContentRaw().equalsIgnoreCase(DumbledoreMain.prefix + "initAssistenza") && assistInit) {

                EmbedBuilder assist = new EmbedBuilder()
                        .setColor(Color.black)
                        .setTitle("RICHIESTA ASSISTENZA")
                        .setDescription(
                                "Prima di richiedere assistenza, sappi che se hai un problema tecnico dovrai prima aprire un <#874239816571711509> e spiegare la tua problematica. " +
                                        "Se la tua richiesta non è risolvibile tramite ticket allora verrai *invitato* in assistenza." + "\n \n" +

                                "Se hai un problema tecnico clicca su: \uD83D\uDD28. \n" +
                                "Se vuoi far valutare un'azione clicca su: \uD83C\uDD98. \n" +
                                "Se sei interessato ad un Pack Vip clicca su: \uD83C\uDF81. \n " +
                                "Se vuoi un Rimborso in Game (con clip) clicca su: \uD83D\uDCE6. \n" +
                                "Se la tua richiesta di assistenza non è sopra citata clicca qui: \uD83D\uDC8C"

                        );
              event.getChannel().sendMessage(assist.build()).queue();


            } else if (assistInit == false) {
             //  System.out.println("Comando assistInit disabilitato -> abilitare manualmente");
           }

            if (event.getChannel().getId().equalsIgnoreCase(MainRevengeProject.rpAssistenzaRoom)
                    && event.getAuthor().isBot() && assistInit) {
                event.getMessage().addReaction("\uD83D\uDD28").complete();
                event.getMessage().addReaction("\uD83C\uDD98").complete();
                event.getMessage().addReaction("\uD83C\uDF81").complete();
                event.getMessage().addReaction("\uD83D\uDCE6").complete();
                event.getMessage().addReaction("\uD83D\uDC8C").complete();
            }

        }
    }
}
