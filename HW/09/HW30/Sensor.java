public abstract class Sensor {
    // Private member vars
    private String name; // Name
    private int modelNumber; // Model

    // initialize Sensor
    public Sensor(String name, int modelNumber) {
        this.name = name;
        this.modelNumber = modelNumber;
    }

    // Name
    public String getName() {
        return name;
    }

    // Name
    public void setName(String name) {
        this.name = name;
    }

    // modelNumber
    public int getModelNumber() {
        return modelNumber;
    }

    // modelNumber
    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    // Abstract method
    public abstract void recordMeasurement();
}
