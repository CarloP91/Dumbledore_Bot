/*
package serverPersonalScript.RevProj;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.react.GenericGuildMessageReactionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;
import static main.DumbledoreMain.dumbledoreID;

public class AssistenzaReactionScript extends ListenerAdapter {

    public void onGenericGuildMessageReaction(@NotNull GenericGuildMessageReactionEvent event) {
        super.onGenericGuildMessageReaction(event);

        Member member = event.getMember();
        Role tecnicaVarie = event.getJDA().getRoleById(MainRevengeProject.rpProblemaTecnicoRole);
        Role azioniGame = event.getJDA().getRoleById(MainRevengeProject.rpValutazioneAzione);
        Role packVip = event.getJDA().getRoleById(MainRevengeProject.rpPackVip);
        Role rimborso = event.getJDA().getRoleById(MainRevengeProject.rpRichiestaRimborso);
        Role nps = event.getJDA().getRoleById(MainRevengeProject.rpNPS);


        if (event.getGuild().getId().equals(MainRevengeProject.revengeProjectID)) {

            if (event.getChannel().getId().equals(MainRevengeProject.rpAssistenzaRoom)
                    && !event.getUser().getId().equals(dumbledoreID)) {

                if (!event.getMember().getRoles().contains(tecnicaVarie)
                        && !event.getMember().getRoles().contains(azioniGame)
                        && !event.getMember().getRoles().contains(packVip)
                        && !event.getMember().getRoles().contains(rimborso)
                        && !event.getMember().getRoles().contains(nps)) {

//                    System.out.println("Non ho ruolo");
                    if (event.getReactionEmote().getName().equals("\uD83D\uDD28")) {
                        event.getChannel().sendMessage("<@" + event.getUserId() + "> hai richiesto assistenza per un problema tecnico. Entra in <#874416009090596874> ed attendi che uno staffer si liberi.").queue(
                                message -> {
                                    message.delete().queueAfter(10, TimeUnit.SECONDS);
                                });

                        event.getGuild().addRoleToMember(member, tecnicaVarie).queue();

*/
/*                        if (event.getMember().getRoles().contains(tecnicaVarie)) {
                            System.out.println("Ho il ruolo");
                        } else if (!event.getMember().getRoles().contains(tecnicaVarie)) {
                            System.out.println("Non ho ruolo");
                        }*//*



                    } else if (event.getReactionEmote().getName().equals("\uD83C\uDD98")) {

                        event.getChannel().sendMessage("<@" + event.getUserId() + "> hai richiesto una valutazione di un'azione. Entra in <#874458584568725534> ed attendi che uno staffer si liberi.").queue(
                                message -> {
                                    message.delete().queueAfter(10, TimeUnit.SECONDS);
                                });

                        event.getGuild().addRoleToMember(member, azioniGame).queue();
//                        event

                    } else if (event.getReactionEmote().getName().equals("\uD83C\uDF81")) {

                        event.getChannel().sendMessage("<@" + event.getUserId() + "> hai richiesto informazioni sui Pack Vip. Entra in <#874458411708862544> ed attendi che uno staffer si liberi.").queue(
                                message -> {
                                    message.delete().queueAfter(10, TimeUnit.SECONDS);
                                });

                        event.getGuild().addRoleToMember(member, packVip).queue();

                    } else if (event.getReactionEmote().getName().equals("\uD83D\uDCE6")) {

                        event.getChannel().sendMessage("<@" + event.getUserId() + "> hai richiesto un rimborso in game. Ti ricordiamo che per essere rimborsato dovrai possedere una clip del materiale perso. \n Entra in <#874458333157933106> ed attendi che uno staffer si liberi.").queue(
                                message -> {
                                    message.delete().queueAfter(10, TimeUnit.SECONDS);
                                });

                        event.getGuild().addRoleToMember(member, rimborso).queue();

                    } else if (event.getReactionEmote().getName().equals("\uD83D\uDC8C")) {

                        event.getChannel().sendMessage("<@" + event.getUserId() + "> hai inviato una richiesta di assistenza generale. Entra in <#874416009090596874> ed attendi che uno staffer si liberi.").queue(
                                message -> {
                                    message.delete().queueAfter(10, TimeUnit.SECONDS);
                                });


                        event.getGuild().addRoleToMember(member, nps).queue();

                    }
                } else if (event.getMember().getRoles().contains(tecnicaVarie)) {
//                    System.out.println("Ho il ruolo");
                    event.getChannel().sendMessage("<@" + event.getUserId() + "> hai già il ruolo <@&" + MainRevengeProject.rpProblemaTecnicoRole + ">\n Entra in <#874416009090596874> ed attendi che uno staffer si liberi.\"").queue(
                            message -> {
                                message.delete().queueAfter(10, TimeUnit.SECONDS);
                            });
                } else if (event.getMember().getRoles().contains(azioniGame)) {
//                    System.out.println("Ho il ruolo");
                    event.getChannel().sendMessage("<@" + event.getUserId() + "> hai già il ruolo <@&" + MainRevengeProject.rpValutazioneAzione + ">\n Entra in <#874458584568725534> ed attendi che uno staffer si liberi.\"").queue(
                            message -> {
                                message.delete().queueAfter(10, TimeUnit.SECONDS);
                            });
                } else if (event.getMember().getRoles().contains(rimborso)) {
//                    System.out.println("Ho il ruolo");
                    event.getChannel().sendMessage("<@" + event.getUserId() + "> hai già il ruolo <@&" + MainRevengeProject.rpRichiestaRimborso + ">\n Entra in <#874458333157933106> ed attendi che uno staffer si liberi.\"").queue(
                            message -> {
                                message.delete().queueAfter(10, TimeUnit.SECONDS);
                            });
                } else if (event.getMember().getRoles().contains(packVip)) {
//                    System.out.println("Ho il ruolo");
                    event.getChannel().sendMessage("<@" + event.getUserId() + "> hai già il ruolo <@&" + MainRevengeProject.rpPackVip + ">\n Entra in <#874458411708862544> ed attendi che uno staffer si liberi.\"").queue(
                            message -> {
                                message.delete().queueAfter(10, TimeUnit.SECONDS);
                            });
                } else if (event.getMember().getRoles().contains(nps)) {
//                    System.out.println("Ho il ruolo");
                    event.getChannel().sendMessage("<@" + event.getUserId() + "> hai già il ruolo <@&" + MainRevengeProject.rpNPS + ">\n Entra in <#874416009090596874> ed attendi che uno staffer si liberi.\"").queue(
                            message -> {
                                message.delete().queueAfter(10, TimeUnit.SECONDS);
                            });
                }
            }
        }
    }
}
*/
