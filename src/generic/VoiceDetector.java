package generic;

import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import serverList.StrangersLife.MainStrangersLife;

import java.awt.*;

public class VoiceDetector extends ListenerAdapter {



    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
        super.onGuildVoiceJoin(event);

        EmbedBuilder voiceDetectJoin = new EmbedBuilder()
                .setColor(Color.yellow)
                .setDescription("<@" + event.getMember().getId() + "> è entrato in <#" + event.getChannelJoined().getId() + ">");


        if (event.getGuild().getId().equals("858674220628049920")) {
            event.getJDA().getGuildById("858674220628049920").getTextChannelById("859378215122239508")
                    .sendMessage("<@" + event.getMember().getId() + "> è entrato in <#" + event.getChannelJoined().getId() + ">").queue();

            event.getJDA().getGuildById(DumbledoreMain.botDiscordID).getTextChannelById("859384555893948476")
                    .sendMessage(voiceDetectJoin.build()).queue();

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
                        .sendMessage(voiceDetectJoin.build()).queue();
            }
        }

    }

    @Override
    public void onGuildVoiceLeave(@NotNull GuildVoiceLeaveEvent event) {
        super.onGuildVoiceLeave(event);

        EmbedBuilder voiceDetectLeft = new EmbedBuilder()
                .setColor(Color.yellow)
                .setDescription("<@" + event.getMember().getId() + "> è uscito da <#" + event.getChannelLeft().getId() + ">");

        if (event.getGuild().getId().equals("858674220628049920")) {
            event.getJDA().getGuildById("858674220628049920").getTextChannelById("859378215122239508")
                    .sendMessage(voiceDetectLeft.build())
                    .queue();
        }

            if (event.getGuild().getId().equals(MainStrangersLife.strangerLifeID)) {
                if (event.getChannelLeft().getId().equals("778315319256940564")
                        || event.getChannelLeft().getId().equals("778315556180066327")
                        || event.getChannelLeft().getId().equals("778315655879327746")
                        || event.getChannelLeft().getId().equals("779003307107811338")
                        || event.getChannelLeft().getId().equals("779003647359057921")
                        || event.getChannelLeft().getId().equals("790223530783408158")
                        || event.getChannelLeft().getId().equals("790223750595477514")
                        || event.getChannelLeft().getId().equals("790223826054676501")
                        || event.getChannelLeft().getId().equals("790223788885278760")
                        || event.getChannelLeft().getId().equals("790223882702553088")) {
                    event.getGuild().getTextChannelById(MainStrangersLife.logWhitelist)
                            .sendMessage(voiceDetectLeft.build())
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

        EmbedBuilder voiceDetectMove = new EmbedBuilder()
                .setColor(Color.yellow)
                .setDescription("<@" + event.getMember().getId() + "> è uscito da <#" + event.getOldValue().getId() + "> ed è entrato in <#" + event.getNewValue().getId() + ">");

        if (event.getGuild().getId().equals("858674220628049920")) {

            event.getJDA().getGuildById("858674220628049920").getTextChannelById("859378215122239508")
                    .sendMessage(voiceDetectMove.build())
                    .queue();

            event.getJDA().getGuildById(DumbledoreMain.botDiscordID).getTextChannelById("859384555893948476")
                    .sendMessage
                            (voiceDetectMove.build())
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
                                (voiceDetectMove.build())
                        .queue();


            }
        }
    }
}