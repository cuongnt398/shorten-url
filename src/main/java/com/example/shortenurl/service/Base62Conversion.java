package com.example.shortenurl.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class Base62Conversion {

    public static Map<Integer, Character> base62Map;

    @PostConstruct
    public void initBase62Map() {
        base62Map = generatorBase62Map();
    }

    public String convertFromId(long uniqueId) {
        StringBuilder uniqueBase62Id = new StringBuilder();
        while (uniqueId > 0) {
            int remainder = (int) (uniqueId % 62);
            uniqueBase62Id.append(base62Map.get(remainder));
            uniqueId /= 62;
        }
        return uniqueBase62Id.toString();
    }

    public static Map<Integer, Character> generatorBase62Map() {
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i <= 9; i++) map.put(i, Character.forDigit(i, Character.DECIMAL_DIGIT_NUMBER));
        for (int i = 10; i <= 35; i++) map.put(i, (char) ('a' + i - 10));
        for (int i = 36; i < 62; i++) map.put(i, (char) ('A' + i - 36));
        return map;
    }

}
