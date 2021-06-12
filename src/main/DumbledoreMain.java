package main;

import all.*;
import commands.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import javax.swing.text.DefaultFormatterFactory;

public class DumbledoreMain {

    public static String prefix = "d-";
    public static String dumbledore = "847029930872930334"; // BOT ID

    public static void main(String[] args) throws LoginException {

        // createLight disables unused cache flags
        // GUILD_MESSAGES enables events for messages sent in guilds
        // GUILD_MEMBERS gives you access to guild member join events so you can send welcome messages
        // The resulting JDA instance will not cache any members since createLight disables it.

        JDABuilder.createLight("ODQ3MDI5OTMwODcyOTMwMzM0.YK4IGA.ajDUVYNaJa0ZvZ5ov3zxpRjT6co", GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_VOICE_STATES)
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.playing("a fare dei Test"))
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .setChunkingFilter(ChunkingFilter.ALL) // enable member chunking for all guilds
                .setMemberCachePolicy(MemberCachePolicy.ALL) // ignored if chunking enabled
                .enableCache(CacheFlag.VOICE_STATE)
                .addEventListeners(new GuildMemberJoin())
                .addEventListeners(new GuildMemberRemove())
                .addEventListeners(new Commands())
                .addEventListeners(new AmbulanceCommands())
                .addEventListeners(new GuildMessageReceived())
                .addEventListeners(new GuildVoiceJoin())
                .addEventListeners(new GuildVoiceLeave())
                .addEventListeners(new GuildVoiceMove())
                .build();
    }
}
