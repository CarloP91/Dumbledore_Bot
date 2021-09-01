package serverPersonalScript.BotTest;

import main.DumbledoreMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

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
                        "Phasellus orci turpis, dignissim quis molestie tincidunt, sodales eu mi. Quisque luctus erat ac massa fermentum, sit amet faucibus sem vehicula. Nam tincidunt pellentesque augue in iaculis. Nunc eu dictum elit. Quisque imperdiet massa at enim euismod tristique. Aenean commodo erat a suscipit dictum. Donec eu euismod nulla. Morbi nibh lacus, molestie a lorem et, mollis pretium turpis. Suspendisse sollicitudin ac urna a porttitor. Proin nec nulla nulla.";
                //                String parti[] = msgTxt.split("Sed");
                msgTxt.substring(0, 1999);

               /* for (int i = 0; i < parti.length; i++) {
                    event.getChannel().sendMessage(parti[i]).queue();
                }*/

                if(msgTxt.length() > 0) {

                    if (msgTxt.length() > 0 && msgTxt.length() < 2000) {
                        event.getChannel().sendMessage(msgTxt.substring(0, 1999)).queue();
                    }

                    if(msgTxt.length() > 2000 && msgTxt.length() < 4000) {
                        event.getChannel().sendMessage(msgTxt.substring(2000, 3999)).queue();
                    }

                    event.getChannel().sendMessage(msgTxt.substring(1999, 3998)).queue();
                   event.getChannel().sendMessage(msgTxt.substring(3999, 5998)).queue();
                   event.getChannel().sendMessage(msgTxt.substring(5999, 7998)).queue();


                }

               /* if (msgTxt.length() > 1999) {
                    event.getChannel().sendMessage(msgTxt.substring(1999, 3998)).queue();
                }

                if (msgTxt.length() > 3999 && msgTxt.length() < 5998) {
                    event.getChannel().sendMessage(msgTxt.substring(3999, 5998)).queue();
                }
                if (msgTxt.length() > 5999 && msgTxt.length() < 7999) {
                    event.getChannel().sendMessage(msgTxt.substring(5999, 7998)).queue();
                }
                if (msgTxt.length() > 7999) {
                   event.getChannel().sendMessage(" \n \n ```il messaggio è troppo lungo, non posso mica far esplodere il discord ❤️```").queue();
                }
*/

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
