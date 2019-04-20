package FunctionalProgramming.ExamplesFromLectures;

public class Server {

    public String getData() {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {}

        return "sunny";
    }
}
