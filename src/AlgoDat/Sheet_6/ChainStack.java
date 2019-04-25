package AlgoDat.Sheet_6; //exercise 17

public class ChainStack implements Stack{
    Wert head;

    public ChainStack() {
        head = null;
    }
    @Override
    public void push(Wert w) {
        if (head != null) {
            w.next = head;
        }
        head = w;
    }

    @Override
    public Wert pop() {
        if (head == null) {
            return null;
        }
        Wert w = head;
        head = head.next;
        return w;
    }
}
