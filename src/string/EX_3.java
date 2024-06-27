package string;

import java.util.*;

public class EX_3 {

    public static void main(String[] args) {
        System.out.println();
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        Map<Integer, String> subStringHashMap = new HashMap<>();

        int subStringsCounter = 0;

        String biggestSubstring = "";

        for (int i = 0; i < s.length(); i++) {

            if (!subStringHashMap.containsKey(subStringsCounter)) {

                subStringHashMap.put(subStringsCounter, String.valueOf(s.charAt(i)));

                String charsList = subStringHashMap.get(subStringsCounter);

                if (biggestSubstring.length() < charsList.length()) {
                    biggestSubstring = charsList;
                }

                continue;
            }

            String charsList = subStringHashMap.get(subStringsCounter);

            if (!charsList.contains(String.valueOf(s.charAt(i)))) {

                charsList += s.charAt(i);

                subStringHashMap.put(subStringsCounter, charsList);

                if (biggestSubstring.length() < charsList.length()) {
                    biggestSubstring = charsList;
                }

                continue;
            }

            subStringsCounter++;

            int indexOfRepeatedChar = charsList.indexOf(s.charAt(i));

            String newCharList = charsList.substring(indexOfRepeatedChar + 1) + s.charAt(i);

            subStringHashMap.put(subStringsCounter, newCharList);

            if (biggestSubstring.length() < newCharList.length()) {
                biggestSubstring = newCharList;
            }
        }

        return biggestSubstring.length();
    }


    public static int lengthOfLongestSubstringImproved(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> charIndexMap = new HashMap<>();

        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            if (charIndexMap.containsKey(currentChar)) {
                start = charIndexMap.get(currentChar) + 1;
            }

            charIndexMap.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

}
