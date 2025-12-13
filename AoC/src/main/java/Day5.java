import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Range {
    long start;
    long end;

    public Range(String input) {
        String[] startEnd = input.split("-");
        start = Long.parseLong(startEnd[0]);
        end = Long.parseLong(startEnd[1]);
    }

    public boolean contains(long num) {
        return num >= start && num <= end;
    }

    @Override
    public String toString() {
        return "%s...%s".formatted(start, end);
    }
}

public class Day5 {

    public ArrayList<Range> getRanges(Scanner in) {
        String line = in.nextLine();
        ArrayList<Range> ranges = new ArrayList<>();
        while (line != "") {
            ranges.add(new Range(line));
//            System.out.println(ranges.getLast());
            line = in.nextLine();
        }
        return ranges;
    }

    public boolean inAnyRange(long num, ArrayList<Range> ranges) {
        for (Range r : ranges) {
            if (r.contains(num)) return true;
        }
        return false;
    }

    public void part1(Scanner in) {
        ArrayList<Range> ranges = getRanges(in);
        long num;
        int count = 0;
        while (in.hasNext()) {
            num = Long.parseLong(in.nextLine());
            if (inAnyRange(num, ranges)) count++;
        }
        System.out.println(count);


    }

    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("AoC/src/main/java/day5-1");
        Scanner in = new Scanner(dataFile);
        Day5 app = new Day5();
        app.part1(in);
    }
}
