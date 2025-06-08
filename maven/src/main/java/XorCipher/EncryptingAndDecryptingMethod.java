package XorCipher;

import CaesarCipher.Cipher;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class EncryptingAndDecryptingMethod {
    public static byte[] encryptingText(String text, String key) {
        byte [] keyBytes = gettingArrayFromKey(key);
        byte [] textBytes = gettingArrayFromText(text);
        byte [] encryptedTextInBytes = new byte[textBytes.length];

        for (int i = 0; i < textBytes.length; i++) {
            if (i >= keyBytes.length) {
                encryptedTextInBytes[i] = (byte) (keyBytes[keyBytes.length - 1] ^ textBytes[i]);
                continue;
            }
            encryptedTextInBytes[i] = (byte) (keyBytes[i] ^ textBytes[i]);
        }

        return encryptedTextInBytes;
    }

    public static byte[] gettingArrayFromText(String text) {
        return text.getBytes(StandardCharsets.UTF_8);
    }

    public static byte[] gettingArrayFromKey(String key) {
        return key.getBytes(StandardCharsets.UTF_8);
    }

    public static String makingKey(int length) {
        String chars;
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!£$%^&*()_+=-{}[]:@';?./#~\\,№`";
        } else {
            chars = "йцукенгшщзхъфывапролджэячсмитьбюёЁЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ!№;%:?*()_+=-0987654321£$^&?@{}[]#~";
        }
        SecureRandom random = new SecureRandom();
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            key.append(chars.charAt(index));
        }

        return key.toString();
    }
}
