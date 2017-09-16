package net.gyhhy.login;
import com.pvpin.Tools;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
public class ReloadPlayerIsLogin {
    public static void main() {
    Tools.getPlugin().getProxy().getScheduler().runAsync((Plugin)Tools.getPlugin(), new Runnable() {
        @Override
        public void run() {
            try{
                String a = (LoginTool.eval("String(Object.keys(isLogin))")).toString();
                String[] values = a.replaceAll(" ","").split(",");
                //ProxyServer.getInstance().broadcast(a);
                for (String i : values){
                    Object[] e = Tools.find(i);
                    if (!((Boolean)e[2])){
                        LoginTool.eval("isLogin['"+i+"'] = false");
                    }
                }
            } catch (ScriptException ex) {
                Logger.getLogger(ReloadPlayerIsLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
  }
}
