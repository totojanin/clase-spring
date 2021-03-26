package com.morse.morse.services;

import java.util.HashMap;
import java.util.Map;

public class MorseService {
    private final static Map<String, String> diccionarioMorse;
    static {
        diccionarioMorse = new HashMap<>();

        diccionarioMorse.put(".-", "A");
        diccionarioMorse.put("-...", "B");
        diccionarioMorse.put("-.-.", "C");
        diccionarioMorse.put("-..", "D");
        diccionarioMorse.put(".", "E");
        diccionarioMorse.put("..-.", "F");
        diccionarioMorse.put("--.", "G");
        diccionarioMorse.put("....", "H");
        diccionarioMorse.put("..", "I");
        diccionarioMorse.put(".---", "J");
        diccionarioMorse.put("-.-", "K");
        diccionarioMorse.put(".-..", "L");
        diccionarioMorse.put("--", "M");
        diccionarioMorse.put("-.", "N");
        diccionarioMorse.put("---", "O");
        diccionarioMorse.put(".--.", "P");
        diccionarioMorse.put("--.-", "Q");
        diccionarioMorse.put(".-.", "R");
        diccionarioMorse.put("...", "S");
        diccionarioMorse.put("-", "T");
        diccionarioMorse.put("..-", "U");
        diccionarioMorse.put("...-", "V");
        diccionarioMorse.put(".--", "W");
        diccionarioMorse.put("-..-", "X");
        diccionarioMorse.put("-.--", "Y");
        diccionarioMorse.put("--..", "Z");

        diccionarioMorse.put("-----", "0");
        diccionarioMorse.put(".----", "1");
        diccionarioMorse.put("..---", "2");
        diccionarioMorse.put("...--", "3");
        diccionarioMorse.put("....-", "4");
        diccionarioMorse.put(".....", "5");
        diccionarioMorse.put("-....", "6");
        diccionarioMorse.put("--...", "7");
        diccionarioMorse.put("---..", "8");
        diccionarioMorse.put("----.", "9");

        diccionarioMorse.put("espacio", " ");
    }

    public static String traducir(String codigoMorse) {
        String traduccion = "";

        codigoMorse = codigoMorse.replace("   ", " espacio ");

        String[] codigos = codigoMorse.split(" ");

        for (String cod : codigos) {
            traduccion += diccionarioMorse.get(cod);
        }

        return traduccion;
    }
}
