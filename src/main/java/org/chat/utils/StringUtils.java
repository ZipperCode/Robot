package org.chat.utils;

import lombok.extern.log4j.Log4j2;
import org.chat.annotation.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.*;

/**
 * @author zzp
 * @date 2020/2/25
 */
public class StringUtils {

    private static final Logger log = LoggerFactory.getLogger(StringUtils.class);
    /**
     * 将NLPIR分词文本转化为map集合 分词:词频
     * @param text 分词文本
     * @return 词频集合
     */
    @Log
    public static Map<String,Double> wordFrequency(String text){
        log.info("拆分NLPIR分词结果");
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

    /**
     * 解析数据库中获取的分词权重 分词:权重
     * @param text 分词权重文本
     * @return 词权集合
     */
    @Log
    public static Map<String,Double> parseWordWeight(String text, String split, String separator){
        log.info("解析数据库问题分词结果");
        String[] wordSplits = text.split(split);
        Map<String,Double> result = new HashMap<>();
        Arrays.stream(wordSplits).forEach(e ->{
            String[] word = e.split(separator);
            result.put(word[0],Double.valueOf(word[1]));
        });
        System.out.println(result);
        return result;
    }

    public static Set<String> splitKeyword(String text){
        Set<String> keywords = new HashSet<>(Arrays.asList(text.split("#")));
        return keywords;
    }
}
