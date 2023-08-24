package com.demo.common.utils;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by HoYoung on 2023/04/28.
 */
public class UniqueRandomNumberGenerator {
    private final Set<Long> generatedNumbers = new HashSet<>();
    private final Random random = new SecureRandom(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")).getBytes());

    public long generate13DigitRandomNumber() {
        long number;
        do {
            long min = 2000000000000L;
            long max = 2099999999999L;
            number = min + (long) (random.nextDouble() * (max - min));
        } while (generatedNumbers.contains(number));
        generatedNumbers.add(number);
        return number;
    }

    public String generateOrderNumber() {
        Random random = new SecureRandom(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")).getBytes());
        long number;
        long now = Long.parseLong(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")));
        do {
            long min = 10000000L;
            long max = 99999999L;
            number = min + (long) (random.nextDouble() * (max - min));
        } while (generatedNumbers.contains(number));
        generatedNumbers.add(number);
        return now + String.valueOf(number);
    }
}
