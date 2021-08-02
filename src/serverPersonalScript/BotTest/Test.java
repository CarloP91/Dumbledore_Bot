package serverPersonalScript.BotTest;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static main.DumbledoreMain.botDiscordID;

public class Test extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);

        Guild guild = event.getGuild();

        if (guild.getId().equals(botDiscordID)) {
//            System.out.println(event.getMessage().getContentRaw());
            try {
//                System.out.println(event.getMessage().getAttachments().get(0).getUrl());
                event.getJDA().getGuildById(botDiscordID).getTextChannelById("856439286382985218").sendMessage(event.getMessage().getAttachments().get(0).getUrl()).queue();
            } catch (IndexOutOfBoundsException exception) {

            }

        }
    }
}
