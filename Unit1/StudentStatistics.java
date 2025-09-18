public class StudentStatistics {
    private int[] grades;

    // Constructor
    public StudentStatistics(int[] grades) {
        this.grades = grades;
    }

    // 1. Calculate the average grade
    private int totalGrades(int[] scores){
        int total = 0;
        for(int score : scores){
            total += score;
        }
        return total;
    }

    public double calculateAverage() {
        double average = totalGrades(grades)/grades.length;
        return average; // TODO: implement
    }

    // 2. Find the highest grade
    public int findHighest() {
        // Person B
        return 0; // TODO: implement
    }

    // 3. Find the lowest grade
    public int findLowest() {
        // Person C
        return 0; // TODO: implement
    }

    // 4. Count how many students passed (>= 60)
    public int countPassing() {
        // Person D
        return 0; // TODO: implement
    }

    // 5. Print all grades in sorted order
    public void printSortedGrades() {
        // Person E
        // TODO: implement
    }

    // main for testing
    public static void main(String[] args) {
        int[] sample = {88, 55, 99, 73, 60, 45};
        StudentStatistics stats = new StudentStatistics(sample);

        System.out.println("Average: " + stats.calculateAverage());
        // System.out.println("Highest: " + stats.findHighest());
        // System.out.println("Lowest: " + stats.findLowest());
        // System.out.println("Passing count: " + stats.countPassing());
        // System.out.print("Sorted grades: ");
        // stats.printSortedGrades();
    }
}
