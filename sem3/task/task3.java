package task;

import java.util.List;

public class task3 {

    public static void main(String[] args) {
        // 1. Странная пара строк
        System.out.println("Задание 1_1: " + isStrangePair("ratio", "orator"));
        System.out.println("Задание 1_2: " + isStrangePair("sparkling", "groups"));
        System.out.println("Задание 1_3: " + isStrangePair("bush", "hubris"));
        System.out.println("Задание 1_4: " + isStrangePair("", ""));

        // 2. Применение скидки к товарам
        System.out.println("Задание 2: ");
        List<String[]> items = List.of(
                new String[] { "Laptop", "124200" },
                new String[] { "Phone", "51450" },
                new String[] { "Headphones", "13800" });
        sale(items, 25).forEach(item -> System.out.println(item[0] + ": " + item[1]));

        // 3. Попадание в мишень
        System.out.println("Задание 3_1: " + successShoot(0, 0, 5, 2, 2));
        System.out.println("Задание 3_2: " + successShoot(-2, -3, 4, 5, -6));

        // 4. Анализ четности
        System.out.println("Задание 4_1: " + parityAnalysis(243));
        System.out.println("Задание 4_2: " + parityAnalysis(12));
        System.out.println("Задание 4_3: " + parityAnalysis(3));

        // 5. Камень, ножницы, бумага
        System.out.println("Задание 5_1: " + rps("rock", "paper"));
        System.out.println("Задание 5_2: " + rps("paper", "rock"));
        System.out.println("Задание 5_3: " + rps("paper", "scissors"));
        System.out.println("Задание 5_4: " + rps("scissors", "scissors"));
        System.out.println("Задание 5_5: " + rps("scissors", "paper"));

        // 6. Мультипликативное постоянство
        System.out.println("Задание 6_1: " + bugger(39));
        System.out.println("Задание 6_2: " + bugger(999));
        System.out.println("Задание 6_3: " + bugger(4));

        // 7. Самый дорогой предмет
        System.out.println("Задание 7: ");
        String[][] inventory = {
                { "Скакалка", "550", "8" },
                { "Шлем", "3750", "4" },
                { "Мяч", "2900", "10" }
        };
        System.out.println(mostExpensive(inventory));

        // 8. Самая длинная уникальная подстрока
        System.out.println("Задание 8_1: " + longestUnique("abcba"));
        System.out.println("Задание 8_2: " + longestUnique("bbb"));

        // 9. Префикс и суффикс
        System.out.println("Задание 9_1: " + isPrefix("automation", "auto-"));
        System.out.println("Задание 9_2: " + isSuffix("arachnophobia", "-phobia"));
        System.out.println("Задание 9_3: " + isPrefix("retrospect", "sub-"));
        System.out.println("Задание 9_4: " + isSuffix("vocation", "-logy"));

        // 10. Проверка, влезет ли кирпич в отверстие
        System.out.println("Задание 10_1: " + doesBrickFit(1, 1, 1, 1, 1));
        System.out.println("Задание 10_2: " + doesBrickFit(1, 2, 1, 1, 1));
        System.out.println("Задание 10_3: " + doesBrickFit(1, 2, 2, 1, 1));
    }

    // 1. Странная пара строк
    public static boolean isStrangePair(String str1, String str2) {
        return (str1.isEmpty() && str2.isEmpty()) ||
                (str1.charAt(0) == str2.charAt(str2.length() - 1) &&
                        str1.charAt(str1.length() - 1) == str2.charAt(0));
    }

    // 2. Применение скидки к товарам
    public static List<String[]> sale(List<String[]> items, int discount) {
        return items.stream().map(item -> {
            String name = item[0];
            int price = Integer.parseInt(item[1]);
            int discountedPrice = Math.max(1, (int) (price * (1 - discount / 100.0)));
            return new String[] { name, String.valueOf(discountedPrice) };
        }).toList();
    }

    // 3. Попадание в мишень
    public static boolean successShoot(int x, int y, int r, int m, int n) {
        return Math.hypot(m - x, n - y) <= r;
    }

    // 4. Анализ четности
    public static boolean parityAnalysis(int num) {
        int sumOfDigits = String.valueOf(num).chars().map(c -> c - '0').sum();
        return (num % 2 == sumOfDigits % 2);
    }

    // 5. Камень, ножницы, бумага
    public static String rps(String p1, String p2) {
        if (p1.equals(p2))
            return "Tie";
        return switch (p1 + p2) {
            case "rockscissors", "scissorspaper", "paperrock" -> "Player 1 wins";
            default -> "Player 2 wins";
        };
    }

    // 6. Мультипликативное постоянство
    public static int bugger(int num) {
        int count = 0;
        while (num >= 10) {
            num = String.valueOf(num).chars().reduce(1, (prod, c) -> prod * (c - '0'));
            count++;
        }
        return count;
    }

    // 7. Самый дорогой предмет
    public static String mostExpensive(String[][] items) {
        return List.of(items).stream()
                .map(item -> new Object[] { item[0], Integer.parseInt(item[1]) * Integer.parseInt(item[2]) })
                .max((a, b) -> (int) a[1] - (int) b[1])
                .map(item -> "Наиб. общ. стоимость у предмета " + item[0] + " - " + item[1])
                .orElse("");
    }

    // 8. Самая длинная уникальная подстрока
    public static String longestUnique(String s) {
        String maxSubstring = "";
        for (int i = 0; i < s.length(); i++) {
            String currentSubstring = "";
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (currentSubstring.indexOf(c) != -1)
                    break;
                currentSubstring += c;
            }
            if (currentSubstring.length() > maxSubstring.length()) {
                maxSubstring = currentSubstring;
            }
        }
        return maxSubstring;
    }

    // 9. Префикс и суффикс
    public static boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.replace("-", ""));
    }

    public static boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.replace("-", ""));
    }

    // 10. Проверка, влезет ли кирпич в отверстие
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= h && b <= w) ||
                (b <= w && c <= h) || (b <= h && c <= w) ||
                (a <= w && c <= h) || (a <= h && c <= w);
    }
}
