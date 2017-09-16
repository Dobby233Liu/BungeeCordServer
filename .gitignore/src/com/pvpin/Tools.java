package com.pvpin;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.plugin.PluginManager;
public class Tools {
  private static PluginManager PluginManager;
  public static void setPluginManager(PluginManager pm){
      PluginManager = pm;
  }
  public static PluginManager getPluginManager(){
      return PluginManager;
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
  };
}
