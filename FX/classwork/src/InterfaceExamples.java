interface Animal {
    public abstract void makeSound();
}

class Shark implements Animal {

    @Override
    public void makeSound() {
        System.out.println("Shark swimming silently");
    }
}

public class InterfaceExamples {
    public static void listen(Animal a) {
        a.makeSound();
    }

    public static void main(String[] args) {
        Animal s = new Shark();
        Animal t = new Shark();
        Animal lion = () -> System.out.println("Roar!");

        listen(lion);
    }

}
