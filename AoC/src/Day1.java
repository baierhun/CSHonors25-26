import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Day1 {
    private int zeroCounter;
    private int previousNum;
    private int currentNum;
    private boolean isRight; //(+) While the dial is going right the numbers are increasing, left is decreasing(-)


    public Day1(){
        zeroCounter =0;
        currentNum = 50;
        isRight = true;
    }

    private void setPreviousNum(int num){
        previousNum = num;
    }

    private void checkAndSetDirection(String s){
        if(s.contains("L")){
            isRight =  false;
        }else if (s.contains("R")) {
            isRight = true;
        }
    }
    //returns the number of times the dial is turned
    private int splitMove(String move){
        String direction = move.substring(0,1); //Gets first letter in string
        int turns =parseInt(move.substring(1));
        checkAndSetDirection(direction);
        return turns;
    }

    private void checkZero(){
        if(currentNum == 0){
            zeroCounter++;
        }
        else if (isRight && previousNum>currentNum) {
            zeroCounter++;
        }
        else if (isRight == false && previousNum<currentNum) {
            zeroCounter++;
        }
    }

    private void calcMove(int turns){
        if(turns>=100) {
            int hundreds = (int)(turns/100);
            zeroCounter+= hundreds;
            turns %= 100;
        }


        if(isRight){
            if(currentNum == 0){
                currentNum += turns;
            }
            currentNum += turns;
            if(currentNum >= 100){
                zeroCounter++;
                currentNum = currentNum % 100;
            }
        }

        else{
            if(currentNum == 0){
                currentNum = 100 - turns;
                return;
            }
            currentNum -= turns;
//          if(currentNum == 0) zeroCounter++;
            if(currentNum <= 0) {
                currentNum =  (100 + currentNum) % 100;
                zeroCounter++;
            }
        }
//        checkZero();
    }




    public static void main(String[] args) throws FileNotFoundException {
        File data = new File("/Users/reeceholt/SoftwareEngineering/AoC/src/Day1-Data.txt");
        Scanner input = new Scanner(data);
        Day1 puzzle = new Day1();

        while(input.hasNextLine()){
            String move = input.nextLine();
            puzzle.calcMove(puzzle.splitMove(move));  //move == "L35" or "R13"
            puzzle.setPreviousNum(puzzle.currentNum);
        }
        System.out.println(puzzle.zeroCounter);
    }
}