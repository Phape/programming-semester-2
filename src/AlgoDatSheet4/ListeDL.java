package AlgoDatSheet4; //Assignment Nr. 7

public class ListeDL<T> {

  private static class ElementDL<E> {
    private E            element;  // Inhalt des Listenelements
    private ElementDL<E> next;     // Verweis auf den Nachfolger
    private ElementDL<E> prev;     // Verweis auf den Vorg�nger
    public ElementDL (E o) {
      element = o;
      next = null;
      prev = null;
    }
  }
  
  private ElementDL<T> head;       // Referenz auf den Anfang der Liste
  private ElementDL<T> tail;       // Referenz auf das Ende der Liste
  
  public ListeDL () {
    head = null;
    tail = null;
  }

  public ListeDL (T o) {
    head = new ElementDL<T>(o);
    tail = head;
  }


// NOCH NICHT FERTIG!!!

  // Methode, um o am Ende einzufügen
  public ElementDL<T> insert (T o) {

    ElementDL<T> neu = new ElementDL<>(o);
    if (head == null) {
      head = tail = neu;
    }
    else {
      tail.next = neu;
      neu.prev = tail;
      tail = neu;
    }
    return tail;
  }

  // Methode, um o an der Postion pos einfügen
  public ElementDL<T> insert (T o, ElementDL<T> pos) {  
    ElementDL<T> newEl = new ElementDL<T>(o);

    //...

    return newEl;
  }
  
  // Element e löschen
  public void remove (ElementDL<T> e) {  
  
    if (head == null || e == null) { //Liste ist leer
      throw new RuntimeException("remove(e): Liste ist leer oder element ist null");
    }
    else if (head == e) { //erstes Element
      head = e.next; //=head.next: auf das zweite Element setzen
      head.prev = null; //Vorgänger löschen
      if (tail == e) { //Liste hat nur ein Element
        tail = null; //Liste löschen
      }
    }
    else if (tail == e) {
      tail = e.prev; //tail auf das vorletzte Element setzen
      e.prev.next = null; //Verweis vom Vorgänger auf e muss gelöscht werden
    }
    else { //mittendrin
      e.prev.next = e.next; //Verweis vom Vorgänger auf Nachfolger von e setzen
      e.next.prev = e.prev; //Verweis vom Nachfolger auf Vorgänger von e setzen
    }

  }
  
  public String toString() {
    String s = "(";
     ElementDL<T> help = head;
     while (help != null) {
         s += help.element + ", ";
         help = help.next;
     }
    return s + ")";
  }

  // Test
  
  public static void main (String[] args) {
    ListeDL<Integer> l = new ListeDL<Integer>();
    l.insert(new Integer(0));
    ElementDL<Integer> eins = l.insert(new Integer(1));
    l.insert(new Integer(3));
    System.out.println(l);
    l.insert(new Integer(2), eins);  // vor eins einfügen
    System.out.println(l);
    l.remove(eins);  // Nachfolger von eins löschen
    System.out.println(l);
  }
  
}
