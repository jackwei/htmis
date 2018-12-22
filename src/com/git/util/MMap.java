package com.git.util;

import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * <p>Title: Webҵ��ϵͳ</p>
 * <p>Description: ����Զ�BLS��Map�࣬�ݲ�֧��Remove����</p>
 * <p>Company: git</p>
 * @author lujun
 * @version 1.0
 */
public class MMap {
    /** ���ݵ����� Map Vector */
    private HashMap mapV = null;

    /** ��������� Map Order */
    private HashMap mapO = null;

    private int mRepeatCount = 0;  //δ���put���������������ͻ���⣬���ӱ��ֶ�������¼�ظ�����

    /**
     * ���캯��
     */
    public MMap() {
        mapV = new HashMap();
        mapO = new HashMap();
    }

    /**
     * ��������ֵ�ԣ���Ŵ�1��ʼ
     * �����˶���������ͻ�Ĵ���
     * 1��������String�����ַ���ĩ������ظ����������Ŀո������µ�String����
     * 2��������Schema����clone�õ��Ķ����滻ԭ����
     * 3��������SchemaSet�������µ�SchemaSet���󣬲���ԭSchemaSet�е�Schema�洢����SchemaSet
     * @param key Object
     * @param value Object
     */
    public void put(Object key, Object value) {
        if (key == null || value == null)
            return;
        if(mapV.containsKey(key)){
            mRepeatCount++;  //��¼key�ظ��Ĵ���
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
     * ��ȡ����ֵSet
     * @return Set
     */
    public Set keySet() {
        return mapV.keySet();
    }

    /**
     * ���ݼ���ȡֵ
     * @param key Object
     * @return Object
     */
    public Object get(Object key) {
        return mapV.get(key);
    }

    /**
     * ��ȡ����Map
     * @return HashMap
     */
    public HashMap getOrder() {
        return mapO;
    }

    /**
     * ͨ����Ż�ȡ������ż�����˳�򣬴�1��ʼ
     * @param order String
     * @return Object
     */
    public Object getKeyByOrder(String order) {
        return mapO.get(order);
    }

    /**
     * ���һ��MMap
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
     * ����������ȡ����
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
     * ����������ȡ���ж���
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

    //�õ��ַ����е����һ����splitChar�ָ�ĵ���
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
