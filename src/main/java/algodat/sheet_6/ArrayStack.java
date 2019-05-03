package algodat.sheet_6; //exercise 17

public class ArrayStack implements Stack {
    Wert[] inhalte;
    int lastIndex;

    public ArrayStack(int length) {
        inhalte = new Wert[length];
        lastIndex = -1;
    }

    @Override
    public void push(Wert w) {
        if (lastIndex == inhalte.length-1) {
            throw new RuntimeException("Liste ist voll");
        }
        inhalte[++lastIndex] = w;
    }

    @Override
    public Wert pop() {
        if (lastIndex < 0) {
            throw new RuntimeException("Liste ist leer.");
        }
        Wert w = inhalte[lastIndex];
        inhalte[lastIndex] = null;
        lastIndex--;
        return w;
    }
}
