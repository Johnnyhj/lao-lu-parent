package com.ai.ge.util;


import java.util.Iterator;
import java.util.List;

/**
 * 数据结构转换工具类
 */
public class StructureTransitionUtil {
    /**
     * 列表数据转换成树形层级结构
     * @param listObjects
     * @param transformMatcher
     * @param <T>
     */
    public static <T> void listToTree(List<T> listObjects, TransformMatcher transformMatcher) {
        for (int i = 0; i < listObjects.size(); i++) {
            T parent = listObjects.get(i);
            for (int j = 0; j < listObjects.size(); j++) {
                T child = listObjects.get(j);

                transformMatcher.transform(parent, child);
            }
        }


        Iterator<T> iterator = listObjects.iterator();
        while (iterator.hasNext()) {
            T object = iterator.next();
            if (transformMatcher.remove(object)) {
                iterator.remove();
            }
        }
    }

    /**
     * 转换接口类
     * @param <T>
     */
    public interface TransformMatcher<T> {
        /**
         * 根据父子关系转换
         * @param parent
         * @param child
         */
        void transform(T parent, T child);

        /**
         * 满足删除条件后删除对象s
         * @param object
         * @return
         */
        boolean remove(T object);
    }

}
