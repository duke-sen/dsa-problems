package designpatterns.builder;

public class Car {
    private final String serialNumber;
    private final String manufacturerName;
    private final String yearOfMake;
    private final String color;

    public Car(Builder builder) {
        this.serialNumber = builder.serialNumber;
        this.manufacturerName = builder.manufacturerName;
        this.yearOfMake = builder.yearOfMake;
        this.color = builder.color;
    }

    public static class Builder {
        // Mandatory Params -- want to ensure this param is always passed
        private final String serialNumber;

        // Optional Params
        private String color;
        private String manufacturerName;
        private String yearOfMake;

        public Builder(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder manufacturerName(String manufacturerName) {
            this.manufacturerName = manufacturerName;
            return this;
        }

        public Builder yearOfMake(String yearOfMake) {
            this.yearOfMake = yearOfMake;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }
}
