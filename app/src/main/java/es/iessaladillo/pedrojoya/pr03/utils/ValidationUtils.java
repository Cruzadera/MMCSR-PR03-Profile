package es.iessaladillo.pedrojoya.pr03.utils;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Utility class for data validation
 */
// DO NOT TOUCH
public class ValidationUtils {

    private ValidationUtils() {
    }

    public static boolean isEmptyText(String text){
        return !TextUtils.isEmpty(text);
    }

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPhone(String phoneNumber) {
        return !TextUtils.isEmpty(phoneNumber) && Patterns.PHONE.matcher(phoneNumber).matches();
    }

    public static boolean isValidUrl(String url) {
        return !TextUtils.isEmpty(url) && Patterns.WEB_URL.matcher(url).matches();
    }

}
