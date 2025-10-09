# Lambda Functions

## 1. What is a Lambda?
A **lambda expression** is a short way to write an **anonymous function** (a function without a name).
- It can be used anywhere a **functional interface** is expected.
- Syntax:

```java
(parameters) -> expression
```

or

```java
(parameters) -> { statements }
```

---

## 2. Why Use Lambdas?
- **Concise**: Less boilerplate compared to anonymous inner classes.
- **Readable**: Makes functional-style programming easier.
- **Useful**: Works with higher-order functions (e.g., Streams).

---

## 3. Basic Examples

### Example 1: With One Parameter
```java
import java.util.function.Function;

public class LambdaExample {
    public static void main(String[] args) {
        // Lambda that squares a number
        Function<Integer, Integer> square = x -> x * x;

        System.out.println(square.apply(5)); // Output: 25
    }
}
```

---

### Example 2: With Multiple Parameters
```java
import java.util.function.BiFunction;

public class LambdaExample2 {
    public static void main(String[] args) {
        // Lambda that adds two numbers
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        System.out.println(add.apply(3, 4)); // Output: 7
    }
}
```

---

### Example 3: With No Parameters
```java
import java.util.function.Supplier;

public class LambdaExample3 {
    public static void main(String[] args) {
        // Lambda with no input, just returns a string
        Supplier<String> greet = () -> "Hello, world!";

        System.out.println(greet.get()); // Output: Hello, world!
    }
}
```

---

## 4. Using Lambdas with Collections

### Sorting with a Lambda
```java
import java.util.*;

public class LambdaSortExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Charlie", "Alice", "Bob"));

        // Sort alphabetically using lambda
        names.sort((a, b) -> a.compareTo(b));

        System.out.println(names); // [Alice, Bob, Charlie]
    }
}
```

---

## 5. Lambdas with Streams
The **Streams API** in Java uses lambdas heavily.

```java
import java.util.List;

public class StreamLambdaExample {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        nums.stream()
            .filter(n -> n % 2 == 0)    // keep even numbers
            .map(n -> n * n)            // square them
            .forEach(x -> System.out.println(x));
    }
}
```

Output:
```
4
16
```

---

## 6. Key Rules About Lambdas
- Parameter types can be **inferred** (no need to write them if obvious).
- If there’s **one parameter**, parentheses can be omitted: `x -> x * x`.
- If there’s **one expression**, braces and `return` can be omitted.
- Lambdas can **only be used where a functional interface is expected**.

---

## 7. Practice Exercises
1. Write a lambda that checks if a number is even.
2. Write a lambda that takes two strings and returns the longer one.
3. Use a lambda in a `forEach` loop to print all items in a list.
4. Use lambdas with `stream()` to:
    - Filter out numbers less than 10.
    - Multiply the remaining numbers by 2.
    - Print the results.  

