import java.util.ArrayList;
import java.util.Collections;

public class AnimalDemo {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();

        // Create Animal objects
        animals.add(new Animal("Lion", 420.5));
        animals.add(new Animal("Elephant", 1200.0));
        animals.add(new Animal("Tiger", 310.2));
        animals.add(new Animal("Zebra", 500.0));

        System.out.println("Before sorting:");
        for (Animal animal : animals) {
            System.out.println(animal);
        }

        // Sort using Comparable
        Collections.sort(animals);

        System.out.println("\nAfter sorting by weight:");
        for (Animal animal : animals) {
            System.out.println(animal);
        }

        // Comparing two animals
        Animal a1 = new Animal("Giraffe", 800.0);
        Animal a2 = new Animal("Buffalo", 900.0);

        int comparison = a1.compareTo(a2);
        if (comparison < 0) {
            System.out.println("\n" + a1.getName() + " is lighter than " + a2.getName());
        } else if (comparison > 0) {
            System.out.println("\n" + a1.getName() + " is heavier than " + a2.getName());
        } else {
            System.out.println("\nBoth animals have the same weight.");
        }
    }
}
