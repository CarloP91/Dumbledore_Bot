package generic;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Random;

public class GuildMemberJoin extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event){

        String[] messages = {
                "Benvenuto [member], sei nel canale sbagliato!",
                "Ciao [member]!"
        };

        Random rand = new Random();
        int number = rand.nextInt(messages.length);
        Guild guild = event.getGuild();
        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0x66d8ff);
        join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));
        guild.getDefaultChannel().sendMessage(join.build()).queue();
        guild.getTextChannelById("847034315342086144").sendMessage(join.build()).queue();

        // Aggiunge Ruolo all'utente che ha joinato (metodo default)
        Member member = event.getMember();
//        Role role = event.getGuild().getRoleById("847121910096723979");
//        guild.addRoleToMember(member, role).complete();

        if (member.getId().equals("345186120683749378")) /*Crowley*/ {
            Role role2 = guild.getRoleById("739464748948652114");
            guild.addRoleToMember(member, role2).complete();
        }
    }

    /*
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) {
            return;
        }
        System.out.println(event.getMessage().getContentRaw());
        System.out.println(event.getAuthor());

        String user = event.getAuthor().getName();

        String[] messages = {
            "Benvenuto " + user + ", sei nel canale sbagliato!",
            "Ciao " + user + "!"
        };

        List<Role> roles;
        roles = event.getGuild().getRoles();
        System.out.println(roles);

        Random rand = new Random();
        int number = rand.nextInt(messages.length);
        event.getChannel().sendMessage(messages[number]).queue();
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Guild guild = event.getGuild(); // Get the guild that the user joined.
        User user = event.getUser();    // Get the user that joined.
        JDA client = event.getJDA();    // Get the already existing JDA instance.
        Member member = guild.getMemberById(user.getId()); // Convert user to Member.
        System.out.println("User " + user.getName() + " has joined the guild!");
        Role role = guild.getRoleById("847121910096723979"); // Set role to assign.
        guild.addRoleToMember(member, role).queue();

        List<TextChannel> channels = guild.getTextChannelsByName("generale", false); // Get the list of channels in the guild that matches that name.

        for (TextChannel channel : channels) { // Loops through the channels and sends a message to each one.
            channel.sendMessage("New member joined: " + user).queue();
        }
    }*/
}
