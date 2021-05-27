import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberJoin extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event){

        String message = event.getGuild().getName() + "si è unito al server.. Mi spiace per lui.." + "(" + event.getGuild().getMembers() + "users)"
                + "\n ID: " + event.getGuild().getId() + ", Proprietario: " + event.getGuild().getOwner().getAsMention();



        /* String[] messages = {
                "Benvenuto [member], sei nel canale sbagliato!",
                "Ciao [member]!"
        };

        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0x66d8ff);
        join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));

        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue(); è questo che non funge*/


    }

    /*@Override
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
