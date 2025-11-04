public class ArrayPractice {
    public static void main(String[] args) {
        //declaration
        String[] names = new String[5];
        System.out.println(names[0]);

        //Instantiate
        int[] ages = new int[5];
        ages[1] = 10;
        ages[2] = 12;
        System.out.println(ages[1]);
        boolean[] a = new boolean[3];
        System.out.println(a[0]);

        // length
        System.out.println(ages.length);

        // instantiate and populate
        String[] colors = {"red", "orange", "yellow"};

        /*
            Task:
            Create a double[] array of 7 temperatures (one for each day of the week).
            Print each day’s temperature.
            Compute and print the average temperature.
            Find the highest and lowest temperature.
         */

        // storage space
        // insert time
        // access (search) time
        // sorting time
        // int[][] grid = new int[3][3];
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // accessing
        System.out.println(grid[0][2]);
        System.out.println(grid[2][0]);

        //change
        grid[0][2] = 99;


    }

    private static void print2DArray(int[][] array) {
        for (int row = 0; row < array.length; row++) {

        }
    }
}
