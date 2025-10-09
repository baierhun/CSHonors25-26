# Generics

## 1. What are Generics?
**Generics** let you write classes, interfaces, and methods that can work with **any type** while still being type-safe.
- Without generics: you often use `Object`, which requires **casting** and can cause **runtime errors**.
- With generics: you can specify the type when you create the object, and the compiler checks it at **compile time**.

---

## 2. Why Use Generics?
- **Type safety**: Errors are caught at compile time, not runtime.
- **Code reusability**: One generic class/method can work with many types.
- **Eliminate casts**: No need to cast back from `Object`.

---

## 3. Generic Classes

### Example: A Generic Box
```java
public class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello");
        System.out.println(stringBox.get()); // Hello

        Box<Integer> intBox = new Box<>();
        intBox.set(42);
        System.out.println(intBox.get()); // 42
    }
}
```

- `T` is a **type parameter** (like a variable for types).
- When you create `Box<String>`, `T` becomes `String`.

---

## 4. Generic Methods
You can define a **generic method** inside a class.

```java
public class GenericMethodExample {
    // Generic method
    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry"};
        Integer[] numbers = {1, 2, 3, 4};

        printArray(words);   // apple banana cherry
        printArray(numbers); // 1 2 3 4
    }
}
```

---

## 5. Bounded Type Parameters
Sometimes you want generics to work only on certain types.

```java
public class MathUtils {
    // T must be a subclass of Number
    public static <T extends Number> double square(T number) {
        return number.doubleValue() * number.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(square(5));      // 25.0
        System.out.println(square(3.14));   // 9.8596
        // square("hello"); // ❌ compile-time error
    }
}
```

---

## 6. Wildcards in Generics
- `?` means "an unknown type."
- Useful when you don’t care about the exact type, just that it’s *some* type.

```java
import java.util.List;

public class WildcardExample {
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        List<String> words = List.of("a", "b", "c");
        List<Integer> numbers = List.of(1, 2, 3);

        printList(words);   // works
        printList(numbers); // works
    }
}
```

---

## 7. Real-World Uses of Generics
- `ArrayList<T>` → stores any type, but keeps type safety.
- `HashMap<K, V>` → stores key-value pairs with type safety.
- `Optional<T>` → represents a value that might be present or absent.

---

## 8. Practice Exercises
1. Write a generic class `Pair<K, V>` that stores two values of possibly different types.
2. Write a generic method `countOccurrences(T[] array, T value)` that counts how many times a value appears.
3. Create a method `<T extends Comparable<T>> T max(T a, T b)` that returns the larger of two values.
4. Use a wildcard `List<?>` to write a method that prints any list.  
