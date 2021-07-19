package ru.naimix.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static ru.naimix.util.Common.randomInt;
import static ru.naimix.util.Common.randomLong;


/**
 * Класс для для работы со строками(Генерация заданных строк и другое)
 */
public class StringFunctions {

    /**
     * Генерирует строку заданной длины, при возможности, содержащую в себе описание своей длины
     *
     * @param length длина строки
     * @param name   используется для описания
     * @return строка заданной длины, содержащая описание
     */
    public static String stringWithLengthDescription(int length, String name, String extraAlphabet) {
        final String suffixOne = " c длиной: ";
        final String suffixTwo = " ";
        StringBuffer base;
        String alphabet = "0123456789" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
                "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя" +
                extraAlphabet;

        if (suffixOne.length() + suffixTwo.length() + name.length() + String.valueOf(length).length() < length) {
            base = new StringBuffer(name + suffixOne + length + suffixTwo);
        } else {
            base = new StringBuffer();
        }

        while (base.length() < length) {
            base.append(alphabet.charAt(new Random().nextInt(alphabet.length() - 1)));
        }
        return base.toString();
    }

    public static String stringWithLengthDescription(int length, String name) {
        return stringWithLengthDescription(length, name, "");
    }

    public static String stringWithLengthDescription(int length) {
        return stringWithLengthDescription(length, "Строка");
    }

    public static String randomFirstName(boolean female) {
        StringGenerator firstLetterGen = new StringGenerator().withLatinLowerCase(false).withExtra("АВГДЕЖЗИКЛМНОПРСТЭЮЯ");
        StringGenerator cyrLCGen = new StringGenerator().withLatinLowerCase(false).withExtra("абвгдежзиклмнопрстфэюя");
        Random rnd = new Random(System.currentTimeMillis());
        return firstLetterGen.generate(1) + cyrLCGen.generate(rnd.nextInt(12)) + (female ? "на" : "");
    }

    public static String randomFirstName() {
        return randomFirstName(false);
    }

    public static String randomLastName(boolean female) {
        StringGenerator firstLetterGen = new StringGenerator().withLatinLowerCase(false).withExtra("АВГДЕЖЗИКЛМНОПРСТЭЮЯ");
        StringGenerator cyrLCGen = new StringGenerator().withLatinLowerCase(false).withExtra("абвгдежзиклмнопрстфэюя");
        Random rnd = new Random(System.currentTimeMillis());
        return firstLetterGen.generate(1) + cyrLCGen.generate(rnd.nextInt(10) + 2) + (female ? "ва" : "ов");
    }

    public static String randomLastName() {
        return randomLastName(false);
    }

    public static String randomPatronymic(boolean female) {
        StringGenerator firstLetterGen = new StringGenerator().withLatinLowerCase(false).withExtra("АВГДЕЖЗИКЛМНОПРСТЭЮЯ");
        StringGenerator cyrLCGen = new StringGenerator().withLatinLowerCase(false).withExtra("абвгдежзиклмнопрстфэюя");
        Random rnd = new Random(System.currentTimeMillis());
        return firstLetterGen.generate(1) + cyrLCGen.generate(rnd.nextInt(10) + 2) + (female ? "вна" : "вич");
    }

    public static String randomPatronymic() {
        return randomPatronymic(false);
    }

    // TODO: Some error check if lengths too small
    public static String randomEmail(int nameMinLen, int nameMaxLen, int domainMinLen, int domainMaxLen) {
        // Choose randomly, upper or lower case
        StringGenerator gen = randomInt(0, 1) == 0 ?
                new StringGenerator().withLatinUpperCase(true).withLatinLowerCase(false) :
                new StringGenerator();
        return gen.generate(randomInt(nameMinLen, nameMaxLen)) + "@" +
                gen.generate(randomInt(domainMinLen - 3, domainMaxLen - 3)) + "." + gen.generate(2);
    }

    public static String randomEmail(int length) {
        assertThat("Некорректный параметр length, валидный email должен быть >= 6 символов", length, greaterThan(5));
        int domainLen = Math.max((length) / 2, 4);
        int nameLen = (length - 1) - domainLen;
        return randomEmail(nameLen, nameLen, domainLen, domainLen);
    }

    /**
     * Генерирует случайное ФИО
     */
    public static String randomFio(boolean dashShouldBe) {
        List<String> maleSecondNames = new ArrayList<>(asList("Ёлкин", "Пётров", "Сорокин", "Васильёв", "Дмитриёв",
                "Смирнов", "Рандомов", "Де-фисов"));
        List<String> malePatronymics = dashShouldBe ? new ArrayList<>(Collections.singletonList("Дё-фисович")) :
                new ArrayList<>(asList("Иванович", "Пётрович", "Алёксеевич", "Васильёвич", "Дмитриёвич", "Анатольёвич",
                        "Ё", "Де-фисович"));

        List<String> femaleSecondNames = new ArrayList<>(asList("Ёлкина", "Пётрова", "Сорокина", "Васильёва",
                "Дмитриёва", "Смирнова", "Рандомова", "Дё-фисофа"));
        List<String> femalePatronymics = dashShouldBe ? new ArrayList<>(Collections.singletonList("Дё-фисовна")) :
                new ArrayList<>(asList("Ивановна", "Пётровна", "Алёксеевна", "Васильёвна", "Дмитриёвна", "Анатольёвна",
                        "Ё", "Дё-фисовна"));

        Random r = new Random(System.currentTimeMillis());
        if (r.nextInt(100) > 49) {
            return maleSecondNames.get(r.nextInt(maleSecondNames.size())) + " " +
                    randomFirstName(false) + " " +
                    malePatronymics.get(r.nextInt(malePatronymics.size()));
        } else {
            return femaleSecondNames.get(r.nextInt(femaleSecondNames.size())) + " " +
                    randomFirstName(true) + " " +
                    femalePatronymics.get(r.nextInt(femalePatronymics.size()));
        }
    }

    /**
     * Случайное ФИО с дефисом или нет
     */
    public static String randomFio() {
        return randomFio(false);
    }

    /**
     * Генерирует случайное ФИО с дефисом
     */
    public static String randomFioWithDash() {
        return randomFio(true);
    }

    public static String removeNonDigits(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return str.replaceAll("\\D+", "");
    }

    public static String convertObjToString(Object clsObj) {
        //convert object  to string json
        return new Gson().toJson(clsObj, new TypeToken<Object>() {
        }.getType());
    }

    public static String randomUuid() {
        return UUID.randomUUID().toString();
    }

    public static String randomOgrn(boolean valid) {
        long firstDigits = randomLong(100000000000L, 999999999999L);
        long lastDigit = (firstDigits % 11) % 10;
        lastDigit = (lastDigit + (valid ? 0 : 1)) % 10; // Делаем последнее число невалидным, если надо
        return Long.toString(firstDigits) + Long.toString(lastDigit);
    }

    public static String randomOgrnValid() {
        return randomOgrn(true);
    }

    public static String randomOgrnInvalid() {
        return randomOgrn(false);
    }

    private static int getNthDigit(long number, int n) {
        return (int) ((number / Math.pow(10, n - 1)) % 10);
    }

    private static int getNthDigit(String number, int n) {
        return Character.getNumericValue(number.charAt(n));
    }

    /**
     * Случайный инн ЮЛ. Валидный или нет в зависимости от @param valid
     */
    public static String randomInnLe(boolean valid) {
        long firstDigits = randomLong(100000000, 999999999);
        int sum = getNthDigit(firstDigits, 9) * 2 +
                getNthDigit(firstDigits, 8) * 4 +
                getNthDigit(firstDigits, 7) * 10 +
                getNthDigit(firstDigits, 6) * 3 +
                getNthDigit(firstDigits, 5) * 5 +
                getNthDigit(firstDigits, 4) * 9 +
                getNthDigit(firstDigits, 3) * 4 +
                getNthDigit(firstDigits, 2) * 6 +
                getNthDigit(firstDigits, 1) * 8;
        int lastDigit = (sum % 11) % 10;
        lastDigit = (lastDigit + (valid ? 0 : 1)) % 10; // Делаем последнее число невалидным, если надо
        return Long.toString(firstDigits) + Integer.toString(lastDigit);
    }

    public static String randomInnLeValid() {
        return randomInnLe(true);
    }

    public static String randomInnLeInvalid() {
        return randomInnLe(false);
    }

    /**
     * Случайный инн ФЛ. Валидный или нет в зависимости от:
     *
     * @param valid11Digit является ли первая контрольная цифра валидной
     * @param valid12Digit является ли вторая контрольная цифра валидной
     */
    public static String randomInnPerson(boolean valid11Digit, boolean valid12Digit) {
        String base = new StringGenerator().withLatin(false).withDigits(true).generate(10);
        int n11 = (getNthDigit(base, 0) * 7 +
                getNthDigit(base, 1) * 2 +
                getNthDigit(base, 2) * 4 +
                getNthDigit(base, 3) * 10 +
                getNthDigit(base, 4) * 3 +
                getNthDigit(base, 5) * 5 +
                getNthDigit(base, 6) * 9 +
                getNthDigit(base, 7) * 4 +
                getNthDigit(base, 8) * 6 +
                getNthDigit(base, 9) * 8) % 11 % 10;

        int n12 = (getNthDigit(base, 0) * 3 +
                getNthDigit(base, 1) * 7 +
                getNthDigit(base, 2) * 2 +
                getNthDigit(base, 3) * 4 +
                getNthDigit(base, 4) * 10 +
                getNthDigit(base, 5) * 3 +
                getNthDigit(base, 6) * 5 +
                getNthDigit(base, 7) * 9 +
                getNthDigit(base, 8) * 4 +
                getNthDigit(base, 9) * 6 +
                n11 * 8) % 11 % 10;

        if (!valid11Digit) {
            n11 = (n11 + 1) % 10;
        }
        if (!valid12Digit) {
            n12 = (n12 + 1) % 10;
        }
        return base + n11 + n12;
    }

    public static String randomInnPersonValid() {
        return randomInnPerson(true, true);
    }

    public static String randomBikValid() {
        String lastDigits = Integer.toString(randomInt(50, 999));
        if (lastDigits.length() < 3) lastDigits = "0" + lastDigits;
        return "04" + randomInt(1000, 9999) + lastDigits;
    }

    /**
     * @param basedOn - три цифры, например для генерации расчетного счета нужно передать 3 последние цифры БИК
     */
    public static String randomBankAccount(String basedOn, boolean valid) {
        StringGenerator generator = new StringGenerator().withLatinLowerCase(false).withDigits(true);
        String sequence = basedOn + generator.generate(8) + "0" + generator.generate(11);

        int sum = 0;
        int multiplier = 7;
        for (int i = 0; i < sequence.length(); i++) {
            sum += Character.getNumericValue(sequence.charAt(i)) * multiplier;
            multiplier = multiplier == 7 ? 1 : (multiplier == 1 ? 3 : 7);
        }
        int controlDigit = (((sum % 10) * 3) % 10);
        if (!valid) {
            controlDigit = (controlDigit + 1) % 10;
        }

        return sequence.substring(3, 11) + controlDigit + sequence.substring(12);
    }

    /**
     * Расчетный счёт для БИК
     */
    public static String randomCheckingAccount(String bik, boolean valid) {
        return randomBankAccount(bik.substring(6), valid);
    }

    /**
     * Корреспондентский счёт для БИК
     */
    public static String randomCorrespondentAccount(String bik, boolean valid) {
        return randomBankAccount("0" + bik.substring(4, 6), valid);
    }

}


