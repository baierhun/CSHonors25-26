import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

enum Side {
    RIGHT,
    LEFT
}

class Node {
    //    public ArrayList<Node> connections = new ArrayList<>();
    public Node leftConnection = null;
    public Node rightConnection = null;
    public boolean visited = false;
    public int row;
    public int col;

    public Node(int row, int index) {
        this.row = row;
        this.col = index;
    }

    public boolean canConnect(Side side) {
        if (side == Side.LEFT) return leftConnection == null;
        return rightConnection == null;
    }

    public void connect(Node node, Side side) {
        if (!canConnect(side)) throw new ArrayIndexOutOfBoundsException("Node cannot have more than 2 connections.");
        if (side == Side.LEFT) leftConnection = node;
        rightConnection = node;
    }


}

class Splitter {
    int lineNumber;
    int index;

    public Splitter(int lineNumber, int index) {
        this.lineNumber = lineNumber;
        this.index = index;
    }
}

public class Day7 {
    File dataFile = new File("AoC/src/main/java/day7-2");
    Scanner in = new Scanner(dataFile);
    long total = 0;

    public Day7() throws FileNotFoundException {
    }

    public void runI() {
        String line = in.nextLine();
        Set<Integer> indecies = new HashSet<>();
        indecies.add(line.indexOf("S"));
        int total = 0;
        while (in.hasNext()) {
            line = in.nextLine();
            for (int index : indecies.stream().toList()) {
                if (line.charAt(index) == '^') {
                    indecies.remove(index);
                    indecies.add(index - 1);
                    indecies.add(index + 1);
                    total++;
                }
            }
        }
        System.out.println(total);
    }

    public ArrayList<Node> makeNodeList(ArrayList<String> lines) {
        ArrayList<Node> nodes = new ArrayList<>();
        int rowNum = 0;
        for (String row : lines) {
            int i = 0;
            for (char letter : row.toCharArray()) {
                if (letter == '^') nodes.add(new Node(rowNum, i));
                i++;
            }
            rowNum++;
        }
        return nodes;
    }

    public void checkBelow(List<String> lines, int lineIndex) {
        if (lines.size() == 1) {
            total++;
            return;
        }
        String line = lines.getFirst();
        if (line.charAt(lineIndex) == '^') {
            checkBelow(lines.subList(1, lines.size()), lineIndex - 1);
            checkBelow(lines.subList(1, lines.size()), lineIndex + 1);
        } else
            checkBelow(lines.subList(1, lines.size()), lineIndex);
    }

    public List<String> getData() {
        ArrayList<String> lines = new ArrayList<>();
//        lines.add(in.nextLine()); // S line
//        String line;
        while (in.hasNext()) {
//            line = in.nextLine();
            lines.add(in.nextLine());
        }
        return lines;
    }

    public void processQueue(Splitter s, String[] lines, Stack<Splitter> queue) {
        // go right once, then all lefts
        int targetIndex = s.index + 1;
        for (int i = s.lineNumber + 2; i < lines.length; i += 2) {
            if (lines[i].charAt(targetIndex) == '^') {
                queue.add(new Splitter(i, targetIndex));
                targetIndex -= 1;
            }
        }
        total++;
    }

    public void runIILoops() {
        Stack<Splitter> rightQueue = new Stack<>();
        List<String> lines = getData();
        String[] s = new String[lines.size()];
        int i = 0;
        for(String line : lines){
            s[i] = line;
            i++;
        }
        // artificially left align first one
        Splitter firstSplitter = new Splitter(0, lines.get(0).indexOf("S") - 1);
        rightQueue.push(firstSplitter);
        while (!rightQueue.isEmpty()) {
            processQueue(rightQueue.pop(), s, rightQueue);
        }

    }

    public void runII() {
        List<String> lines = getData();
        int sIndex = lines.getFirst().indexOf('S');
        checkBelow(lines.subList(1, lines.size()), sIndex);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Day7 app = new Day7();
        app.runIILoops();
        System.out.println(app.total);
    }
}
