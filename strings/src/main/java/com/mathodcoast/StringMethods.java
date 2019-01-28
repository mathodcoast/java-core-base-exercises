package com.mathodcoast;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StringMethods {

    /**
    * This method compounds two strings to one, without first letters of them, end @returns the result.
    * */
    public static String concatTwoStringsWithoutFirstLetters(String str1,String str2) {
        return str1.substring(1) + str2.substring(1);
    }

    /**
     * This method cuts string with not even amount of symbols from both sides. If string is too short or amount of symbols is even,
     * you need to @return string "Too short string or amount of symbols is even"
     *
     * @param str - string with not even amount of symbols
     * @return string where amount of symbols is three.
    * */
    public static String cutNotEvenStringFromSides(String str) {
        if (str.length() < 5 || (str.length() % 2) == 0) {
            return "Too short string or amount of symbols is even";
        } else {
            int centreOfStringIndex = str.length() / 2;
            return str.substring(centreOfStringIndex - 1,centreOfStringIndex + 2);
        }
    }

    /**
     * This method transfers two last symbols of string to its beginning.
    * */
    public static String transferTwoLettersFromEndToBeginning(String str) {
        String twoLastLetters = str.substring(str.length() - 2);
        String stringWithoutTwoLastLetters = str.substring(0, str.length() - 2);
        return twoLastLetters + stringWithoutTwoLastLetters;
    }

    /**
     * This method creates and returns the string with double symbols of input string.
    * */
    public static String createDoublingCharacterString(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char strChar = str.charAt(i);
            result = result + strChar + strChar;
        }
        return result;
    }

    /**
     * This method creates and returns the string with double symbols of input string.
     * You need to implement it with Stream API.
    * */
    public static String createDoublingCharacterStringWithStream(String str) {
        Stream<String> stream = Stream.of(str);
        return stream.flatMapToInt(String::chars)
                .mapToObj(c -> String.valueOf((char)c))
                .map(s -> s + s + "")
                .collect(joining());
    }

    /**
     * This method excludes all space signs from
     * @param str is String
     * @return String without space signs
    * */
    public static String excludeAllSpaceSigns(String str) {
        return str.chars()
                .filter(c -> c != 32)
                .mapToObj(c -> (char) c)
                .map(character -> Character.toString(character))
                .collect(Collectors.joining());
    }

    /**
    * This method checks the string if it is a palindrome
     * @param str is a checking String
    * */
    public static boolean palindromeCheck(String str){
        StringBuilder string = new StringBuilder(str);
        return string.reverse().toString().equals(str);
    }
}
