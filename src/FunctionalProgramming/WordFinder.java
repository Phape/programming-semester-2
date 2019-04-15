package FunctionalProgramming; //sheet 2 ex. 2

public class WordFinder {

    public static String firstWord (String[] str, Condition condition) {
        for (String s : str) {
            if(condition.appliesTo(s))
                return s;
        }
        return "";
    }

    public static void main(String[] args) {
        String[] words = TestDaten.erzeuge();
        System.out.println("first letter is an A: " + firstWord(words, w -> w.charAt(0) == 'A'));
        System.out.println("first word containing 'au': " + firstWord(words, w -> w.contains("au")));
        System.out.println("first word ending with 'suppe': " + firstWord(words, w -> w.endsWith("suppe")));
        System.out.println("first word containing 8 letters: " + firstWord(words, w -> w.length() == 8));
    }

}
