import java.io.File;

import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Day3 {

    private static int totalJolts;


    private static int findGreatest(int[] a) {
        int index = 0; //equals index which element is found
        int greatest = a[0];
        for (int i = 0; i < a.length - 1; i++) {  //doesnt look at last element
            if (a[i] > greatest) {        // finds greatest tens place
                greatest = a[i];
                index = i;
            }
        }

        a[index] = 0;
        int greatestOnes = a[index + 1];
        for (int j = 0; j < a.length; j++) {
            if (j <= index) {
                continue;
            } else {
                if (a[j] > greatestOnes) {
                    greatestOnes = a[j];
                }
            }
        }
        String joltsString = String.valueOf(greatest) + String.valueOf(greatestOnes);
        int jolts = parseInt(joltsString);
        return jolts;
    }




    public static void main(String[] args) throws Exception{
        File data = new File("/Users/reeceholt/SoftwareEngineering/AoC/src/Day3-Data.txt");
        Scanner input = new Scanner(data);

        int joltsTotal = 0;
        while(input.hasNextLine()) {
            String[] stringBattery = input.nextLine().split("");
            int[] intBattery = new int[stringBattery.length];
            for (int i = 0; i < stringBattery.length; i++) {
                intBattery[i] = parseInt(stringBattery[i]);
            }
            int currentJolts = findGreatest(intBattery);
            System.out.println(currentJolts);
            joltsTotal += currentJolts;
        }
        System.out.println(joltsTotal);
    }
}
