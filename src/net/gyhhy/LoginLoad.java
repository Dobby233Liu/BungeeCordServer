package net.gyhhy;
import com.pvpin.Tools;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import com.pvpin.Load;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;
import net.gyhhy.login.commands.*;
import net.md_5.bungee.api.plugin.Command;
import net.gyhhy.login.LoginTool;
import net.gyhhy.login.events.LoginListener;
public class LoginLoad {
    private static Load Plugin;
    public static void load(Load thiss){
        Plugin = thiss;
        LoginTool.Start(thiss);
        Tools.registerCommand(new Command[]{
            new CommandLogin(),
            new CommandRegister()
        });
        Tools.registerListener(new LoginListener());
    }
}
