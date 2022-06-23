package src.core.resource.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class DataGenerateUtils {
    public static String randomString(int length) {
        String randomString = RandomStringUtils.randomAlphabetic(length);
        return randomString;
    }
}
