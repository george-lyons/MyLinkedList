package nat;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * Created by georgelyons
 * basic declare and use
 */
public class main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("jell");
        list.add("bell");
        list.add("bfll");
        list.add("well");


        Iterator<String> iterator=list.iterator();

        //Linked list is a doubly linked list

        //get: O(1) for ArrayList, because ArrayList allow random access by using index. O(N) for LinkedList, because it needs to find the index first
        //LinkedList is faster in add and remove, O(1) at add (end list) and remove (end list), but O(N) middle as needs to find index first
        //ArrayList add and remove O(N) as require memory resizing costs. O(1) best


        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Iterator<String> iterator2 =list.iterator();


        list.removeLast();
        list.removeFirst();


        while(iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }



    }
}
