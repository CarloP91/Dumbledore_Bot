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
import serverPersonalScript.AmbulanceStangersLife.*;
import serverPersonalScript.BalbettanteBamboccionaBandaDiBabbuini.*;
import serverPersonalScript.BotTest.*;
import serverPersonalScript.GovernoPoliziaSceriffi.ComunicationDatabase;
import serverPersonalScript.RevProj.*;

import javax.security.auth.login.LoginException;

public class DumbledoreMain {

    public static String prefix = "d-";
    public static String dumbledoreID = "847029930872930334"; // BOT ID
    public static String botVersion = "1.99.80-rpc";
    public static String botDiscordID = "856439285879144468";


    public static void main(String[] args) throws LoginException {

        JDABuilder.createLight("ODQ3MDI5OTMwODcyOTMwMzM0.YK4IGA.ajDUVYNaJa0ZvZ5ov3zxpRjT6co", GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_WEBHOOKS, GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.DIRECT_MESSAGE_REACTIONS)
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
                .addEventListeners(new Test())

                .addEventListeners(new GenericMessageReceived())
                .addEventListeners(new UpdateRole())
                .addEventListeners(new GuildMemberRoleManager())
                .addEventListeners(new FilterWord())
//                .addEventListeners(new VoiceDetector())
       //         .addEventListeners(new GenericMsgCheckDb())
       //         .addEventListeners(new GenericDeleteCheckDb())

                //REVENGE PROJECT
/*                .addEventListeners(new RevProjGuildJoined())
                .addEventListeners(new RevProjGestioneRole())*/
                .addEventListeners(new RevProjPersonalCMD())
                .addEventListeners(new RevProjPersScript())
                .addEventListeners(new RevProjGuildJoined())
                .addEventListeners(new AssistenzaReactionScript())


                // BalbettanteBamboccionaBandaDiBabbuini
                .addEventListeners(new BBBDBMessageReceived())


                // AMBULANCE STRANGER'S LIFE
                .addEventListeners(new AmbulanceCommands())
                .addEventListeners(new AmbMessageReceived())
/*
                .addEventListeners(new AmbRoleManagerScript())
*/

/*                // STRANGER'S LIFE
                .addEventListeners(new SLMessageReceived())
                .addEventListeners(new SLMessageDeleted())
                .addEventListeners(new SLGestioneRuoli())*/

                //GOVERNO-POLIZIA-SCERIFFI
               .addEventListeners(new ComunicationDatabase())
    //            .addEventListeners(new GovernRoleManagerScript())
//                .addEventListeners(new PersonalGovernoScript())

                .build();
    }
}
