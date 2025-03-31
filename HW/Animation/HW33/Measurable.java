import java.util.ArrayList;

// interfaces can have static methods
public static double calcAvg(ArrayList<Measurable> list) {
    if (list.size() == 0) {
        return 0;
    }
    double sum = 0;
    for (Measurable item : list) {
        sum = sum + item.getMeasure();
    }
    return sum / list.size();
}

public interface Measurable {
    // abstract method.
    double getMeasure();

}
