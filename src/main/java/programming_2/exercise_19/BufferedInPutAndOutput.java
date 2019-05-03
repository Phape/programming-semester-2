package programming_2.exercise_19;

import java.io.*;

public class BufferedInPutAndOutput {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(new File("C:\\Users\\phili\\source\\repos\\ProgSemester2\\src\\Programming2\\Exercise_19\\Eingabe.txt"));
            BufferedReader reader = new BufferedReader(fileReader);

            FileWriter filewriter = new FileWriter(new File("C:\\Users\\phili\\source\\repos\\ProgSemester2\\src\\Programming2\\Exercise_19\\Ausgabe.txt"));
            PrintWriter printWriter = new PrintWriter(filewriter);

            printWriter.println(reader.readLine());
            printWriter.println("NEUE ZEILE");
            printWriter.println(reader.readLine());

            reader.close();
            printWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
