import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static long sum = 0;

    public static boolean shouldIgnore(String[] startEnd) {
        return startEnd[0].length() % 2 != 0 && startEnd[0].length() == startEnd[1].length();
    }

    public static String getHalf(String num) {
        int length;
        if (num.length() % 2 == 0) length = num.length() / 2;
        else length = num.length() / 2 + 1;
        return num.substring(0, length);
    }

    public static int checkForSingleValue(String num) {
        return checkForSingleValue(num, false);
    }

    public static int checkForSingleValue(String num, boolean isEnd) {
        String firstHalf = getHalf(num);
        int firstHalfNum = Integer.parseInt(firstHalf);
        int secondHalf = Integer.parseInt(num.split(firstHalf, 2)[1]);

        if (isEnd) {
            if (firstHalfNum >= secondHalf) return 1;
            return 0;
        }
        if (firstHalfNum <= secondHalf) return 1;
        return 0;
    }

    public static int processSameLength(String start, String end) {
        int sum = 0;
        String startHalf = getHalf(start);
        String endHalf = getHalf(end);

        // find difference between first halves
        int startHalfVal = Integer.parseInt(startHalf);
        int endHalfVal = Integer.parseInt(endHalf);
        int diff = startHalfVal - endHalfVal;
        if (diff > 0) sum += diff;
        // check first and last
        sum += checkForSingleValue(start);
        sum += checkForSingleValue(end, true);
        return sum;
    }

    private static String getTop(String base) {
        String top = "1";
        for (int i = 0; i < base.length(); i++) {
            top += "0";
        }
        return String.valueOf(Integer.parseInt(top) - 1);
    }

    private static String getBottom(String base) {
        String bottom = "1";
        for (int i = 0; i < base.length() - 1; i++) {
            bottom += "0";
        }
        return String.valueOf(Integer.parseInt(bottom));
    }

    private static void attempt1(Scanner in) {
        String allData = in.nextLine();
        int sum = 0;
        for (String range : allData.split(",")) {
            String[] startEnd = range.split("-");
            if (shouldIgnore(startEnd)) continue;

            String start = startEnd[0];
            String end = startEnd[1];
            if (start.length() == end.length()) {
                sum += processSameLength(start, end);
            } else {
                // if numbers are not the same length
                // only need to check the one with the even length
                if (start.length() % 2 == 0) {
                    sum += processSameLength(start, getTop(start));
                } else {
                    sum += processSameLength(getBottom(end), end);
                }
            }
        }
        System.out.println(sum);
    }
// -------------------------------------------------------------------------------------
    private static boolean isInvalid(String number){
        int middle = number.length()/2;
        String left = number.substring(0, middle);
        String right = number.substring(middle);
        return left.equals(right);
    }

    private static void checkRange(String start, String end){
        long startL = Long.parseLong(start);
        long endL = Long.parseLong(end);
        for(long s = startL; s <= endL ; s++){
            String current = String.valueOf(s);
            if (current.length() % 2 == 1) continue;
            if (isInvalid(current)) {
                Day2.sum += s;
            }
        }
    }

    // range is ###-###
    private static void processRange(String range){
        String[] splitRange = range.split("-");
        String startRange = splitRange[0];
        String endRange = splitRange[1];
        checkRange(startRange, endRange);
    }

    private static void attempt2(Scanner in) {
        String allData = in.nextLine();
        String[] ranges = allData.split(",");
        int sum = 0;
        for(String range : ranges){
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
