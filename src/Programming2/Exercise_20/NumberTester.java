package Programming2.Exercise_20;

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class NumberTester {
    public static void main(@NotNull String[] args) {
        try {
            String path = args[0];
            StreamTokenizer streamTokenizer = new StreamTokenizer(new FileReader(new File(path)));

            int tokenType = streamTokenizer.nextToken();
            while (tokenType != StreamTokenizer.TT_EOF) {
                if (tokenType == StreamTokenizer.TT_NUMBER) {
                    System.out.println("Vorsicht! Der Text enthält die Zahl " + streamTokenizer.nval);
                    return;
                }
                tokenType = streamTokenizer.nextToken();
            }
            System.out.println("Der Text ist sauber.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
