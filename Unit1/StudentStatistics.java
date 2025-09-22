public class StudentStatistics {
    private int[] grades;

    // Constructor
    public StudentStatistics(int[] grades) {
        this.grades = grades;
    }

    // 1. Calculate the average grade
    public double calculateAverage() {
        // Person A
        return 0.0; // TODO: implement
    }

    // 2. Find the highest grade
    public int findHighest() {
        // Person B
        return 0; // TODO: implement
    }

    // 3. Find the lowest grade
    public int findLowest() {
        int lowest = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }
    return lowest;
    }

    // 4. Count how many students passed (>= 60) 
    public int countPassing() {
        int numPassed = 0;
        for (int i = 0; i < grades.length; i++){
            if(grades[i] >= 60){
                numPassed++;
            }
        }
        // Person D
        return numPassed; 
    }

    // 5. Print all grades in sorted order -- Nina 
    public void printSortedGrades() {
        // grades[0] = findHighest();
        // grades[grades.length-1] = findLowest();
        for (int i = 0; i < grades.length - 1; i++){
            int maxIndex = i;
            for(int j = i+1; j < grades.length; j++){
                if(grades[j] > grades[maxIndex]){
                    maxIndex = j; 
                }
            }
            int temp = grades[i];
            grades[i] = grades[maxIndex];
            grades[maxIndex] = temp;
            
            System.out.print(grades[i] + ", ");
        }
    }

    // main for testing
    public static void main(String[] args) {
        int[] sample = {88, 55, 99, 73, 60, 45};
        StudentStatistics stats = new StudentStatistics(sample);

        System.out.println("Average: " + stats.calculateAverage());
        System.out.println("Highest: " + stats.findHighest());
        System.out.println("Lowest: " + stats.findLowest());
        System.out.println("Passing count: " + stats.countPassing());
        System.out.print("Sorted grades: ");
        stats.printSortedGrades();
    }
}
