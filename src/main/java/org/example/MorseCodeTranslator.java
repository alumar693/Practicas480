package org.example;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeTranslator {
    public static final Map<Character, String> TEXT_TO_MORSE = new HashMap<>();
    public static final Map<String, Character> MORSE_TO_TEXT = new HashMap<>();

    static {
        TEXT_TO_MORSE.put('A', ".-");
        TEXT_TO_MORSE.put('B', "-...");
        TEXT_TO_MORSE.put('C', "-.-.");
        TEXT_TO_MORSE.put('D', "-..");
        TEXT_TO_MORSE.put('E', ".");
        TEXT_TO_MORSE.put('F', "..-.");
        TEXT_TO_MORSE.put('G', "--.");
        TEXT_TO_MORSE.put('H', "....");
        TEXT_TO_MORSE.put('I', "..");
        TEXT_TO_MORSE.put('J', ".---");
        TEXT_TO_MORSE.put('K', "-.-");
        TEXT_TO_MORSE.put('L', ".-..");
        TEXT_TO_MORSE.put('M', "--");
        TEXT_TO_MORSE.put('N', "-.");
        TEXT_TO_MORSE.put('O', "---");
        TEXT_TO_MORSE.put('P', ".--.");
        TEXT_TO_MORSE.put('Q', "--.-");
        TEXT_TO_MORSE.put('R', ".-.");
        TEXT_TO_MORSE.put('S', "...");
        TEXT_TO_MORSE.put('T', "-");
        TEXT_TO_MORSE.put('U', "..-");
        TEXT_TO_MORSE.put('V', "...-");
        TEXT_TO_MORSE.put('W', ".--");
        TEXT_TO_MORSE.put('X', "-..-");
        TEXT_TO_MORSE.put('Y', "-.--");
        TEXT_TO_MORSE.put('Z', "--..");
        TEXT_TO_MORSE.put('0', "-----");
        TEXT_TO_MORSE.put('1', ".----");
        TEXT_TO_MORSE.put('2', "..---");
        TEXT_TO_MORSE.put('3', "...--");
        TEXT_TO_MORSE.put('4', "....-");
        TEXT_TO_MORSE.put('5', ".....");
        TEXT_TO_MORSE.put('6', "-....");
        TEXT_TO_MORSE.put('7', "--...");
        TEXT_TO_MORSE.put('8', "---..");
        TEXT_TO_MORSE.put('9', "----.");
        TEXT_TO_MORSE.put(' ', "/");

        TEXT_TO_MORSE.forEach((character, morse) -> MORSE_TO_TEXT.put(morse, character));
    }

    public static String text2Morse(String text) {
        StringBuilder morse = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (TEXT_TO_MORSE.containsKey(c)) {
                morse.append(MorseCodeTranslator.TEXT_TO_MORSE.get(c)).append(" ");
            }
        }
        return morse.toString().trim();
    }

    public static String morse2Text(String morse) {
        String[] characters = morse.split(" ");
        StringBuilder text = new StringBuilder();
        for (String character : characters) {
            if (MorseCodeTranslator.MORSE_TO_TEXT.containsKey(character)) {
                text.append(MorseCodeTranslator.MORSE_TO_TEXT.get(character));
            }
        }
        return text.toString().trim();
    }
}

