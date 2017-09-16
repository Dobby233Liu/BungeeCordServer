
package com.pvpin.commands;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;
public class CommandServerSay extends Command {
    public CommandServerSay() {
        super("serversay", "com.pvpin.serversay", new String[0]);
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0){
            sender.sendMessage(ChatColor.RED + "Where are the messages?");
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append("§r[§c"+"跨服说话"+"§r] §b" + sender.getName() + "§b> ");
            for (String s : args) {
                builder.append(ChatColor.translateAlternateColorCodes('&', s));
                builder.append(" ");
            }
            String message = builder.substring(0, builder.length() - 1);
            ProxyServer.getInstance().broadcast(message);
        }
    }
    
}
