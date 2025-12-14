import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Ranges {
    ArrayList<Range> ranges = new ArrayList<>();

    public void add(String range) {
        this.add(new Range(range));
    }

    public void add(Range range) {
        adjustForOverlap(range);
    }

    private void adjustForOverlap(Range newRange) {
        if (ranges.size() == 0) {
            ranges.add(newRange);
            return;
        }
        Range oldRange;
        for (int i = 0; i < ranges.size(); i++) {
            oldRange = ranges.get(i);
            // newStart ... oldStart/End ... newEnd -> newStart ... newEnd
            if (newRange.start <= oldRange.start && newRange.end >= oldRange.end) {
                ranges.remove(i);
                ranges.add(newRange);
                return;
            }

            // newStart ... oldStart ... newEnd ... oldEnd -> newStart ... oldEnd
            if (newRange.start <= oldRange.start && newRange.end >= oldRange.start && newRange.end <= oldRange.end) {
                ranges.remove(i);
                adjustForOverlap(new Range(newRange.start, oldRange.end));
                return;
            }

            // oldStart ... newStart ... oldEnd ... newEnd -> oldStart ... newEnd
            if (oldRange.start <= newRange.start && oldRange.end >= newRange.start && oldRange.end <= newRange.end) {
                ranges.remove(i);
                adjustForOverlap(new Range(oldRange.start, newRange.end));
                return;
            }
            // oldStart ... newStart/End ... oldEnd -> skip
            if (oldRange.start <= newRange.start && newRange.end <= oldRange.end) return;
        }
        ranges.add(newRange);

    }

    public long count() {
        long count = 0;
        for (Range r : ranges) {
            count += r.end - r.start + 1;
        }
        return count;
    }

    public void print() {
        for (Range r : ranges) {
            System.out.println(r);
        }
    }
}

class Range {
    long start;
    long end;

    public Range(String input) {
        String[] startEnd = input.split("-");
        start = Long.parseLong(startEnd[0]);
        end = Long.parseLong(startEnd[1]);
    }

    public Range(long start, long end) {
        this.start = start;
        this.end = end;
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

    public void part2(Scanner in) {
        Ranges ranges = new Ranges();
        String rangeString = in.nextLine();
        while (rangeString != "") {
            ranges.add(rangeString);
            rangeString = in.nextLine();
        }
        System.out.println(ranges.count());
    }

    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("AoC/src/main/java/day5-1");
        Scanner in = new Scanner(dataFile);
        Day5 app = new Day5();
        app.part2(in);
    }
}
