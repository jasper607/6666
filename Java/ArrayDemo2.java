
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("iq.txt");
        File f2 = new File("age.txt");

        Scanner sc = new Scanner(f);
        Scanner sc2 = new Scanner(f2);

        List<Integer> iqList = new ArrayList<>();
        List<Integer> ageList = new ArrayList<>();

        // read iq file first
        while (sc.hasNextInt()) {
            iqList.add(sc.nextInt());
        }
        sc.close();

        // read age file after
        while (sc2.hasNextInt()) {
            ageList.add(sc2.nextInt());
        }
        sc2.close();

        // convert lists to arrays
        int[] iq = new int[iqList.size()];
        int[] age = new int[ageList.size()];

        for (int i = 0; i < iqList.size(); i++) {
            iq[i] = iqList.get(i);
        }
        for (int i = 0; i < ageList.size(); i++) {
            age[i] = ageList.get(i);
        }

        // process IQ values
        increase(iq);

        // print arrays
        System.out.println("IQ (after doubled): " + Arrays.toString(iq));
        System.out.println("Age: " + Arrays.toString(age));

        // optional: show paired values
        System.out.println("\n--- IQ and Age Pairs ---");
        for (int i = 0; i < Math.min(iq.length, age.length); i++) {
            System.out.println("IQ: " + iq[i] + " | Age: " + age[i]);
        }
    }

    public static void increase(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * 2;
        }
    }
}