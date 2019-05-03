package programming_2.exercise_22;

import java.io.*;
import java.util.Scanner;

public class LineInserter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a filename, preferred an absolute path");
        String fileName = scanner.nextLine() ;
        System.out.println("Please enter a line number");
        int lnNr = scanner.nextInt();
        System.out.println("Please enter the line to be inserted");
        String newLine = scanner.nextLine();

        try {
            File f = new File(fileName);
            System.out.println(f.getAbsolutePath());
            InputStream inputStream = new FileInputStream(f);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            OutputStream outputStream = new FileOutputStream("BlaBla.txt");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            String contentOfLine = "";
            for (int i = 0; i < lnNr - 1; i++) {
                contentOfLine = reader.readLine();
                writer.write(contentOfLine);
                writer.newLine();
            }
            writer.write(newLine);
            writer.newLine();
            while (reader.readLine() != null) {
                contentOfLine = reader.readLine();
                writer.write(contentOfLine);
                writer.newLine();
            }

            writer.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
