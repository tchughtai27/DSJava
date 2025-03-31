import java.util.ArrayList;

public class Animal implements Comparable<Animal> {
    private String name;
    private double weight;

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Animal [name = %s, weight = %.2f lbs]", name, weight);
    }

    // Implement Comparable Interface
    @Override
    public int compareTo(Animal other) {
        // Compare by weight
        return Double.compare(this.weight, other.weight);
    }

    public static double calcAvg(ArrayList<Animal> list) {
        double sum = 0;
        if (list.isEmpty()) {
            return 0;
        }
        for (Animal animal : list) {
            sum += animal.getWeight();
        }
        return sum / list.size();
    }
}
