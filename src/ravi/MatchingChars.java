package ravi;

import java.util.*;

public class MatchingChars {
    public static void main(String[] args) {
        String str1 = "Ronaldo";
        String str2 = "Romario";

        System.out.println(getMatchingCharsN(str1.toLowerCase().toCharArray(), str2.toLowerCase().toCharArray()));
    }

    //complexity: O(n^2 + 1 + n) = O(n^2)
    private static String getMatchingCharsNSquare(char[] a, char[] b) {
        Set<Character> characterSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    characterSet.add(a[i]);
                }
            }
        }

        for (Character character : characterSet) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

    //complexity: O(n + n + n) = O(n)
    private static String getMatchingCharsN(char[] a, char[] b) {
        Map<Character, Integer> characterMap1 = new HashMap<>();
        Map<Character, Integer> characterMap2 = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < a.length; i++) {
            characterMap1.putIfAbsent(a[i], (int) a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            characterMap2.putIfAbsent(b[i], (int) b[i]);
        }

        for (Character character: characterMap1.keySet()) {
            if (characterMap2.containsKey(character)) {
                stringBuilder.append(character);
            }
        }

        return stringBuilder.toString();
    }
}
