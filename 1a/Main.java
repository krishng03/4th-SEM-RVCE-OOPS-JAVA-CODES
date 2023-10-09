import java.util.Scanner;
class Complex {
    private int real;
    private int imaginary;

    // Default constructor
    public Complex() {
        this.real = 0;
        this.imaginary = 0;
    }

    // Parameterized constructor
    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Display the complex number
    public void display() {
        if (imaginary < 0)
            System.out.print(real + " - i" + (-imaginary));
        else
            System.out.print(real + " + i" + imaginary);
    }

    // Method to perform addition of two complex numbers
    public Complex addition(Complex that) {
        int r = this.real + that.real;
        int i = this.imaginary + that.imaginary;
        Complex result = new Complex(r, i);
        return result;
    }

    // Method to perform subtraction of two complex numbers
    public Complex subtraction(Complex that) {
        int r = this.real - that.real;
        int i = this.imaginary - that.imaginary;
        Complex result = new Complex(r, i);
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        int real;
        int imaginary;

        Scanner sc = new Scanner(System.in);

        System.out.println("Read Details of First Complex Number :");
        System.out.print("Read Real Part :\n>>> ");
        real = sc.nextInt();
        System.out.print("Read Imaginary Part :\n>>> ");
        imaginary = sc.nextInt();

        Complex c1 = new Complex(real, imaginary);
        
        System.out.println("\nRead Details of Second Complex Number :");
        System.out.print("Read Real Part :\n>>> ");
        real = sc.nextInt();
        System.out.print("Read Imaginary Part :\n>>> ");
        imaginary = sc.nextInt();
        Complex c2 = new Complex(real, imaginary);
        
        System.out.println("The First Complex Number is :");
        c1.display();
        System.out.println("\nThe Second Complex Number is :");
        c2.display();

        System.out.print("\nThe Addition of ( ");
        c1.display();
        System.out.print(" ) & ( ");
        c2.display();
        System.out.print(" ) is : ");
        Complex add = c1.addition(c2);
        add.display();

        System.out.print("\nThe Subtraction of ( ");
        c1.display();
        System.out.print(" ) & ( ");
        c2.display();
        System.out.print(" ) is : ");
        Complex sub = c1.subtraction(c2);
        sub.display();

        sc.close();
    }
}
