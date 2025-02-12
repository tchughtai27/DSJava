public class BaseballCard {
    private String name; // the name
    private int year; // the year

    // Constructor
    public BaseballCard(String name, int year) {
        this.name = name;
        this.year = year;
    }

    // Name
    public String getName() {
        return name;
    }

    // Year
    public int getYear() {
        return year;
    }

    // Defines toString()
    public String toString() {
        return "BaseballCard " + "Name: '" + name + '\'' + ", Year: " + year + " ";
    }

    // Defines equals()
    public boolean equals(Object obj) {
        // Check if the compared object is the same instance or if not
        if (this == obj)
            return true;

        // Check if the compared object is null or diff class, dont know if this is
        // needed
        if (obj == null || getClass() != obj.getClass())
            return false;

        // Cast to BaseballCard and compare
        BaseballCard card = (BaseballCard) obj;
        return year == card.year && name.equals(card.name);
    }
}
