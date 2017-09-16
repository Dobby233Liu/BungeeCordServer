package net.gyhhy.login.commands;
import com.pvpin.Tools;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;
import net.gyhhy.login.LoginTool;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
public class CommandLogin extends Command{
    public CommandLogin() {
        super("login", "net.gyhhy.login.login", new String[0]);
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0){
            sender.sendMessage("/login 密码");
            return;
        }
        try {
            if (!LoginTool.isRegister(sender.getName())){
                sender.sendMessage("请先注册");
                return;
            }
            if (LoginTool.isLogin(sender.getName())){
                sender.sendMessage("您已经登陆了");
                return;
            }
            Object pas = LoginTool.eval("Password['"+sender.getName()+"'] == "+args[0]);
            if ((Boolean)pas){
                sender.sendMessage("登陆成功");
                LoginTool.eval("isLogin['"+sender.getName()+"'] = true;");
            }
        } catch (ScriptException ex) {
            Logger.getLogger(CommandLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
