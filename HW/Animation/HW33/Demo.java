public class Demo {
    public static void main(String[] args) {
        Animal a = new Animal("Animal", 1000);
        Measurable m = (Measurable) a;
        System.out.println(m.getMeasure());

    }
}
