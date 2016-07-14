package com.allenliu.alog;

import android.util.Log;

import java.sql.Types;

import static com.allenliu.alog.LogType.D;

/**
 * Created by Allen Liu on 2016/7/14.
 */
public class ALog {
    public  static boolean allowV=true;
    public  static  boolean allowD=true;
    public  static  boolean allowI=true;
    public static  boolean allowE=true;
    public static boolean allowW=true;
    public static boolean isDebug=true;
    public static String defaultMsg="";

     public static void v(){
         if(allowV)
             addLog(LogType.V,null,defaultMsg);
     }
    public static void v(Object msg){
        if(allowV)
            addLog(LogType.V,null,msg);
    }
    public static void v(String tag,Object msg){
        if(allowV)
            addLog(LogType.V,tag,msg);
    }

    public static void d(){
        if(allowD)
            addLog(LogType.D,null,defaultMsg);
    }
    public static void d(Object msg){
        if(allowD)
            addLog(LogType.D,null,msg);
    }
    public static void d(String tag,Object msg){
        if(allowD)
            addLog(LogType.D,tag,msg);
    }
    public static void i(){
        if(allowI)
            addLog(LogType.I,null,defaultMsg);
    }
    public static void i(Object msg){
        if(allowI)
            addLog(LogType.I,null,msg);
    }
    public static void i(String tag,Object msg){
        if(allowI)
            addLog(LogType.I,tag,msg);
    }
    public static void e(){
        if(allowE)
            addLog(LogType.E,null,defaultMsg);
    }
    public static void e(Object msg){
        if(allowE)
            addLog(LogType.E,null,msg);
    }
    public static void e(String tag,Object msg){
        if(allowE)
            addLog(LogType.E,tag,msg);
    }
    public static void w(){
        if(allowW)
            addLog(LogType.W,null,defaultMsg);
    }
    public static void w(Object msg){
        if(allowW)
            addLog(LogType.W,null,msg);
    }
    public static void w(String tag,Object msg){
        if(allowW)
            addLog(LogType.W,tag,msg);
    }






    private static void addLog(LogType type,String tag,Object msg){
        if(!isDebug)
            return;
        StackTraceElement[]stackTraceElements=Thread.currentThread().getStackTrace();
        int index=4;
        String className=stackTraceElements[index].getClassName();
        String methodName=stackTraceElements[index].getMethodName();
        int lineNumer=stackTraceElements[index].getLineNumber();
        if(msg ==null){
            msg="tagMsg is null";
        }else{
            msg=msg.toString();
        }
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("{").append(className).append("}[").append(methodName).append("](").append(lineNumer).append("):");
        if(msg!=null)
            stringBuilder.append(msg);
        tag=tag==null?className:tag;
        String logMsg=stringBuilder.toString();
        switch (type) {
            case D:
                Log.d(tag,logMsg);
                break;
            case E:
                Log.e(tag,logMsg);
                break;
            case I:
                Log.i(tag,logMsg);
                break;
            case V:
                Log.v(tag,logMsg);
                break;
            case W:
                Log.w(tag,logMsg);
                break;

        }
    }
}
