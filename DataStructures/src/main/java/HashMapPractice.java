import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {
    public static void main(String[] args) {
        HashMap<String, Integer> grades = new HashMap<>();
        grades.put("cindy", 90);
        System.out.println(grades.get("cindy"));
        grades.put("cindy", 80);
        System.out.println(grades.get("cindy"));
        grades.isEmpty();
        grades.containsKey("cindy");
        grades.putIfAbsent("cindy", 90);
        grades.put("bob", 20);

        for(Map.Entry<String, Integer> item : grades.entrySet()) {
            System.out.println("%s: %d".formatted(item.getKey(), item.getValue()));
        }

    }
}
