package com.vincent.flytools;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 描述：反射工具类
 * 创建人：LWS
 * 创建时间: 2020/10/30
 */
public class ReflectTools {
    /**
     * 通过反射，用属性名称获得属性值
     *
     * @param thisClass 需要获取属性值的类
     * @param fieldName 该类的属性名称
     * @return
     */
    private Object getFieldValue(Object thisClass, String fieldName) {
        Object value = null;
        Method method = null;
        try {
            String methodName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            method = thisClass.getClass().getMethod("get" + methodName);
            value = method.invoke(thisClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


    /**
     * 通过反射，赋值
     *
     * @param thisClass 需要获取属性值的类
     * @param fieldName 该类的属性名称
     * @return
     */
    private void setFieldValue(Object thisClass, String fieldName, String value) {
        Method method = null;
        try {
            Field f = thisClass.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            f.set(thisClass, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
