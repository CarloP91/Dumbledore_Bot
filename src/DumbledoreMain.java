import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import javax.security.auth.login.LoginException;

public class DumbledoreMain {

    public static String prefix = "~";

    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault("ODQ3MDI5OTMwODcyOTMwMzM0.YK4IGA.B_480wsxsFHinVnqhyrl8WnBbCc").build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("a fare dei Test"));
        jda.addEventListener(new Commands());
        jda.addEventListener(new GuildMemberJoin());
        jda.addEventListener(new GuildMemberRemove());
    }
}
