import java.util.function.Consumer;
import java.util.function.Function;

public class Timing {
    public static void main(String[] args) {
        // background
        printTitle("veggies");
        String[] foods = {"grapes", "carrots", "peas"};
        long roughTime = roughTimeForLoop(foods, (f) -> foodFunction(f));
        long accurateTime = timeForLoop(foods, (f) -> foodFunction(f));
        System.out.println("Rough time: " + roughTime);
        System.out.println("Accurate time: " + accurateTime);
        System.out.println("%s\n".formatted("-".repeat(30)));

        // example 1
        printTitle("sums");
        long oneMil = timer(1000000, Timing::exampleOne);
        long hundredMil = timer(100000000, Timing::exampleOne);
        System.out.println("One million time: " + oneMil);
        System.out.println("Hundred million time: " + hundredMil);
        System.out.println("%s\n".formatted("-".repeat(30)));

        // example 2
        printTitle("square sums");
        long exampleTwoSumTime = timer(Timing::exampleTwoSum);
        long exampleTwoSquareSumTime = timer(Timing::exampleTwoSquareSum);
        System.out.println("Sum Time: " + exampleTwoSumTime);
        System.out.println("Square Sum Time: " + exampleTwoSquareSumTime);
        System.out.println("%s\n".formatted("-".repeat(30)));

        // exercise 1
        printTitle("count down");
        long countDownTime = timer(Timing::exerciseOne);
        System.out.println("Countdown time: " + countDownTime);
        System.out.println("%s\n".formatted("-".repeat(30)));

        // exercise 2
        printTitle("multiplication tables");
//        long multiplicationTime = timeForLoop(100, Timing::exerciseTwo);
//        long multiplicationTime500 = timeForLoop(500, Timing::exerciseTwo);
//        System.out.println("Multiplication table 100 x 100: " + multiplicationTime);
//        System.out.println("Multiplication table 500 x 500: " + multiplicationTime500);
        System.out.println("%s\n".formatted("-".repeat(30)));
    }

    private static void exerciseTwo(int upperLimit) {
        for (int r = 1; r <= upperLimit; r++) {
            int product = 0;
            for (int c = 1; c <= upperLimit; c++) {
                product = r * c;
                System.out.print("%d%s".formatted(product, getTabs(product)));
            }
            System.out.println();
        }
    }

    private static String getTabs(int value) {
        if (value < 1000) return "\t\t";
        return "\t";
    }

    private static void exerciseOne() {
        for (int i = 10_000_000; i >= 0; i--) {
        }
    }

    private static void exampleTwoSum() {
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
    }

    private static void exampleTwoSquareSum() {
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i * i;
        }
    }

    private static int exampleOne(int upperLimit) {
        int sum = 0;
        for (int i = 0; i < upperLimit; i++) {
            sum += i;
        }
        return sum;
    }

    private static void foodFunction(String[] foods) {
        for (String food : foods) {
            System.out.print(food + " ");
        }
        System.out.println();
    }

    private static <T> long roughTimeForLoop(T input, Consumer<T> func) {
        long start = System.currentTimeMillis();
        func.accept(input);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static <T> long timeForLoop(T input, Consumer<T> func) {
        long start = System.nanoTime();
        func.accept(input);
        long end = System.nanoTime();
        return end - start;
    }

    private static <T, R> long timer(T input, Function<T, R> func) {
        long start = System.nanoTime();
        R result = func.apply(input);
        long end = System.nanoTime();
        System.out.println(result);
        return end - start;

    }

    private static long timer(Runnable func) {
        long start = System.nanoTime();
        func.run();
        long end = System.nanoTime();
        return end - start;
    }

    private static void printTitle(String section) {
        int count = (25 - section.length());
        System.out.println("%s %s %s".formatted("---", section, "-".repeat(count)));
    }
}
