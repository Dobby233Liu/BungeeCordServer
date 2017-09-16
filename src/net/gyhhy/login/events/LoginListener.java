package net.gyhhy.login.events;
import net.gyhhy.login.LoginTool;
import net.md_5.bungee.api.connection.Connection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.api.event.*;
public class LoginListener implements Listener {
    @EventHandler
    public void PlayerChatEvent(ChatEvent event){
        Connection sd = event.getSender();
        if (sd instanceof ProxiedPlayer){
            ProxiedPlayer sender = (ProxiedPlayer)sd;
            if (!LoginTool.isLogin(sender.getName())){
                sender.sendMessage("请先登陆/注册");
                event.setCancelled(true);
            }
        }
    }
    public void PlayerTabCompleteEvent(TabCompleteEvent event){
        Connection sd = event.getSender();
        if (sd instanceof ProxiedPlayer){
            ProxiedPlayer sender = (ProxiedPlayer)sd;
            if (!LoginTool.isLogin(sender.getName())){
                sender.sendMessage("请先登陆/注册");
                event.setCancelled(true);
            }
        }
    }
    public void PlayerTabCompleteResponseEvent(TabCompleteResponseEvent event){
        Connection sd = event.getSender();
        if (sd instanceof ProxiedPlayer){
            ProxiedPlayer sender = (ProxiedPlayer)sd;
            if (!LoginTool.isLogin(sender.getName())){
                sender.sendMessage("请先登陆/注册");
                event.setCancelled(true);
            }
        }
    }
}
