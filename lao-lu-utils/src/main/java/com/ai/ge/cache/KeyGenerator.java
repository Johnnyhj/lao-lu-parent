package com.ai.ge.cache;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class KeyGenerator
{

    /**
     * 把对象封装为Key格式
     * 
     * @param o
     *            对象
     * @return Key格式
     */
    public static String keyGenerator(final Object o)
    {
        if (o == null) { return "null"; }
        if (o instanceof String) // String
        { return string2Key((String) o); }
        if (o instanceof Boolean) // Boolean
        { return boolean2Key((Boolean) o); }
        if (o instanceof Number) // Number
        { return number2Key((Number) o); }
        if (o instanceof Map) // Map
        { return map2Key((Map<String, Object>) o); }
        if (o instanceof Collection) // List Set
        { return collection2Key((Collection) o); }
        if (o instanceof Object[]) // 对象数组
        { return array2Key((Object[]) o); }
        if (o instanceof int[])// 基本类型数组
        { return intArray2Key((int[]) o); }
        if (o instanceof boolean[])// 基本类型数组
        { return booleanArray2Key((boolean[]) o); }
        if (o instanceof long[])// 基本类型数组
        { return longArray2Key((long[]) o); }
        if (o instanceof float[])// 基本类型数组
        { return floatArray2Key((float[]) o); }
        if (o instanceof double[])// 基本类型数组
        { return doubleArray2Key((double[]) o); }
        if (o instanceof short[])// 基本类型数组
        { return shortArray2Key((short[]) o); }
        if (o instanceof byte[])// 基本类型数组
        { return byteArray2Key((byte[]) o); }
        if (o instanceof Object) // 保底收尾对象
        { return object2Key(o); }

        throw new RuntimeException("不支持的类型: " + o.getClass().getName());
    }

    /**
     * 将 String 对象编码为 Key格式，只需处理好特殊字符
     * 
     * @param s
     *            String 对象
     * @return Key格式
     */
    private static String string2Key(final String s)
    {
        return "_" + s.toString() + ":";
    }

    /**
     * 将 Number 表示为 Key格式
     * 
     * @param number
     *            Number
     * @return Key格式
     */
    private static String number2Key(final Number number)
    {
        return "_" + number.toString() + ":";
    }

    /**
     * 将 Boolean 表示为 Key格式
     * 
     * @param bool
     *            Boolean
     * @return Key格式
     */
    private static String boolean2Key(final Boolean bool)
    {
        return "_" + bool.toString() + ":";
    }

    /**
     * 将 Collection 编码为 Key 格式 (List,Set)
     * 
     * @param c
     * @return
     */
    private static String collection2Key(final Collection<Object> c)
    {
        final Object[] arrObj = c.toArray();
        return keyGenerator(arrObj);
    }

    /**
     * 将 Map<String, Object> 编码为 Key 格式
     * 
     * @param map
     * @return
     */
    private static String map2Key(final Map<String, Object> map)
    {
        if (map.isEmpty()) { return "M__"; }
        final StringBuffer sb = new StringBuffer();
        final Set<String> keys = map.keySet();
        for (final String key : keys)
        {
            final Object value = map.get(key);
            if (null == value)
            {
                continue;
            }
            sb.append(key); // 不能包含特殊字符
            sb.append('_');
            sb.append(keyGenerator(value)); // 循环引用的对象会引发无限递归
        }
        return sb.toString();
    }

    /**
     * 将数组编码为 Key 格式
     * 
     * @param array
     *            数组
     * @return Key 格式
     */
    private static String array2Key(final Object[] array)
    {
        if (array.length == 0) { return "A__"; }
        final StringBuffer sb = new StringBuffer();
        for (final Object o : array)
        {
            sb.append(keyGenerator(o));
        }
        return sb.toString();
    }

    private static String intArray2Key(final int[] array)
    {
        if (array.length == 0) { return "A__"; }
        final StringBuffer sb = new StringBuffer();
        for (final int o : array)
        {
            sb.append(Integer.toString(o));
        }
        return "_" + sb.toString() + ":";
    }

    private static String longArray2Key(final long[] array)
    {
        if (array.length == 0) { return "A__"; }
        final StringBuffer sb = new StringBuffer();
        for (final long o : array)
        {
            sb.append(Long.toString(o));
        }
        return "_" + sb.toString() + ":";
    }

    private static String booleanArray2Key(final boolean[] array)
    {
        if (array.length == 0) { return "A__"; }
        final StringBuffer sb = new StringBuffer();
        for (final boolean o : array)
        {
            sb.append(Boolean.toString(o));
        }
        return "_" + sb.toString() + ":";
    }

    private static String floatArray2Key(final float[] array)
    {
        if (array.length == 0) { return "A__"; }
        final StringBuffer sb = new StringBuffer();
        for (final float o : array)
        {
            sb.append(Float.toString(o));
        }
        return "_" + sb.toString() + ":_";
    }

    private static String doubleArray2Key(final double[] array)
    {
        if (array.length == 0) { return "A__"; }
        final StringBuffer sb = new StringBuffer();
        for (final double o : array)
        {
            sb.append(Double.toString(o));
        }
        // set last ',' to ']':
        return "_" + sb.toString() + ":";
    }

    private static String shortArray2Key(final short[] array)
    {
        if (array.length == 0) { return "A__"; }
        final StringBuffer sb = new StringBuffer();
        for (final short o : array)
        {
            sb.append(Short.toString(o));
        }
        // set last ',' to ']':
        return "_" + sb.toString() + ":";
    }

    private static String byteArray2Key(final byte[] array)
    {
        if (array.length == 0) { return "A__"; }
        final StringBuffer sb = new StringBuffer();
        for (final byte o : array)
        {
            sb.append(Byte.toString(o));
        }
        // set last ',' to ']':
        return "_" + sb.toString() + ":";
    }

    private static String object2Key(final Object bean)
    {
        // 数据检查
        if (bean == null) { return "O__"; }
        final Method[] methods = bean.getClass().getMethods(); // 方法数组
        final StringBuffer sb = new StringBuffer();

        for (final Method method : methods)
        {
            try
            {
                final String name = method.getName();
                String key = "";
                if (name.startsWith("get"))
                {
                    key = name.substring(3);

                    // 防死循环
                    final String[] arrs =
                    { "Class", "AllCriteria" };
                    boolean bl = false;
                    for (final String s : arrs)
                    {
                        if (s.equals(key))
                        {
                            bl = true;
                            continue;
                        }
                    }
                    if (bl)
                    {
                        continue; // 防死循环
                    }
                }
                else if (name.startsWith("is"))
                {
                    key = name.substring(2);
                }
                if (key.length() > 0 && Character.isUpperCase(key.charAt(0)) && method.getParameterTypes().length == 0)
                {
                    if (key.length() == 1)
                    {
                        key = key.toLowerCase();
                    }
                    else if (!Character.isUpperCase(key.charAt(1)))
                    {
                        key = key.substring(0, 1).toLowerCase() + key.substring(1);
                    }
                    final Object elementObj = method.invoke(bean);

                    if (null == elementObj)
                    {
                        continue;
                    }
                    else if ("".equals(elementObj))
                    {
                        continue;
                    }
                    else if (elementObj instanceof Boolean && String.valueOf(elementObj).equals("false"))
                    {
                        continue;
                    }
                    // System.out.println("###" + key + ":" +
                    // elementObj.toString());

                    sb.append(key); // 不能包含特殊字符
                    sb.append('_');
                    sb.append(keyGenerator(elementObj)); // 循环引用的对象会引发无限递归
                }
            }
            catch (final Exception e)
            {
                // e.getMessage();
                throw new RuntimeException("在将bean封装成Key格式时异常：" + e.getMessage(), e);
            }
        }
        if (sb.length() == 1)
        {
            return bean.toString();
        }
        else
        {
            return sb.toString();
        }
    }

}
