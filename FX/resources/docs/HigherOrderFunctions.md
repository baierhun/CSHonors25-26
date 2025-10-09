# Higher-Order Functions

## 1. What is a Higher-Order Function?
A **higher-order function** is a function that does one of the following:
- **Takes another function as a parameter**, or  
- **Returns a function as its result**.  

In Java, functions are represented using [**functional interfaces**](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/function/package-summary.html) (like `Function`, `Consumer`, `Predicate`, `Supplier`).

---

## 2. Why Use Higher-Order Functions?
- Encourages **functional programming** style.  
- Makes code more **flexible** and **reusable**.  
- Works seamlessly with **lambdas** and **streams**.

---

## 3. Example: Passing Functions as Parameters

```java
import java.util.function.Function;

public class HigherOrderExample {
    // Higher-order function: takes a function as an argument
    public static int applyTwice(Function<Integer, Integer> func, int value) {
        return func.apply(func.apply(value));
    }

    public static void main(String[] args) {
        // Lambda: multiply by 2
        Function<Integer, Integer> doubleIt = x -> x * 2;

        int result = applyTwice(doubleIt, 5); 
        System.out.println(result); // Output: 20 ( (5*2) * 2 )
    }
}
```

---

## 4. Example: Returning a Function

```java
import java.util.function.Function;

public class ReturnFunctionExample {
    // Higher-order function: returns a function
    public static Function<Integer, Integer> multiplyBy(int factor) {
        return x -> x * factor;
    }

    public static void main(String[] args) {
        Function<Integer, Integer> triple = multiplyBy(3);

        System.out.println(triple.apply(4)); // Output: 12
    }
}
```

---

## 5. Example: With Collections

```java
import java.util.*;
import java.util.function.Predicate;

public class CollectionExample {
    // Higher-order function: filters a list using a predicate
    public static List<Integer> filter(List<Integer> numbers, Predicate<Integer> condition) {
        List<Integer> result = new ArrayList<>();
        for (int n : numbers) {
            if (condition.test(n)) {
                result.add(n);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);

        // Use lambda to filter even numbers
        List<Integer> evens = filter(nums, n -> n % 2 == 0);

        System.out.println(evens); // Output: [2, 4, 6]
    }
}
```

---

## 6. Summary
- A **higher-order function** takes functions as inputs or outputs.  
- In Java, this is done with **functional interfaces** and **lambdas**.  
- Common use cases: filtering, mapping, reducing collections.
