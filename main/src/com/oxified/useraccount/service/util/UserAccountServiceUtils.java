package com.oxified.useraccount.service.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class UserAccountServiceUtils {

    private static final Pattern INVALID_CHARACTER_PATTERN = Pattern.compile("[\"\'\\\\]");

    static final int PLAYLIST_ID_LENGTH = 5;

    public UserAccountServiceUtils() {
    }

    public static boolean isValidString(final String stringToValidate) {
        if (StringUtils.isBlank(stringToValidate)) {
            return false;
        }

        return !INVALID_CHARACTER_PATTERN.matcher(stringToValidate).find();
    }

    public static String generateUaId() {
        return RandomStringUtils.randomAlphanumeric(PLAYLIST_ID_LENGTH);
    }
}
