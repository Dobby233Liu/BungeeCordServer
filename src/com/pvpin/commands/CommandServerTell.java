package com.pvpin.commands;

import com.pvpin.Tools;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
public class CommandServerTell extends Command {
    public CommandServerTell() {
        super("servertell", "com.pvpin.servertell", new String[0]);
    }

    @Override
    public void execute(CommandSender cs, String[] strings) {
        if (strings.length >= 2){
            Object[] gets = Tools.find(strings[0]);
            String message = Tools.join(Tools.kot(strings, 1, strings.length - 1));
//            cs.sendMessage(""+gets[0]+"\n"+gets[1]+"\n"+gets[2]);
//            if (gets[1]!= null){
//                Server ser = (Server)gets[1];
//                cs.sendMessage(""+ser.getInfo().getPlayers());
//            }
            if ((Boolean)gets[2]){
                ProxiedPlayer player = (ProxiedPlayer)gets[0];
                player.sendMessage("§r[§b跨服私聊§r] §e"+cs.getName()+"对你说:§b "+message);
            } else {
                cs.sendMessage("§c玩家 "+strings[0]+"不在线，无法私聊");
            }
        } else {
            cs.sendMessage(ChatColor.RED + "命令格式: /ServerTell <Player> <message>");
        }
    }
}
