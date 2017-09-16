package net.gyhhy.login.events;
import com.pvpin.Tools;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;
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
                String[] cmd = event.getMessage().toLowerCase().split(" ");
                if ("/login".equals(cmd[0]) || "/register".equals(cmd[0])){
                    return;
                }
                //sender.sendMessage(event.getMessage().toLowerCase());
                sender.sendMessage("请先登陆/注册");
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
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
    @EventHandler
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
//    @EventHandler
//    public void PlayerLoginEvent(LoginEvent event){
//        Connection sd = event.getConnection();
//        if (sd instanceof ProxiedPlayer){
//            ProxiedPlayer sender = (ProxiedPlayer)sd;
//            Timer timer = new Timer();
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    
//                }
//            }, 20000);
//        }
//    }
}
