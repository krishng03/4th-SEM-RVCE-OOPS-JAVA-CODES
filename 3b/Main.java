// Define an interface 'Animal' with an 'eat' method.
interface Animal {
    void eat();
}

// Define an interface 'TiredAnimal' which extends 'Animal' and adds a 'sleep' method.
interface TiredAnimal extends Animal {
    void sleep();
}

// Create a 'Lion' class that implements the 'TiredAnimal' interface.
class Lion implements TiredAnimal {
    // Implement the 'eat' method specific to Lion.
    public void eat() {
        System.out.println("Lion is eating Deer");
    }

    // Implement the 'sleep' method specific to Lion.
    public void sleep() {
        System.out.println("Lion is Sleeping");
    }

    // Define an additional method 'roar' specific to Lion.
    public void roar() {
        System.out.println("Lion is roaring");
    }
}

// Create a 'Snake' class that implements the 'TiredAnimal' interface.
class Snake implements TiredAnimal {
    // Implement the 'eat' method specific to Snake.
    public void eat() {
        System.out.println("Snake is eating Frog");
    }

    // Implement the 'sleep' method specific to Snake.
    public void sleep() {
        System.out.println("Snake is Sleeping");
    }

    // Define an additional method 'hiss' specific to Snake.
    public void hiss() {
        System.out.println("Snake is hissing");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an instance of Lion and demonstrate Lion-specific methods.
        Lion lion = new Lion();
        lion.roar();
        lion.eat();
        lion.sleep();

        // Create an instance of Snake and demonstrate Snake-specific methods.
        Snake snake = new Snake();
        snake.hiss();
        snake.eat();
        snake.sleep();
    }
}