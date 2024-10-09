package task;

import java.util.Arrays;

public class tasks2 {

    public static void main(String[] args) {
        // Задание 1
        System.out.println("Задание 1: " + duplicateChars("Barack", "Obama"));

        // Задание 2
        System.out.println("Задание 2: " + dividedByThree(new int[] { 3, 12, 7, 81, 52 }));

        // Задание 3
        System.out.println("Задание 3_1: " + getInitials("simonov sergei evgenievich"));
        System.out.println("Задание 3_2: " + getInitials("kozhevnikova tatiana vitalevna"));

        // Задание 4 (в методичке не верный ответ)
        System.out.println("Задание 4_1: " + Arrays.toString(normalizator(new double[] { 3.5, 7.0, 1.5, 9.0, 5.5 })));
        System.out.println("Задание 4_2: " + Arrays.toString(normalizator(new double[] { 10.0, 10.0, 10.0, 10.0 })));

        // Задание 5
        System.out.println(
                "Задание 5: " + Arrays.toString(compressedNums(new double[] { 1.6, 0, 212.3, 34.8, 0, 27.5 })));

        // Задание 6
        System.out.println("Задание 6: " + camelToSnake("helloWorld"));

        // Задание 7
        System.out.println("Задание 7: " + secondBiggest(new int[] { 3, 5, 8, 1, 2, 4 }));

        // Задание 8
        System.out.println("Задание 8_1: " + localReverse("baobab", 'b'));
        System.out.println("Задание 8_2: " + localReverse("Hello, I’m under the water, please help me", 'e'));

        // Задание 9
        System.out.println("Задание 9_1: " + equal(8, 1, 8));
        System.out.println("Задание 9_2: " + equal(5, 5, 5));
        System.out.println("Задание 9_3: " + equal(4, 9, 6));

        // Задание 10
        System.out.println("Задание 10_1: " + isAnagram("LISTEN", "silent"));
        System.out.println("Задание 10_2: " + isAnagram("Eleven plus two?", "Twelve plus one!"));
        System.out.println("Задание 10_3: " + isAnagram("hello", "world"));
    }

    // Задание 1
    public static String duplicateChars(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        String s1Lower = s1.toLowerCase();
        String s2Lower = s2.toLowerCase();
        for (int i = 0; i < s1.length(); i++) {
            char originalChar = s1.charAt(i);
            char lowerChar = s1Lower.charAt(i);
            if (s2Lower.indexOf(lowerChar) == -1) {
                result.append(originalChar);
            }
        }
        return result.toString();
    }

    // Задание 2
    public static int dividedByThree(int[] arr) {
        int count = 0;
        for (int x : arr) {
            if (x % 2 != 0 && x % 3 == 0) {
                count++;
            }
        }
        return count;
    }

    // Задание 3
    public static String getInitials(String name) {
        String[] parts = name.split(" ");
        if (parts.length != 3) {
            return "Некорректный формат ввода";
        }
        // Берем первую букву имени и отчества, добавляем точки
        String initials = parts[1].substring(0, 1).toUpperCase() + "." + parts[2].substring(0, 1).toUpperCase() + ".";
        // Добавляем фамилию с заглавной буквы
        String lastName = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1);
        return initials + " " + lastName;
    }

    // Задание 4
    public static double[] normalizator(double[] arr) {
        double min = Arrays.stream(arr).min().getAsDouble();
        double max = Arrays.stream(arr).max().getAsDouble();

        double range = max - min; // Разница между максимальным и минимальным значениями

        // Если все элементы одинаковые, возвращаем массив нулей
        if (range == 0) {
            return new double[arr.length];
        }

        // Нормализуем значения
        double[] normalized = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            normalized[i] = (arr[i] - min) / range;
        }

        // Округляем до четырех знаков после запятой
        for (int i = 0; i < normalized.length; i++) {
            normalized[i] = Math.round(normalized[i] * 10000.0) / 10000.0;
        }
        return normalized;
    }

    // Задание 5
    public static int[] compressedNums(double[] arr) {
        return Arrays.stream(arr)
                .filter(x -> x != 0)
                .mapToInt(x -> (int) x)
                .sorted()
                .toArray();
    }

    // Задание 6
    public static String camelToSnake(String camelStr) {
        StringBuilder result = new StringBuilder();
        for (char c : camelStr.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append("_").append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Задание 7
    public static int secondBiggest(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }

    // Задание 8
    public static String localReverse(String s, char marker) {
        String[] parts = s.split(String.valueOf(marker), -1);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            if (i % 2 != 0) {
                // Реверсируем часть между маркерами
                result.append(new StringBuilder(parts[i]).reverse());
            } else {
                // Оставляем часть без изменений
                result.append(parts[i]);
            }
            // Добавляем маркер, кроме последней части
            if (i < parts.length - 1) {
                result.append(marker);
            }
        }
        return result.toString();
    }

    // Задание 9
    public static int equal(int a, int b, int c) {
        if (a == b && b == c)
            return 3;
        if (a == b || b == c || a == c)
            return 2;
        return 0;
    }

    // Задание 10
    public static boolean isAnagram(String s1, String s2) {
        s1 = s1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        s2 = s2.replaceAll("[^a-zA-Z]", "").toLowerCase();
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        return Arrays.equals(s1Arr, s2Arr);
    }
}