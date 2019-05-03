package programming_2.exercise_22;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

 //I didn't finish copying
public class LineInserterTogether {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a filename");
        String name = scanner.nextLine();
        System.out.println("Please enter the line number");
        int n = scanner.nextInt();
        System.out.println("Please enter the text to be inserted");
        String lnNr = scanner.nextLine();


        try {
            FileReader fileReader = new FileReader(name);
            BufferedReader buffedReader = new BufferedReader(fileReader);

            PrintWriter printWriter = new PrintWriter("BlaBla.txt");

            String s = buffedReader.readLine();
            int i = 1;
            while (i < n && s != null) {
                printWriter.println(s);
                s = buffedReader.readLine();
                i++;
            }
            printWriter.println(lnNr);

            while (s != null) {
                printWriter.println(s);
                s = buffedReader.readLine();
            }

            printWriter.close();
            buffedReader.close();
            fileReader.close();

            fileReader = new FileReader("Blabla.txt");
            buffedReader = new BufferedReader(fileReader);
            printWriter = new PrintWriter(name);

            s = buffedReader.readLine();

            while (s != null) {
                printWriter.println(s);
                s = buffedReader.readLine();
            }

            printWriter.close();
            buffedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
