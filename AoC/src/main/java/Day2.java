import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static long sum = 0;

    private static boolean isInvalid(String number) {
        int middle = number.length() / 2;
        String left = number.substring(0, middle);
        String right = number.substring(middle);
        return left.equals(right);
    }

    private static void checkRange(String start, String end) {
        long startL = Long.parseLong(start);
        long endL = Long.parseLong(end);
        for (long s = startL; s <= endL; s++) {
            String current = String.valueOf(s);
            if (current.length() % 2 == 1) continue;
            if (isInvalid(current)) {
                Day2.sum += s;
            }
        }
    }

    // range is ###-###
    private static void processRange(String range) {
        String[] splitRange = range.split("-");
        String startRange = splitRange[0];
        String endRange = splitRange[1];
        checkRange(startRange, endRange);
    }

    private static void attempt2(Scanner in) {
        String allData = in.nextLine();
        String[] ranges = allData.split(",");
        for (String range : ranges) {
            processRange(range);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File data = new File("AoC/src/main/java/day2-1");
        Scanner in = new Scanner(data);
        attempt2(in);
        System.out.println(Day2.sum);

    }
}
