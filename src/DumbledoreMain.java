import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import javax.security.auth.login.LoginException;

public class DumbledoreMain {

    public static String prefix = "~";

    public static void main(String[] args) throws LoginException {
        // createLight disables unused cache flags
        // GUILD_MESSAGES enables events for messages sent in guilds
        // GUILD_MEMBERS gives you access to guild member join events so you can send welcome messages
        // The resulting JDA instance will not cache any members since createLight disables it.

        JDABuilder.createLight("ODQ3MDI5OTMwODcyOTMwMzM0.YK4IGA.B_480wsxsFHinVnqhyrl8WnBbCc", GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS)
                .setStatus(OnlineStatus.IDLE)
                .setActivity(Activity.playing("a fare dei Test"))
                .addEventListeners(new GuildMemberJoin())
                .addEventListeners(new GuildMemberRemove())
                .addEventListeners(new Commands())
                .build();
    }
}
