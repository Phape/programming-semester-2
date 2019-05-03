package algodat.sheet_5;

public class ListeL<I extends Comparable<I>> {

    static class ElementL<K> {
        private K inhalt;           // Inhalt des Listenelements
        private ElementL<K> next;   // Verweis auf den Nachfolger
        public ElementL (K o) {
            inhalt = o;
            next = null;
        }
    }

    private ElementL<I> head;       // Referenz auf den Anfang der Liste

    public ListeL () {
        head = null;
    }

    public ListeL (I o) {
        head = new ElementL<I>(o);
    }

    public ElementL<I> insert (I o) {   // am Anfang einfügen
        ElementL<I> newEl = new ElementL<I>(o);
        if (head == null) { // Liste ist noch leer
            head = newEl;
        }
        else {
            newEl.next = head;
            head = newEl;
        }
        return newEl;
    }

    public ElementL<I> insert (I o, ElementL<I> pred) { // nach pred (Vorgänger) einfügen
        ElementL<I> newEl = new ElementL<I>(o);
        if (pred == null) { // am Anfang einfügen
            newEl.next = head;
            head = newEl;
        }
        else {  // nach pred (Vorgänger) einfügen
            newEl.next = pred.next;
            pred.next = newEl;
        }
        return newEl;
    }

    public void remove (ElementL<I> pred) {  // Element nach pred (Vorgänger) löschen
        if (pred == null) // erstes Element löschen
            head = head.next;
        else if (pred.next != null)  // Element nach pred (Vorgänger) löschen
            pred.next = pred.next.next;
    }

    public String toString() {
        String s = "(";
        ElementL<I> help = head;
        while (help != null && help.next != null) {
            s = s + help.inhalt + ", ";
            help = help.next;
        }
        if (help != null)
            s = s + help.inhalt;
        return s + ")";
    }

    public int find1 (I o) {
        if (head == null) {
            return -1;
        }
        ElementL<I> help = head;
        int pos = 0;
        while (help != null) {
            if (help.inhalt.equals(o)) {
                return pos;
            }
            help = help.next;
            pos++;
        }
        return -1;
    }

    public void sort1() { //Selection Sort
        ElementL<I> help = head; // counting variable for the outer loop
        ElementL<I> help2;
        ElementL<I> smallestObject = head;

        while (help.next != null) { //counting loop
            smallestObject = help;
            help2 = smallestObject.next;
            while (help2 != null) { //searches the minimum

                if (smallestObject.inhalt.compareTo(help2.inhalt) > 0) {
                    smallestObject = help2;
                }
                help2 = help2.next;
            }
            //swap content (inhalt)
            if (smallestObject != help) {
                I inhalt = smallestObject.inhalt;
                smallestObject.inhalt = help.inhalt;
                help.inhalt = inhalt;
            }
            help = help.next;
        }
    }

    public void sort2() { //Bubble sort
        ElementL<I> help = head;
        ElementL<I> help2;
        boolean swapped;

        while (help.next != null) {
            swapped = false;
            help2 = help.next;

            while (help2 != null) {
                if (help.inhalt.compareTo(help2.inhalt) > 0) {
                    I content = help.inhalt;
                    help.inhalt = help2.inhalt;
                    help2.inhalt = content;
                    swapped = true;
                }
                help2 = help2.next;
            }
            if (!swapped)
                return;
            help = help.next;
        }
    }


    public void sort3() { //insertion sort @author: Phape
        ElementL<I> toSort = head.next;

        while(toSort != null) { //as long as there is an element to sort left
            ElementL<I> pointer = head; //pointer is to compare the toSort element with an already sorted element from the list
            ElementL<I> toInsert = toSort; //toInsert is copied so that it won't be manipulated by the inner loop
            I temp;

            while (pointer != toSort) { //go through the (already) sorted elements
                if (toInsert.inhalt.compareTo(pointer.inhalt) < 0) {
                    temp = pointer.inhalt; //temp stores the content
                    pointer.inhalt = toInsert.inhalt; //at the first call, this will sort in the toSort content
                    toInsert.inhalt = temp; //the content that has been replaced has to be sorted in next
                }
                pointer = pointer.next;
            }
            toSort = toSort.next; //the next unsorted element is called
        }
    }



    // Test

    public static void main (String[] args) {
        ListeL<Integer> l = new ListeL<Integer>();
        l.insert(0);
        ElementL<Integer> eins = l.insert(1);
        l.insert(3);
        System.out.println(l);
        l.insert(2, eins);  // nach eins einfügen
        System.out.println(l);
        l.remove(eins);  // Nachfolger von eins löschen
        l.insert(9);
        l.insert(5);
        l.insert(7);
        System.out.println("Original list: " + l);


        //l.sort1();
     //   System.out.println("sort1: " + l);
       // l.sort2();
      //  System.out.println("sort2: " + l);
       l.sort3();
        System.out.println("sort3: " + l);
    }

}
