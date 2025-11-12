import java.util.LinkedList;

public class LinkedListPractice {
    /*
        Manage a To-Do List
        Create a LinkedList<String> to store tasks.
        1. Add two tasks to the linked list (at the end)
        2. Add three tasks to the beginning.
        3. Add the task "homework" at index 3
        4. Remove the third task in the list by its index.
        5. Remove the task "homework" by object
        6. Remove the last element
        7. print the final list
     */
    public static void main(String[] args) {
        LinkedList<String> todo = new LinkedList<>();
        todo.addLast("do work");
        todo.add("groceries");
        todo.addFirst("pick up kids");
        todo.push("listen to radio");
        todo.addLast("change shoes");
        todo.add(3, "homework");
        todo.remove(2);
        todo.remove("homework");
        todo.removeLast();
        for(String e : todo) {
            System.out.print("%s | ".formatted(e));
        }
        todo.toString();
        System.out.println(todo);

    }
}
