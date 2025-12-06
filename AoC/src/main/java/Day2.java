import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.Function;

public class Day2 {
    private long sum = 0;
    private Function<String, Boolean> isInvalid;

    public Day2(Function<String, Boolean> isInvalid) {
        this.isInvalid = isInvalid;
    }

    public static boolean isInvalidOne(String number) {
        if (number.length() % 2 == 1) return false;
        int middle = number.length() / 2;
        String left = number.substring(0, middle);
        String right = number.substring(middle);
        return left.equals(right);
    }

    private boolean isInvalid(String number) {
        return isInvalid.apply(number);
    }

    private void checkRange(String start, String end) {
        long startL = Long.parseLong(start);
        long endL = Long.parseLong(end);
        for (long s = startL; s <= endL; s++) {
            String current = String.valueOf(s);
            if (isInvalid(current)) {
                sum += s;
            }
        }
    }

    // range is ###-###
    private void processRange(String range) {
        String[] splitRange = range.split("-");
        String startRange = splitRange[0];
        String endRange = splitRange[1];
        checkRange(startRange, endRange);
    }

    private void runOne(Scanner in) {
        String allData = in.nextLine();
        String[] ranges = allData.split(",");
        for (String range : ranges) {
            processRange(range);
        }
    }

    //  ------------------------------------------------------------------------------------------------
    private void partTwo(Scanner in) {
        String allData = in.nextLine();
        String[] ranges = allData.split(",");
        for (String range : ranges) {
            processRange(range);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File data = new File("AoC/src/main/java/day2-1");
        Scanner in = new Scanner(data);
        Day2 app = new Day2(Day2::isInvalidOne);
        app.runOne(in);
        System.out.println(app.sum);
    }
}
