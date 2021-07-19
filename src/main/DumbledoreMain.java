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
import serverPersonalScript.AmbulanceStangersLife.AmbMessageReceived;
import serverPersonalScript.AmbulanceStangersLife.AmbRoleManagerScript;
import serverPersonalScript.AmbulanceStangersLife.AmbulanceCommands;
import serverPersonalScript.BalbettanteBamboccionaBandaDiBabbuini.BBBDBMessageReceived;
import serverPersonalScript.GovernoPoliziaSceriffi.ComunicationDatabase;
import serverPersonalScript.GovernoPoliziaSceriffi.GovernRoleManagerScript;
import serverPersonalScript.StrangersLife.SLGestioneRuoli;
import serverPersonalScript.StrangersLife.SLMessageDeleted;
import serverPersonalScript.StrangersLife.SLMessageReceived;

import javax.security.auth.login.LoginException;

public class DumbledoreMain {

    public static String prefix = "d-";
    public static String dumbledoreID = "847029930872930334"; // BOT ID
    public static String botVersion = "1.99.36-sc";
    public static String botDiscordID = "856439285879144468";


    public static void main(String[] args) throws LoginException {

        // createLight disables unused cache flags
        // GUILD_MESSAGES enables events for messages sent in guilds
        // GUILD_MEMBERS gives you access to guild member join events so you can send welcome messages
        // The resulting JDA instance will not cache any members since createLight disables it.

        JDABuilder.createLight("ODQ3MDI5OTMwODcyOTMwMzM0.YK4IGA.ajDUVYNaJa0ZvZ5ov3zxpRjT6co", GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_WEBHOOKS)
                .setStatus(OnlineStatus.ONLINE)
                //        .setActivity(Activity.playing("d-help"))
                .setActivity(Activity.listening("d-help"))
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .setChunkingFilter(ChunkingFilter.ALL) // enable member chunking for all guilds
                .setMemberCachePolicy(MemberCachePolicy.ALL) // ignored if chunking enabled
                .enableCache(CacheFlag.VOICE_STATE)

                .addEventListeners(new GuildMemberJoin())
                .addEventListeners(new AdminCommands())
                .addEventListeners(new PublicCommands())

                .addEventListeners(new GenericMessageReceived())
                .addEventListeners(new UpdateRole())
                .addEventListeners(new GuildMemberRoleManager())
                .addEventListeners(new VoiceDetector())
                .addEventListeners(new GenericMsgCheckDb())
                .addEventListeners(new GenericDeleteCheckDb())

                // BalbettanteBamboccionaBandaDiBabbuini
                .addEventListeners(new BBBDBMessageReceived())


                // AMBULANCE STRANGER'S LIFE
                .addEventListeners(new AmbulanceCommands())
                .addEventListeners(new AmbMessageReceived())
                .addEventListeners(new AmbRoleManagerScript())

                // STRANGER'S LIFE
                .addEventListeners(new SLMessageReceived())
                .addEventListeners(new SLMessageDeleted())
                .addEventListeners(new SLGestioneRuoli())

                //GOVERNO-POLIZIA-SCERIFFI
                .addEventListeners(new ComunicationDatabase())
                .addEventListeners(new GovernRoleManagerScript())





                .build();
    }
}
