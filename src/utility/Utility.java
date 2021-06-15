package utility;

import net.dv8tion.jda.api.entities.Role;

import java.util.List;

public class Utility {


    public static String getRoleAsStringID(List rolelist){ //TRASFORMA UNA LISTA DI RUOLI IN ID
        String rolesID;
        if (!rolelist.isEmpty()) {
            Role tempRole = (Role) rolelist.get(0);
            rolesID = "<@&" + tempRole.getId() + ">";
            for (int i = 1; i < rolelist.size(); i++){
                tempRole = (Role) rolelist.get(i);
                rolesID = rolesID + ", <@&" + tempRole.getId() + ">.";
            }
        } else {
            rolesID = "Non ha ruoli!";
        }
        return rolesID;
    }

    public static String getRoleAsStringName(List rolelist){ //TRASFORMA UNA LISTA DI RUOLI IN ID
        String rolesName;
        if (!rolelist.isEmpty()) {
            Role tempRole = (Role) rolelist.get(0);
            rolesName = "<@&" + tempRole.getName() + ">";
            for (int i = 1; i < rolelist.size(); i++){
                tempRole = (Role) rolelist.get(i);
                rolesName = rolesName + ", <@" + tempRole.getName() + ">.";
            }
        } else {
            rolesName = "Non ha ruoli!";
        }
        return rolesName;
    }

    public static String getRoleAsStringToPrint(List rolelist){ //TRASFORMA UNA LISTA DI RUOLI IN ID
        String rolesNameToPrint;
        if (!rolelist.isEmpty()) {
            Role tempRole = (Role) rolelist.get(0);
            rolesNameToPrint =  tempRole.getName();
            for (int i = 1; i < rolelist.size(); i++){
                tempRole = (Role) rolelist.get(i);
                rolesNameToPrint = rolesNameToPrint + ", " + tempRole.getName() + ".";
            }
        } else {
            rolesNameToPrint = "Non ha ruoli!";
        }
        return rolesNameToPrint;
    }
}
