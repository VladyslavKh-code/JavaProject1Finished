package comcrypto.transformer;

import java.util.HashMap;
import java.util.Map;

public class TextTransformer {

    public String moveLetterOnRightPositions(int pos, String text) { // used to shift text
        Map<Character, Character> alphabet = prepareAlphabet(pos, 1); // get map with mode 1(that means shifting to the right side)
        return transformText(alphabet, text);
    }

    public String moveLetterOnLeftPositions(int pos, String text) { // used to decrypt text
        Map<Character, Character> alphabet = prepareAlphabet(pos, 0); // get map with mode 0(that means shifting to he left side)
        return transformText(alphabet, text);
    }

    private Map<Character, Character> prepareAlphabet(int move, int mode) {
        int shift;
        if (mode == 1) {
            shift = move; // used to create a shift in the right direction
        } else {
            shift = -move; // used to create a shift in the left direction
        }

        Map<Character, Character> Letters = new HashMap<>();
        for (char s = 'A'; s <= 'Z'; s++) {
            char shiftedS = (char) ('A' + (s - 'A' + shift + 26) % 26); // with formula for Сaesar's cipher for UpperCase
            Letters.put(s, shiftedS);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            char shiftedC = (char) ('a' + (c - 'a' + shift + 26) % 26); // with formula for Сaesar's cipher for LowerCase
            Letters.put(c, shiftedC);
        }
        return Letters;
    }

    private String transformText(Map<Character, Character> alphabet, String text) { //fucntion that returns transformed text
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : text.toCharArray()) { // going through each symbol
            char shiftedS = alphabet.getOrDefault(c, c); // store the value into the char
            stringBuilder.append(shiftedS); // add each symbol into the StringBuilder
        }
        String result = stringBuilder.toString(); // convert from StringBuilder to String
        return result;
    }

}

