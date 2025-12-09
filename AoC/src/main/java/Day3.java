import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day3 {

    public static long part1(List<Long> i) {
        long max = Collections.max(i.subList(0, i.size() - 1));
        int maxIndex = i.indexOf(max);
        long secondMax = Collections.max(i.subList(maxIndex + 1, i.size()));
        String num = "%d%d".formatted(max, secondMax);
        return Long.parseLong(num);
    }

    public static int maxWithNulls(Long x, Long y) {
        if (x == null && y != null) return -1; // choose y (the not null value)
        if (x != null && y == null) return 1; // choose x (the not null value)
        if (x == null && y == null) return 0; // both null are equal
        return x.compareTo(y); // otherwise compare the Longs normally
    }

    public static void setNulls(ArrayList<Long> list, int upTo) {
        for (int i = 0; i <= upTo; i++) {
            list.set(i, null);
        }
    }

    public static long part2(List<Long> i) {
        ArrayList<Long> numList = new ArrayList<>(i);
        long max = Collections.max(i.subList(0, i.size() - 11));
        int maxIndex = i.indexOf(max);
        Day3.setNulls(numList, maxIndex);
        String number = String.valueOf(max);
        for (int remaining = 10; remaining >= 0; remaining--) {
            max = Collections.max(numList.subList(0, numList.size() - remaining), Day3::maxWithNulls);
            Day3.setNulls(numList, numList.indexOf(max));
            number += String.valueOf(max);
        }
        return Long.valueOf(number);
    }

    public static void main(String[] args) throws FileNotFoundException {
        // get the index of the maximum value
        // then get the index of the maximum value of the substring of the first max to the end
        // first max cannot be last digit
        File data = new File("AoC/src/main/java/day3-1");
        Scanner in = new Scanner(data);
        Long total = 0L;
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] ll = line.split("");
            List<Long> i = Arrays.stream(ll)
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
            total += part2(i);
        }
        System.out.println(total);
        // too high: 175128170703088
        // 175053592950232
    }
}
