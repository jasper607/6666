import java.io.FileNotFoundException; // for Scanner, ArrayList, Arrays
import java.util.*;

public class ArrayDemo {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        // Read IQ values from user
        System.out.println("Enter IQ values (press Enter with no input to finish):");
        ArrayList<Integer> iqList = new ArrayList<>();
        while (true) {
            System.out.print("IQ: ");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break; // User pressed Enter on empty line
            }
            iqList.add(Integer.parseInt(input));
        }

        // Read Age values from user
        System.out.println("Enter Age values (press Enter with no input to finish):");
        ArrayList<Integer> ageList = new ArrayList<>();
        while (true) {
            System.out.print("Age: ");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break; // User pressed Enter on empty line
            }
            ageList.add(Integer.parseInt(input));
        }

        // Convert ArrayList to array
        int[] iq = new int[iqList.size()];
        for (int i = 0; i < iqList.size(); i++) {
            iq[i] = iqList.get(i);
        }

        int[] age = new int[ageList.size()];
        for (int i = 0; i < ageList.size(); i++) {
            age[i] = ageList.get(i);
        }

        // Print both arrays
        System.out.println("\nIQ values: " + Arrays.toString(iq));
        System.out.println("Age values: " + Arrays.toString(age));

        // Original demonstration with increase method
        increase(iq);
        System.out.println("\nAfter doubling IQ: " + Arrays.toString(iq));

        scanner.close();
    }

    /**
     * Demonstrates passing an array to a method.
     * Doubles each element in the array.
     */
    public static void increase(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * 2;
        }
    }
}