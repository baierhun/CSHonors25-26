import java.io.File;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;



public class Day3 {



    private static long findGreatest(int[] a) {
        int limit = a.length-12;
        int[] jolts = new int[a.length];
        int index = 0; //equals index which element is found

        for (int i = 0; i < a.length; i++) {  //doesnt look at last element
            int num = a[i];
            while(limit > 0 && index > 0 && jolts[index - 1] < num){
                index--;
                limit--;
            }
            jolts[index] = num;
            index++;
        }
        index = 12;
        long joltsValue = 0;
        for (int j = 0; j < 12; j++) {
           joltsValue = joltsValue * 10 + jolts[j];
        }


            return joltsValue;
    }

    private static int findValue(int[] a, int v){
        for (int i = 0; i < a.length; i++) {
            if(a[i] == v){
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) throws Exception{
        File data = new File("/Users/reeceholt/SoftwareEngineering/CSHonors25-26/AoC/src/Day3-Data.txt");
        Scanner input = new Scanner(data);

        long joltsTotal = 0;
        while(input.hasNextLine()) {
            String[] stringBattery = input.nextLine().split("");
            int[] intBattery = new int[stringBattery.length];
            for (int i = 0; i < stringBattery.length; i++) {
                intBattery[i] = parseInt(stringBattery[i]);
            }
            long currentJolts = findGreatest(intBattery);
            System.out.println(currentJolts);
            joltsTotal += currentJolts;
        }
        System.out.println(joltsTotal);
    }
}
