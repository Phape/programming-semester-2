package functional_programming.exercise_sheet_2; //sheet 2 ex.1

public class SortOut {

    public static int[] reducedArray (int[] ia, Verification ver) {
        //count for how many elements of ia the Verification is successful
        int n = 0;
        for (int i : ia) {
            if (ver.isSuccessfulFor(i))
                n++;
        }

        //create a new Array with all successful Elements and return it
        int[] successfulElements = new int[n];
        int s = 0;
        for (int i : ia) {
            if (ver.isSuccessfulFor(i)) {
                successfulElements[s++] = i;
            }
        }
        return successfulElements;
    }

    public static void output (String text, int[] ia) {
        System.out.print(text + ": ");
        for (int i : ia)
            System.out.print(i + "|");
        System.out.println();
    }

    public static void main(String[] args) {

        // creates the integer array (length: 30) with random ints between -100 and 100
        int[] ia = new int[30];
        for(int i = 0; i<30; i++) {
            ia[i] = (int)(Math.random() * 201 - 100);
        }

        //print all numbers of the array ia
        output("all integers", ia);
        output("negative integers of the array", reducedArray(ia, i -> i < 0));
        output("only the even numbers", reducedArray(ia, i -> i%2 == 0));
        output("only dividable by 7", reducedArray(ia, i -> i%7 == 0));
        output("only quadratic numbers", reducedArray(ia, i -> Math.sqrt(i) % 1 == 0));
    }
}
