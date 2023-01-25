package main.java.org.service.message.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class MessageUtils {
    private static final Pattern INVALID_CHARACTER_PATTERN = Pattern.compile("[\"\'\\\\]");

    static final int ID_LENGTH = 5;
    public static Boolean isValid(final String stringToValidate) {
        if (StringUtils.isBlank(stringToValidate)) {
            return false;
        }
        return !INVALID_CHARACTER_PATTERN.matcher(stringToValidate).find();
    }
    public static String generateMessageId() {
        return RandomStringUtils.randomAlphanumeric(ID_LENGTH);
    }
}
