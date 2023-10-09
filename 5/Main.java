import java.util.LinkedList;
import java.util.Random;

class Market {
    // LinkedList to represent the market
    LinkedList<String> list = new LinkedList<>();
    int capacity = 5; // Capacity of the market
    String[] fruits = {"Apple", "Watermelon", "Grapes", "Orange", "Strawberry"};
    Random random = new Random();

    // Producer method to add fruits to the market
    public void Produce() throws InterruptedException {
        while (true) {
            synchronized (this) {
                // Wait if the market is full
                while (list.size() == capacity)
                    wait();

                // Produce a random fruit
                String fruit = fruits[random.nextInt(fruits.length)];
                System.out.println("Farmer produced " + fruit);
                list.add(fruit);

                // Notify consumers
                notifyAll();

                // Simulate time for production
                Thread.sleep(500);
            }
        }
    }

    // Consumer method to consume fruits from the market
    public void Consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                // Wait if the market is empty
                while (list.size() == 0)
                    wait();

                // Consume the first available fruit
                String fruit = list.removeFirst();
                System.out.println("Person Consumed " + fruit);

                // Notify producers
                notifyAll();

                // Simulate time for consumption
                Thread.sleep(500);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Market market = new Market();

        // Create producer thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    market.Produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create consumer thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    market.Consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();
    }
}