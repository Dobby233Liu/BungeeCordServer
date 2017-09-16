package com.pvpin;
import net.md_5.bungee.api.plugin.Command;
import com.pvpin.commands.*;
public class Commands {
    public static Command[] getCommands(){
        Command[] cmds = new Command[]{
            new CommandServerSay(),
            new CommandServerTell(),
            new CommandServerTp(),
            new CommandHelp()
        };
        return cmds;
    }
}
