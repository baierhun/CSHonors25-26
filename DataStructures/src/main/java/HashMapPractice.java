import java.util.HashMap;

public class HashMapPractice {
    public static void main(String[] args) {
        HashMap<String, Integer> grades = new HashMap<>();
        grades.put("cindy", 90);
        System.out.println(grades.get("cindy"));
        grades.put("cindy", 80);
        System.out.println(grades.get("cindy"));
    }
}
