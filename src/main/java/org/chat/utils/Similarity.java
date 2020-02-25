package org.chat.utils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zzp
 * @date 2020/2/25
 */
public class Similarity {

    public static double vsm(Map<String,Double> d1, Map<String,Double> d2){

        double similar = 0, molecule = 0.0;
        Set<String> k1 = d1.keySet();
        Set<String> k2 = d2.keySet();

        Set<String> both= new HashSet<>();
        both.addAll(k1);
        // 求交集，避免从map取出元素相乘null异常
        both.retainAll(k2);
        // 计算分子
        for(String s : both){
            molecule += d1.get(s) * d2.get(s);
        }
        // 计算分母
        double edge1s = 0.0;
        for(String s : k1)
            edge1s += Math.pow(d1.get(s),2);
        double edge2s = 0.0;
        for(String s : k2)
            edge2s += Math.pow(d2.get(s),2);

        similar = molecule / Math.sqrt(edge1s * edge2s);
        return similar;
    }




}
