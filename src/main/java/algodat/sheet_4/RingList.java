package algodat.sheet_4; //Assignment Nr. 7

public class RingList<T> {

    private T[] content;
    private int firstIndex;
    private int currentSize;

    public RingList(int len) {
        content = (T[]) new Object[len];
        currentSize = 0;
        firstIndex = 0;
    }

    public void insert(T object) {
        if (currentSize == content.length) {
            throw new RuntimeException("The list is full!");
        }
        content[(firstIndex + currentSize) % content.length] = object;
        currentSize++;
    }

    public void remove() {
        if (currentSize == 0) {
            throw new RuntimeException("The list is empty!");
        }
        content[firstIndex] = null;
        firstIndex++;
        if (firstIndex == content.length) {
            firstIndex = 0;
        }
        currentSize--;
    }

    public String toString() {
        String allToStringsInOne = "(";
        for (int i = 0; i < currentSize; i++) {
            allToStringsInOne += content[(i + firstIndex) % content.length].toString();
            allToStringsInOne += ", ";
        }
        return allToStringsInOne + ")";
    }

    public static void main(String[] args) {
        RingList<Integer> list = new RingList<>(5);
        list.insert(4);
        System.out.println(list);
        list.insert(10);
        System.out.println(list);
        list.insert(3);
        System.out.println(list);
        list.remove();
        System.out.println(list);
        list.insert(8);
        System.out.println(list);
        list.insert(41);
        System.out.println(list);
        list.insert(7);
        System.out.println(list);
        list.insert(1); //The list will be full at this point --> Exception is thrown
    }
}
