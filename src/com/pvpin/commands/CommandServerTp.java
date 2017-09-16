
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
public class CommandServerTp extends Command{
    public CommandServerTp() {
        super("playertp", "com.pvpin.servertp", new String[0]);
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length != 0){
            String playerName = args[0];
            Object[] player = Tools.find(playerName);
            if ((Boolean)player[2]){
                Server ser = (Server)player[1];
                String ServerName = ser.getInfo().getName();
                Tools.getPluginManager().dispatchCommand(sender, "server "+ServerName);
            } else {
                sender.sendMessage("§c该玩家不在线");
            }
        } else {
            sender.sendMessage("§c格式:/PlayerTp [玩家]");
        }
    }
    
}
