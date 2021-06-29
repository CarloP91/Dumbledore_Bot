package generic;

import main.DumbledoreMain;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import serverList.StrangersLife.MainStrangersLife;

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

        if (event.getGuild().getId().equals(MainStrangersLife.strangerLifeID)) {
            if (event.getChannelJoined().getId().equals("778315319256940564")
                    || event.getChannelJoined().getId().equals("778315556180066327")
                    || event.getChannelJoined().getId().equals("778315655879327746")
                    || event.getChannelJoined().getId().equals("779003307107811338")
                    || event.getChannelJoined().getId().equals("779003647359057921")
                    || event.getChannelJoined().getId().equals("790223530783408158")
                    || event.getChannelJoined().getId().equals("790223750595477514")
                    || event.getChannelJoined().getId().equals("790223826054676501")
                    || event.getChannelJoined().getId().equals("790223788885278760")
                    || event.getChannelJoined().getId().equals("790223882702553088")) {
                event.getGuild().getTextChannelById(MainStrangersLife.logWhitelist)
                        .sendMessage(" <@" + event.getMember().getId() + "> è entrato nella stanza <#" + event.getChannelJoined().getId() + ">").queue();
            }
        }

    }

    @Override
    public void onGuildVoiceLeave(@NotNull GuildVoiceLeaveEvent event) {
        super.onGuildVoiceLeave(event);
        if (event.getGuild().getId().equals("858674220628049920")) {
            event.getJDA().getGuildById("858674220628049920").getTextChannelById("859378215122239508")
                    .sendMessage("<@" + event.getMember().getId() + "> è uscito da <#" + event.getChannelLeft().getId() + ">")
                    .queue();
        }

            if (event.getGuild().getId().equals(MainStrangersLife.strangerLifeID)) {
                if (event.getChannelLeft().getId().equals("778315319256940564")
                        || event.getChannelJoined().getId().equals("778315556180066327")
                        || event.getChannelJoined().getId().equals("778315655879327746")
                        || event.getChannelJoined().getId().equals("779003307107811338")
                        || event.getChannelJoined().getId().equals("779003647359057921")
                        || event.getChannelJoined().getId().equals("790223530783408158")
                        || event.getChannelJoined().getId().equals("790223750595477514")
                        || event.getChannelJoined().getId().equals("790223826054676501")
                        || event.getChannelJoined().getId().equals("790223788885278760")
                        || event.getChannelJoined().getId().equals("790223882702553088")) {
                    event.getGuild().getTextChannelById(MainStrangersLife.logWhitelist)
                            .sendMessage("<@" + event.getMember().getId() + "> è uscito da <#" + event.getChannelLeft().getId() + ">")
                            .queue();

                }
            }
        }


        /*if (event.getGuild().getId().equals(MainStrangersLife.strangerLifeID)) {

            event.getGuild().getTextChannelById(MainStrangersLife.logWhitelist)
                    .sendMessage(" <@" + event.getMember().getId() + "> è uscito dalla stanza <#" + event.getChannelLeft().getId() + ">").queue();
        }*/


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

        if (event.getGuild().getId().equals(MainStrangersLife.strangerLifeID)) {
            if (event.getChannelJoined().getId().equals("778315319256940564")
                    || event.getChannelJoined().getId().equals("778315556180066327")
                    || event.getChannelJoined().getId().equals("778315655879327746")
                    || event.getChannelJoined().getId().equals("779003307107811338")
                    || event.getChannelJoined().getId().equals("779003647359057921")
                    || event.getChannelJoined().getId().equals("790223530783408158")
                    || event.getChannelJoined().getId().equals("790223750595477514")
                    || event.getChannelJoined().getId().equals("790223826054676501")
                    || event.getChannelJoined().getId().equals("790223788885278760")
                    || event.getChannelJoined().getId().equals("790223882702553088")) {
                event.getGuild().getTextChannelById(MainStrangersLife.logWhitelist)
                        .sendMessage
                                ("<@" + event.getMember().getId()
                                        + "> è uscito da <#" + event.getOldValue().getId() + "> ed è entrato in <#" + event.getNewValue().getId() + ">")
                        .queue();


            }
        }
    }
}