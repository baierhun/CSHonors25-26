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
        while(input.hasNext()) {
            line = input.nextLine();
            direction = line.substring(0, 1);
            num = Integer.parseInt(line.substring(1));
            if (direction.equals("L")){
                dial = (dial - num) % 100;
            } else {
                dial = (dial + num) % 100;
            }
            if (dial == 0) counter ++;
        }
        System.out.println(counter);
    }

    private static void part2(Scanner input) {
        int counter = 0;
        int dial = 50;
        int clicks;
        String direction;
        String line;
        while(input.hasNext()) {
            line = input.nextLine();
            direction = line.substring(0, 1);
            clicks = Integer.parseInt(line.substring(1));
            if (direction.equals("L")){
                while(clicks > 0) {
                    dial--;
                    if (dial == -1) dial = 99;
                    if (dial == 0) counter ++;
                    clicks--;
                }
            } else {
                while(clicks > 0) {
                    dial++;
                    if (dial == 100) {
                        dial = 0;
                        counter ++;
                    }
                    clicks--;
                }
            }
        }
        System.out.println(counter);
    }

    private static void part2a(Scanner input) {
        int counter = 0;
        int dial = 50;
        int rotation;
        String direction;
        String line;
        while(input.hasNext()) {
            line = input.nextLine();
            direction = line.substring(0, 1);
            rotation = Integer.parseInt(line.substring(1));
            if (direction.equals("L")){
                // exactly once
                if(rotation >= dial && rotation <= 100 && dial != 0) counter++;
                // multiple hits
                System.out.println("Dial(%d) - Rotation(%d) mod 100 = %d".formatted(dial, rotation, (dial - rotation) % 100));
                int diff = dial - rotation;
                if (diff < 0 ) diff = 100 + diff;
                dial = (diff) % 100;
            } else {
                // exactly once
                if(100 - dial <= rotation && rotation <= 100) counter++;
                dial = (dial + rotation) % 100;
            }
            System.out.println("Dial at: %d".formatted(dial));
        }
        System.out.println(counter);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File data = new File("AoC/src/main/java/day1-1.txt");
        Scanner input = new Scanner(data);
        part2(input);
    }
}
