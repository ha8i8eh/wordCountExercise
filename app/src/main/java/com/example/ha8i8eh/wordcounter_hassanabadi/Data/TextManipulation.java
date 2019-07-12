package com.example.ha8i8eh.wordcounter_hassanabadi.Data;

import java.util.HashMap;

public class TextManipulation {


    public static char TenthChar(Text text) {
        String textStr = text.getText();

        return textStr.charAt(9);
    }

    public static char[] AllTenthChar(Text text) {
        String textStr = text.getText();
        int textLength = (textStr.length() / 10);
        char[] AllTenthChar = new char[textLength];
        int index = 0;
        for (int i = 9; i < textStr.length(); i = i + 10) {

            AllTenthChar[index] = textStr.charAt(i);
            index++;
        }
        return AllTenthChar;
    }



    public static HashMap<String, Integer> WordsCount(Text text) {

        String textStr = text.getText();
        textStr = textStr.replace(".","");
        textStr = textStr.replace(",","");
        textStr = textStr.replace("("," ");
        textStr = textStr.replace(")"," ");
        String[] splited = textStr.split("\\s+");
        HashMap<String, Integer> words = new HashMap();


        for (int i = 0; i < splited.length; i++) {

            if (words.containsKey(splited[i])) {
                words.put(splited[i], words.get(splited[i]) + 1);
            } else
                words.put(splited[i], 1);
        }
        return words;
    }

    public static String[] PrintWordCount(HashMap<String, Integer> words){

        int num = words.size();
        String result[] = new String [num];
        int index = 0;
        for (String name : words.keySet()) {
            String key = name.toString();
            String value = words.get(name).toString();
            result[index] = name + ":" + value;
            index++;
        }
        return result;
    }
}
