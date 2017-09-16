package com.pvpin;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.Command;
import net.gyhhy.LoginLoad;
public class Load extends Plugin{
    @Override
    public void onEnable(){
        Tools.setPlugin(this);
        Command[] cmds = Commands.getCommands();
        Tools.registerCommand(cmds);
        LoginLoad.load(this);
        //getProxy().getPluginManager().registerCommand(this,new Command());
    }
}
