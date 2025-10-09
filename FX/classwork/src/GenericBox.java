import java.util.ArrayList;
import java.util.List;

class ArrayPrinter {
    public static <V> void printArray(V[] array) {
        for (V item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

public class GenericBox<T> {
    private T value;

    public GenericBox(T value) {
        this.value = value;
    }

    public GenericBox() {
    }

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    @Override
    public String toString() {
        return "GenericBox{" +
                "value=" + value +
                '}';
    }

    public static void main(String[] args) {
        GenericBox<String> s = new GenericBox<>("Hello, world!");
        GenericBox<String> t = new GenericBox<>("How are you?");

        GenericBox<Integer> i = new GenericBox<>();
        System.out.println(s);

        String[] fruits = {"apple", "banana", "cherry"};
        ArrayPrinter.printArray(fruits);
        Integer[] ages = {1,2,3,4};
        ArrayPrinter.printArray(ages);

        // This does not work because of "type erasure"
        // Java removes generic type information at runtime but
        // arrays need types at runtime.
        // GenericBox<String>[] gb = {s, t};
        // Instead, use Collections (but this will not work with our generic print method)
        List<GenericBox<String>> gb = new ArrayList<>();
        gb.add(s);
        gb.add(t);
    }

}
