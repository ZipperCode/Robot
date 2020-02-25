package org.chat.utils.nlpir;

import org.chat.utils.Similarity;
import org.chat.utils.StringUtils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zzp
 * @date 2020/2/25
 */
public class Main {
    public static void main(String[] args) {

        String string1 = NLPIR.wordFreqStat("你好,我是张志鹏");
        String string2 = NLPIR.wordFreqStat("你是张志鹏吗");
        Map<String, Double> stringDoubleMap1 = StringUtils.wordFrequency(string1);
        Map<String, Double> stringDoubleMap2 = StringUtils.wordFrequency(string2);

        double vsm = Similarity.vsm(stringDoubleMap1, stringDoubleMap2);
        System.out.println(vsm);

        System.out.println(NLPIR.getKeyWords("我是张志鹏",100,false));
        NLPIR.exit();

    }
}
