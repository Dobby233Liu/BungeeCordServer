package com.pvpin.commands;
import com.pvpin.Tools;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
public class CommandHelp extends Command{
    public CommandHelp() {
        super("help", "com.pvpin.help", new String[0]);
    }
    @Override
    public void execute(CommandSender cs, String[] strings) {
        send(cs,new String[]{
            "/help §6显示此帮助",
            "/perms §6显示你拥有的权限和所在权限组",
            "/ServerSay <message> §6发送跨服说话",
            "/ServerTell <player> <message> §6忽略服务器的限制，跨服私聊",
            "/PlayerTp <player> §6进入该玩家所在的服务器",
            "/server [Server]§6进入服务器"
        });
    }
    private void send(CommandSender sd,String[] messages,String as){
        for (String i : messages){
            sd.sendMessage(as+i);
        }
    }
    private void send(CommandSender sd,String[] messages){
        send(sd,messages,"§b");
    }
}
