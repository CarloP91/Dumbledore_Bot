package main;

import generic.*;
import commands.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import serverList.AmbulanceStangersLife.AmbMessageReceived;
import serverList.BalbettanteBamboccionaBandaDiBabbuini.BBBDBMessageReceived;
import serverList.LosSantosPoliceDepartment.LSPDMessageReceived;
import serverList.MercatoNero.MNMessageReceived;
import serverList.StrangersLife.SLGestioneRuoli;
import serverList.StrangersLife.SLMessageDeleted;
import serverList.StrangersLife.SLMessageReceived;

import javax.security.auth.login.LoginException;

public class DumbledoreMain {

    public static String prefix = "d-";
    public static String dumbledoreID = "847029930872930334"; // BOT ID
    public static String botVersion = "1.50";


    public static void main(String[] args) throws LoginException {

        // createLight disables unused cache flags
        // GUILD_MESSAGES enables events for messages sent in guilds
        // GUILD_MEMBERS gives you access to guild member join events so you can send welcome messages
        // The resulting JDA instance will not cache any members since createLight disables it.

        JDABuilder.createLight("ODQ3MDI5OTMwODcyOTMwMzM0.YK4IGA.ajDUVYNaJa0ZvZ5ov3zxpRjT6co", GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_WEBHOOKS)
                .setStatus(OnlineStatus.ONLINE)
        //        .setActivity(Activity.playing("d-help"))
                .setActivity(Activity.watching("d-help"))
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .setChunkingFilter(ChunkingFilter.ALL) // enable member chunking for all guilds
                .setMemberCachePolicy(MemberCachePolicy.ALL) // ignored if chunking enabled
                .enableCache(CacheFlag.VOICE_STATE)

                .addEventListeners(new GuildMemberJoin())
                .addEventListeners(new Commands())

                .addEventListeners(new GenericMessageReceived())
                .addEventListeners(new GuildVoiceJoin())
                .addEventListeners(new GuildVoiceLeave())
                .addEventListeners(new GuildVoiceMove())
                .addEventListeners(new UpdateRole())
                .addEventListeners(new GuildMessageDeleteEvent())
                .addEventListeners(new GuildMemberRoleManager())

                // BalbettanteBamboccionaBandaDiBabbuini
                .addEventListeners(new BBBDBMessageReceived())


                // AMBULANCE STRANGER'S LIFE
                .addEventListeners(new AmbulanceCommands())
                .addEventListeners(new AmbMessageReceived())

                // STRANGER'S LIFE
                .addEventListeners(new SLMessageReceived())
                .addEventListeners(new SLMessageDeleted())
                .addEventListeners(new SLGestioneRuoli())

                //LSPD
                .addEventListeners(new LSPDMessageReceived())

                //MERCATO NERO
                .addEventListeners(new MNMessageReceived())


                .build();
    }
}
