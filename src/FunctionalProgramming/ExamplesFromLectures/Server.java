package FunctionalProgramming.ExamplesFromLectures;

public class Server {

    public static String getData() {
        //simulated access time: 5 seconds
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "sunny";
    }
}
