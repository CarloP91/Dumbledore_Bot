package generic;

import main.DumbledoreMain;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class VoiceDetector extends ListenerAdapter {

    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
        super.onGuildVoiceJoin(event);

        if (event.getGuild().getId().equals("858674220628049920")) {
            event.getJDA().getGuildById("858674220628049920").getTextChannelById("859378215122239508")
                    .sendMessage("<@" + event.getMember().getId() + "> è entrato in <#" + event.getChannelJoined().getId() + ">").queue();

            event.getJDA().getGuildById(DumbledoreMain.botDiscordID).getTextChannelById("859384555893948476")
                    .sendMessage("<@" + event.getMember().getId() + "> è entrato in <#" + event.getChannelJoined().getId() + ">").queue();

        }

    }

    @Override
    public void onGuildVoiceLeave(@NotNull GuildVoiceLeaveEvent event) {
        super.onGuildVoiceLeave(event);
        if (event.getGuild().getId().equals("858674220628049920")) {
            event.getJDA().getGuildById("858674220628049920").getTextChannelById("859378215122239508")
                    .sendMessage("<@" + event.getMember().getId() + "> è uscito da <#" + event.getChannelLeft().getId() + ">")
                    .queue();

            event.getJDA().getGuildById(DumbledoreMain.botDiscordID).getTextChannelById("859384555893948476")
                    .sendMessage("<@" + event.getMember().getId() + "> è uscito da <#" + event.getChannelLeft().getId() + ">")
                    .queue();

        }

    }

    @Override
    public void onGuildVoiceMove(@NotNull GuildVoiceMoveEvent event) {
        super.onGuildVoiceMove(event);

        if (event.getGuild().getId().equals("858674220628049920")) {

            event.getJDA().getGuildById("858674220628049920").getTextChannelById("859378215122239508")
                    .sendMessage
                            ("<@" + event.getMember().getId()
                                    + "> è uscito da <#" + event.getOldValue().getId() + "> ed è entroto in <#" + event.getNewValue().getId() + ">")
                    .queue();

            event.getJDA().getGuildById(DumbledoreMain.botDiscordID).getTextChannelById("859384555893948476")
                    .sendMessage
                            ("<@" + event.getMember().getId()
                                    + "> è uscito da <#" + event.getOldValue().getId() + "> ed è entroto in <#" + event.getNewValue().getId() + ">")
                    .queue();
        }
    }
}