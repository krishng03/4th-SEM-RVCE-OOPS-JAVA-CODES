import java.util.*;

class Array {
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> rev_list = new ArrayList<>();

    // Method to add items to the list.
    public void addItems(String color) {
        list.add(color);
    }

    // Method to display the contents of the list.
    public void display() {
        if (list.size() == 0)
            System.out.print("List is Empty\n");
        else
            System.out.print("The List Contents are :\n>>> " + list + "\n");
    }

    // Method to convert the list to an array and display its contents.
    public void toArray() {
        if (list.size() == 0)
            System.out.print("List is Empty\n");
        else {
            String[] arr = new String[list.size()];
            list.toArray(arr);
            System.out.print("The Array Contents are:\n>>> ");
            for (String st : arr)
                System.out.print(st + " ");
            System.out.print("\n");
        }
    }

    // Method to reverse the list and display its contents.
    public void reverse() {
        if (list.size() == 0)
            System.out.print("List is Empty\n");
        else {
            for (int i = list.size() - 1; i >= 0; i--)
                rev_list.add(list.get(i));

            System.out.print("The Reverse List is :\n>>> " + rev_list + "\n");
        }
    }

    // Method to create a sublist based on the start and end indices and display it.
    public void subArray(int start, int end) {
        if (start < 0 || end > list.size())
            System.out.print("Invalid!\n");
        else {
            ArrayList<String> temp = new ArrayList<>(list.subList(start, end));
            System.out.print("The Sublist is :\n>>> " + temp + "\n");
        }
    }

    // Method to sort the list in ascending order.
    public void sort() {
        if (list.size() == 0) {
            System.out.println("List is Empty!\n");
        } else {
            Collections.sort(list);
            System.out.println("List is Now Sorted!");
        }
    }

    // Method to clone the list and display the clone.
    @SuppressWarnings("unchecked")
    public void Clone() {
        if (list.size() == 0)
            System.out.print("List is Empty!");
        else {
            ArrayList<String> clonelist = (ArrayList<String>) list.clone();
            System.out.print("The Clone is :\n>>> " + clonelist + "\n");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Array arr = new Array();
        System.out.print("1. Add\n2. Display\n3. ToArray\n4. Reverse\n5. SubArray\n6. Sort\n7. Clone\n8. Exit\n");
        while (true) {
            System.out.print("Read Choice :\n>>> ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Read Color :\n>>> ");
                    String color = sc.next();
                    arr.addItems(color);
                    break;
                case 2:
                    arr.display();
                    break;
                case 3:
                    arr.toArray();
                    break;
                case 4:
                    arr.reverse();
                    break;
                case 5:
                    System.out.print("Read Start :\n>>> ");
                    int start = sc.nextInt();
                    System.out.print("Read End :\n>>> ");
                    int end = sc.nextInt();
                    arr.subArray(start, end);
                    break;
                case 6:
                    arr.sort();
                    break;
                case 7:
                    arr.Clone();
                    break;
                default:
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
