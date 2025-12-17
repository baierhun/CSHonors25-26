import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

class Equations implements Iterable<Equation> {
    ArrayList<Equation> equations = new ArrayList<>();
    int index = 0;

    public void add(Equation eq) {
        equations.add(eq);
    }

    public Equation get(int index) {
        return equations.get(index);
    }

    public List<Equation> subList(int start, int end) {
        return equations.subList(start, end);
    }

    public int size() {
        return equations.size();
    }

    public void split(String opsLine) {
        char[] opsChars = opsLine.toCharArray();
        String op = String.valueOf(opsChars[0]);
        char current;
        for (int i = 1; i < opsChars.length; i++) {
            current = opsChars[i];
            if (current == '*' || current == '+') {
                this.add(new Equation(op));
                op = String.valueOf(current);
            } else {
                op += " ";
            }
        }
        this.add(new Equation(op));
    }

    public long sum() {
        long total = 0L;
        for (Equation eq : equations) {
            total += eq.total();
        }
        return total;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return index < equations.size();
            }

            @Override
            public Equation next() {
                return equations.get(index++);
            }
        };
    }
}

class Equation {
    ArrayList<String> numberLines = new ArrayList<>();
    BiFunction<Long, Long, Long> op;
    int spaces;
    Long total;

    public Equation(String opLine) {
        this.addOp(opLine);
    }

    public void addLine(String line) {
        numberLines.add(line.replaceAll(" ", "0"));
    }

    private void countSpaces(String s) {
        spaces = 0;
        for (char a : s.toCharArray()) {
            if (a == ' ') spaces++;
        }
    }

    public void addOp(String op) {
        countSpaces(op);
        if (op.contains("+")) {
            this.op = (Long x, Long y) -> Math.addExact(x, y);
            total = 0L;
        } else {
            this.op = (Long x, Long y) -> Math.multiplyExact(x, y);
            total = 1L;
        }
    }

    public Long total() {
        int digits = spaces;
        for (int i = 0; i < digits; i++) {
            String verticalNumber = "";
            for (String line : numberLines) {
                String digit = line.substring(i, i + 1);
                if (digit.equals("0")) continue;
                verticalNumber += line.substring(i, i + 1);
            }
            total = op.apply(total, Long.parseLong(verticalNumber));
        }
        return total;
    }
}

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

    public void runPartII() {
        while (in.hasNext()) {
            data.push(in.nextLine());
        }
        String opsLine = data.pop();
        ArrayList<String> dataLines = new ArrayList<>();
        while (!data.empty()) dataLines.add(data.pop());
        Equations eqs = new Equations();
        eqs.split(opsLine);
        int start = 0;
        int end;
        String line;
        for (Equation eq : eqs.subList(0, eqs.size() - 1)) {
            end = start + eq.spaces;
            for (int i = dataLines.size() - 1; i >= 0; i--) {
                line = dataLines.get(i);
                eq.addLine(line.substring(start, end).replaceAll(" ", "0"));
            }
            start = end + 1;
        }
        // last one
        Equation last = eqs.get(eqs.size() - 1);
        last.spaces += 1;
        for (int i = dataLines.size() - 1; i >= 0; i--) {
            line = dataLines.get(i);
            last.addLine(line.substring(start).replaceAll(" ", "0"));
        }

        System.out.println(eqs.sum());
    }

    public static void main(String[] args) throws FileNotFoundException {
        Day6 app = new Day6();
        app.runPartII();
    }
}
