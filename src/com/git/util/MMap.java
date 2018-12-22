package com.git.util;

import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * <p>Title: Web业务系统</p>
 * <p>Description: 配合自动BLS的Map类，暂不支持Remove方法</p>
 * <p>Company: git</p>
 * @author lujun
 * @version 1.0
 */
public class MMap {
    /** 数据的容器 Map Vector */
    private HashMap mapV = null;

    /** 排序的容器 Map Order */
    private HashMap mapO = null;

    private int mRepeatCount = 0;  //未解决put方法引起的索引冲突问题，增加本字段用来记录重复次数

    /**
     * 构造函数
     */
    public MMap() {
        mapV = new HashMap();
        mapO = new HashMap();
    }

    /**
     * 建立键－值对，序号从1开始
     * 增加了对象索引冲突的处理：
     * 1、对象是String，在字符串末添加与重复次数等量的空格，生成新的String对象
     * 2、对象是Schema，用clone得到的对象替换原对象
     * 3、对象是SchemaSet，生成新的SchemaSet对象，并将原SchemaSet中的Schema存储到新SchemaSet
     * @param key Object
     * @param value Object
     */
    public void put(Object key, Object value) {
        if (key == null || value == null)
            return;
        if(mapV.containsKey(key)){
            mRepeatCount++;  //记录key重复的次数
            String className = key.getClass().getName();

            if(className.endsWith("String")){

                String keyStr = (String)key;
                for(int i = 0; i < mRepeatCount; i++){
                    keyStr += " ";
                }
                key = keyStr;
            }            
        }
        mapV.put(key, value);
        mapO.put(String.valueOf(mapV.size()), key);
    }
    
    /**
     * 获取键－值Set
     * @return Set
     */
    public Set keySet() {
        return mapV.keySet();
    }

    /**
     * 根据键获取值
     * @param key Object
     * @return Object
     */
    public Object get(Object key) {
        return mapV.get(key);
    }

    /**
     * 获取排序Map
     * @return HashMap
     */
    public HashMap getOrder() {
        return mapO;
    }

    /**
     * 通过序号获取键，序号即插入顺序，从1开始
     * @param order String
     * @return Object
     */
    public Object getKeyByOrder(String order) {
        return mapO.get(order);
    }

    /**
     * 添加一个MMap
     * @param srcMap MMap
     */
    public void add(MMap srcMap) {
        if (srcMap == null)
            return;
        for (int i = 0; i < srcMap.keySet().size(); i++) {
            Object key = srcMap.getKeyByOrder(String.valueOf(i + 1));
            this.put(key, srcMap.get(key));
        }
    }

    /**
     * 根据类名获取对象
     * @param cObjectName String
     * @param cStartPos int
     * @return Object
     */
    public Object getObjectByObjectName(String cObjectName, int cStartPos) {
        int i = 0, iMax = 0;
        String tStr1 = "", tStr2 = "";
        Object tReturn = null;
        if (cStartPos < 0) {
            cStartPos = 0;
        }
        iMax = this.keySet().size();
        try {
            for (i = cStartPos; i < iMax; i++) {
                if (this.getOrder().get(String.valueOf(i + 1)) == null) {
                    continue;
                }
                tStr1 = this.getOrder().get(String.valueOf(i + 1)).getClass().getName().
                        toUpperCase();
                tStr2 = cObjectName.toUpperCase();
                if (tStr1.equals(tStr2) ||
                    this.getLastWord(tStr1, ".").equals(tStr2)) {
                    tReturn = this.getOrder().get(String.valueOf(i + 1));
                    break;
                }
            }
        } catch (Exception ex) {
            tReturn = null;
        }
        return tReturn;
    }

    /**
     * 根据类名获取所有对象
     * @param cObjectName String
     * @param cStartPos int
     * @return Object
     */
    public Object[] getAllObjectByObjectName(String cObjectName, int cStartPos)
    {
        int i = 0, iMax = 0;
        String tStr1 = "", tStr2 = "";
        ArrayList tReturn = new ArrayList();
        if (cStartPos < 0) {
            cStartPos = 0;
        }
        iMax = this.keySet().size();
        try {
            for (i = cStartPos; i < iMax; i++) {
                if (this.getOrder().get(String.valueOf(i + 1)) == null) {
                    continue;
                }
                tStr1 = this.getOrder().get(String.valueOf(i + 1)).getClass().getName().
                        toUpperCase();
                tStr2 = cObjectName.toUpperCase();
                if (tStr1.equals(tStr2) ||
                    this.getLastWord(tStr1, ".").equals(tStr2)) {
                    tReturn.add(this.getOrder().get(String.valueOf(i + 1)));
                }
            }
        } catch (Exception ex) {
            tReturn = null;
        }
        return tReturn.toArray();

    }

    //得到字符串中的最后一个以splitChar分割的单词
    public String getLastWord(String cStr, String splitStr) {
        String tReturn;
        int tIndex = -1, tIndexOld = -1;
        tReturn = cStr;
        try {
            while (true) {
                tIndex = tReturn.indexOf(splitStr, tIndex + 1);
                if (tIndex > 0) {
                    tIndexOld = tIndex;
                } else {
                    break;
                }
            }
            if (tIndexOld > 0) {
                tReturn = cStr.substring(tIndexOld + 1, cStr.length());
            } else {
                tReturn = cStr;
            }
        } catch (Exception ex) {
            tReturn = "";
        }
        return tReturn;
    }

    public int size() {
        return this.keySet().size();
    }

    public static void main(String[] args) {
        MMap amap = new MMap();
        amap.put("key1", "value1");
        amap.put("key2", "value2");
        String a = (String) amap.getKeyByOrder("1");
        System.out.println("a" + a);
        System.out.println("size" + amap.size());
        MMap bmap = new MMap();
        bmap.put("keyb1", "valueb1");
        bmap.put("keyb2", "valueb2");
        amap.add(bmap);
        System.out.println("keyb1=======" + amap.get("keyb1"));
        
        System.out.println("size" + amap.size());
        for (int i = 0; i < amap.keySet().size(); i++)
        {
            Object key = amap.getKeyByOrder(String.valueOf(i + 1));
            System.out.println(String.valueOf(key)+"="+amap.get(key).toString());
       }
   }
}
