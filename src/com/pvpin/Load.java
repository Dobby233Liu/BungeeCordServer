package com.pvpin;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.Command;

public class Load extends Plugin{
    @Override
    public void onEnable(){
        Tools.setPluginManager(getProxy().getPluginManager());
        Command[] cmds = Commands.getCommands();
        for (Command cmd : cmds){
            Tools.getPluginManager().registerCommand(this,cmd);
        }
        //getProxy().getPluginManager().registerCommand(this,new Command());
    }
}
