package OOP;
abstract class Animal<T> {
    protected T name;
    protected int numLegs;
    protected int numEyes;

    public Animal(T name, int numLegs, int numEyes) {
        this.name = name;
        this.numLegs = numLegs;
        this.numEyes = numEyes;
    }

    public T getName() {
        return name;
    }

    public int getNumLegs() {
        return numLegs;
    }

    public int getNumEyes() {
        return numEyes;
    }

    public String makeNoise() {
        return "Done.";
    }
}

class Dog extends Animal<String> {
    private String breed;

    public Dog(String name, String breed) {
        super(name, 4, 2);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String makeNoise() {
        return "The dog is barking";
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Aloo", "Golden Retriever");
        System.out.println(
                "Breed: " + dog.getBreed() +
                        " | Name: " + dog.getName() +
                        " | # of legs: " + dog.getNumLegs() +
                        " | " + dog.makeNoise());
    }
}
