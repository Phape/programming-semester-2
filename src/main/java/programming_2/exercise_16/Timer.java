package programming_2.exercise_16; //Sheet 5

import prog_1_tools.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer extends Thread {

    private  Thread thread;
    private Date date;
    private boolean isRunning;
    private static final SimpleDateFormat longDateFormat = new SimpleDateFormat("d.MMM, h:mm:ss");


    public Timer() {
        if (IOTools.readLine().equals("")) {
            isRunning = true;
            thread = new Thread();
            thread.start();
        }
        else {
            isRunning = false;
        }

        while (isRunning) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException iex) {
             //   thread.
            }

            date = new Date(System.currentTimeMillis());
            System.out.println(longDateFormat.format(date));
            thread.interrupt();
        }
    }


    public static void main(String[] args) {
        Timer timer = new Timer();
    }

}
