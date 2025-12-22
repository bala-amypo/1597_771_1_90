package com.example.demo.util;

public class TextSimilarityUtil {

    public static double similarity(String text1, String text2) {

        if (text1 == null || text2 == null) {
            return 0.0;
        }

        text1 = text1.toLowerCase();
        text2 = text2.toLowerCase();

        String[] words1 = text1.split("\\s+");
        String[] words2 = text2.split("\\s+");

        int common = 0;

        for (String w1 : words1) {
            for (String w2 : words2) {
                if (w1.equals(w2)) {
                    common++;
                    break;
                }
            }
        }

        int total = Math.max(words1.length, words2.length);
        return total == 0 ? 0.0 : (double) common / total;
    }
}
