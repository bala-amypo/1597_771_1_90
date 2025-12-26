package com.example.demo.util;

/**
 * Utility class for text similarity calculation.
 * Used by DuplicateDetectionService for SIMILARITY rules.
 */
public class TextSimilarityUtil {

    private TextSimilarityUtil() {
        // utility class
    }

    /**
     * Returns a similarity score between 0.0 and 1.0
     */
    public static double similarity(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0.0;
        }

        text1 = text1.toLowerCase();
        text2 = text2.toLowerCase();

        if (text1.equals(text2)) {
            return 1.0;
        }

        // Simple fallback similarity
        int maxLength = Math.max(text1.length(), text2.length());
        int minLength = Math.min(text1.length(), text2.length());

        return maxLength == 0 ? 1.0 : (double) minLength / maxLength;
    }
}
