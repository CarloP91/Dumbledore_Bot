package serverPersonalScript.BotTest;

import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static main.DumbledoreMain.botDiscordID;

public class Test extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);

        Guild guild = event.getGuild();
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (guild.getId().equals(botDiscordID)
                && args[0].equalsIgnoreCase(DumbledoreMain.prefix + "test")) {
//            System.out.println(event.getMessage().getContentRaw());
            try {
//                System.out.println(event.getMessage().getAttachments().get(0).getUrl());

                String msgTxt = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris vitae metus vitae lectus tempus eleifend dignissim ac metus. Nam ut nunc eu diam commodo dignissim nec non tellus. Integer gravida erat sed enim varius faucibus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer dictum urna quis consectetur auctor. Maecenas gravida tristique accumsan. Quisque vulputate vitae eros at rhoncus. Vestibulum et quam vitae nisi congue dignissim non eu nibh. Aliquam maximus arcu a lorem fermentum, et ultricies arcu condimentum. Praesent et congue est, sit amet sagittis mauris. Curabitur commodo, ante eget maximus porta, nisl lorem sagittis ligula, ut auctor orci augue in velit.\n" +
                        "\n" +
                        "Maecenas vitae lacinia justo. Vestibulum mauris nisl, congue et facilisis quis, blandit at enim. Morbi hendrerit, sem at porttitor rutrum, risus neque elementum enim, non porttitor ex est id ipsum. Nam imperdiet vestibulum leo, id porttitor nunc pulvinar eleifend. Vestibulum at hendrerit erat. Proin hendrerit felis urna. Morbi quis elit eu erat luctus congue rhoncus non lacus. Phasellus sollicitudin mollis suscipit. Aenean posuere convallis massa eu vulputate. In sollicitudin tortor purus, sit amet vehicula erat malesuada vitae. Nam eget suscipit tellus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In a lobortis sapien. Phasellus a neque fringilla, pulvinar tortor non, dapibus nisl.\n" +
                        "\n" +
                        "Duis mauris diam, mattis id eros quis, pulvinar efficitur nisl. Sed in convallis tortor. Nulla sed ullamcorper lorem, id convallis urna. Donec vel nulla non neque pulvinar vestibulum non a lorem. Mauris viverra mauris sed augue faucibus ornare. In hac habitasse platea dictumst. Mauris ut arcu gravida, finibus sem nec, ornare arcu. Aliquam erat volutpat. Ut vitae laoreet arcu, vitae vestibulum arcu. Quisque accumsan dolor vitae est consequat volutpat.\n" +
                        "\n" +
                        "Nullam eu tellus vel elit faucibus laoreet. Duis accumsan egestas massa quis accumsan. Cras iaculis accumsan metus. Donec nec finibus turpis. In ut mollis tellus. Aenean volutpat diam mi, vitae porttitor orci tristique euismod. Donec cursus laoreet orci vel elementum. Pellentesque luctus nunc ex, vestibulum pharetra quam molestie in. Duis eu convallis tortor. Nunc sit amet cursus quam, et pharetra nulla. Ut porta justo nisl, et dictum elit efficitur quis. Aenean sapien leo, tristique non aliquet nec, eleifend a mi. Sed erat urna, tempor id sapien ut, dignissim vestibulum arcu.\n" +
                        "\n" +
                        "Mauris nec blandit libero. Ut finibus tellus a libero scelerisque, ut posuere quam rutrum. Vivamus rhoncus elementum dui ac molestie. Nulla feugiat consequat ante vitae fermentum. Donec congue aliquet turpis a viverra. Nunc ut quam eget sem lobortis feugiat. Nullam semper sagittis augue blandit ultrices. Phasellus eget tristique justo. Sed lobortis dignissim interdum. Sed laoreet lectus eu enim finibus interdum. Aliquam tincidunt eleifend cursus. Proin diam justo, dapibus eget porta id, condimentum sed quam. Maecenas varius ligula dictum nisl semper iaculis nec ut dui. Morbi eu sapien nulla. Sed in purus et eros dignissim elementum. Nulla molestie nulla et augue dignissim accumsan.\n" +
                        "\n" +
                        "Curabitur tellus nunc, ultricies vel luctus at, porta nec enim. Morbi sed odio eleifend, malesuada magna eu, accumsan ipsum. Sed non ipsum velit. Morbi suscipit enim et ullamcorper fermentum. Ut pulvinar turpis eu cursus maximus. Proin sed nulla aliquam, suscipit dui nec, aliquet dui. Cras at ex pellentesque, auctor sem eu, ornare mauris. Morbi sit amet neque nec metus tempus tempus. Phasellus eget leo sed arcu pretium porta eu nec eros. Nunc eu eros velit. Donec faucibus faucibus est sed maximus. Morbi id nisl non dolor scelerisque ultrices.\n" +
                        "\n" +
                        "Sed facilisis id risus nec egestas. Nunc et enim sapien. Donec ullamcorper neque sit amet laoreet dignissim. Nullam sed mauris sagittis, consectetur diam at, suscipit dolor. Morbi consectetur massa lectus, et imperdiet est elementum in. Sed auctor orci leo, ut facilisis augue dignissim ut. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Aliquam sed tortor lobortis, consectetur augue sit amet, accumsan elit. Phasellus pretium nulla vel libero euismod dapibus. Nam auctor posuere urna, non iaculis dui tincidunt eu. Duis vitae arcu commodo, cursus tortor sit amet, sollicitudin risus. Sed viverra suscipit quam, sed aliquam urna bibendum ac.\n" +
                        "\n" +
                        "Phasellus rutrum ipsum ut ultricies bibendum. Nam nisl felis, scelerisque vitae lectus non, varius viverra risus. Praesent nec aliquam lacus. Proin blandit, nunc ac aliquam vehicula, purus elit tempus sapien, ultricies faucibus odio nibh accumsan urna. Donec lectus dui, facilisis eget hendrerit vel, malesuada eu arcu. In eget fringilla libero, non auctor libero. Maecenas pretium in metus cursus convallis. Suspendisse volutpat lacus vel mauris lobortis porta. In tincidunt vitae augue a blandit. Nullam malesuada a orci eget bibendum. Nulla accumsan, metus sit amet tincidunt hendrerit, magna tortor fermentum ante, id accumsan urna lectus a ante.\n" +
                        "\n" +
                        "Nulla scelerisque pulvinar lorem sit amet molestie. Etiam nec orci finibus, tempor ipsum eget, imperdiet mauris. Fusce neque nisl, rhoncus id dictum ut, tristique ut mi. Sed imperdiet tristique mauris, at egestas nisl maximus in. Donec est tortor, sodales hendrerit vulputate at, elementum sit amet eros. Integer efficitur tristique est, at pharetra lectus congue sed. Nam vitae purus arcu. Integer faucibus scelerisque nisl, quis tempor felis ultrices eu. Maecenas mollis aliquet mauris, at volutpat orci eleifend et. Donec eu ullamcorper sapien. Morbi sit amet mi turpis. Fusce non nunc ullamcorper libero dignissim bibendum quis a orci. Nulla vestibulum urna eu ipsum mollis, non placerat massa maximus. Proin arcu risus, convallis at interdum vitae, laoreet sit amet magna. Nunc laoreet vulputate mi, quis dignissim nisi cursus eget. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.\n" +
                        "\n" +
                        "In vitae ipsum vel urna fermentum malesuada. Suspendisse mollis diam et leo porttitor tempor. In eu arcu dapibus, faucibus libero a, pretium quam. Nullam a arcu ante. Nulla facilisi. Duis mi ligula, molestie non eleifend vitae, venenatis id ex. Donec dictum varius ornare. Curabitur suscipit vehicula nisl in volutpat. Integer vitae porta eros. Vestibulum elementum, neque ac venenatis lacinia, massa turpis efficitur ipsum, quis blandit justo elit quis nulla. Cras posuere nibh tellus, vitae accumsan enim feugiat eu. Phasellus et viverra est. Nulla et neque eget diam efficitur sagittis.\n" +
                        "\n" +
                        "In quis tincidunt purus. Phasellus velit urna, rutrum ut sapien id, scelerisque tempor justo. Nunc varius felis ornare metus suscipit pulvinar. Donec mi purus, iaculis quis nisi ut, faucibus eleifend ligula. Fusce venenatis orci ex, id finibus justo aliquet in. Fusce accumsan lacus eu dui vehicula, eu interdum sem convallis. In volutpat orci a euismod aliquam. Donec gravida erat at risus interdum, eu bibendum ante suscipit. Aliquam accumsan nulla justo, a rutrum tortor accumsan at. Suspendisse pharetra eros eget euismod elementum. Vestibulum ac velit facilisis, malesuada dui eget, tempus ipsum.\n" +
                        "\n" +
                        "Proin commodo turpis sed orci ultricies, vitae aliquet magna elementum. Praesent vehicula a metus eget euismod. Donec tincidunt libero quis ante pellentesque, tincidunt bibendum elit vulputate. Integer tincidunt, eros et ornare pharetra, enim justo lobortis nisl, vel feugiat elit elit semper diam. In ornare, augue quis vulputate scelerisque, velit tortor imperdiet nulla, ac volutpat nibh justo ut justo. Mauris pulvinar a nisl quis pellentesque. Morbi a purus massa. Aliquam erat volutpat. Sed dictum tempor vestibulum. In hac habitasse platea dictumst.\n" +
                        "\n" +
                        "Sed interdum magna pulvinar ligula tempus interdum. Phasellus pharetra fermentum tristique. Nullam ex dui, commodo eu sem placerat, vulputate vulputate augue. Phasellus ac interdum felis. Praesent aliquet fringilla quam, in placerat nibh mollis ut. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Duis lacinia arcu tellus, nec sodales mauris pretium eget. Vivamus ut metus vel massa laoreet pulvinar. Duis nec urna turpis. Suspendisse ultricies sapien ut lacus pulvinar, a molestie est tempor.\n" +
                        "\n" +
                        "Aliquam posuere lorem metus, ullamcorper malesuada lectus aliquet ac. Cras eget metus sed lectus rhoncus suscipit eu sed tortor. Etiam non tellus vulputate, bibendum metus vitae, fermentum neque. Nulla dignissim sit amet ex a semper. Quisque eget pulvinar augue, sed lobortis nisl. Ut convallis purus magna, id rhoncus nisl posuere eu. Sed molestie euismod elit ac gravida. Praesent porttitor ornare mi, sit amet tincidunt urna sagittis non. Ut nisi nulla, auctor at lacus nec, tincidunt consectetur lectus. Maecenas nec porta est.\n" +
                        "\n" +
                        "Maecenas ultricies leo porttitor felis porttitor luctus. Vivamus tempus turpis ut eros placerat, vel lobortis velit blandit. Nullam sed nunc nisi. Maecenas tristique gravida erat. Nulla blandit, tortor non viverra ullamcorper, nunc leo ornare lectus, sit amet egestas turpis mi quis tortor. Mauris placerat, dolor non imperdiet eleifend, risus lectus tincidunt velit, sed blandit leo felis sit amet ante. Donec dolor mauris, iaculis nec purus sed, tempus malesuada augue. Praesent pretium nulla ex, malesuada volutpat velit condimentum non. Vivamus rhoncus dictum tempus. Vivamus in faucibus quam, ut interdum libero. Aenean varius metus leo, non laoreet odio fermentum id.\n" +
                        "\n" +
                        "Nulla tincidunt, mauris volutpat pellentesque dignissim, elit tortor egestas ipsum, ut luctus nibh odio maximus odio. Fusce cursus urna ut sapien vehicula, non molestie felis luctus. Vivamus condimentum nulla lectus, ut lobortis enim laoreet in. Proin condimentum nec mauris ut laoreet. Nulla vulputate nunc libero. Pellentesque eget justo ac ligula tincidunt lacinia. Nunc tempus ultricies dapibus. Sed suscipit ullamcorper lorem, vitae volutpat lacus vulputate non. Vestibulum faucibus turpis lorem.\n" +
                        "\n" +
                        "Sed faucibus ac augue vitae efficitur. Nam luctus nisl quis quam tempor, et condimentum augue vehicula. Sed sit amet feugiat tortor, at pretium dui. Duis sollicitudin mi id interdum tempus. Maecenas et facilisis mauris, quis molestie velit. Praesent id mi enim. Praesent dapibus mattis maximus.\n" +
                        "\n" +
                        "Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla magna felis, bibendum non ipsum eu, pulvinar molestie nibh. Nunc vitae diam vel elit malesuada tristique. Nulla malesuada fermentum dolor quis aliquam. Duis id posuere quam. Vivamus vehicula accumsan turpis, eu mollis enim sagittis accumsan. Vestibulum posuere tempus diam. Sed vel finibus tellus, sed volutpat tellus. Nulla dignissim sem eu sapien luctus, vitae sollicitudin enim tincidunt. Nam pharetra lobortis porttitor. Morbi gravida elementum dapibus. Phasellus condimentum dui et ornare sollicitudin. Suspendisse auctor accumsan enim et sagittis.\n" +
                        "\n" +
                        "Etiam dictum, nisl eu vehicula faucibus, lectus nulla vestibulum ante, vel posuere elit lacus in massa. Maecenas eu efficitur ipsum. Pellentesque nibh diam, ultrices eu risus id, porta faucibus odio. Nam blandit vulputate neque, ut elementum enim interdum at. Nam tempus nisi non efficitur blandit. Cras elementum auctor sapien non vehicula. Integer ornare rutrum sapien eu lobortis. Sed sodales arcu et ipsum lobortis, non vestibulum odio lacinia. Aliquam quis turpis porta, feugiat mauris eget, molestie enim.\n" +
                        "\n" +
                        "Vestibulum et mi eget ipsum laoreet commodo. Aenean ut eros quis justo rhoncus tristique quis et odio. Donec vitae nunc at lacus pellentesque fermentum ac id ex. Integer quis eleifend ex, ut vehicula magna. Duis vel purus neque. Ut consequat felis sodales massa pulvinar molestie. Praesent vulputate tellus a ante dapibus facilisis.\n" +
                        "\n" +
                        "Quisque tincidunt diam sit amet tempor consectetur. Ut ac porttitor ligula, vitae bibendum leo. Sed suscipit non tortor ac porttitor. Nullam tincidunt diam arcu, et convallis nibh rhoncus quis. Aliquam odio purus, cursus sit amet lectus et, efficitur dapibus diam. Nunc in faucibus libero, quis ornare enim. Integer lacinia nisi non malesuada eleifend. Ut pellentesque risus quam.\n" +
                        "\n" +
                        "Praesent placerat porta risus. Aliquam suscipit diam quis purus mattis, auctor scelerisque massa sagittis. Sed feugiat ac lorem ut lacinia. Duis faucibus tortor vel euismod molestie. Pellentesque placerat est non tempus porttitor. Fusce vel ante non augue feugiat porta. Duis ac erat eget odio euismod varius.\n" +
                        "\n" +
                        "Fusce maximus, lorem at vulputate malesuada, orci arcu porttitor nibh, sed rhoncus nisi nisi sed nisl. Fusce ornare, nibh in tristique scelerisque, lectus nisl ullamcorper leo, interdum scelerisque enim mi ac libero. Duis ac rutrum lectus, at interdum elit. Quisque sollicitudin id leo nec condimentum. Suspendisse egestas ipsum lectus, vitae pretium sem mattis eget. Suspendisse et blandit massa. Duis dolor massa, tempus non dapibus eget, tincidunt pellentesque neque. Vestibulum non elementum ante. Nulla facilisi.\n" +
                        "\n" +
                        "Phasellus orci turpis, dignissim quis molestie tincidunt, sodales eu mi. Quisque luctus erat ac massa fermentum, sit amet faucibus sem vehicula. Nam tincidunt pellentesque augue in iaculis. Nunc eu dictum elit. Quisque imperdiet massa at enim euismod tristique. Aenean commodo erat a suscipit dictum. Donec eu euismod nulla. Morbi nibh lacus, molestie a lorem et, mollis pretium turpis. Suspendisse sollicitudin ac urna a porttitor. Proin nec nulla nulla.";
                //                String parti[] = msgTxt.split("Sed");
                msgTxt.substring(0, 1999);

               /* for (int i = 0; i < parti.length; i++) {
                    event.getChannel().sendMessage(parti[i]).queue();
                }*/

                if(msgTxt.length() > 1999) {
                    event.getChannel().sendMessage(msgTxt.substring(0, 1999)).queue();
//                    event.getChannel().sendMessage(msgTxt.substring(1999, 3998)).queue();
//                    event.getChannel().sendMessage(msgTxt.substring(3999, 5998)).queue();
//
//                    event.getChannel().sendMessage(msgTxt.length()).queue();
                }

                if (msgTxt.length() > 3999) {
                    event.getChannel().sendMessage(msgTxt.substring(1999, 3998)).queue();
                }

                if (msgTxt.length() > 5999) {
                    event.getChannel().sendMessage(msgTxt.substring(3999, 5998)).queue();
                }
                if (msgTxt.length() > 5999) {
                    event.getChannel().sendMessage(msgTxt.substring(5999, 7998)).queue();
                }
                if (msgTxt.length() > 7999) {
                   event.getChannel().sendMessage(" \n \n ```il messaggio è troppo lungo, non posso mica far esplodere il discord ❤️```").queue();
                }


            } catch (IndexOutOfBoundsException exception) {

            }

        }

        //TEST

        if (args[0].equalsIgnoreCase(DumbledoreMain.prefix + "builder")) {
            EmbedBuilder formMsg = new EmbedBuilder()
                    .setColor(0x000000)
                    .setTitle(event.getGuild().getName() + " " + event.getChannel().getName())
                    .setDescription("**Messaggio:** \n" + event.getMessage().getContentRaw());

            event.getJDA().getGuildById(botDiscordID).getTextChannelById("856626062779088966").sendMessage(formMsg.build()).queue();
        }
    }
}
