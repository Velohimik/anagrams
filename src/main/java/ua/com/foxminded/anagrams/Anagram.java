package ua.com.foxminded.anagrams;

import com.google.common.annotations.*;

public class Anagram {
    
    /*
     * This method divide input sentence to words and then reverse them using
     * reverseWord method and join into new sentence.
     */
    public String makeAnagrams(String inputSentence) {
        final String WORD_DELIMITER_REGEXP = "(?=[\\n\\r\\t\\u0020])";
        String[] inputWords = inputSentence.split(WORD_DELIMITER_REGEXP, -1);
        String[] outputWords = new String[inputWords.length];
        
        for (int i = 0; i < inputWords.length; i++) {
            outputWords[i] = reverseWord(inputWords[i]).toString();
        }
        
        return String.join("", outputWords);
    }
    
    /*
     * In this method input word will be reversed. For this I create StringBuilder
     * for result string. Then begin to iterate character positions in the string
     * step-by-step in the loop. Each character is check is it a letter? If "no",
     * add it to new result string in current position. If "yes", search
     * step-by-step the letter character in the end of the string and add it to
     * result string. Result of method work is returned reversed string.
     */
    @VisibleForTesting
    StringBuilder reverseWord(String word) {
        StringBuilder reversedWord = new StringBuilder();
        int endIndex = word.length() - 1;
        
        for (int startIndex = 0; startIndex < word.length(); startIndex++) {
            if (Character.isLetter(word.charAt(startIndex))) {
                while (!Character.isLetter(word.charAt(endIndex))) {
                    endIndex--;
                }
                reversedWord.append(word.charAt(endIndex--));
            } else {
                reversedWord.append(word.charAt(startIndex));
            }
        }
        
        return reversedWord;
    }
}