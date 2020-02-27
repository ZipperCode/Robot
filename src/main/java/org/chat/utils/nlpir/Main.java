package org.chat.utils.nlpir;

import org.chat.utils.Similarity;
import org.chat.utils.StringUtils;

import java.util.Map;

/**
 * @author zzp
 * @date 2020/2/25
 */
public class Main {
    public static void main(String[] args) {
        Nlpir nlpir = new Nlpir();
        String string1 = nlpir.wordFreqStat("你好,我是张志鹏");
        String string2 = nlpir.wordFreqStat("你是张志鹏吗");
        System.out.println(string1);
        Map<String, Double> stringDoubleMap1 = StringUtils.wordFrequency(string1);
        Map<String, Double> stringDoubleMap2 = StringUtils.wordFrequency(string2);

        double vsm = Similarity.vsm(stringDoubleMap1, stringDoubleMap2);
        System.out.println(vsm);

        System.out.println(nlpir.getKeyWords("你好，我是张志鹏，请问你那儿有XX吗",100,false));
        nlpir.exit();

    }
}
