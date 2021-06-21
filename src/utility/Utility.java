package utility;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.util.List;

public class Utility {

    public static String getRoleAsStringID(List rolelist) { //TRASFORMA UNA LISTA DI RUOLI IN ID
        String rolesID;
        if (!rolelist.isEmpty()) {
            Role tempRole = (Role) rolelist.get(0);
            rolesID = "<@&" + tempRole.getId() + ">";
            for (int i = 1; i < rolelist.size(); i++) {
                tempRole = (Role) rolelist.get(i);
                rolesID = rolesID + ", <@&" + tempRole.getId() + ">";
            }
        } else {
            rolesID = "Non ha ruoli!";
        }
        return rolesID;
    }

    public static String getRoleAsStringName(List rolelist) { //TRASFORMA UNA LISTA DI RUOLI IN ID
        String rolesName;
        if (!rolelist.isEmpty()) {
            Role tempRole = (Role) rolelist.get(0);
            rolesName = "<@&" + tempRole.getName() + ">";
            for (int i = 1; i < rolelist.size(); i++) {
                tempRole = (Role) rolelist.get(i);
                rolesName = rolesName + ", <@" + tempRole.getName() + ">";
            }
        } else {
            rolesName = "Non ha ruoli!";
        }
        return rolesName;
    }

    public static String getRoleAsStringToPrint(List rolelist) { //TRASFORMA UNA LISTA DI RUOLI IN ID
        String rolesNameToPrint;
        if (!rolelist.isEmpty()) {
            Role tempRole = (Role) rolelist.get(0);
            rolesNameToPrint = tempRole.getName();
            for (int i = 1; i < rolelist.size(); i++) {
                tempRole = (Role) rolelist.get(i);
                rolesNameToPrint = rolesNameToPrint + ", " + tempRole.getName();
            }
        } else {
            rolesNameToPrint = "Non ha ruoli!";
        }
        return rolesNameToPrint;
    }

    public static String getMemberAsStringID(List memberlist) { //TRASFORMA UNA LISTA DI RUOLI IN ID
        String memberID;
        if (!memberlist.isEmpty()) {
            Member tempMember = (Member) memberlist.get(0);
            memberID = "<@" + tempMember.getId() + ">";
            for (int i = 1; i < memberlist.size(); i++) {
                tempMember = (Member) memberlist.get(i);
                memberID = memberID + ", <@" + tempMember.getId() + ">";
            }
        } else {
            memberID = "Non ha membri!";
        }
        return memberID;
    }

    public static String getServerListID(List serverList) {
        String serverID;
        if (!serverList.isEmpty()) {
            Guild tempServerList = (Guild) serverList.get(0);
            serverID = tempServerList.getId() + "\n";
            for (int i = 1; i < serverList.size(); i++) {
                tempServerList = (Guild) serverList.get(i);
                serverID = serverID + tempServerList.getId() + "\n";
            }

        } else {
            serverID = "Non ha membri!";
        }

        return serverID;

    }

    public static String getServerListName(List serverList) {
        String serverName;
        if (!serverList.isEmpty()) {
            Guild tempServerList = (Guild) serverList.get(0);
            serverName = tempServerList.getName() + "\n";
            for (int i = 1; i < serverList.size(); i++) {
                tempServerList = (Guild) serverList.get(i);
                serverName = serverName + tempServerList.getName() + "\n";
            }

        } else {
            serverName = "Non ha membri!";
        }

        return serverName;

    }

    public static String getChannelListName(List chList) {
        String chName;
        if (!chList.isEmpty()) {
            GuildChannel tempchList = (GuildChannel) chList.get(0);
            chName = tempchList.getName() + "\n";
            for (int i = 1; i < chList.size(); i++) {
                tempchList = (GuildChannel) chList.get(i);
                chName = chName + tempchList.getName() + "\n";
            }

        } else {
            chName = "Non ha membri!";
        }

        return chName;

    }


}
