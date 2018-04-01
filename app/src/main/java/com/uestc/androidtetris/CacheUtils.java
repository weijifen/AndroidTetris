package com.uestc.androidtetris;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;
import java.util.Set;

/**
 * 缓存
 * Created by Lucky_Xiao on 2016/7/8.
 * SharedPreferences的简单封装
 */
public class CacheUtils {
    String fileName;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public CacheUtils(Context context, String fileName)//fileName是缓存的唯一标识
    {
        this.fileName=fileName;
//        数据只能被本应用程序读写
        preferences=context.getSharedPreferences(this.fileName,Context.MODE_PRIVATE);
        editor=preferences.edit();
    }

    /**
     * 向Cache存入指定key对应的数据
     * 其中value可以是String、boolean、float、int、long等各种基本类型的值
     * @param key
     * @param value
     */
    public void putValue(String key,String value)
    {
        editor.putString(key,value);
//        提交所做的修改
        editor.commit();
    }
    public void putValue(String key,int value)
    {
        editor.putInt(key,value);
//        提交所做的修改
        editor.commit();
    }
    public void putValue(String key,List<String> value)
    {
        editor.putStringSet(key,(Set<String>) value);
//        提交所做的修改
        editor.commit();
    }
    /**
     * 向Cache存入指定key对应的数据
     * 其中value可以是String、boolean、float、int、long等各种基本类型的值
     * @param key
     * @param value
     */
    public void putValue(String key,boolean value)
    {
        editor.putBoolean(key,value);
//        提交所做的修改
        editor.commit();
    }

    /**
     * 获取Cache数据里指定key对应的value。如果key不存在，则返回默认值def。
     * @param key
     * @param def
     * @return
     */
    public String getValue(String key,String def)
    {
        return preferences.getString(key,def);
    }

    /**
     * 清空Cache里所有数据
     */
    public void clearCache()
    {
        editor.clear();
//        保存修改
        editor.commit();
    }
}
