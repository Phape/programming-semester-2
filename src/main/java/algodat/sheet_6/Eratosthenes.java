package algodat.sheet_6; //exercise 15, Eratosthenes Sieb

import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;

public class Eratosthenes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collection<Integer> setT = new TreeSet<>();
        Collection<Integer> setS = new TreeSet<>();
        System.out.print("Bitte geben sie n ein: ");
        int n = scanner.nextInt();
        int p = 2;

        for (int i = 2; i < n; i++) {
            setT.add(i);
        }
        do {
            for (int i = 2; p * i < n; i++) {
                setS.add(p*i);
            }
            if(p == 2) {
                p = 3;
            }
            else {
                do {
                    p += 2;
                } while (setS.contains(p));
            }
        } while (p * p <= n);
        setT.removeAll(setS);
        System.out.println(setT);
        scanner.close();
    }
}
