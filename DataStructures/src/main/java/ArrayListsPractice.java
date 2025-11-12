import java.util.ArrayList;
import java.util.List;

public class ArrayListsPractice {
    public static void main(String[] args) {
        // construction
        ArrayList<String> groceries = new ArrayList<>();

        // adding elements
        groceries.add("Milk");
        groceries.add("eggs");
        groceries.add("bread");
        printArray(groceries);
        // accessing elements
        System.out.println(groceries.get(1));

        // changing an element
        groceries.set(2, "bagel");
        printArray(groceries);

        // removing elements
        groceries.remove("eggs");
        printArray(groceries);

        System.out.println(groceries.size());

        /*
        Create an ArrayList<String> called movies.
        Add at least 5 movie titles.
        Print the list using a loop.
        Remove one movie and print the updated list.
         */

        List<String> movieList = new ArrayList<>(List.of(
                "The Big Lebowski",
                "The Godfather",
                "Fight Club"
        ));
    }

    private static void printArray(List<String> list) {
        int index = 1;
        for (String item : list) {
            System.out.print("%d. %s - ".formatted(index, item));
            index += 1;
        }
        System.out.println();
    }
}
