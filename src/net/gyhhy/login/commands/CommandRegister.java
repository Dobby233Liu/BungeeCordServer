package net.gyhhy.login.commands;
import com.pvpin.Tools;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;
import net.gyhhy.login.LoginTool;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
public class CommandRegister extends Command{
    public CommandRegister() {
        super("register", "net.gyhhy.login.register", new String[0]);
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length != 2){
            sender.sendMessage("/register 密码 重复密码");
            return;
        }
        try {
            if (LoginTool.isRegister(sender.getName())){
                sender.sendMessage("您可以直接登陆");
                return;
            }
            if (args[0].equals(args[1])){
                if (!Tools.onlyOf(args[0])){
                    sender.sendMessage("密码不允许含有特殊字符");
                    return;
                }
                sender.sendMessage("注册成功");
                LoginTool.eval("isLogin['"+sender.getName()+"'] = true;");
                LoginTool.eval("Password['"+sender.getName()+"'] = '"+args[0]+"'");
                LoginTool.saveFile((String)LoginTool.eval("JSON.stringify(Password)"));
            } else {
                sender.sendMessage("两次密码不一致");
            }
        } catch (ScriptException ex) {
            Logger.getLogger(CommandLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
