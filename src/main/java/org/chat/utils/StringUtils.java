package org.chat.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zzp
 * @date 2020/2/25
 */
public class StringUtils {

    public static Map<String,Double> wordFrequency(String text){
        String[] words = text.split("#");
        Map<String,Double> result = new HashMap<>();

        Arrays.stream(words).forEach(e -> {
            String s = e.replaceAll("/\\w+/", " ");
            String[] split = s.split(" ");
            result.put(split[0],Double.valueOf(split[1]));
        });

        System.out.println(result);
        return result;
    }
}
