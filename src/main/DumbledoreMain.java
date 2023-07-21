package main;

import commands.*;
import generic.*;
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
//import serverPersonalScript.RevProj.AssistenzaReactionScript;
import serverPersonalScript.RevProj.DsCommunication.AnnunciCondivisi;
import serverPersonalScript.RevProj.DsCommunication.DatabaseCondivisoRP;
import serverPersonalScript.RevProj.*;

import javax.security.auth.login.LoginException;

public class DumbledoreMain {

    public static String prefix = "d-";
    public static String dumbledoreID = "847029930872930334"; // BOT ID
    public static String botVersion = "1.99.98-rpcnew ";
    public static String botDiscordID = "856439285879144468";
    public static String dominyID = "383035474807095296";


    public static void main(String[] args) throws LoginException {

        JDABuilder.createLight("", GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_WEBHOOKS, GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.DIRECT_MESSAGE_REACTIONS)
                .setStatus(OnlineStatus.ONLINE)
//              .setActivity(Activity.playing("d-help"))
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
//                .addEventListeners(new UpdateRole())
                .addEventListeners(new GuildMemberRoleManager())
                .addEventListeners(new FilterWord())
//              .addEventListeners(new VoiceDetector())
//              .addEventListeners(new GenericMsgCheckDb())
//              .addEventListeners(new GenericDeleteCheckDb())

                //REVENGE PROJECT
/*              .addEventListeners(new RevProjGuildJoined())
                .addEventListeners(new RevProjGestioneRole())*/
                .addEventListeners(new RevProjPersonalCMD())
                .addEventListeners(new RevProjPersScript())
//                .addEventListeners(new RevProjGuildJoined())
//                .addEventListeners(new AssistenzaReactionScript())

                //DB CONDIVISO
                .addEventListeners(new AnnunciCondivisi())
                .addEventListeners(new DatabaseCondivisoRP())


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
                // .addEventListeners(new ComunicationDatabase())
//             .addEventListeners(new GovernRoleManagerScript())
//             .addEventListeners(new PersonalGovernoScript())

                .build();
    }
}
