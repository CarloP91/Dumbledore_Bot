package serverPersonalScript.RevProj.DsCommunication;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import serverPersonalScript.RevProj.*;

import java.awt.*;

public class AnnunciCondivisi extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);


        if (event.getChannel().getId().equals(MainCommunication.govAnnunciCondivisi) && !event.getAuthor().isBot()){

            EmbedBuilder ebann = new EmbedBuilder()
                    .setColor(0x00e6e6)
                    .setTitle("ANNUNCIO GOVERNO \uD83E\uDD85")
                    .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());


            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage(ebann.build()).queue();
            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage("<@&874426404308152370>").queue();

        }

        if (event.getChannel().getId().equals(MainCommunication.armeria60AnnunciIC) && !event.getAuthor().isBot()) {

            EmbedBuilder armeria60 = new EmbedBuilder()
                    .setColor(Color.red)
                    .setTitle("ANNUNCIO ARMERIA 60 \uD83D\uDCA3")
                    .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage(armeria60.build()).queue();
            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage("<@&874426404308152370>").queue();
        }

        if (event.getChannel().getId().equals(MainCommunication.import19AnnunciIC) && !event.getAuthor().isBot()) {

            EmbedBuilder ebann = new EmbedBuilder()
                    .setColor(Color.green)
                    .setTitle("ANNUNCIO IMPORT 19 \uD83D\uDCE6")
                    .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage(ebann.build()).queue();
            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage("<@&874426404308152370>").queue();
        }

        if (event.getChannel().getId().equals(MainCommunication.craftBarAnnunciIC) && !event.getAuthor().isBot()) {

            EmbedBuilder ebann = new EmbedBuilder()
                    .setColor(Color.orange)
                    .setTitle("ANNUNCIO CRAFT BAR \uD83C\uDF7A")
                    .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage(ebann.build()).queue();
            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage("<@&874426404308152370>").queue();
        }

        if (event.getChannel().getId().equals(MainCommunication.bennysAnnunciIC) && !event.getAuthor().isBot()) {

            EmbedBuilder ebann = new EmbedBuilder()
                    .setColor(0xff751a)
                    .setTitle("ANNUNCIO BENNYS \uD83C\uDFCE")
                    .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage(ebann.build()).queue();
            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage("<@&874426404308152370>").queue();
        }

        if (event.getChannel().getId().equals(MainCommunication.usato519AnnunciIC) && !event.getAuthor().isBot()) {

            EmbedBuilder ebann = new EmbedBuilder()
                    .setColor(0x008ae6)
                    .setTitle("ANNUNCIO CONCESSIONARIO USATO 519 \uD83D\uDE97")
                    .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage(ebann.build()).queue();
            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage("<@&874426404308152370>").queue();
        }

        if (event.getChannel().getId().equals(MainCommunication.concessionarioLussoAnnunciIC) && !event.getAuthor().isBot()) {

            EmbedBuilder ebann = new EmbedBuilder()
                    .setColor(Color.magenta)
                    .setTitle("ANNUNCIO CONCESSIONARIO LUSSO 682  \uD83D\uDE98")
                    .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage(ebann.build()).queue();
            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage("<@&874426404308152370>").queue();
        }

        if (event.getChannel().getId().equals(MainCommunication.vespucciBeachAnnunciIC) && !event.getAuthor().isBot()) {

            EmbedBuilder ebann = new EmbedBuilder()
                    .setColor(0xff9933)
                    .setTitle("ANNUNCIO VESPUCCI BEACH  ☀️")
                    .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage(ebann.build()).queue();
            event.getJDA().getGuildById(MainRevengeProject.revengeProjectID).getTextChannelById(MainRevengeProject.rpAnnunciChatIC).sendMessage("<@&874426404308152370>").queue();
        }

    }
}
