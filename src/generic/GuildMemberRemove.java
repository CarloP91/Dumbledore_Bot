package generic;

import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberRemove extends ListenerAdapter {

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
/*
        String[] messages = {
                "[member], ha lasciato il Discord!",
                "Ciao [member], ha lasciato il Discordia!"
        };

        Random rand = new Random();
        int number = rand.nextInt(messages.length);
        EmbedBuilder leave = new EmbedBuilder();
        leave.setColor(0x66d8ff);
        User user = event.getUser(); // Get the user that left
        leave.setDescription(messages[number].replace("[member]", user.getName()));
        event.getGuild().getDefaultChannel().sendMessage(leave.build()).queue();
*/
    }
}