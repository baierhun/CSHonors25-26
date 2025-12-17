import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    private static void part1(Scanner input) {
        int counter = 0;
        int dial = 50;
        int num;
        String direction;
        String line;
        while (input.hasNext()) {
            line = input.nextLine();
            direction = line.substring(0, 1);
            num = Integer.parseInt(line.substring(1));
            if (direction.equals("L")) {
                dial = (dial - num) % 100;
            } else {
                dial = (dial + num) % 100;
            }
            if (dial == 0) counter++;
        }
        System.out.println(counter);
    }

    private static void part2(Scanner input) {
        int counter = 0;
        int dial = 50;
        int clicks;
        String direction;
        String line;
        while (input.hasNext()) {
            line = input.nextLine();
            direction = line.substring(0, 1);
            clicks = Integer.parseInt(line.substring(1));
            if (direction.equals("L")) {
                while (clicks > 0) {
                    dial--;
                    if (dial == -1) dial = 99;
                    if (dial == 0) counter++;
                    clicks--;
                }
            } else {
                while (clicks > 0) {
                    dial++;
                    if (dial == 100) {
                        dial = 0;
                        counter++;
                    }
                    clicks--;
                }
            }
        }
        System.out.println(counter);
    }

    private static int getRotations(String input) {
        return Integer.parseInt(input.substring(1));
    }

    private static String getDirection(String input) {
        return input.substring(0, 1);
    }

    private static void part2Class(Scanner input) {
        int zeroCounter = 0;
        int position = 50;
        while (input.hasNext()) {
            // parse input
            String command = input.nextLine();
            String direction = getDirection(command);
            int rotations = getRotations(command);

            // handle hundreds rotations
            int hundreds = rotations / 100;
            zeroCounter += hundreds;

            // the rotations without the hundreds
            // ex: if rotations is 876, parsedRotations is 76
            int parsedRotations = rotations - hundreds * 100;

            // handle parsedRotations
            //      nextPosition is position +(R)/-(L) parsedRotations
            //      if Right and nextPosition < 100
            //          move position to nextPosition
            //      if Right and nextPosition >= 100
            //          add 1 to zero counter
            //          position = nextPosition - 100
            //      if Left and nextPosition > 0
            //          move position to nextPosition
            //      if Left and position is 0
            //          just update the position (we've already accounted for 0s)
            //      if Left and nextPosition <= 0
            //          add 1 to zero counter
            //          position = 100 + nextPosition

            int nextPosition;
            if (direction.equals("R")) {
                nextPosition = position + parsedRotations;
                if (nextPosition < 100) position = nextPosition;
                else {
                    zeroCounter++;
                    position = nextPosition - 100;
                }
            } else {
                nextPosition = position - parsedRotations;
                if (nextPosition > 0) position = nextPosition;
                else if (position == 0) position = 100 + nextPosition;
                else {
                    zeroCounter++;
                    position = 100 + nextPosition;
                    if (position == 100) position = 0;
                }
            }
        }
        System.out.println(zeroCounter);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File data = new File("AoC/src/main/java/day1-1.txt");
        Scanner input = new Scanner(data);
        part2Class(input);
    }
}
