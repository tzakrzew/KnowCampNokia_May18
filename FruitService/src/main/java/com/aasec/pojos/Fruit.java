package com.aasec.pojos;

public class Fruit {
    String name;
    String type;
    int sweetness;
    int size;

    public Fruit ()
    {

    }

    private Fruit(FruitBuilder fruitBuilder) {
        this.name = fruitBuilder.name;
        this.type = fruitBuilder.type;
        this.sweetness = fruitBuilder.sweetness;
        this.size = fruitBuilder.size;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSweetness() {
        return sweetness;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", sweetness=" + sweetness +
                ", size=" + size +
                '}';
    }

    public static class FruitBuilder {
        private final String name;
        private final String type;
        private int sweetness;
        private int size;

        public FruitBuilder(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public FruitBuilder sweetness(int sweetness) {
            this.sweetness = sweetness;
            return this;
        }

        public FruitBuilder size(int size) {
            this.size = size;
            return this;
        }

        public Fruit build() {
            return new Fruit(this);
        }

    }
}
