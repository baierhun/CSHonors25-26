import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day3 {

    public static int part1(List<Integer> i) {
        int max = Collections.max(i.subList(0, i.size() - 1));
        int maxIndex = i.indexOf(max);
        int secondMax = Collections.max(i.subList(maxIndex + 1, i.size()));
        String num = "%d%d".formatted(max, secondMax);
        return Integer.parseInt(num);
    }

    public static void main(String[] args) throws FileNotFoundException {
        // get the index of the maximum value
        // then get the index of the maximum value of the substring of the first max to the end
        // first max cannot be last digit
        File data = new File("AoC/src/main/java/day3-1");
        Scanner in = new Scanner(data);
        int total = 0;
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] ll = line.split("");
            List<Integer> i = Arrays.stream(ll)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            total += part1(i);
        }
        System.out.println(total);
    }
}
