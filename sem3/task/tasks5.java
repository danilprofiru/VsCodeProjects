package task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class tasks5 {

    public static void main(String[] args) {
        System.out.println("Задание 1: " + sameLetterPattern("ABAB", "CDCD"));
        System.out.println("Задание 2: " + memeSum(26, 39));
        System.out.println("Задание 3: " + digitsCount(4666));
        System.out.println("Задание 4: " + totalPoints(new String[] { "cat", "create", "sat" }, "caster"));
        System.out.println("Задание 5: " + longestRun(new int[] { 1, 2, 3, 5, 6, 7, 8, 9 }));
        System.out
                .println("Задание 6: " + takeDownAverage(new String[] { "95%", "83%", "90%", "87%", "88%", "93%" }));
        System.out.println("Задание 7: " + canMove("Rook", "A8", "H8"));
        System.out.println("Задание 8: " + maxPossible(9328, 456));
        System.out.println("Задание 9: " + timeDifference("New York", "2024-11-11 15:00", "Moscow"));
        System.out.println("Задание 10: " + isNew(321));
    }

    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        Map<Character, Character> pattern = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if (pattern.containsKey(ch1) && pattern.get(ch1) != ch2)
                return false;
            pattern.putIfAbsent(ch1, ch2);
        }

        return new HashSet<>(pattern.values()).size() == pattern.size();
    }

    public static int memeSum(int num1, int num2) {
        StringBuilder result = new StringBuilder();
        while (num1 > 0 || num2 > 0) {
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;
            result.insert(0, digit1 + digit2);
            num1 /= 10;
            num2 /= 10;
        }
        return Integer.parseInt(result.toString());
    }

    public static int digitsCount(long number) {
        return number < 10 ? 1 : 1 + digitsCount(number / 10);
    }

    public static int totalPoints(String[] guessedWords, String unscrambledWord) {
        int points = 0;
        for (String word : guessedWords) {
            if (canFormWord(word, unscrambledWord)) {
                points += switch (word.length()) {
                    case 3 -> 1;
                    case 4 -> 2;
                    case 5 -> 3;
                    case 6 -> 54;
                    default -> 0;
                };
            }
        }
        return points;
    }

    private static boolean canFormWord(String word, String letters) {
        Map<Character, Integer> letterCounts = new HashMap<>();
        for (char ch : letters.toCharArray()) {
            letterCounts.put(ch, letterCounts.getOrDefault(ch, 0) + 1);
        }
        for (char ch : word.toCharArray()) {
            if (!letterCounts.containsKey(ch) || letterCounts.get(ch) == 0)
                return false;
            letterCounts.put(ch, letterCounts.get(ch) - 1);
        }
        return true;
    }

    public static int longestRun(int[] arr) {
        if (arr.length == 0)
            return 0;

        int maxRun = 1, currentRun = 1;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) == 1) {
                currentRun++;
            } else {
                maxRun = Math.max(maxRun, currentRun);
                currentRun = 1;
            }
        }
        return Math.max(maxRun, currentRun);
    }

    public static String takeDownAverage(String[] scores) {
        int total = Arrays.stream(scores)
                .mapToInt(score -> Integer.parseInt(score.replace("%", "")))
                .sum();
        int currentAverage = total / scores.length;
        int newScore = currentAverage - 5 * (scores.length + 1);
        return newScore + "%";
    }

    public static boolean canMove(String piece, String start, String end) {
        int startX = start.charAt(0) - 'A', startY = start.charAt(1) - '1';
        int endX = end.charAt(0) - 'A', endY = end.charAt(1) - '1';

        return switch (piece.toLowerCase()) {
            case "pawn" -> startX == endX && (endY == startY + 1 || (startY == 1 && endY == 3));
            case "knight" -> Math.abs(startX - endX) * Math.abs(startY - endY) == 2;
            case "bishop" -> Math.abs(startX - endX) == Math.abs(startY - endY);
            case "rook" -> startX == endX || startY == endY;
            case "queen" -> canMove("rook", start, end) || canMove("bishop", start, end);
            case "king" -> Math.abs(startX - endX) <= 1 && Math.abs(startY - endY) <= 1;
            default -> false;
        };
    }

    public static int maxPossible(int num1, int num2) {
        char[] num1Chars = String.valueOf(num1).toCharArray();
        char[] num2Chars = String.valueOf(num2).toCharArray();
        Arrays.sort(num2Chars);

        int j = num2Chars.length - 1;
        for (int i = 0; i < num1Chars.length; i++) {
            if (j >= 0 && num2Chars[j] > num1Chars[i]) {
                num1Chars[i] = num2Chars[j--];
            }
        }
        return Integer.parseInt(new String(num1Chars));
    }

    public static String timeDifference(String cityA, String timestamp, String cityB) {
        Map<String, Double> offsets = Map.ofEntries(
                Map.entry("Los Angeles", -8.0),
                Map.entry("New York", -5.0),
                Map.entry("Caracas", -4.5),
                Map.entry("Buenos Aires", -3.0),
                Map.entry("London", 0.0),
                Map.entry("Rome", 1.0),
                Map.entry("Moscow", 3.0),
                Map.entry("Tehran", 3.5),
                Map.entry("New Delhi", 5.5),
                Map.entry("Beijing", 8.0),
                Map.entry("Canberra", 10.0));

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = sdf.parse(timestamp);

            double hoursDifference = offsets.get(cityB) - offsets.get(cityA);
            Date newDate = new Date(date.getTime() + (long) (hoursDifference * 3600 * 1000));
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

            return sdf.format(newDate);
        } catch (ParseException e) {
            return "Неверный формат времени";
        }
    }

    public static boolean isNew(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return Integer.parseInt(new String(digits)) == num;
    }
}
