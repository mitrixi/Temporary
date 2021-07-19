package ru.naimix.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import static ru.naimix.util.Common.randomInt;

@With
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StringGenerator {
    private final String latLC = "abcdefghijklmnopqrstuvwxyz";
    private final String latUC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String cyrLC = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private final String curUC = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private final String dig = "0123456789";
    private boolean latinLowerCase = true;
    private boolean cyrillicLowerCase = false;
    private boolean latinUpperCase = false;
    private boolean cyrillicUpperCase = false;
    private boolean digits = false;
    private String extra = "";

    private String buildCharSet() {
        StringBuilder resultAlphabetBuilder = new StringBuilder();
        if (latinLowerCase) resultAlphabetBuilder.append(latLC);
        if (latinUpperCase) resultAlphabetBuilder.append(latUC);
        if (cyrillicLowerCase) resultAlphabetBuilder.append(cyrLC);
        if (cyrillicUpperCase) resultAlphabetBuilder.append(curUC);
        if (digits) resultAlphabetBuilder.append(dig);
        resultAlphabetBuilder.append(extra);

        return resultAlphabetBuilder.toString();
    }

    private boolean isStringContainsSpecifiedCharsOnly(String str) {
//        String alphabet = buildCharSet();
//        for (int i = 0; i < str.length(); i++) {
//            if (!alphabet.contains(Character.toString(str.charAt(i)))) {
//                return false;
//            }
//        }
        return true;
    }

    public String generate(int length) {
        String alphabet = buildCharSet();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(alphabet.charAt(randomInt(alphabet.length())));
        }
        return result.toString();
    }

    public StringGenerator withCyrillic(boolean cyrillic) {
        this.cyrillicUpperCase = cyrillic;
        this.cyrillicLowerCase = cyrillic;
        return this;
    }

    public StringGenerator withLatin(boolean latin) {
        this.latinUpperCase = latin;
        this.latinLowerCase = latin;
        return this;
    }

    private String removeLastChar(String src) {
        return src.substring(0, src.length() - 1);
    }

    private String removeFirstChar(String src) {
        return src.substring(1);
    }

    public String generateDescribed(int length, String description) {
        if (!description.endsWith(" ")) description += " ";
        String result = (description + generate(length - description.length())).substring(0, length);
        if (result.endsWith(" ")) result = removeLastChar(result) + generate(1);
        if (result.startsWith(" ")) result = generate(1) + removeFirstChar(result);
        return result;
    }
}
