package net.gyhhy.login;
import java.io.File;
import com.pvpin.Load;
import com.pvpin.Tools;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine; 
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;  
import java.io.FileInputStream;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.RandomAccessFile;  
import java.io.Reader;
import java.io.FileWriter;  
import java.io.RandomAccessFile;  
public class LoginTool {
    private static ScriptEngine scriptEngine;
    private static ScriptEngineManager scriptEngineManager;
    private static File fe;
    private static File lc;
    private static Load plugin;
    public static void Start(Load pl){
        plugin = pl;
        fe = pl.getDataFolder();
        if (fe.exists() && fe.isDirectory()){
            fe.delete();
        }
        if (!fe.exists()){
            fe.mkdirs();
        }
        lc = new File(fe,"Password.json");
        if (!lc.isFile()){
            if(lc.exists())lc.delete();
            try {
                lc.createNewFile();
            } catch (IOException ex) {}
        }
        
        scriptEngineManager = new ScriptEngineManager();
        scriptEngine = scriptEngineManager.getEngineByName("javascript");
        try {
            eval("LoginTool = Packages.net.gyhhy.login.LoginTool");
            eval("Tool = Packages.com.pvpin.Tools");
            String sav = readFileByChars(getFile());
            if (sav.replaceAll(" ", "").replaceAll("\n","") == ""){
                sav = "{}";
            }
            eval("Password = "+sav);
            eval("isLogin = {}");
        } catch (ScriptException ex) {
            Logger.getLogger(LoginTool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Boolean isRegister(String player){
        Boolean ret = false;
        try {
            ret = (Boolean)LoginTool.eval("Password['"+player+"'] != undefined");
        } catch (ScriptException ex) {}
        return ret;
    }
    public static Boolean isLogin(String player){
        Boolean ret = false;
        try {
            ret = (Boolean)LoginTool.eval("isLogin['"+player+"'] == true");
        } catch (ScriptException ex) {}
        return ret;
    }
    public static Object eval(String js) throws ScriptException{
        return scriptEngine.eval(js);
    }
    public static Object eval(String[] js) throws ScriptException{
        return scriptEngine.eval(Tools.join(js,"\n"));
    }
    public static void setPassword(String player,String Password){
        
    }
    public static String readFileByChars(File file) {
        Reader reader = null;
        String str = "";
        try {
            reader = new InputStreamReader(new FileInputStream(file));  
            int tempchar;  
            while ((tempchar = reader.read()) != -1) {  
                str += (char)tempchar;
            }  
            reader.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        if (reader != null) {  
            try {  
                reader.close();  
            } catch (IOException e1) {}  
        }
        return str;
    }
    public static void saveFile(File fe, String content) {  
        try { 
            FileWriter writer = new FileWriter(fe);  
            writer.write(content);  
            writer.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
    public static void saveFile(String se){
        saveFile(getFile(),se);
    }
    public static File getFile(){
        return lc;
    }
}
