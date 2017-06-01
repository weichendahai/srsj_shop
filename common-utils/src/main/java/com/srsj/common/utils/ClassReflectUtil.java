package com.srsj.common.utils;

import java.lang.reflect.Field;

/**
 * Created by weichen on 2017/6/1.
 */
public class ClassReflectUtil {
    /**
     * 根据类名反射创建对象
     *
     * @param name 类名
     * @return 对象
     * @throws Exception
     */
    public static Object getInstance(String name) throws Exception {
        Class<?> cls = Class.forName(name);
        return cls.newInstance();
    }

    /**
     *
     * @param obj 访问对象
     * @param filedname 对象的属性
     * @return 返回对象的属性值
     */
    public static Object getFieldValue(Object obj, String filedname) {
        Class<?> cls = obj.getClass();
        Object val = null;
        Field field = null;
        try {
            field = cls.getDeclaredField(filedname);
            field.setAccessible(true);
            val = field.get(obj);
        } catch (Exception e) {
        }
        return val;
    }

    /**
     *
     * @param obj 访问对象
     * @param filedname 对象的属性
     * @return 返回对象的属性值
     * @throws Exception
     */
    public static Object setIdKeyValue(Object obj, String filedname,
                                       String value) throws Exception {
        Class<?> cls = obj.getClass();
        Field field = null;
        try {
            field = cls.getDeclaredField(filedname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (field == null) {
            return null;
        }
        field.setAccessible(true);
        if (!field.getType().getName().contains("Integer")) {
            field.set(obj, value);
        }
        Object val = field.get(obj);
        field.setAccessible(false);
        return val;
    }

    /**
     *
     * @param obj 访问对象
     * @param filedname 对象的属性
     * @return 返回对象的属性值
     * @throws Exception
     */
    public static Object setFieldValue(Object obj, String filedname,
                                       String value) throws Exception {
        Class<?> cls = obj.getClass();
        Field field = null;
        try {
            field = cls.getDeclaredField(filedname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (field == null) {
            return null;
        }
        field.setAccessible(true);
        Object val = field.get(obj);
        field.setAccessible(false);
        return val;
    }
}
