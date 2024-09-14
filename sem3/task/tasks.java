package task;

public class tasks {
    public static void main(String[] args) {

        // Task 1
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

        // Task 2
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));

        // Task 3
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));

        // Task 4
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));

        // Task 5
        System.out.println(trenaryEvaluation(8, 4));
        System.out.println(trenaryEvaluation(1, 11));
        System.out.println(trenaryEvaluation(5, 9));

        // Task 6
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));

        // Task 7
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        // Task 8
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));

        // Task 9
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        // Task 10
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));

    }

    // Взял американские галлоны
    public static double convert(double gallons) {
        return Math.round(gallons * 3.785 * 1000.0) / 1000.0;
    }

    public static int fitCalc(int minutes, int intensity) {
        return minutes * intensity;
    }

    public static int containers(int boxes, int bags, int barrels) {
        return boxes * 20 + bags * 50 + barrels * 100;
    }

    public static String triangleType(int X, int Y, int Z) {
        if (X + Y <= Z || Y + Z <= X || X + Z <= Y) {
            return "Невозможно постороить треугольник с заданными сторонами";
        } else if (X == Z && Z == Y) {
            return "Равносторонний";
        } else if (X == Y || Y == Z || X == Z) {
            return "Равнобедренный";
        } else
            return "Разносторонний";
    }

    public static int trenaryEvaluation(int a, int b) {
        return a > b ? a : b;
    }

    public static double howManyItems(double n, double w, double h) {
        double fabricArea = n * 2;
        double itemArea = w * h;
        return (int) fabricArea / itemArea;
    }

    public static long factorial(long number) {
        if (number == 0) {
            return 1;
        }
        long result = 1;
        for (long i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int ticketSaler(int ticketsSold, int ticketsPrice) {
        double totalPrice = ticketsPrice * 1.08; // Коммисия в 8 %
        return (int) (ticketsSold * totalPrice);
    }

    public static int tables(int students, int desks) {
        int neededDesks = (students + 1) / 2;
        return Math.max(0, neededDesks - desks);
    }

}
