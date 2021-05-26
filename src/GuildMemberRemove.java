import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Random;

public class GuildMemberRemove extends ListenerAdapter {

    String[] messages = {
            "[member], ha lasciato il Discord!",
            "Ciao [member], ha lasciato il Discordia!"
    };

    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        //Remove Role
        EmbedBuilder leave = new EmbedBuilder();
        leave.setColor(0x66d8ff);
        leave.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));
        event.getGuild().getDefaultChannel().sendMessage(leave.build()).queue();
    }

}