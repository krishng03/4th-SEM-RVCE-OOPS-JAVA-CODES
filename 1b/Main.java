import java.util.Scanner;

class Address {
    int street;
    String city;
    String state;
    String country;

    // Constructor for the Address class
    public Address(int street, String city, String state, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    // Method to display the address details
    public void display() {
        System.out.println("Address :\nStreet : " + this.street + "\nCity : " + this.city + "\nState : " + this.state
                + "\nCountry : " + this.country);
    }
}

class Student extends Address {
    String usn;
    String name;
    Address addr;

    // Constructor for the Student class
    public Student(String usn, String name, int street, String city, String state, String country) {
        // Call the constructor of the superclass (Address)
        super(street, city, state, country);
        this.usn = usn;
        this.name = name;
    }

    // Method to display student details
    public void student() {
        System.out.println("Name : " + this.name + "\nUSN : " + this.usn);
        display(); // Call the display method of the Address class
    }
}

class Employee extends Address {
    String emp;
    String name;

    // Constructor for the Employee class
    public Employee(String emp, String name, int street, String city, String state, String country) {
        // Call the constructor of the superclass (Address)
        super(street, city, state, country);
        this.emp = emp;
        this.name = name;
    }

    // Method to display employee details
    public void employee() {
        System.out.println("Name : " + this.name + "\nID : " + this.emp);
        display(); // Call the display method of the Address class
    }
}

class College extends Address {
    String name;

    // Constructor for the College class
    public College(String name, int street, String city, String state, String country) {
        // Call the constructor of the superclass (Address)
        super(street, city, state, country);
        this.name = name;
    }

    // Method to display college details
    public void college() {
        System.out.println("Name : " + this.name);
        display(); // Call the display method of the Address class
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of Records :\n>>> ");
        int n = sc.nextInt();
        Student[] s = new Student[n];
        College[] c = new College[n];
        Employee[] e = new Employee[n];
        System.out.println("Enter the Records of Students :");
        for (int i = 1; i <= n; i++) {
            String usn, name, city, state, country;
            int street;
            System.out.print("Read the name of Student " + i + " :\n>>> ");
            name = sc.next();
            System.out.print("Read the USN of Student " + i + " :\n>>> ");
            usn = sc.next();
            System.out.print("Read the Address of Student " + i + " :\n");
            System.out.print("Read the Street Number :\n>>> ");
            street = sc.nextInt();
            System.out.print("Read the City :\n>>> ");
            city = sc.next();
            System.out.print("Read the state :\n>>> ");
            state = sc.next();
            System.out.print("Read the country :\n>>> ");
            country = sc.next();
            s[i - 1] = new Student(usn, name, street, city, state, country);
        }
        for (int i = 1; i <= n; i++) {
            String emp, name, city, state, country;
            int street;
            System.out.print("Read the Name of Employee " + i + " :\n>>> ");
            name = sc.next();
            System.out.print("Read the ID of Employee " + i + " :\n>>> ");
            emp = sc.next();
            System.out.print("Read the Address of Employee " + i + " :\n");
            System.out.print("Read the Street Number :\n>>> ");
            street = sc.nextInt();
            System.out.print("Read the City :\n>>> ");
            city = sc.next();
            System.out.print("Read the state :\n>>> ");
            state = sc.next();
            System.out.print("Read the country :\n>>> ");
            country = sc.next();
            e[i - 1] = new Employee(emp, name, street, city, state, country);
        }
        for (int i = 1; i <= n; i++) {
            String name, city, state, country;
            int street;
            System.out.print("Read the Name of College " + i + " :\n>>> ");
            name = sc.next();
            System.out.print("Read the Address of College " + i + " :\n");
            System.out.print("Read the Street Number :\n>>> ");
            street = sc.nextInt();
            System.out.print("Read the City :\n>>> ");
            city = sc.next();
            System.out.print("Read the state :\n>>> ");
            state = sc.next();
            System.out.print("Read the country :\n>>> ");
            country = sc.next();
            c[i - 1] = new College(name, street, city, state, country);
        }
        System.out.println("\nThe Student Records are :");
        for (int i = 0; i < n; i++)
            s[i].student();
        System.out.println("\nThe College Records are :");
        for (int i = 0; i < n; i++)
            c[i].college();
        System.out.println("\nThe Employee Records are :");
        for (int i = 0; i < n; i++)
            e[i].employee();
        sc.close();
    }
}