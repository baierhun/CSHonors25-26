import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isValid(int maxX, int maxY) {
        return x >= 0 && x <= maxX - 1 && y >= 0 && y <= maxY - 1;
    }
}

public class Day4 {
    private ArrayList<String> data = new ArrayList<>();
    private Set<Point> removedPoints = new HashSet<>();
    private Scanner in;
    private int maxX = 0;
    private int maxY = 0;

    public Day4(Scanner in) {
        this.in = in;

    }

    public int getAdjacentRolls(int x, int y) {
        Point topLeft = new Point(x - 1, y - 1);
        Point topMiddle = new Point(x, y - 1);
        Point topRight = new Point(x + 1, y - 1);
        Point middleLeft = new Point(x - 1, y);
        Point middleRight = new Point(x + 1, y);
        Point bottomLeft = new Point(x - 1, y + 1);
        Point bottomMiddle = new Point(x, y + 1);
        Point bottomRight = new Point(x + 1, y + 1);
        List<Point> points = List.of(topLeft, topMiddle, topRight, middleLeft, middleRight, bottomLeft, bottomMiddle, bottomRight);
        int total = 0;
        for (Point point : points) {
            if (point.isValid(maxX, maxY) && isPaperRoll(data.get(point.y).charAt(point.x))) {
                total++;
            }
        }
        return total;
    }

    public boolean isPaperRoll(char input) {
        return input == '@';
    }

    public void printBoard() {
        for (String line : data) {
            System.out.println(String.join("", line.split("")));
        }
    }

    public void removePoints() {
        String line;
        StringBuilder s;
        for(Point point : removedPoints){
            line = data.get(point.y);
            s = new StringBuilder(line.substring(0, point.x));
            s.append(".");
            s.append(line.substring(point.x + 1));
            data.set(point.y, s.toString());
        }
        removedPoints.clear();
    }

    public void part2() {
        while (in.hasNext()) data.add(in.nextLine());
        int accessibleRolesOneRound = 0;
        int accessibleRolesTotal = 0;
        String line;
        maxX = data.getFirst().length();
        maxY = data.size();
        do {
            accessibleRolesOneRound = 0;
            for (int y = 0; y < data.size(); y++) {
                line = data.get(y);
                for (int x = 0; x < line.length(); x++) {
                    if (isPaperRoll(line.charAt(x))) {
                        int adjacentRolls = getAdjacentRolls(x, y);
                        if (adjacentRolls < 4) {
                            accessibleRolesOneRound++;
                            removedPoints.add(new Point(x, y));
                        }
                    }
                }
            }
            accessibleRolesTotal += accessibleRolesOneRound;
            removePoints();
//            printBoard();
        } while (accessibleRolesOneRound > 0);
        System.out.println(accessibleRolesTotal);
    }

    public void part1() {
        while (in.hasNext()) data.add(in.nextLine());
        String line;
        int accessibleRoles = 0;
        maxX = data.getFirst().length();
        maxY = data.size();
        for (int y = 0; y < data.size(); y++) {
            line = data.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (isPaperRoll(line.charAt(x))) {
                    int adjacentRolls = getAdjacentRolls(x, y);
                    if (adjacentRolls < 4) accessibleRoles++;
                }
            }
        }
        System.out.println(accessibleRoles);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("AoC/src/main/java/day4-1");
        Scanner in = new Scanner(dataFile);
        Day4 app = new Day4(in);
        app.part1();
    }
}
