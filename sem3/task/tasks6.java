package task;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import javax.script.ScriptEngineManager;

public class tasks6 {
    public static void main(String[] args) {

        System.out.println(
                "Задание 1:" + hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));

        System.out.println("Задание 2:" + stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[] { "b" }));

        System.out.println("Задание 3:" + nicoCipher("mubashirhassan", "crazy"));

        System.out.println("Задание 4:" + Arrays.toString(twoProduct(new int[] { 1, 2, 3, 9, 4, 5, 15, 3 }, 45)));

        System.out.println("Задание 5:" + Arrays.toString(isExact(720)));

        System.out.println("Задание 6:" + fractions("0.(6)"));

        System.out.println("Задание 7:"
                + piString("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICS"));

        System.out.println("Задание 8_1:" + formula("6 * 4 = 24"));
        System.out.println("Задание 8_2:" + formula("18 / 17 = 2"));
        System.out.println("Задание 8_3:" + formula("16 * 10 = 160 = 14 + 120"));

        System.out.println("Задание 9_1:" + isValid("aabbcc"));
        System.out.println("Задание 9_2:" + isValid("aaabbcc"));

        System.out.println("Задание 10_1:" + palindromeDescendant(11211221));
        System.out.println("Задание 10_2:" + palindromeDescendant(1122));

    }

    // Task 1
    public static String hiddenAnagram(String sentence, String word) {
        String cleanedSentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String sortedWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
        sortedWord = sortedWord.chars().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());

        for (int i = 0; i <= cleanedSentence.length() - sortedWord.length(); i++) {
            String sub = cleanedSentence.substring(i, i + sortedWord.length());
            String sortedSub = sub.chars().sorted().mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.joining());
            if (sortedSub.equals(sortedWord))
                return sub;
        }
        return "noutfond";
    }

    // Task 2
    public static String stripUrlParams(String url, String[] paramsToStrip) {
        if (!url.contains("?"))
            return url;

        String[] parts = url.split("\\?");
        String baseUrl = parts[0];
        String[] params = parts[1].split("&");

        Map<String, String> paramMap = new LinkedHashMap<>();
        for (String param : params) {
            String[] pair = param.split("=");
            if (pair.length == 2) {
                paramMap.put(pair[0], pair[1]);
            }
        }

        if (paramsToStrip != null) {
            for (String param : paramsToStrip) {
                paramMap.remove(param);
            }
        }

        return baseUrl + "?" + paramMap.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));
    }

    // Task 3
    public static String nicoCipher(String message, String key) {
        int[] order = key.chars().sorted().map(c -> key.indexOf((char) c)).toArray();
        int keyLength = key.length();
        StringBuilder paddedMessage = new StringBuilder(message);
        while (paddedMessage.length() % keyLength != 0) {
            paddedMessage.append(" ");
        }

        char[][] matrix = new char[paddedMessage.length() / keyLength][keyLength];
        for (int i = 0; i < paddedMessage.length(); i++) {
            matrix[i / keyLength][i % keyLength] = paddedMessage.charAt(i);
        }

        StringBuilder encoded = new StringBuilder();
        for (int col : order) {
            for (char[] row : matrix) {
                encoded.append(row[col]);
            }
        }

        return encoded.toString();
    }

    // Task 4
    public static int[] twoProduct(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (n % arr[i] == 0 && map.containsKey(n / arr[i])) {
                return new int[] { n / arr[i], arr[i] };
            }
            map.put(arr[i], i);
        }
        return new int[0];
    }

    // Task 5
    public static int[] isExact(int n, int factor) {
        if (n == 1)
            return new int[] { 1, factor - 1 };
        if (n % factor != 0)
            return new int[0];
        return isExact(n / factor, factor + 1);
    }

    public static int[] isExact(int n) {
        return isExact(n, 2);
    }

    // Task 6
    public static String fractions(String decimal) {
        Matcher matcher = Pattern.compile("0\\.\\((\\d+)\\)").matcher(decimal);
        if (matcher.find()) {
            String repeat = matcher.group(1);
            int numerator = Integer.parseInt(repeat);
            int denominator = (int) Math.pow(10, repeat.length()) - 1;
            int gcd = gcd(numerator, denominator);
            return (numerator / gcd) + "/" + (denominator / gcd);
        }
        return null;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Task 7
    public static String piString(String input) {
        int[] piDigits = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9 };
        StringBuilder result = new StringBuilder();
        int index = 0;

        for (int length : piDigits) {
            if (index + length > input.length()) {
                result.append(input.substring(index));
                while (result.length() % length != 0) {
                    result.append(result.charAt(result.length() - 1));
                }
                break;
            }
            result.append(input.substring(index, index + length)).append(" ");
            index += length;
        }

        return result.toString().trim();
    }

    // Task 8
    public static boolean formula(String s) {
        try {
            String[] parts = s.split("=");
            double result1 = eval(parts[0].trim());
            double result2 = eval(parts[1].trim());
            return result1 == result2;
        } catch (Exception e) {
            return false;
        }
    }

    private static double eval(String expression) {
        try {
            return (double) new ScriptEngineManager().getEngineByName("JavaScript").eval(expression);
        } catch (Exception e) {
            return 0;
        }
    }

    // Task 9
    public static String isValid(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int count : freqMap.values()) {
            freqCount.put(count, freqCount.getOrDefault(count, 0) + 1);
        }

        if (freqCount.size() == 1) {
            return "YES";
        }

        if (freqCount.size() == 2) {
            int key1 = (int) freqCount.keySet().toArray()[0];
            int key2 = (int) freqCount.keySet().toArray()[1];

            if ((freqCount.get(key1) == 1 && key1 == 1) || (freqCount.get(key2) == 1 && key2 == 1)) {
                return "YES";
            }
            if (Math.abs(key1 - key2) == 1 && (freqCount.get(Math.min(key1, key2)) == 1)) {
                return "YES";
            }
        }

        return "NO";
    }

    // Task 10
    public static boolean palindromeDescendant(int n) {
        String number = String.valueOf(n);

        if (isPalindrome(number)) {
            return true;
        }

        while (number.length() > 2) {
            number = getNextDescendant(number);
            if (isPalindrome(number)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static String getNextDescendant(String number) {
        StringBuilder nextNumber = new StringBuilder();
        for (int i = 0; i < number.length() - 1; i++) {
            int sum = Character.getNumericValue(number.charAt(i)) + Character.getNumericValue(number.charAt(i + 1));
            nextNumber.append(sum);
        }
        return nextNumber.toString();
    }
}
