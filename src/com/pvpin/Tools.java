package com.pvpin;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.plugin.PluginManager;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
public class Tools {
  private static PluginManager PluginManager;
  private static Load plugin;
  public static void setPlugin(Load pl){
      PluginManager = pl.getProxy().getPluginManager();
      plugin = pl;
  }
  public static Load getPlugin(){
      return plugin;
  }
  public static PluginManager getPluginManager(){
      return PluginManager;
  }
  public static void registerCommand(Command cmd){
      getPluginManager().registerCommand(plugin,cmd);
  }
  public static void registerCommand(Command[] cmds){
      for (Command cmd : cmds){
          registerCommand(cmd);
      }
  }
  public static void registerListener(Listener listener){
      getPluginManager().registerListener(plugin,listener);
  }
  public static void registerListener(Listener[] listeners){
      for (Listener listener : listeners){
          registerListener(listener);
      }
  }
  public static Object[] find(String find_) {
    Object[] ret = new Object[]{
        null,//Player
        null,//Server
        false//is Online
    };
    if (!"".equals(find_)) {
      ProxiedPlayer player = ProxyServer.getInstance().getPlayer(find_);
      Server ser = null;
      if (player != null){
          ser = player.getServer();
      }
      ret = new Object[]{
        player,
        ser,
        false
      };
      if ((player == null) || (player.getServer() == null)) {
        //sender.sendMessage(ChatColor.RED + "That user is not online");
      } else {
        //sender.sendMessage(ChatColor.GREEN + args[0] + " is online at " + player.getServer().getInfo().getName());
        ret = new Object[]{
            player,
            player.getServer(),
            true
        };
      }
    }
    return ret;
  }
  public static String join(String[] strings,String mr){
      String ret = "";
      for (String str : strings){
          if (!"".equals(ret)){
              ret += mr;
          }
          ret += str;
      }
      return ret;
  }
  public static String join(String[] strings){
      return join(strings," ");
  }
  public static String[] kot(String[] array,int at1 ,int at2){
      String str = "";
      for (int i = at1;i<= at2;i++){
          if (!"".equals(str)){
              str += " ";
          }
          str+= array[i];
      }
      String[] ret = str.split(" ");
      return ret;
  }
  public static int indexOf(String string,String in){
      String[] a = in.split(string);
      return a.length - 1;
  }
  public static Boolean onlyOf(String find,String only){
      Boolean ret = true;
      String[] findd = find.split("");
      for (String i : findd){
          if (indexOf(i,only) == 0){
              ret = false;
          }
      }
      return ret;
  }
  public static Boolean onlyOf(String find){
      return onlyOf(find,"1234567890-_-BUGINVSPVPIN qazwsxedcrfvtgbyhnujmikloop CCTV MineCraft QPWOEIRUTYGHFJDKSLAZMXNCBV");
  }
}
