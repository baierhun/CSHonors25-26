import java.util.*;

public class Summary {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        LinkedList<String> ll = new LinkedList<>();
        Stack<String> st = new Stack<>();
        Queue<String> qu = new LinkedList<>();
        HashMap<String, Integer> hm = new HashMap<>();


        al.add("hello");
        ll.add("hello");
        st.push("hello");
        qu.add("hello");
        hm.put("hello", 1);
        hm.keySet();

        Scanner s = new Scanner(System.in);
        s.close();
        try {
            int i = s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("handling input mismatch!");
        } catch (IllegalStateException e) {
            System.out.println("handling illegal state");
        }
    }
}
