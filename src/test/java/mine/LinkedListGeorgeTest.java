package mine;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by georgelyons
 */

public class LinkedListGeorgeTest {


    @Test
    public void addToTailAndGet() {
        LinkedListGeorge linkedListGeorge = new LinkedListGeorge();
        linkedListGeorge.add(1);
        linkedListGeorge.add(2);
        linkedListGeorge.add(4);
        linkedListGeorge.add(8);

        linkedListGeorge.prettyPrintConsole();

        //get tail index
        Assert.assertEquals(4, linkedListGeorge.get(2), 0.0001);
        //get a middle index
        Assert.assertEquals(8, linkedListGeorge.get(3), 0.0001);
        //get head index
        Assert.assertEquals(1, linkedListGeorge.get(0), 0.0001);


        System.out.println("index 2 (middle)" + linkedListGeorge.get(2));
        System.out.println("index 3 (last)" + linkedListGeorge.get(3));
        System.out.println("index 0 (first)" + linkedListGeorge.get(0));
    }

    @Test
    public void addIndex() {
        LinkedListGeorge linkedListGeorge = new LinkedListGeorge();
        linkedListGeorge.add(1);
        linkedListGeorge.add(2);
        linkedListGeorge.add(4);
        linkedListGeorge.add(8);

        linkedListGeorge.prettyPrintConsole();

        linkedListGeorge.add(3, 2);

        linkedListGeorge.prettyPrintConsole();

        Assert.assertEquals(3, linkedListGeorge.get(2), 0.001);

        //add to tail by index - 5
        linkedListGeorge.add(5, 5);

        linkedListGeorge.prettyPrintConsole();

        Assert.assertEquals(5, linkedListGeorge.get(5), 0.001);


        //add to head by index - 0
        linkedListGeorge.add(3, 0);

        Assert.assertEquals(3, linkedListGeorge.get(0), 0.001);
    }



    @Test
    public void removeIndex() {
        LinkedListGeorge linkedListGeorge = new LinkedListGeorge();
        linkedListGeorge.add(1);
        linkedListGeorge.add(2);
        linkedListGeorge.add(4);
        linkedListGeorge.add(8);
        linkedListGeorge.prettyPrintConsole();
        linkedListGeorge.remove(2);
        linkedListGeorge.prettyPrintConsole();
        Assert.assertEquals(8, linkedListGeorge.get(2), 0.0001);

        linkedListGeorge.remove(0);
        Assert.assertEquals(2, linkedListGeorge.get(0), 0.0001);
        linkedListGeorge.prettyPrintConsole();

    }

    @Test
    public void removelastIndex() {
        LinkedListGeorge linkedListGeorge = new LinkedListGeorge();
        linkedListGeorge.add(1);
        linkedListGeorge.add(2);
        linkedListGeorge.add(4);
        linkedListGeorge.add(8);
        linkedListGeorge.prettyPrintConsole();
        linkedListGeorge.remove(3);
        linkedListGeorge.prettyPrintConsole();
        Assert.assertEquals(4, linkedListGeorge.tail.data, 0.0001);

    }

    @Test
    public void removeFirst() {
        LinkedListGeorge linkedListGeorge = new LinkedListGeorge();
        linkedListGeorge.add(1);
        linkedListGeorge.add(2);
        linkedListGeorge.add(4);
        linkedListGeorge.add(8);


        Assert.assertEquals(1, linkedListGeorge.head.data, 0.0001);

        linkedListGeorge.removeFirst();

        Assert.assertEquals(2, linkedListGeorge.head.data, 0.0001);
    }

    @Test
    public void removeLast() {
        LinkedListGeorge linkedListGeorge = new LinkedListGeorge();
        linkedListGeorge.add(1);
        linkedListGeorge.add(2);
        linkedListGeorge.add(4);
        linkedListGeorge.add(8);
        linkedListGeorge.prettyPrintConsole();
        linkedListGeorge.removeLast();
        linkedListGeorge.prettyPrintConsole();
        Assert.assertEquals(4, linkedListGeorge.tail.data, 0.0001);
    }


}