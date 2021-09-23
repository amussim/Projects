package cmsc256;
import bridges.base.DLelement;
import bridges.connect.Bridges;
import bridges.validation.RateLimitException;

import java.io.IOException;
/*
Aneesh Mussim
3/19/2021
CMSC 256 sec 004
Project 4
 */
public class BridgesDoublyLinkedList<E> implements List<E>  {
    // Instance Variables
    //DLelement reference to the first node in the list
    //DLelement reference to last node in the list
    //DLelement reference to a "current" element that will be used when moving through the list
    // An integer reference to the size of the list
    private DLelement<E> first;
    private DLelement<E> last;
    private DLelement<E> current;
    private int numElements;



    public BridgesDoublyLinkedList(){
        clear();
    }

    public BridgesDoublyLinkedList(DLelement<E> node) {
        first = new DLelement<>();
        last = new DLelement<>();
        node.setPrev(first);
        node.setNext(last);
        first.setNext(node);
        last.setPrev(node);
        current = node;
        numElements = 1;
    }

    // Remove all contents from the list, so it is once again empty
    @Override
    public void clear() {
        first = new DLelement<>();
        last = new DLelement<>();
        first.setNext(last);
        last.setPrev(first);

        current = last;
        numElements = 0;
    }

    // Insert "it" at the current location
    // The client must ensure that the list's capacity is not exceeded
    @Override
    public boolean insert(E it) {
        DLelement<E> newNode = new DLelement<>(it.toString(), it);
        DLelement<E> B4Current = current.getPrev();
        B4Current.setNext(newNode);
        newNode.setPrev(B4Current);
        newNode.setNext(current);
        current.setPrev(newNode);
        current = current.getPrev();
        numElements++;
        return true;
    }
    // Append "it" at the end of the list
    // The client must ensure that the list's capacity is not exceeded
    @Override
    public boolean append(E it) {
        current = last;
        insert(it);
        return true;
    }

    // Remove and return the current element
    @Override
    public E remove() {
        if(current == last) {
            return null;
        }
        E it = current.getValue();
        current.setValue(current.getNext().getValue());
        if(current.getNext() == last) {
            last = current;
        }
        current.setNext(current.getNext().getNext());
        numElements--;
        return it;
    }

    // Set the current position to the start of the list
    @Override
    public void moveToStart() {
        current = first.getNext();
    }

    // Set the current position to the end of the list
    @Override
    public void moveToEnd() {
        current= last;
    }

    // Move the current position one step left, no change if already at beginning
    @Override
    public void prev() {
       if(first.getNext() == current) {
           return;
       }
       DLelement<E> temp = first;
       while (temp.getNext() != current) {
           temp = temp.getNext();
       }
       current = temp;

    }

    // Move the current position one step right, no change if already at end
    @Override
    public void next() {
        if(current != last) {
            current = current.getNext();
        }
    }

    // Return the number of elements in the list
    @Override
    public int length() {
        return numElements;
    }

    // Return the position of the current element
    @Override
    public int currPos() {
        DLelement<E> newNode = first.getNext();
        int i = 0;
        if (!isEmpty()) {
            for (i = 0; current != newNode; i++) {
                newNode = newNode.getNext();
            }
        }
        if (isEmpty()) {
            i = -1;
        }

        return i;
    }

    // Set the current position to "pos"
    @Override
    public boolean moveToPos(int pos) {
        if((pos < 0) || (pos > numElements)) {
            return false;
        }
        if (current == first) {
            current = first.getNext();
            for (int i =0; i < pos; i++) {
                current = current.getNext();
            }
        }
        else if (current == last) {
            current = last.getPrev();
            for (int i =0; i < pos; i++) {
                current = current.getPrev();
            }
        }

        return true;
    }

    // Return true if current position is at end of the list
    @Override
    public boolean isAtEnd() {

        if(current == last) {
            return true;
        }
        return false;
    }

    // Return the current element
    @Override
    public E getValue() {
        if(current == last) {
            return null;
        }
        return current.getValue();
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public String toString() {
        DLelement<E> temp = first.getNext();
        String s = "";
        while(true) {
            if (temp == last) {
                break;
            }

            s += temp.getValue() + " ";
            temp = temp.getNext();
        }
        
        return s;
    }

    public static void main(String[] args) {
        Bridges bridges = new Bridges(4, "mussima", "359297210625");
        bridges.setTitle("Project 4: DoublyLinkedList");
        BridgesDoublyLinkedList<String> states = new BridgesDoublyLinkedList<>();

        states.insert("Florida");

        states.insert("California");

        states.insert("Minnesota");

        states.insert("Virginia");

        states.insert("Texas");

        states.insert("Georgia");

        states.insert("Montana");

        states.insert("Utah");

        states.insert("Missippi");

        states.insert("Wyoming");

        states.insert("Nevada");

        states.insert("Arizona");

        states.insert("Oregon");

        states.insert("Oklahoma");

        states.insert("Kansas");

        states.insert("South Dakota");

        states.insert("Indiana");

        states.insert("West Virginia");

        states.insert("North Dakota");

        states.insert("Iowa");

        states.insert("Ohio");

        states.insert("New York");

        states.insert("Conneticut");

        states.insert("Maryland");

        states.insert("Pensylvania");

        states.insert("Louisiana");

        states.insert("Alabama");

        states.insert("Tennessee");

        states.insert("Missouri");

        states.insert("Delaware");

        states.insert("Maine");

        states.insert("Nebraska");

        states.insert("Kentucky");

        states.insert("New Jersey");

        states.insert("Vermont");

        states.append("Washington");

        states.length();

        states.moveToStart();

        states.next();

        states.moveToPos(states.currPos());

        states.prev();

        states.moveToEnd();

        states.remove();

        states.clear();


        System.out.println(states);

        bridges.setDataStructure(states.first);
        try {
            bridges.visualize();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
