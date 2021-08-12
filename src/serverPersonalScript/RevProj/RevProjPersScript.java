package serverPersonalScript.RevProj;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static generic.FilterWord.filterOn;

public class RevProjPersScript extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);

        if (event.getGuild().getId().equals(MainRevengeProject.revengeProjectID)) {
            if (event.getGuild().getId().equals(MainRevengeProject.revengeProjectID)
                    && !event.getAuthor().getId().equals("323058900771536898")) {
            //

            }

            if (filterOn == true) {
                String[] banWords = {"negro", "negri", "negr0", "negr1", "negr3", "nigga", "n1gga", "nigger", "n1gger", "n1gg3r", "nigg3r", "neggro", "n3ggro", "dio", "diocane", "diocan3", "d1ocan3", "d1ocane", "porc0", "porc0dio", "porcamadonna", "puttana", "troia", "zoccola", "mignotta", "discord.gg", "3 months", ".ru", "discord nitro for free", "steam store", "simp"};
                String[] msg = event.getMessage().getContentRaw().split(" ");

                for (int i = 0; i < msg.length; i++) {
                    for (int j = 0; j < banWords.length; j++) {
                        if (msg[i].equalsIgnoreCase(banWords[j])) {
                            event.getMessage().delete().queue();
                            event.getChannel().sendMessage("Bad Word Detected! \n").queue();
                        } else if (filterOn == false) {
                            //
                        }
                    }
                }
            }
        }
    }
}
