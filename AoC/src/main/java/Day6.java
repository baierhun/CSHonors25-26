import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Day6 {
    File fileData = new File("AoC/src/main/java/day6-1");
    Scanner in = new Scanner(fileData);
    Stack<String> data = new Stack<>();
    ArrayList<List<Long>> dataLines = new ArrayList<>();

    public Day6() throws FileNotFoundException {
    }

    public void processLine(String line) {
        List<Long> a = List.of(line.split(" "))
                .stream()
                .filter(x -> x != "")
                .map(Long::parseLong)
                .collect(Collectors.toList());
        dataLines.add(a);
    }

    public long addLines(String[] ops) {
        long[] totals = new long[ops.length];
        Optional<Long> total;
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            ArrayList<Long> x = new ArrayList<>();
            for (List<Long> l : dataLines) {
                x.add(l.get(i));
            }
            if (op.equals("+")) total = x.stream().reduce(Math::addExact);
            else total = x.stream().reduce(Math::multiplyExact);
            totals[i] = total.orElse(0L);
        }
        long grandTotal = 0;
        for (long lineTotal : totals) grandTotal += lineTotal;
        System.out.println(grandTotal);
        return grandTotal;
    }

    public void run() {
        while (in.hasNext()) {
            data.push(in.nextLine());
        }
        String[] ops = data.pop().replaceAll(" ", "").split("");
        while (!data.empty()) {
            processLine(data.pop());
        }
        addLines(ops);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Day6 app = new Day6();
        app.run();
    }
}
