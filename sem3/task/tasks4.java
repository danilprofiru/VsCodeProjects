package task;

import java.util.*;
import java.util.stream.Collectors;

public class tasks4 {

    public static void main(String[] args) {
        // Задание 1
        System.out.println("Задание 1_1: " + nonRepeat("abracadabra"));
        System.out.println("Задание 1_2: " + nonRepeat("abababcac"));

        // Задание 2
        System.out.println("Задание 2_1: " + bruteForce(1, 5));
        System.out.println("Задание 2_2: " + bruteForce(2, 2));
        System.out.println("Задание 2_3: " + bruteForce(5, 3));

        // Задание 3
        System.out.println("Задание 3_1: " + Arrays.toString(decode("MTUCI", "MKIIT")));
        System.out.println("Задание 3_2: " + encode(new int[] { 0, 31, 28, 10, 29 }, "MKIIT"));

        // Задание 4
        System.out.println("Задание 4_1: " + split("()()()"));
        System.out.println("Задание 4_2: " + split("((()))"));
        System.out.println("Задание 4_3: " + split("((()))(())()()(()())"));
        System.out.println("Задание 4_4: " + split("((())())(()(()()))"));

        // Задание 5
        System.out.println("Задание 5_1: " + shortHand("abbccc"));
        System.out.println("Задание 5_2: " + shortHand("vvvvaajaaaaa"));

        // Задание 6
        System.out.println("Задание 6_1: " + convertToRome(8));
        System.out.println("Задание 6_2: " + convertToRome(1234));
        System.out.println("Задание 6_3: " + convertToRome(52));

        // Задание 7
        System.out.println("Задание 7_1: " + uniqueSubstring("31312131"));
        System.out.println("Задание 7_2: " + uniqueSubstring("1111111"));
        System.out.println("Задание 7_3: " + uniqueSubstring("12223234333"));

        // Задание 8
        System.out.println("Задание 8_1: " + labirint(new int[][] { { 1, 3, 1 }, { 1, -1, 1 }, { 4, 2, 1 } }));
        System.out.println("Задание 8_2: " + labirint(new int[][] { { 2, -7, 3 }, { -4, -1, 8 }, { 4, 5, 9 } }));

        // Задание 9
        System.out.println("Задание 9_1: " + numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println("Задание 9_2: " + numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        // Задание 10
        System.out.println("Задание 10_1: " + fibString("CCCABDD"));
        System.out.println("Задание 10_2: " + fibString("ABC"));
    }

    public static String nonRepeat(String s) {
        for (char c : s.toLowerCase().toCharArray())
            if (s.chars().filter(ch -> ch == c).count() > 3)
                s = s.replace(String.valueOf(c), "");
        return s;
    }

    public static List<String> bruteForce(int n, int k) {
        if (n > k)
            return new ArrayList<>();
        List<String> res = new ArrayList<>();
        permute("", k, n, res);
        return res;
    }

    private static void permute(String prefix, int k, int n, List<String> res) {
        if (prefix.length() == n)
            res.add(prefix);
        else
            for (int i = 0; i < k; i++)
                if (!prefix.contains("" + i))
                    permute(prefix + i, k, n, res);
    }

    public static int[] decode(String text, String key) {
        return text.chars().map(i -> i ^ key.charAt(text.indexOf(i))).toArray();
    }

    public static String encode(int[] data, String key) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < data.length; i++)
            res.append((char) (data[i] ^ key.charAt(i)));
        return res.toString();
    }

    public static List<String> split(String s) {
        List<String> res = new ArrayList<>();
        int balance = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            balance += s.charAt(i) == '(' ? 1 : -1;
            if (balance == 0)
                res.add(s.substring(start, i + 1));
            start = balance == 0 ? i + 1 : start;
        }
        return res;
    }

    public static String shortHand(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            int count = 1;
            while (i + count < s.length() && s.charAt(i + count) == c)
                count++;
            res.append(c).append(count > 1 ? "*" + count : "");
            i += count;
        }
        return res.toString();
    }

    public static String convertToRome(int num) {
        String[] rom = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] val = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < val.length && num > 0; i++)
            while (num >= val[i]) {
                num -= val[i];
                res.append(rom[i]);
            }
        return res.toString();
    }

    public static String uniqueSubstring(String s) {
        int[] even = new int[10], odd = new int[10];
        for (int i = 0; i < s.length(); i++)
            if (i % 2 == 0)
                even[s.charAt(i) - '0']++;
            else
                odd[s.charAt(i) - '0']++;
        return Arrays.stream(even).max().getAsInt() > Arrays.stream(odd).max().getAsInt() ? "чет" : "нечет";
    }

    public static String labirint(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        dp[n - 1][n - 1] = matrix[n - 1][n - 1] < 0 ? Integer.MAX_VALUE : matrix[n - 1][n - 1];
        for (int i = n - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] < 0)
                    continue;
                if (i > 0)
                    dp[i - 1][j] = Math.min(dp[i - 1][j], dp[i][j] + matrix[i - 1][j]);
                if (j > 0)
                    dp[i][j - 1] = Math.min(dp[i][j - 1], dp[i][j] + matrix[i][j - 1]);
            }
        return dp[0][0] == Integer.MAX_VALUE ? "Прохода нет" : "1-" + dp[0][0];
    }

    public static String numericOrder(String s) {
        return Arrays.stream(s.split(" "))
                .sorted(Comparator.comparingInt(
                        w -> w.replaceAll("\\D", "").isEmpty() ? 0 : Integer.parseInt(w.replaceAll("\\D", ""))))
                .map(w -> w.replaceAll("\\d", "")).collect(Collectors.joining(" "));
    }

    public static boolean fibString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'A']++;
        }
        List<Integer> fib = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144);
        return Arrays.stream(freq)
                .filter(f -> f > 0)
                .allMatch(fib::contains);
    }

}
