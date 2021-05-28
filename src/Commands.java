import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.channel.voice.update.VoiceChannelUpdatePositionEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.List;

public class Commands extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "info")) {

            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Dumbledore Bot dice:");
            info.addField("Creatore", "Dominy", false);
            info.setDescription("Check Box [member]");
            info.setColor(0xffffff);
            info.clear();
            // event.getChannel().sendMessage("Messaggio di prova").queue();
        }

        if (args[0].equalsIgnoreCase("who")) {
            Guild guild = event.getGuild();
            List<Role> roleList = guild.getRoles();
            List<Member> membersList = guild.getMembers();
            List<Role> memberRoles;

            for (Role r : roleList) {
                if (event.getMessage().toString().contains("@" + r.getName())) {
                    for (Member member : membersList) {
                        memberRoles = member.getRoles();
                        for (Role m_role : memberRoles) {
                            if (m_role.equals(r)) {
                                event.getChannel().sendMessage("Ruolo: " + "<@&" + r.getId() + ">" + " - Utente: " + "<@" + member.getUser().getId() + ">").queue();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onVoiceChannelUpdatePosition(VoiceChannelUpdatePositionEvent positionEvent) {
        System.out.println(positionEvent.getChannel());
    }
}

