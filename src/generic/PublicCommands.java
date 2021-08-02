    package generic;

    import db.DbCredentials;
    import main.DumbledoreMain;
    import net.dv8tion.jda.api.EmbedBuilder;
    import net.dv8tion.jda.api.entities.Guild;
    import net.dv8tion.jda.api.entities.Member;
    import net.dv8tion.jda.api.entities.Message;
    import net.dv8tion.jda.api.entities.Role;
    import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
    import net.dv8tion.jda.api.hooks.ListenerAdapter;
    import net.dv8tion.jda.internal.requests.Route;
    import utility.Utility;
    import commands.PublicCmdList;

    import java.awt.*;
    import java.sql.*;
    import java.time.format.DateTimeFormatter;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.concurrent.TimeUnit;
    import java.util.function.Consumer;

    public class PublicCommands extends ListenerAdapter {

        DbCredentials credentials = new DbCredentials();

        String username = credentials.getUsername();
        String password = credentials.getPassword();

        String cVersion = DumbledoreMain.botVersion; //COMANDO 1

        DateTimeFormatter itafmt = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        int count = 0;


        // LISTA COMANDI
        ArrayList<String> baseCMD = new ArrayList<String>();
        ArrayList<String> explainCMD = new ArrayList<String>();



        public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

            EmbedBuilder activeCommand = new EmbedBuilder()
                    .setColor(Color.green)
                    .setDescription("Comando Eseguito");

            EmbedBuilder disabledCommand = new EmbedBuilder()
                    .setColor(Color.red)
                    .setDescription("Comando non ancora attivo!");

            StringBuilder buildLoop = new StringBuilder();

            Guild guild = event.getGuild();
            String[] args = event.getMessage().getContentRaw().split("\\s+");

            baseCMD.add(PublicCmdList.cmdVersione); explainCMD.add(": Show the actual BOT version");
            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + PublicCmdList.cmdVersione)) {
                event.getChannel().sendMessage("Versione attuale: " + cVersion).queue();
            }

            baseCMD.add(PublicCmdList.cmdDeleteMsgByID); explainCMD.add("*msgID:* Delete a message by ID (if you have Role Permissions)");
            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + PublicCmdList.cmdDeleteMsgByID)) { // cancella un messaggio tramite id
                event.getChannel().deleteMessageById(args[1]).queue();
                event.getMessage().delete().queue();
            }

            baseCMD.add(PublicCmdList.cmdWho); explainCMD.add("*@role:* show all member of mentioned role");
            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "who")) {

                List<Role> roleList = guild.getRoles();
                List<Role> mentRole = event.getMessage().getMentionedRoles();
                List<Member> membersList = guild.getMembers();

                EmbedBuilder whoReq = new EmbedBuilder()
                        .setDescription("<@" + event.getMessage().getAuthor().getId() + ">" + " HA RICHIESTO: " + Utility.getRoleAsStringID(mentRole) + " \n")
                        .setColor(Color.green);


                event.getChannel().sendMessage(whoReq.build()).queue();

                if (args.length > 1 && args.length < 3) {

                    for (Role r1 : roleList) {
                        if (args[1].contains(r1.getId())) {
                            for (Member member : membersList) {
                                List<Role> memberRoles = member.getRoles();
                                for (Role m_role : memberRoles) {
                                    if (m_role.equals(r1)) {

                                        buildLoop.append("Ruolo: " + "<@&" + r1.getId() + ">" + " - Utente: " + "<@" + member.getUser().getId() + "> \r");

                                    }
                                }
                            }
                        }
                    }
                    EmbedBuilder whoPrint = new EmbedBuilder()
                            .setDescription(buildLoop.toString());

                    event.getChannel().sendMessage(whoPrint.build()).queue();
                }
                EmbedBuilder endReport = new EmbedBuilder()
                        .setDescription("**//------// FINE REPORT //------//**")
                        .setColor(Color.green);
                event.getChannel().sendMessage(endReport.build()).queue();
                event.getMessage().delete().queue();
            }

            baseCMD.add(PublicCmdList.cmdInfo); explainCMD.add("*@member:* Show the information about mentioned member");
            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "info")) {
                if (args.length > 1 && args.length < 3) {
                    try {
                        Member name = event.getMessage().getMentionedMembers().get(0);
                        //    System.out.println(name);

                        EmbedBuilder embB = new EmbedBuilder()
                                .setColor(0xF6BE00)
                                .setAuthor("Info riguardanti: " + name.getUser().getName(), "https://www.google.com", name.getUser().getAvatarUrl())
                                .setDescription("Entrato nel discord il: " + name.getTimeJoined().format(itafmt))
                                .addField("Status: ", name.getOnlineStatus().toString(), true)
                                .addField("Ruoli", Utility.getRoleAsStringID(name.getRoles()) + ".", true);

                        event.getChannel().sendMessage(embB.build()).queue();
                    } catch (IndexOutOfBoundsException exception) {
                        event.getChannel().sendMessage("Non hai taggato un @nome").queue();
                    }
                }
            }

           /* // STAMPA TUTTI I MEMBRI DEL DISCORD
            baseCMD.add(PublicCmdList.cmdWhoAllMembers); explainCMD.add("do not use if you have very much member in your guild");
            if (args[0].equalsIgnoreCase(PublicCmdList.cmdWhoAllMembers)) {

                List<Member> membersList = guild.getMembers();

                for (Member member : membersList) {
                    event.getChannel().sendMessage("<@" + member.getUser().getId() + ">").queue();
                }
            }*/

            baseCMD.add(PublicCmdList.cmdInvite); explainCMD.add("*link:* Print the Dumbledore's Invite Link");
            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "invite")
                    && args[1].equalsIgnoreCase("link")) {

                EmbedBuilder botLink = new EmbedBuilder()
                        .setColor(Color.blue)
                        .setDescription("https://discord.com/api/oauth2/authorize?client_id=847029930872930334&permissions=8&scope=bot");

                event.getChannel().sendMessage(botLink.build()).queue();
            }

            baseCMD.add(PublicCmdList.cmdAdd); explainCMD.add("*server:* Inizialize Dumbledore in your Discord Server");
            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + PublicCmdList.cmdAdd)
                    && args[1].equalsIgnoreCase("server")) {

                System.out.println(guild.getId() + " " + guild.getName());
                /*try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", username, password);
                    String sql = "INSERT INTO `tab1` (server_id, server_name) VALUES (?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, guild.getId());
                    statement.setString(2, guild.getName());
                    int rows = statement.executeUpdate();
                    if (rows > 0) {
                        System.out.println("Inserito");
                    }
                    statement.close();
                    connection.close();

                    guild.createTextChannel("bot-channel-log").queue();
                    System.out.println("channel-log creato");

                    event.getChannel().sendMessage("bot-channel-log **created**. Now inizialize it whit d-init (chID) command" +
                            "and replace (chID) with bot-channel-log channel ID. \r" +
                            "Example: d-init 859050416876027904").queue();

                    event.getJDA().getGuildById(DumbledoreMain.botDiscordID).getTextChannelById("857557884003287111")
                            .sendMessage("Creato channel-log nel discord: " + guild.getName() + " ID: "
                            + guild.getId() + ". **Attendo per inizializzarlo!**").queue();
                } catch (SQLException e) {

                    event.getJDA().getGuildById(DumbledoreMain.botDiscordID).getTextChannelById("857557884003287111")
                            .sendMessage("Il comando d-add server non ha funzionato nel discord: " + guild.getName() + " ID: "
                                    + guild.getId() + ". **CONTROLLA NON SIA GIA' INSERITO!**").queue();
                    System.out.println("Non funge cmdADD");
                    e.printStackTrace();
                }*/

                event.getJDA().getGuildById(DumbledoreMain.botDiscordID).getTextChannelById("857557884003287111")
                        .sendMessage("Interazione con il Discord " + guild.getName() + " ID: "
                                + guild.getId() + ". Fai **d-print guildchannel** " + guild.getId()).queue();
            }

            baseCMD.add(PublicCmdList.cmdInit); explainCMD.add("*(chID):* Inizialize bot-channel-log Channel");
            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "init")) {

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", username, password);
                    String sql = "UPDATE `tab1` SET `bot_log_channel` = " + args[1] + ", `init` = 'yes', WHERE `server_id` = " + event.getGuild().getId();
                    PreparedStatement statement = connection.prepareStatement(sql);

                    statement.close();
                    connection.close();


                    event.getJDA().getGuildById(DumbledoreMain.botDiscordID).getTextChannelById("857557884003287111")
                            .sendMessage("bot-channel log di " + guild.getName() + " ID: "
                                    + guild.getId() + ". **INIZIALIZZATO** su chID" + args[1]).queue();
                } catch (SQLException e) {

                    /*event.getJDA().getGuildById(DumbledoreMain.botDiscordID).getTextChannelById("857557884003287111")
                            .sendMessage("Il comando d-add server non ha funzionato nel discord: " + guild.getName() + " ID: "
                                    + guild.getId() + ". **CONTROLLA NON SIA GIA' INSERITO!**").queue();*/
                    System.out.println("Non funge cmdInit");
                    e.printStackTrace();
                }


                System.out.println(args[1]);
            }

            //baseCMD.add(PublicCmdList.cmdHelp);
            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "help")) {

                event.getChannel().sendMessage
                        ("\uD83C\uDDEE\uD83C\uDDF9 Sono il bot di Dominy, sono attualmente in sviluppo \uD83D\uDC97 \n"
                                + "\uD83C\uDDEC\uD83C\uDDE7 I'm Dominy's Bot, and I'm currently in development \uD83D\uDC97 \r \r")
                        .queue();

                event.getChannel().sendMessage( "COMMAND LIST: \r").queue();

                buildLoop.append(
                "1) **" + PublicCmdList.cmdVersione + "** " + explainCMD.get(0) + ";" + "\r" +
                        "2) **" + PublicCmdList.cmdDeleteMsgByID + "** " + explainCMD.get(1) + ";" + "\r" +
                        "3) **" + PublicCmdList.cmdWho + "** " + explainCMD.get(2) + ";" + "\r" +
                        "4) **" + PublicCmdList.cmdInfo + "** " + explainCMD.get(3) + ";" + "\r" +
                        "5) **" + PublicCmdList.cmdInvite + "** " + explainCMD.get(4) + ";" + "\r" +
                        "6) **" + PublicCmdList.cmdAdd + "** " + explainCMD.get(5) + ";" + "\r"
                );

    /*
                for (int i = 0; i < baseCMD.size(); i++) {
                    buildLoop.append(i + 1 + " **" + baseCMD.get(i) + "** " + explainCMD.get(i) + ";" + "\r");
                    String[] splitta = baseCMD.get(i).split("-");
                }
    */
                event.getChannel().sendMessage(buildLoop).queue();

                EmbedBuilder helpEb = new EmbedBuilder()
                        .setColor(Color.blue)
                        .addField("Online Version",  DumbledoreMain.botVersion, true)
                        .addField("Invite Bot in your Discord Server",  "[Click Here!](https://discord.com/api/oauth2/authorize?client_id=847029930872930334&permissions=8&scope=bot)", true)
                        .addField("Bug Segnalation", "Use command d-segnalation bug", true);
                //          .addField("Do you want a personal command?", "d-suggest command")
                //.addField("Created by", "Carlo Pennetta", true);

                event.getChannel().sendMessage(helpEb.build()).queue();
                event.getChannel().sendMessage(activeCommand.build()).queue();
            }

            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "segnalation")
                    && args[1].equalsIgnoreCase("bug")) {
                event.getChannel().sendMessage(disabledCommand.build()).queue();
            }


            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "add") //ancora non funge
                    && args[1].equalsIgnoreCase("role")) { //ancora non funge correttamente

                String guildID = args[2];
                String memberID = args[3];
                String roleID = args[4];

                //    event.getJDA().getGuildById(guildID).addRoleToMember(memberID, guild.getRoleById(roleID));
                event.getJDA().getGuildById(guildID).addRoleToMember(memberID, guild.getRoleById(roleID)).queue();
                //  System.out.println(event.getJDA().getGuildById(guildID).getRoles());
            }

            if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "consiglio")) {

                EmbedBuilder consSended = new EmbedBuilder()
                        .setColor(Color.green)
                        .setDescription("Il tuo consiglio è stato inviato, grazie \uD83E\uDDE1");

                event.getChannel().sendMessage(consSended.build()).queue();

                event.getJDA().getGuildById(DumbledoreMain.botDiscordID).getTextChannelById("859050416876027904")
                        .sendMessage("- " + event.getAuthor().getName() + " ha scritto: " + event.getMessage().getContentRaw() + " <@383035474807095296>").queue();


            }

        }
    }

